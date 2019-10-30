package com.example.mybindapp

import android.app.Application
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val viewProperies: MyViewObservable = MyViewObservable()

    fun setText(newName: String) {
        viewProperies.apply {
            if (newName.length > 10)
                myTextVisibility = View.GONE
            else
                myTextVisibility = View.VISIBLE

            myName = newName
        }
    }

    inner class MyViewObservable : BaseObservable() {
        @get: Bindable
        var myName: String = "Starter Name"
            set(myName) {
                field = myName
                notifyPropertyChanged(BR.myName)
            }

        @get: Bindable
        var myTextVisibility: Int = View.VISIBLE
            set(myTextVisibility) {
                field = myTextVisibility
                notifyPropertyChanged(BR.myTextVisibility)
            }
    }
}