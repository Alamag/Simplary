package bonch.hack.ssd.simplary.utils

import android.content.Context
import android.widget.Toast

object ToastHelper {
    fun showShort(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}