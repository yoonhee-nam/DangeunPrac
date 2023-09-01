package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var heart: Boolean = false
    private var aLike = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        aLike = intent.getIntExtra("aLike",0)


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

            heart = clickItem.heart

            binding.heart.setImageResource(if (heart) R.drawable.fillheart else R.drawable.empty_heart)

            binding.heart.setOnClickListener {
                heart = if(!heart){
                    aLike += 1
                    binding.heart.setImageResource(R.drawable.fillheart)
                    Snackbar.make(binding.constraintLayout, "관심목록에 추가됐습니다.", Snackbar.LENGTH_SHORT).show()
                    true
                } else {
                    aLike -= 1
                    binding.heart.setImageResource(R.drawable.empty_heart)
                    false
                }
            }
        }
    }


    fun exit() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("itemIndex", intent.getIntExtra("itemIndex",0))
            putExtra("heart", heart)
            putExtra("aLike", aLike)
        }
        setResult(RESULT_OK, intent)
        if (!isFinishing) finish()
    }
    override fun onBackPressed() {
        exit()
    }
}