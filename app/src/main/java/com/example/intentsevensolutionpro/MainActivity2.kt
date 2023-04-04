package com.example.intentsevensolutionpro

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intentsevensolutionpro.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1단계 액티비티 전환

        // 2단계 데이터 받기 id, pw
        if(intent.hasExtra("no")){
        when(intent.getIntExtra("no",0)){
            0 -> {
                if (intent.hasExtra("id").equals("") && intent.hasExtra("pw").equals("")) {
                    Toast.makeText(applicationContext, "id 와 pw 가 없습니다.", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    val id = intent.getStringExtra("id")
                    val pw = intent.getStringExtra("pw")
                    Toast.makeText(applicationContext,"${id} ${pw}", Toast.LENGTH_SHORT).show()
                }
            }
            1 -> {}
            2 -> {}
            // 3단계 데이터 객체로 보내기(serializable)
            3 -> {
                val loginData = intent.getSerializableExtra("loginData") as LoginData
                Toast.makeText(applicationContext,"${loginData.id} ${loginData.pw}", Toast.LENGTH_SHORT).show()
            }
            4 -> {
                val loginDataParcel = intent.getParcelableExtra<LoginDataParcel>("loginDataParcel")
                Toast.makeText(applicationContext,"${loginDataParcel?.id} ${loginDataParcel?.pw}", Toast.LENGTH_SHORT).show()
            }
            5 -> {
                val loginDataParcelList = intent.getParcelableArrayListExtra<LoginDataParcel>("loginDataParcelList")
                Toast.makeText(applicationContext,"${loginDataParcelList?.get(1)?.id} ${loginDataParcelList?.get(1)?.pw}", Toast.LENGTH_SHORT).show()
            }
            6 -> {}
            7 -> {}

        }

        }

    }
}