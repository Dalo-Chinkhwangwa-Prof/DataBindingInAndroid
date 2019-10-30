package com.example.mybindapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.mybindapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        myViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.mainViewModel = myViewModel.viewProperies

        binding.myEdittext.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                myViewModel.setText(s.toString().toUpperCase())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
            }

        })
    }
}
