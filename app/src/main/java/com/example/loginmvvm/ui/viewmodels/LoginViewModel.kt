package com.example.loginmvvm.ui.viewmodels

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoginEnabled: Boolean = false
)

class LoginViewModel : ViewModel() {
    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    fun onEmailChange(email: String) {
        _loginState.update { currentState ->
            currentState.copy(
                email = email,
                isLoginEnabled = enableLogin(email, currentState.password)
            )
        }
    }

    fun onPasswordChange(password: String) {
        _loginState.update { currentState ->
            currentState.copy(
                password = password,
                isLoginEnabled = enableLogin(currentState.email, password)
            )
        }
    }

    fun onPasswordVisibilityChange() {
        _loginState.update { currentState ->
            currentState.copy(isPasswordVisible = !currentState.isPasswordVisible)
        }
    }

    private fun enableLogin(email: String, password: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    fun login() {
        // TODO: Implement actual login logic here
        // This would typically involve calling a repository or use case
    }
} 