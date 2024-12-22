ForoHub 🌐
ForoHub es una aplicación de foro en línea desarrollada con Spring Boot. Este proyecto está organizado en varios paquetes que manejan diferentes aspectos de la funcionalidad de la aplicación.

📂 Descripción de Paquetes y Clases
controller 🕹️
Contiene los controladores de la aplicación que manejan las solicitudes HTTP y devuelven las respuestas adecuadas.

AutenticacionController: Maneja las solicitudes de autenticación.

CursoController: Maneja las solicitudes relacionadas con los cursos.

TopicoController: Maneja las solicitudes relacionadas con los tópicos.

UsuarioController: Maneja las solicitudes relacionadas con los usuarios.

dominio 💼
Contiene las clases de dominio que representan los datos y la lógica de negocio de la aplicación.

curso: Paquete para las clases relacionadas con los cursos.

topico: Paquete para las clases relacionadas con los tópicos.

DatosActualizarTopico: Clase para los datos de actualización de un tópico.

DatosListadoTopicos: Clase para los datos de listado de tópicos.

DatosRegistroTopico: Clase para los datos de registro de un tópico.

DatosRespuestaTopico: Clase para los datos de respuesta de un tópico.

Topico: Clase que representa un tópico.

TopicoRepository: Interfaz para el repositorio de tópicos.

usuario: Paquete para las clases relacionadas con los usuarios.

DatosAutenticacionUsuario: Clase para los datos de autenticación de un usuario.

DatosRegistroUsuario: Clase para los datos de registro de un usuario.

Usuario: Clase que representa un usuario.

UsuarioRepository: Interfaz para el repositorio de usuarios.

ValidacionExcepcion: Clase para manejar excepciones de validación.

infra ⚙️
Contiene las clases de infraestructura que soportan la funcionalidad de la aplicación.

errores: Paquete para el manejo de errores.

security: Paquete para la configuración de seguridad.

AutenticacionService: Servicio para la autenticación.

DatosJWTtoken: Clase para los datos del token JWT.

SecurityConfigurations: Configuraciones de seguridad.

SecurityFilter: Filtro de seguridad.

TokenService: Servicio para el manejo de tokens.

springdoc 📄
Contiene las configuraciones para la documentación de Spring.

SpringDocConfiguration: Configuración de SpringDoc.

ForoApplication 🚀
Clase principal que inicia la aplicación Spring Boot.

🛠️ Requisitos
Java 11 o superior

Maven 3.6.3 o superior

MySQL: Asegúrate de tener una instancia de MySQL en funcionamiento.

📦 Dependencias
El proyecto utiliza las siguientes dependencias:

Spring Boot Starter Data JPA: org.springframework.boot:spring-boot-starter-data-jpa:3.4.1

Spring Boot Starter Validation: org.springframework.boot:spring-boot-starter-validation:3.4.1

Spring Boot Starter Web: org.springframework.boot:spring-boot-starter-web:3.4.1

Flyway Core: org.flywaydb:flyway-core:10.20.1

Flyway MySQL: org.flywaydb:flyway-mysql:10.20.1

Spring Boot DevTools: org.springframework.boot:spring-boot-devtools:3.4.1

MySQL Connector/J: com.mysql:mysql-connector-j:9.1.0

Lombok: org.projectlombok:lombok:1.18.36

Spring Boot Starter Test: org.springframework.boot:spring-boot-starter-test:3.4.1

Spring Boot Starter Security: org.springframework.boot:spring-boot-starter-security:3.4.1

Spring Security Test: org.springframework.security:spring-security-test:6.4.2

Java JWT: com.auth0:java-jwt:4.4.0

Springdoc OpenAPI WebMVC UI: org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0

🛠️ Instalación
Clona el repositorio:

bash
git clone https://github.com/tu-usuario/forohub.git
Navega al directorio del proyecto:

bash
cd forohub
Configura tu base de datos MySQL:

Crea una base de datos en MySQL.

Actualiza las credenciales de acceso a la base de datos en el archivo application.properties.

Compila y ejecuta la aplicación:

bash
mvn spring-boot:run
🔐 Características de Seguridad
Servicios y Configuraciones de Seguridad
AutenticacionService 🛡️

Categoría: Servicio de Autenticación

Uso: Maneja la autenticación de usuarios verificando credenciales y generando tokens de acceso.

DatosJWTtoken 🔐

Categoría: Datos de Token JWT

Uso: Contiene la estructura de datos relacionada con los tokens JWT, utilizados para la autenticación y autorización.

SecurityConfigurations ⚙️

Categoría: Configuraciones de Seguridad

Uso: Configura las políticas de acceso, la configuración de filtros de seguridad y otros ajustes relacionados con la seguridad.

SecurityFilter 🛡️

Categoría: Filtro de Seguridad

Uso: Implementa filtros de seguridad que interceptan las solicitudes HTTP para aplicar reglas de seguridad como la validación de tokens.

TokenService 🔑

Categoría: Servicio de Tokens

Uso: Maneja la creación, validación y renovación de tokens de acceso, asegurando que solo los usuarios autenticados puedan acceder a los recursos protegidos.

Uso de Tokens JWT para Autenticación
Para proteger los recursos de la aplicación, se utilizan tokens JWT (JSON Web Tokens). Aquí hay un flujo típico de cómo se utiliza la autenticación con JWT:

Registro de Usuario: El usuario se registra a través del endpoint /usuarios/registrar.

Inicio de Sesión: El usuario inicia sesión en /login, proporcionando sus credenciales (email y contraseña).

Generación de Token: Si las credenciales son correctas, se genera un token JWT en el TokenService y se devuelve al usuario.

Acceso a Recursos Protegidos: El usuario utiliza el token JWT en el encabezado de autorización para acceder a recursos protegidos.

Validación del Token: El SecurityFilter valida el token en cada solicitud para asegurar que el usuario tiene permisos para acceder al recurso.

📄 Documentación con Swagger
ForoHub utiliza Swagger para documentar la API, lo que permite a los desarrolladores explorar y probar los endpoints de manera interactiva.

Acceso a la Documentación
Una vez que la aplicación esté en funcionamiento, puedes acceder a la documentación de la API en:

http://localhost:8080/swagger-ui/index.html
🌐 Insomnia
Para probar y documentar las solicitudes HTTP, utilizamos Insomnia. Aquí tienes cómo configurar y utilizar Insomnia para interactuar con la API:

Descarga Insomnia: Insomnia

Importa la Colección:

Abre Insomnia y selecciona Import/Export.

Importa la colección de solicitudes JSON proporcionada.

Configura el Entorno:

Asegúrate de que las variables de entorno están configuradas correctamente, especialmente la URL base de la API y cualquier token necesario.

Prueba las Solicitudes:

Utiliza las solicitudes predefinidas para interactuar con los diferentes endpoints de la API.

