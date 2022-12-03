package com.app.firebasedemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         var firestore:FirebaseFirestore = FirebaseFirestore.getInstance()

        var hashMap : HashMap<String, Int>
                = HashMap<String, Int> ()


        //adding elements to the hashMap using
        // put() function
        val add = HashMap<String,Any>()

        add["firstName"] = "ihsanaaa"
        add["lastName"] = "syafiul umamhhd"
        add["email"] = "ihsansyafiul@gmail.com"
        add["password"] = "ayangaku"

        firestore.collection("users")
            .add(add)
            .addOnSuccessListener {
                Toast.makeText(this,"Data added ",Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(this," Data not added ",Toast.LENGTH_LONG).show()
            }

        // Write a message to the database
        // Write a message to the database
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef: DatabaseReference = database.getReference("message")
        var myUsers: DatabaseReference = database.getReference("users")
        myUsers.setValue(add)

        myRef.setValue("Hello, anjeli yee!")
    }
}