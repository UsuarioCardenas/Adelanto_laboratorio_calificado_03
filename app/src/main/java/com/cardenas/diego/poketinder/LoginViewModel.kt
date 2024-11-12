package com.cardenas.diego.poketinder

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(
    val context: Context
): ViewModel() {

    val inputsError = MutableLiveData<Boolean>()
    val registerError = MutableLiveData<Boolean>()
    val authError = MutableLiveData<Boolean>()
    val loginSuccess = MutableLiveData<Boolean>()
    private var sharedPreferencesRepository: SharedPreferencesRepository =
        SharedPreferencesRepository().also {
            it.setSharedPreference(context)
        }
    fun validateInputs(email: String, password: String)
    {
        if (isEmptyInputs(email, password))
        {
            inputsError.postValue(true)
            return
        }
        val emailSharedPreferences = sharedPreferencesRepository.getUserEmail()
        val passwordPreferences = sharedPreferencesRepository.getUserPassword()
        if (emailSharedPreferences.isEmpty()) {
            registerError.postValue(true)
            return
        }
        if (emailSharedPreferences == email && passwordPreferences == password)
        {
            loginSuccess.postValue(true)
        } else
        {
            authError.postValue(true)
        }
    }
    private fun isEmptyInputs(email: String, password: String) =
        email.isEmpty() || password.isEmpty()
}
