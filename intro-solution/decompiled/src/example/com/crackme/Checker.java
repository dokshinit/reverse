package example.com.crackme;

import android.content.Context;
import example.com.crackme.i;

public class Checker {
    public static boolean check(String str, Context context) {
        return i.checkKey(str, context) == i.Status.KEY_GOOD;
    }

    public boolean getRandomBoolean() {
        return Math.random() < 0.5d;
    }
}
