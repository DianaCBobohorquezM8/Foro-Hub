##📣 ForoHub 🌐 Challenge ##

ForoHub es una aplicación de foro en línea desarrollada con Spring Boot. Este proyecto está organizado en varios paquetes que manejan diferentes aspectos de la funcionalidad de la aplicación.

<img width="106" alt="image" src="https://github.com/user-attachments/assets/82219cfa-e61d-43d8-9095-edc6ca8d3a88" />


## 📂 Descripción de Paquetes y Clases

### controller 🕹️
Contiene los controladores de la aplicación que manejan las solicitudes HTTP y devuelven las respuestas adecuadas.

- **AutenticacionController**: Maneja las solicitudes de autenticación.
- **CursoController**: Maneja las solicitudes relacionadas con los cursos.
- **TopicoController**: Maneja las solicitudes relacionadas con los tópicos.
- **UsuarioController**: Maneja las solicitudes relacionadas con los usuarios.

### Dominio 💼
Contiene las clases de dominio que representan los datos y la lógica de negocio de la aplicación.

- **curso**: Paquete para las clases relacionadas con los cursos.
- **topico**: Paquete para las clases relacionadas con los tópicos.
  - **DatosActualizarTopico**: Clase para los datos de actualización de un tópico.
  - **DatosListadoTopicos**: Clase para los datos de listado de tópicos.
  - **DatosRegistroTopico**: Clase para los datos de registro de un tópico.
  - **DatosRespuestaTopico**: Clase para los datos de respuesta de un tópico.
  - **Topico**: Clase que representa un tópico.
  - **TopicoRepository**: Interfaz para el repositorio de tópicos.
- **usuario**: Paquete para las clases relacionadas con los usuarios.
  - **DatosAutenticacionUsuario**: Clase para los datos de autenticación de un usuario.
  - **DatosRegistroUsuario**: Clase para los datos de registro de un usuario.
  - **Usuario**: Clase que representa un usuario.
  - **UsuarioRepository**: Interfaz para el repositorio de usuarios.
  - **ValidacionExcepcion**: Clase para manejar excepciones de validación.

### Infra ⚙️
Contiene las clases de infraestructura que soportan la funcionalidad de la aplicación.

- **errores**: Paquete para el manejo de errores.
- **security**: Paquete para la configuración de seguridad.
  - **AutenticacionService**: Servicio para la autenticación.
  - **DatosJWTtoken**: Clase para los datos del token JWT.
  - **SecurityConfigurations**: Configuraciones de seguridad.
  - **SecurityFilter**: Filtro de seguridad.
  - **TokenService**: Servicio para el manejo de tokens.

### Springdoc 📄
Contiene las configuraciones para la documentación de Spring.

- **SpringDocConfiguration**: Configuración de SpringDoc.

### ForoApplication 🚀
Clase principal que inicia la aplicación Spring Boot.

## 🛠️ Requisitos

- **Java 11** o superior
- **Maven 3.6.3** o superior
- **MySQL**: Asegúrate de tener una instancia de MySQL en funcionamiento.

## 📦 Dependencias

El proyecto utiliza las siguientes dependencias:

- **Spring Boot Starter Data JPA**: `org.springframework.boot:spring-boot-starter-data-jpa:3.4.1`
- **Spring Boot Starter Validation**: `org.springframework.boot:spring-boot-starter-validation:3.4.1`
- **Spring Boot Starter Web**: `org.springframework.boot:spring-boot-starter-web:3.4.1`
- **Flyway Core**: `org.flywaydb:flyway-core:10.20.1`
- **Flyway MySQL**: `org.flywaydb:flyway-mysql:10.20.1`
- **Spring Boot DevTools**: `org.springframework.boot:spring-boot-devtools:3.4.1`
- **MySQL Connector/J**: `com.mysql:mysql-connector-j:9.1.0`
- **Lombok**: `org.projectlombok:lombok:1.18.36`
- **Spring Boot Starter Test**: `org.springframework.boot:spring-boot-starter-test:3.4.1`
- **Spring Boot Starter Security**: `org.springframework.boot:spring-boot-starter-security:3.4.1`
- **Spring Security Test**: `org.springframework.security:spring-security-test:6.4.2`
- **Java JWT**: `com.auth0:java-jwt:4.4.0`
- **Springdoc OpenAPI WebMVC UI**: `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0`

## 🛠️ Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/forohub.git

✨ Contribuyendo ¡Las contribuciones son bienvenidas! Siéntete libre de abrir un issue o enviar un pull request.

💬 Contacto Para cualquier consulta o comentario, por favor envia un mendaje : www.linkedin.com/in/diana-c-bohorquez-m-bb70a2108

Desarrollado con ❤️ por Diana Bohorquez

