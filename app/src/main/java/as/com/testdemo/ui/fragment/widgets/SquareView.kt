package `as`.com.testdemo.ui.fragment.widgets

import `as`.com.testdemo.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class SquareView : View {

   val value : Char?
    get
   private var shown = true
       get


   private var textPaint = Paint()
    private var rectPaint = Paint()

    private var length : Float

   constructor(context: Context?, c : Char?) : super(context) {
       value = c
       length = context?.resources?.getDimension(R.dimen.square_length)!!
       initPaints()
   }

    fun setShown(shown : Boolean){
        this.shown = shown
        invalidate()
    }


    fun initPaints(){
        textPaint.color = Color.BLUE
        textPaint.style = Paint.Style.FILL
        textPaint.textSize = context.resources.getDimension(R.dimen.square_text_size)


        rectPaint.color = Color.WHITE
        rectPaint.style = Paint.Style.FILL

    }


    override fun onDraw(canvas: Canvas?) {
        canvas?.drawRect(0f,0f, length,length, rectPaint)

        if(shown)
        canvas?.drawText( value.toString() , 0, 1, length/4,3 *length/4, textPaint)

    }



}