package com.example.diary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.room.Room
import com.example.diary.databinding.ActivityWorkBinding
import com.google.android.material.navigation.NavigationView

class WorkActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    private var mBinding: ActivityWorkBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "historyDB"
        ).build()

        binding.btnNavi.setOnClickListener{
            binding.layoutDrawer.openDrawer(GravityCompat.START) //Start: left - End: right
        }

        binding.naviView.setNavigationItemSelectedListener(this) //네이게이션뷰 메뉴 아이템에 클릭 시 수행

        binding.btnNext.setOnClickListener{
            val intent = Intent(this,TextActivity::class.java) //다음화면으로 넘어가는 인텐트 객체 생성
            startActivity(intent)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { //네비게이션 메뉴아이템 클릭시 수행
        when (item.itemId) {
            R.id.daily -> Toast.makeText(applicationContext,"일상일기", Toast.LENGTH_SHORT).show()
            R.id.work -> Toast.makeText(applicationContext,"업무일기", Toast.LENGTH_SHORT).show()
            R.id.learning -> Toast.makeText(applicationContext,"학습일기", Toast.LENGTH_SHORT).show()
            R.id.family -> Toast.makeText(applicationContext,"가족일기", Toast.LENGTH_SHORT).show()
            R.id.friend -> Toast.makeText(applicationContext,"친구일기", Toast.LENGTH_SHORT).show()
            R.id.emotion -> Toast.makeText(applicationContext,"감정일기", Toast.LENGTH_SHORT).show()
        }
        binding.layoutDrawer.closeDrawers() //토스트 메세지 띄운 이후 네비게이션 뷰닫기기
        return false
    }

    override fun onBackPressed() {
        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START)){
            binding.layoutDrawer.closeDrawers()
        }
        else{
            super.onBackPressed()
        }
    }

    //액티비티가 파괴될 때
    override fun onDestroy() {
        //onDestory에서 binding class 인스턴스 참조를 정리해 주어야한다.
        mBinding = null
        super.onDestroy()
    }
}