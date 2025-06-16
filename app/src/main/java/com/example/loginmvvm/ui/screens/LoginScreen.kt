package com.example.loginmvvm.ui.screens

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginmvvm.R
import com.example.loginmvvm.ui.viewmodels.LoginViewModel
import com.example.loginmvvm.ui.viewmodels.LoginState

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel()
) {
    val loginState by viewModel.loginState.collectAsState()

    Box(
        Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(
            modifier = Modifier.align(Alignment.Center),
            loginState = loginState,
            onEmailChange = viewModel::onEmailChange,
            onPasswordChange = viewModel::onPasswordChange,
            onPasswordVisibilityChange = viewModel::onPasswordVisibilityChange,
            onLoginClick = viewModel::login
        )
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalDivider(
            Modifier
                .background(Color(0XFFF9F9F9))
                .height(3.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        SignUp()
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun SignUp() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            "Don't have an account?",
            fontSize = 12.sp,
            color = Color(0XFFB5B5B5),
        )
        Text(
            "Sign Up",
            Modifier.padding(horizontal = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun Body(
    modifier: Modifier,
    loginState: LoginState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityChange: () -> Unit,
    onLoginClick: () -> Unit
) {
    Column(modifier = modifier) {
        LogoLogin(Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.size(48.dp))
        Email(
            email = loginState.email,
            onTextChanged = onEmailChange
        )
        Spacer(Modifier.size(16.dp))
        Password(
            password = loginState.password,
            isPasswordVisible = loginState.isPasswordVisible,
            onTextChanged = onPasswordChange,
            onPasswordVisibilityChange = onPasswordVisibilityChange
        )
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(Modifier.size(32.dp))
        LoginButton(
            loginEnable = loginState.isLoginEnabled,
            onLoginClick = onLoginClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun LoginButton(
    loginEnable: Boolean,
    onLoginClick: () -> Unit,
    modifier: Modifier
) {
    Button(
        onClick = onLoginClick,
        enabled = loginEnable,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EA8E9),
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text("Login")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@Composable
fun Password(
    password: String,
    isPasswordVisible: Boolean,
    onTextChanged: (String) -> Unit,
    onPasswordVisibilityChange: () -> Unit
) {
    TextField(
        value = password,
        onValueChange = onTextChanged,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Password") },
        shape = RoundedCornerShape(16.dp),
        minLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color(0XFF4285F4),
            unfocusedIndicatorColor = Color(0XFF4285F4),
            focusedContainerColor = Color(0xFFFAFAFA),
            unfocusedContainerColor = Color(0xFFFAFAFA)
        ),
        trailingIcon = {
            val imagen = if (isPasswordVisible) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            IconButton(onClick = onPasswordVisibilityChange) {
                Icon(imageVector = imagen, contentDescription = "show password")
            }
        },
        visualTransformation = if (isPasswordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = onTextChanged,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Email") },
        shape = RoundedCornerShape(8.dp),
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color(0XFF4285F4),
            unfocusedIndicatorColor = Color(0XFF4285F4),
            focusedContainerColor = Color(0xFFFAFAFA),
            unfocusedContainerColor = Color(0xFFFAFAFA)
        ),
        trailingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")
        }
    )
}

@Composable
fun LogoLogin(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.tutoria),
        contentDescription = "Logo Login",
        modifier = modifier
    )
}

@Composable
fun Header(modifier: Modifier) {
    val context = LocalContext.current
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "close icon",
        modifier = modifier.clickable { (context as Activity).finish() }
    )
} 