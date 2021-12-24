package org.poriad.planyourweek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.poriad.planyourweek.databinding.ActivityRegisterBinding
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.registerButton.setOnClickListener {
            val registerEmail = binding.emailRegister.text.toString()
            val registerPassword = binding.passwordRegister.text.toString()

            val passwordRegex = Pattern.compile("^(?=.*[-@#$%^&+=]).{6,}$")

            if (registerEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(registerEmail).matches()) {
                Toast.makeText(baseContext, "Invalid email.",
                    Toast.LENGTH_SHORT).show()
            } else if (registerPassword.isEmpty() || !passwordRegex.matcher(registerPassword).matches()) {
                Toast.makeText(baseContext, "Invalid password.",
                    Toast.LENGTH_SHORT).show()
            } else {
                createAccount(registerEmail, registerPassword)
            }
        }

    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, CheckEmailActivity::class.java))
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "createUserWithEmail:success")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}