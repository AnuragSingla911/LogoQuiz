package `as`.com.testdemo

import `as`.com.testdemo.ui.fragment.repor.VolleyWrapper
import android.app.Application

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        VolleyWrapper.getInstance(this)
    }

}