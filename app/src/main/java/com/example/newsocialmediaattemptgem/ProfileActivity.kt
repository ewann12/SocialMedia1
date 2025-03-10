package com.example.newsocialmediaattemptgem

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProfileActivity : AppCompatActivity() {

    private lateinit var usernameTextView: TextView
    private lateinit var emailTextView: TextView

    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile) // Replace with your layout

        usernameTextView = findViewById(R.id.profileUsername) // Replace with your TextView ID
        emailTextView = findViewById(R.id.profileEmail) // Replace with your TextView ID

        loadUserProfile()
    }

    private fun loadUserProfile() {
        val currentUser = auth.currentUser
        currentUser?.let { user ->
            firestore.collection("users")
                .document(user.uid)
                .get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        val userData = document.toObject(User::class.java)
                        userData?.let {
                            usernameTextView.text = it.username
                            emailTextView.text = it.email
                        }
                    } else {
                        // Handle user data not found
                    }
                }
                .addOnFailureListener {
                    // Handle Firestore error
                }
        }
    }
}