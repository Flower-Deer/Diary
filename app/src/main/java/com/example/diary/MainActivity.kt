package com.example.diary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubMain.setOnClickListener{
            val intent =Intent(this,SubmainActivity::class.java) //다음화면으로 넘어가는 인텐트 객체 생성
            startActivity(intent)
        }

    }

    //액티비티가 파괴될 때
    override fun onDestroy() {
        //onDestory에서 binding class 인스턴스 참조를 정리해 주어야한다.
        mBinding = null
        super.onDestroy()
    }

}