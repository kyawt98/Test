package com.test.pos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_register.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_register)

        txtLogin.setOnClickListener{
            var email = et_username.text.toString()
            var password = et_password.text.toString()
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            intent.putExtra("Username", email)
            intent.putExtra("Password", password)
            startActivity(intent)
        }

        btn_register.setOnClickListener {
            var firstname = et_firstname.text.toString()
            var lastname = et_lastname.text
            var email = et_username.text.toString()
            var password = et_password.text.toString()
            var retypePassword = et_retypepassword.text.toString()

            if (firstname.isEmpty()) {
                Toast.makeText(applicationContext, "First Name is required", Toast.LENGTH_LONG)
                    .show()
            } else {
                if (lastname.isEmpty()) {
                    Toast.makeText(applicationContext, "Last Name is required", Toast.LENGTH_LONG)
                        .show()
                } else {

                    if (email.isEmpty()) {
                        Toast.makeText(
                            applicationContext,
                            "User Name is required",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    } else {

                        if (retypePassword == password && password.isNotEmpty()) {
                            val intent = Intent(this@MainActivity, LoginActivity::class.java)
                            intent.putExtra("Username", email)
                            intent.putExtra("Password", password)
                            startActivity(intent)

                            Toast.makeText(
                                applicationContext,
                                "Registered!!",
                                Toast.LENGTH_LONG
                            )
                                .show()

                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Passwords are not match",
                                Toast.LENGTH_LONG
                            )
                                .show()

                        }
                    }
                }
            }
        }
    }
}

