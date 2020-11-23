# ВВОДНОЕ - Решение

Получаем исходники и ресурсы (используем jadx 1.2.0 для "app.jar" и для "resources.arsc").
Проверил также вариант с преобразованием dex в jar (используем dex-tools-2.0) и последующей декомпиляцией jadx - код более читаемый, но ресурсы из arsc остаются за кадром (да, из-за оптимизации есть шанс упустить что-то, но тут тривиальный пример).

На выходе получаем исходники приложения и ресурсов:
```java
example.com.crackme.MainActivity.java
example.com.crackme.Checker.java
example.com.crackme.i.java
example.com.crackme.R.java
```

Исследуем код, начиная с точки входа - "MainActivity.java", как видно, по нажатию кнопки вызывается проверка введенного текста "Checker.check(obj, this)", который в свою очередь вызывает реализацию проверки "i.checkKey(str, context)".
По большому счету видим элементарное "запутывание" путём динамического вызова методов и хранения срок в массивах, формируемых динамически при старте.
Элементарно создав [тестовое приложение](./src/app/CrackmeAppKey.java) - узнаём все используемые строки массива "i.l".
```
l[6]=ength
l[7]=java.lang.String
l[8]=android.content.Context
l[9]=getResources
l[10]=SHA-1
l[11]=000000000000000
l[12]=java.lang.System
l[13]=android.telephony.TelephonyManager
l[14]=exit
l[15]=equals
l[16]=java.lang.Object
l[17]=getDeviceId
```

После чего, последовательно заменяем invoke на статический вызов методов. В одном месте используется значение из ресурса:
```java
Method declaredMethod2 = cls.getDeclaredMethod(Character.toString(context.getResources().getString(R.string.good).charAt(9)) + "ength", new Class[0]);
```

Конечно же - это метод length, но формально проверям - в декомпилированных ресурсах находим значение строкового ресурса (/res/values/strings.xml):
```xml
<resources>
    ...
    <string name="good">Key is valid</string>
    ...
</resources>
```

В результате получаем следующий код (контекст убран - не влияет на значение ключа):
```java
/** Формализованно очищенный код. */
public static Status checkKey(String str) {
    str = str.replaceAll("-", "").toLowerCase(Locale.UK);
    if (str.length() != 16) return Status.KEY_INVALID;
    try {
        byte[] copyOf = Arrays.copyOf(MessageDigest.getInstance("SHA-1").digest(
                new byte[]{getbyte(123, (byte) 14, (byte) 125, (byte) 6), 2, getbyte(321, (byte) 6, (byte) 14, (byte) 125)}
        ), 16);
        byte[] bArr = new byte[l[1].length + l[3].length];
        System.arraycopy(l[1], 0, bArr, 0, l[1].length);
        System.arraycopy(l[3], 0, bArr, l[1].length, l[3].length);
        byte[] bArr2 = new byte[32];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(new byte[]{122, 125, -19, 33, 69, 71, 112, -6, 36, 19, -90, 118}, 0, bArr2, bArr.length, 12);
        String key = new String(iiiilll(copyOf, bArr2)); // key=3814606579781593
        System.out.println("checkKey: key=" + key);
        return str.equals(key) ? Status.KEY_GOOD : Status.KEY_INVALID;
    } catch (NumberFormatException e) {
        return Status.KEY_INVALID;
    } catch (Exception e2) {
        return Status.KEY_GOOD;
    }
}
```
checkKey: key=3814606579781593

Причем, все вычисления до вызова iiiilll генерируют статические данные и могут быть предрассчитаны и редуцированы:
```java
/ Все константы предрассчитаны.
static byte[] ar1 = new byte[]{-78, 42, 76, 45, 81, 110, 37, 52, 83, -77, 79, -60, -99, 94, -38, 49}; // sha-digest
static byte[] ar2 = new byte[]{64, 118, -91, 90, 7, -17, -114, 118, -49, 31, -40, // l[1]
    -70, -16, 42, -68, 127, 34, -66, -74, -102, // l[3]
    122, 125, -19, 33, 69, 71, 112, -6, 36, 19, -90, 118}; // suffix

/** Оптимизированный код. */
public static void getKey() {
    try {
        String key = new String(iiiilll(ar1, ar2));
        System.out.println("getKey:   key=" + key);  //key=3814606579781593
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
```
getKey:   key=3814606579781593

Значение искомого ключа найдено.

Метод iiiilll, возвращающий значение ключа, получает на вход 16 байтный ключ шифрования и 32 байтный блок зашифрованных данных и возвращает результат дешифровки данных. Ипользуется "AES" шифрование.

Ключ шифрования формируется как 16 байтный хеш ("SHA-1") на базе трехбайтного значения, где один байт задан статически, а два других - результат вызова getbyte, формирующего результат на базе значений l.
Данные для расшифровки формируются из последовательной конкатенации двух субмассивов l[1] и l[3] и локального константного массива.
И ключ и данные - суть константы.

Собственно, вся защита строилась на динамическом заполнении l массива и субмассивов и динамическом вызове методов классов.
