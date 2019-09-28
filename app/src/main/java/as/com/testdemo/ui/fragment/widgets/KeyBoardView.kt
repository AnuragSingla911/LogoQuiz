package `as`.com.testdemo.ui.fragment.widgets

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout


class KeyBoardView : LinearLayout, View.OnClickListener {

    interface OnKeyListener{
        fun onKey(key : Char)
    }

    override fun onClick(v: View?) {
        if(v is SquareView){
            onKeyListener.onKey(v.value!!)
        }
    }

    var value : String
    var onKeyListener : OnKeyListener

    constructor(context : Context, value : String, onKeyListener: OnKeyListener) : super(context){
        this.value = value
        this.onKeyListener = onKeyListener
        initViews()
    }

    fun initViews(){
        this.orientation = LinearLayout.HORIZONTAL
        this.layoutParams = LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        for(i in 0..value.length-1){
            var squareView = SquareView(context, value.get(i))
            squareView.setOnClickListener(this)
            addView(squareView)
        }
    }
}