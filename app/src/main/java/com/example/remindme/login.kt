package com.example.remindme

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch
import java.lang.Exception


class login: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    fun loginGoogle(credential: AuthCredential, MainActivity:()-> Unit)
            = viewModelScope.launch {
        try {
            auth.signInWithCredential(credential).addOnCompleteListener{
                    task ->
                if (task.isSuccessful){
                    Log.d("RemindMe","Login Exitoso")
                    MainActivity()

                }
            }
                .addOnFailureListener {
                    Log.d("RemindMe","Login Fallado")
                }
        }
        catch (ex: Exception){
            Log.d("RemindMe","Excepcion con el Login"+ "${ex.localizedMessage}")


        }
    }



}