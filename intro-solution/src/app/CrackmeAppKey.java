package app;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CrackmeAppKey {

    public static enum Status {
        KEY_GOOD,
        KEY_INVALID;
    }

    public static byte[][] l;

    static {
        l = new byte[0][];
        byte[][] arrarrby = new byte[20][];
        arrarrby[0] = new byte[]{26, 6, 125};
        arrarrby[1] = new byte[]{64, 118, -91, 90, 7, -17, -114, 118, -49, 31, -40};
        arrarrby[2] = new byte[]{8, 1, 36};
        arrarrby[13] = new byte[]{97, 110, 100, 114, 111, 105, 100, 46, 116, 101, 108, 101, 112, 104, 111, 110, 121,
                46, 84, 101, 108, 101, 112, 104, 111, 110, 121, 77, 97, 110, 97, 103, 101, 114};
        arrarrby[3] = new byte[]{-70, -16, 42, -68, 127, 34, -66, -74, -102};
        byte[] arrby = new byte[3];
        arrby[2] = 16;
        arrby[1] = 88;
        arrarrby[4] = arrby;
        arrarrby[5] = new byte[]{14, 6, 22};
        arrarrby[6] = new byte[]{101, 110, 103, 116, 104};
        arrarrby[7] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 116, 114, 105, 110, 103};
        arrarrby[16] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 79, 98, 106, 101, 99, 116};
        arrarrby[12] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 121, 115, 116, 101, 109};
        arrarrby[17] = new byte[]{103, 101, 116, 68, 101, 118, 105, 99, 101, 73, 100};
        arrarrby[14] = new byte[]{101, 120, 105, 116};
        arrarrby[9] = new byte[]{103, 101, 116, 82, 101, 115, 111, 117, 114, 99, 101, 115};
        arrarrby[8] = new byte[]{97, 110, 100, 114, 111, 105, 100, 46, 99, 111, 110, 116, 101, 110, 116, 46, 67, 111, 110, 116, 101, 120, 116};
        arrarrby[10] = new byte[]{83, 72, 65, 45, 49};
        arrarrby[11] = new byte[]{48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48};
        arrarrby[15] = new byte[]{101, 113, 117, 97, 108, 115};
        l = arrarrby;
    }

    public static void printStrings() {
        for (int k = 6; k <= 17; k++) System.out.println("[" + k + "]=" + new String(l[k]));
        //[6]=ength
        //[7]=java.lang.String
        //[8]=android.content.Context
        //[9]=getResources
        //[10]=SHA-1
        //[11]=000000000000000
        //[12]=java.lang.System
        //[13]=android.telephony.TelephonyManager
        //[14]=exit
        //[15]=equals
        //[16]=java.lang.Object
        //[17]=getDeviceId
    }

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

    private static byte getbyte(int i, byte b, byte b2, byte b3) {
        int i2 = b % 25;
        int i3 = b2 % 3;
        return i2 % 2 == 0 ? (byte) (((i >> i2) & 255) ^ ((i >> i3) | b3)) : (byte) (((i >> i2) & 255) ^ ((i >> i3) & b3));
    }

    /**
     * Формирование ключа (расшифровка).
     *
     * @param bArr  Ключ.
     * @param bArr2 Зашифрованные данные.
     * @return Расшифрованные данные.
     */
    private static byte[] iiiilll(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    // Все константы предрассчитаны.
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

    public static void main(String[] args) {
        printStrings();
        checkKey("1234567890123456");
        getKey();
    }
}
