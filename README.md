# 📚 Spring 1: Sistema Gestión Tutorías Académicas
Plataforma web que centraliza y automatiza la gestión de asesorías académicas entre tutores y estudiantes, 
eliminando la coordinación manual y desorganizada que genera conflictos de horario, doble reserva y falta de seguimiento.

## 🛠️ Tecnologías Utilizadas
- MongoDB Atlas --	Base de datos no relacional hospedada en la nube 
- Spring Boot	-- API REST con autenticación JWT
- React -- Interfaz de usuario con Login y CRUD

## 📁 Estructura del Proyecto
 
```
gestion-tutorias-v2/
│
├── backend/                          # Spring Boot
│   ├── src/
│   │   └── main/
│   │       ├── java/co/edu/gestiontutoriasmongo/
│   │       │   ├── config/
│   │       │   │   ├── JwtFilter.java        # Filtro JWT
│   │       │   │   ├── JwtUtil.java          # Utilidad JWT
│   │       │   │   └── SecurityConfig.java   # Configuración seguridad
│   │       │   ├── controller/
│   │       │   │   └── UsuarioController.java
│   │       │   ├── DTO/
│   │       │   │   ├── LoginDTO.java
│   │       │   │   ├── RegistroUsuarioDTO.java
│   │       │   │   └── UsuarioRespuestaDTO.java
│   │       │   ├── excepcion/
│   │       │   │   ├── ApiExcepcion.java
│   │       │   │   └── GlobalExcepcionHandler.java
│   │       │   ├── model/
│   │       │   │   ├── TipoUsuario.java      # Enum: tutor, estudiante
│   │       │   │   └── Usuario.java          
│   │       │   ├── repository/
│   │       │   │   └── UsuarioRepository.java
│   │       │   └── service/
│   │       │       └── UsuarioService.java
│   │       └── resources/
│   │           └── application-example.properties
│   └── pom.xml
│
├── mongo/                            # React + Vite
│   ├── src/
│   │   ├── api/
│   │   │   └── usuarioApi.js         # Llamadas al backend
│   │   ├── pages/
│   │   │   ├── LoginPage.jsx         # Pantalla de login
│   │   │   ├── RegisterPage.jsx      # Registro de usuario
│   │   │   └── Dashboard.jsx         # CRUD de usuarios
│   │   ├── App.jsx
│   │   └── main.jsx
│   └── package.json
│
└── README.md
```
## 🔌 Endpoints del API
 
### Autenticación
| Método | Endpoint | Descripción | 
|--------|----------|-------------|
| POST | `/usuarios/registrar` | Registrar nuevo usuario |
| POST | `/usuarios/login` | Iniciar sesión |
 
### CRUD Usuarios
| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| GET | `/usuarios/listar` | Listar todos los usuarios | ✅ JWT |
| PUT | `/usuarios/actualizar/{id}` | Actualizar usuario | ✅ JWT |
| DELETE | `/usuarios/eliminar/{id}` | Eliminar usuario | ✅ JWT |

## Vistas
- Registro nuevo usuario
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/5966b539-b9b1-414b-b861-ef2c71a293d9" />

- Login
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/96fb2c0c-e9cb-4d85-833c-22e121219361" />

- Panel 
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/3fad5466-3f43-488e-8370-bfa309a1f744" />

- Editar
<img width="1414" height="182" alt="image" src="https://github.com/user-attachments/assets/acc4ac05-4a79-4bc9-964a-f5c75becddaa" />
  

## 👥 Autores
- Alejandra Rodriguez Forero
- Jerson Steven Mantilla Ramirez
- Santiago Galvis Saavedra
 
