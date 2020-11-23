package example.com.crackme;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class i {
    static final /* synthetic */ boolean $assertionsDisabled = (!i.class.desiredAssertionStatus());
    private static byte[][] l;

    public enum Status {
        KEY_GOOD,
        KEY_INVALID
    }

    static {
        l = new byte[0][];
        byte[][] bArr = new byte[20][];
        bArr[0] = new byte[]{26, 6, 125};
        bArr[1] = new byte[]{64, 118, -91, 90, 7, -17, -114, 118, -49, 31, -40};
        bArr[2] = new byte[]{8, 1, 36};
        bArr[13] = new byte[]{97, 110, 100, 114, 111, 105, 100, 46, 116, 101, 108, 101, 112, 104, 111, 110, 121, 46, 84, 101, 108, 101, 112, 104, 111, 110, 121, 77, 97, 110, 97, 103, 101, 114};
        bArr[3] = new byte[]{-70, -16, 42, -68, Byte.MAX_VALUE, 34, -66, -74, -102};
        byte[] bArr2 = new byte[3];
        bArr2[2] = 16;
        bArr2[1] = 88;
        bArr[4] = bArr2;
        bArr[5] = new byte[]{14, 6, 22};
        bArr[6] = new byte[]{101, 110, 103, 116, 104};
        bArr[7] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 116, 114, 105, 110, 103};
        bArr[16] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 79, 98, 106, 101, 99, 116};
        bArr[12] = new byte[]{106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 121, 115, 116, 101, 109};
        bArr[17] = new byte[]{103, 101, 116, 68, 101, 118, 105, 99, 101, 73, 100};
        bArr[14] = new byte[]{101, 120, 105, 116};
        bArr[9] = new byte[]{103, 101, 116, 82, 101, 115, 111, 117, 114, 99, 101, 115};
        bArr[8] = new byte[]{97, 110, 100, 114, 111, 105, 100, 46, 99, 111, 110, 116, 101, 110, 116, 46, 67, 111, 110, 116, 101, 120, 116};
        bArr[10] = new byte[]{83, 72, 65, 45, 49};
        bArr[11] = new byte[]{48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48};
        bArr[15] = new byte[]{101, 113, 117, 97, 108, 115};
        l = bArr;
    }

    @TargetApi(19)
    public static Status checkKey(String str, Context context) {
        try {
            Class<?> cls = Class.forName(new String(l[7]));
            Class<?> cls2 = Class.forName(new String(l[8]));
            try {
                if ($assertionsDisabled || cls2 != null) {
                    Method declaredMethod = cls2.getDeclaredMethod(new String(l[9]), new Class[0]);
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    try {
                        if (!$assertionsDisabled && cls == null) {
                            throw new AssertionError();
                        } else if ($assertionsDisabled || declaredMethod != null) {
                            Method declaredMethod2 = cls.getDeclaredMethod(Character.toString(((Resources) declaredMethod.invoke(context, new Object[0])).getString(R.string.good).charAt(9)) + new String(l[6]), new Class[0]);
                            try {
                                Method declaredMethod3 = cls.getDeclaredMethod(new String(l[15]), Object.class);
                                try {
                                    Class<?> cls3 = Class.forName(new String(l[12]));
                                    Class<?> cls4 = Class.forName(new String(l[13]));
                                    try {
                                        if (!$assertionsDisabled && cls4 == null) {
                                            throw new AssertionError();
                                        } else if ($assertionsDisabled || cls3 != null) {
                                            Method declaredMethod4 = cls4.getDeclaredMethod(new String(l[17]), new Class[0]);
                                            Method declaredMethod5 = cls3.getDeclaredMethod(new String(l[14]), Integer.TYPE);
                                            try {
                                                if (((Boolean) declaredMethod3.invoke(declaredMethod4.invoke(telephonyManager, new Object[0]), new String(l[11]))).booleanValue()) {
                                                    declaredMethod5.invoke(cls3, 0);
                                                }
                                                try {
                                                    if ($assertionsDisabled || declaredMethod2 != null) {
                                                        if (!((Boolean) declaredMethod3.invoke(Integer.toString(((Integer) declaredMethod2.invoke(str.replaceAll("-", "").toLowerCase(Locale.UK), new Object[0])).intValue()), Integer.toString(l[4][2]))).booleanValue()) {
                                                            return Status.KEY_INVALID;
                                                        }
                                                        try {
                                                            byte[] copyOf = Arrays.copyOf(MessageDigest.getInstance(new String(l[10])).digest(new byte[]{getbyte(123, l[5][0], l[0][2], l[0][1]), 2, getbyte(321, l[0][1], l[5][0], l[0][2])}), (int) l[4][2]);
                                                            byte[] bArr = new byte[(l[1].length + l[3].length)];
                                                            System.arraycopy(l[1], 0, bArr, 0, l[1].length);
                                                            System.arraycopy(l[3], 0, bArr, l[1].length, l[3].length);
                                                            byte[] bArr2 = new byte[(bArr.length + 12)];
                                                            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                                                            System.arraycopy(new byte[]{122, 125, -19, 33, 69, 71, 112, -6, 36, 19, -90, 118}, 0, bArr2, bArr.length, 12);
                                                            return ((Boolean) declaredMethod3.invoke(str.replaceAll("-", "").toLowerCase(Locale.UK), new Object[]{new String(iiiilll(copyOf, bArr2))})).booleanValue() ? Status.KEY_GOOD : Status.KEY_INVALID;
                                                        } catch (NumberFormatException e) {
                                                            return Status.KEY_INVALID;
                                                        } catch (Exception e2) {
                                                            return Status.KEY_GOOD;
                                                        }
                                                    } else {
                                                        throw new AssertionError();
                                                    }
                                                } catch (IllegalAccessException | InvocationTargetException e3) {
                                                    return Status.KEY_INVALID;
                                                }
                                            } catch (IllegalAccessException | InvocationTargetException e4) {
                                                return Status.KEY_INVALID;
                                            }
                                        } else {
                                            throw new AssertionError();
                                        }
                                    } catch (NoSuchMethodException e5) {
                                        return Status.KEY_INVALID;
                                    }
                                } catch (ClassNotFoundException e6) {
                                    return Status.KEY_INVALID;
                                }
                            } catch (NoSuchMethodException e7) {
                                return Status.KEY_INVALID;
                            }
                        } else {
                            throw new AssertionError();
                        }
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e8) {
                        return Status.KEY_INVALID;
                    }
                } else {
                    throw new AssertionError();
                }
            } catch (NoSuchMethodException e9) {
                return Status.KEY_INVALID;
            }
        } catch (ClassNotFoundException e10) {
            return Status.KEY_INVALID;
        }
    }

    private static byte getbyte(int i, byte b, byte b2, byte b3) {
        int i2 = b % 25;
        int i3 = b2 % 3;
        return i2 % 2 == 0 ? (byte) (((i >> i2) & 255) ^ ((i >> i3) | b3)) : (byte) (((i >> i2) & 255) ^ ((i >> i3) & b3));
    }

    private static byte[] iiiilll(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    protected static String intToHex(Number number, int i) {
        return String.format("%0" + i + "x", number);
    }
}
