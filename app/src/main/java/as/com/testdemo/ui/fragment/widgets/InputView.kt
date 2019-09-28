package `as`.com.testdemo.ui.fragment.widgets

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout


class InputView : LinearLayout {

    fun onKeyEntered(key : Char) {
        validable.incrementCount(key)
        if(validable.isValidated()){
            onSuccessValidationListener.onSuccessFullyValidated()
        }

    }

    var validable : Validable

    var onSuccessValidationListener : OnSuccessValidationListener

    var value : String?

    var map : HashMap<Char?, SquareView>  = HashMap()


    constructor(context : Context, onSuccessValidationListener: OnSuccessValidationListener, value : String?) : super(context){
        this.onSuccessValidationListener = onSuccessValidationListener
        this.value = value
        initViews()
        validable = InputViewValidableImpl(value, map)
    }

    fun initViews(){
        this.orientation = LinearLayout.HORIZONTAL
        this.layoutParams = LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        for(i in 0..value?.length!!-1){
            var squareView = SquareView(context, value?.get(i))
            addView(squareView)
            map.put(value?.get(i), squareView)
        }
    }
}