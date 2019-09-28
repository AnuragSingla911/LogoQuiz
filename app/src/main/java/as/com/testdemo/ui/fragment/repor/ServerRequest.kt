package `as`.com.testdemo.ui.fragment.repor

import `as`.com.testdemo.datamodals.ResponseModal
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.google.gson.Gson
import com.google.gson.GsonBuilder


class ServerRequest(method: Int, url: String?, listener: Response.ErrorListener?) :
    Request<ResponseModal>(method, url, listener) {

    var listener : Response.Listener<ResponseModal>? = null

    fun setSuccessListener(listener : Response.Listener<ResponseModal>?){
        this.listener = listener
    }

    override fun parseNetworkResponse(response: NetworkResponse?): Response<ResponseModal> {
        val builder = GsonBuilder()
        val mGson = builder.create()
       var data : ResponseModal = mGson.fromJson(String(response?.data!!), ResponseModal::class.java)
        return Response.success(data, null)
    }

    override fun deliverResponse(response: ResponseModal?) {
        listener?.onResponse(response)
    }


}