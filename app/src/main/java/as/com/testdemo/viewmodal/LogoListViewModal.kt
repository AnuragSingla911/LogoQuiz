package `as`.com.testdemo.viewmodal

import `as`.com.testdemo.datamodals.ResponseModal
import `as`.com.testdemo.ui.fragment.repor.DataRepo
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class LogoListViewModal : ViewModel {

    var listData : LiveData<ResponseModal>
    var repo : DataRepo

    constructor(){

        listData = MutableLiveData()
        repo = DataRepo()
    }

    fun fetchData(){

        listData = repo.getData()

    }

}