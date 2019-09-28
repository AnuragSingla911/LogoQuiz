package `as`.com.testdemo.ui.fragment.repor

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleyWrapper {

    private constructor(context: Context){
        requestQueue = Volley.newRequestQueue(context)
    }

    init {
        INSTANCE = this
    }

    lateinit var requestQueue: RequestQueue

    companion object {

        lateinit var INSTANCE: VolleyWrapper

        fun getInstance() : VolleyWrapper?{
            return INSTANCE
        }

        fun getInstance(context: Context) : VolleyWrapper{
            if(INSTANCE == null){
                synchronized(VolleyWrapper::class.java){
                    if(INSTANCE == null){
                        INSTANCE = VolleyWrapper(context)
                    }
                }
            }
            return INSTANCE
        }

    }
}