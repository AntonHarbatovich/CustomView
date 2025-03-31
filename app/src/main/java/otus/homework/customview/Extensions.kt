package otus.homework.customview

import android.content.res.Resources
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.RequiresApi

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()


inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}
