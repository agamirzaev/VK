package com.example.vkwall.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

public class Input {
    private static InputMethodManager imm;

    public static void hide(Context context) {
        imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS, 0);
    }
}
