package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.arrow.setOnClickListener {
            exit()
        }


        val clickItem = intent.getParcelableExtra<MyItem>("clickItem")



        if (clickItem != null) {

            binding.goods.setImageResource(clickItem.aIcon)
            binding.textView2.text = clickItem.aNickname
            binding.textView3.text = clickItem.aAdress
            binding.textView6.text = clickItem.aTitle
            binding.textView7.text = clickItem.aReason
            binding.textView8.text = clickItem.aPrice

            var heart = clickItem?.heart == true

            binding.heart.setImageResource(if(heart) {R.drawable.fillheart}else{R.drawable.empty_heart})

            binding.heart.setOnClickListener {
                if(!heart){
                    binding.heart.setImageResource(R.drawable.fillheart)
                    Snackbar.make(binding.constraintLayout, "관심목록에 추가됐습니다.", Snackbar.LENGTH_SHORT).show()
                    heart = true
                } else {
                    binding.heart.setImageResource(R.drawable.empty_heart)
                    heart = false
                }
            }
        }
    }

    fun exit() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("clickItem", intent)
            putExtra("heart", intent)
        }
        setResult(RESULT_OK, intent)
        if (!isFinishing) finish()
    }
    override fun onBackPressed() {
        exit()
    }
}