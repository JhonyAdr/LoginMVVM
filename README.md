# Login MVVM - Aplicación de Login con Patrón MVVM

## 📱 Descripción
Login MVVM es una aplicación Android que demuestra la implementación de un sistema de login básico utilizando el patrón de arquitectura MVVM (Model-View-ViewModel) con Jetpack Compose.

## 🛠 Tecnologías Utilizadas
- Kotlin
- Jetpack Compose
- MVVM Architecture
- StateFlow
- Material Design 3

## 🏗 Estructura del Proyecto
```
app/
├── src/main/java/com/example/loginmvvm/
│   ├── ui/
│   │   ├── screens/
│   │   │   └── LoginScreen.kt    # UI Components
│   │   └── viewmodels/
│   │       └── LoginViewModel.kt # Business Logic
│   └── MainActivity.kt
```

## ✨ Características
- Interfaz de usuario moderna con Material Design 3
- Validación de email en tiempo real
- Contraseña con opción de mostrar/ocultar
- Botón de login que se habilita/deshabilita según la validación
- Implementación del patrón MVVM
- Manejo de estado con StateFlow

## 🚀 Cómo Ejecutar el Proyecto

1. Clona el repositorio:
```bash
git clone https://github.com/tu-usuario/login-mvvm.git
```

2. Abre el proyecto en Android Studio

3. Sincroniza el proyecto con los archivos Gradle

4. Ejecuta la aplicación en un emulador o dispositivo físico

## 📦 Dependencias Principales
```kotlin
dependencies {
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.4")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
}
```

## 🎯 Funcionalidades Implementadas

### Validación de Email
- Verifica el formato del email en tiempo real
- Utiliza el patrón de validación de Android

### Manejo de Contraseña
- Mínimo 6 caracteres
- Opción para mostrar/ocultar contraseña
- Validación en tiempo real

### Estado de la UI
- Botón de login se habilita/deshabilita automáticamente
- Feedback visual del estado de los campos
- Manejo de estado centralizado en el ViewModel

## 🎨 UI Components
- `LoginScreen`: Pantalla principal de login
- `Email`: Campo de entrada para email
- `Password`: Campo de entrada para contraseña
- `LoginButton`: Botón de login
- `Header`: Encabezado con botón de cerrar
- `Footer`: Pie de página con opción de registro

## 🔄 Flujo de Datos
1. Usuario ingresa datos
2. ViewModel valida la información
3. UI se actualiza automáticamente
4. Botón de login se habilita/deshabilita según la validación

## 🛠 Próximas Mejoras
- [ ] Implementar autenticación real
- [ ] Agregar persistencia de datos
- [ ] Implementar recuperación de contraseña
- [ ] Agregar animaciones
- [ ] Implementar temas claro/oscuro


⭐️ Si te gustó el proyecto, dale una estrella en GitHub! 
