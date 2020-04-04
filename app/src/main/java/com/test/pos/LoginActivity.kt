package com.test.pos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        var username: String = intent.getStringExtra("Username")
        var password: String = intent.getStringExtra("Password")
        et_username.setText(username)
        et_password.setText(password)

    }
}
