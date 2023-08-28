package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val clickItem = intent.getParcelableExtra<MyItem>("clickItem")

        if (clickItem != null) {

            binding.goods.setImageResource(clickItem.aIcon)
            binding.textView2.text = clickItem.aNickname
            binding.textView3.text = clickItem.aAdress
            binding.textView6.text = clickItem.aTitle
            binding.textView7.text = clickItem.aReason
            binding.textView8.text = clickItem.aPrice

        }
    }
}