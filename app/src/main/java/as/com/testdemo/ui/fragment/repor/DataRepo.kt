package `as`.com.testdemo.ui.fragment.repor

import `as`.com.testdemo.datamodals.ResponseModal
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.android.volley.Response
import com.android.volley.VolleyError

class DataRepo : Response.Listener<ResponseModal>, Response.ErrorListener {

    override fun onErrorResponse(error: VolleyError?) {

    }

    override fun onResponse(response: ResponseModal?) {
        liveData.value = response
    }

    var liveData  = MutableLiveData<ResponseModal>()

    fun getData() : LiveData<ResponseModal>{



        var request = ServerRequest(1, "https//jsonblob.com/6ea497e4-e1c8-11e9-902b-df371d1bb4ea", this)

        request?.setSuccessListener(this)

        VolleyWrapper.getInstance()?.requestQueue?.add(request)
        https@ //jsonblob.com/6ea497e4-e1c8-11e9-902b-df371d1bb4ea

        return liveData


    }

}