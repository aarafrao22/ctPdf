package com.grandmaaverse.pdfApp

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.grandmaaverse.pdfApp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    //    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    var status: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        status = sharedPref.getBoolean("page", false)

//        auth = Firebase.auth


        binding.btnLogin.setOnClickListener {

            val email = binding.edEmail.text.toString()
            val password = binding.edPassword.text.toString()

            if (status == false) {
                if (email == "abc@gmail.com" && password == "12345") {
                    val intent: Intent = Intent(this, IndexActivity::class.java)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this, "Logged In Successfully!", Toast.LENGTH_SHORT).show()
                    editor = sharedPref.edit()
                    editor.putBoolean("page", true)
                    editor.apply()

                } else {
                    Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show()
                }
            }

        }


//        binding.btnLogin.setOnClickListener {
//            if (email.isEmpty()) {
//                binding.edEmail.setError("Required");
//            } else {
//                binding.edEmail.setError(null);
//            }
//            if (password.isEmpty()) {
//                binding.edPassword.setError("Required");
//            } else {
//                binding.edPassword.setError(null);
//            }
//
//            auth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this) { task ->
//                    if (task.isSuccessful) {
//                        // Sign in success, update UI with the signed-in user's information
//                        Log.d(TAG, "signInWithEmail:success")
//                        val user = auth.currentUser
////                        updateUI(user)
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        Log.w(TAG, "signInWithEmail:failure", task.exception)
//                        Toast.makeText(
//                            baseContext, "Authentication failed.",
//                            Toast.LENGTH_SHORT
//                        ).show()
////                        updateUI(null)
//                    }
//                }
//
//        }


        binding.getCredentials.setOnClickListener {
            val number = "923313344034"
            val url = "https://api.whatsapp.com/send?phone=$number"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }


    }

    override fun onStart() {
        super.onStart()
        if (status==true){
            val intent: Intent = Intent(this, IndexActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}