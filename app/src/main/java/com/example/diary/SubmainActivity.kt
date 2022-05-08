 package com.example.diary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diary.databinding.ActivitySubmainBinding

 class SubmainActivity : AppCompatActivity() {
    private var mBinding: ActivitySubmainBinding? = null
     private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivitySubmainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDaily.setOnClickListener{
            val intent = Intent(this,DailyActivity::class.java) //다음화면으로 넘어가는 인텐트 객체 생성
            startActivity(intent)
        }
        binding.btnWork.setOnClickListener{
            val intent = Intent(this,WorkActivity::class.java) //다음화면으로 넘어가는 인텐트 객체 생성
            startActivity(intent)
        }
        binding.btnEmotion.setOnClickListener{
            val intent = Intent(this,EmotionActivity::class.java) //다음화면으로 넘어가는 인텐트 객체 생성
            startActivity(intent)
        }
        binding.btnFamily.setOnClickListener{
            val intent = Intent(this,FamilyActivity::class.java) //다음화면으로 넘어가는 인텐트 객체 생성
            startActivity(intent)
        }
        binding.btnFriend.setOnClickListener{
            val intent = Intent(this,FriendActivity::class.java) //다음화면으로 넘어가는 인텐트 객체 생성
            startActivity(intent)
        }
        binding.btnLearning.setOnClickListener{
            val intent = Intent(this,LearningActivity::class.java) //다음화면으로 넘어가는 인텐트 객체 생성
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