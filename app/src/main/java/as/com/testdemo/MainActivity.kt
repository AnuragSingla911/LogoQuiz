package `as`.com.testdemo

import `as`.com.testdemo.ui.fragment.LogoFragment
import `as`.com.testdemo.ui.fragment.widgets.InputView
import `as`.com.testdemo.ui.fragment.widgets.OnSuccessValidationListener
import `as`.com.testdemo.ui.fragment.widgets.SquareView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnSuccessValidationListener {

    override fun onSuccessFullyValidated() {
        Log.d("anurag"," validated")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment = LogoFragment()

        supportFragmentManager?.beginTransaction()?.add(R.id.linear, fragment)





    }
}
