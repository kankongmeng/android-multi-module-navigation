package com.brian.core.helper

import android.content.Context
import android.widget.Toast

object ViewUtils {
    fun showToastShort(ctx: Context, text: String) {
        Toast.makeText(ctx, text, Toast.LENGTH_SHORT).show()
    }
}
