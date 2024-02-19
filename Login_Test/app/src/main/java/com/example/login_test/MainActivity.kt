package com.example.login_test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var email: TextView
    private lateinit var logoutBtn: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        email = findViewById(R.id.email_tv)
        email.text = auth.currentUser?.email

        logoutBtn = findViewById(R.id.logoutBtn)
        logoutBtn.setOnClickListener {
            // Firebase Auth에서 sign out 기능 호출
            auth.signOut()

            // 로그인 페이지로 이동
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            // 현재 액티비티 종료
            finish()
        }
    }
}
