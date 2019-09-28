package `as`.com.testdemo.ui.fragment

import `as`.com.testdemo.R
import `as`.com.testdemo.datamodals.Data
import `as`.com.testdemo.datamodals.ResponseModal
import `as`.com.testdemo.ui.fragment.widgets.InputView
import `as`.com.testdemo.ui.fragment.widgets.KeyBoardView
import `as`.com.testdemo.ui.fragment.widgets.OnSuccessValidationListener
import `as`.com.testdemo.viewmodal.LogoListViewModal
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.logo_main_layout.*

class LogoFragment : Fragment(), OnSuccessValidationListener, KeyBoardView.OnKeyListener {
    override fun onKey(key: Char) {
        inputView.onKeyEntered(key)
    }

    override fun onSuccessFullyValidated() {
        current++;

        updateUI()

    }

    lateinit var viewmodal : LogoListViewModal
    var current = 0
    var list : List<Data>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodal = ViewModelProviders.of(this).get(LogoListViewModal::class.java)
        viewmodal.listData.observe(this, Observer {
            data ->
            initUI(data)
        })
        viewmodal.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.logo_main_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    lateinit var inputView : InputView

    fun updateUI(){

        Picasso.get().load(list?.get(current)?.imgUrl).into(logo)

        dynamic.removeAllViews()

         inputView = InputView(requireContext(), this, list?.get(current)?.name)

        dynamic.addView(inputView)

        var keyboardView = KeyBoardView(requireContext(),  list?.get(current)?.name!!, this)


        dynamic.addView(keyboardView)


    }

    fun initUI(response : ResponseModal?){
        this.list = response?.list

        Picasso.get().load(list?.get(current)?.imgUrl).into(logo)


        dynamic.removeAllViews()
        inputView = InputView(requireContext(), this, list?.get(current)?.name)
        dynamic.addView(inputView)

        var keyboardView = KeyBoardView(requireContext(),  list?.get(current)?.name!!, this)


        dynamic.addView(keyboardView)

    }


}

