package org.poriad.planyourweek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.poriad.planyourweek.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onStart()

        binding.logoutButton.setOnClickListener {
            signOut()
        }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            if (currentUser.isEmailVerified) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                startActivity(Intent(this, CheckEmailActivity::class.java))
            }
        }
    }
    private fun signOut() {
        Firebase.auth.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}