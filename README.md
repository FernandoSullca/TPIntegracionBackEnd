# TP Integracion BackEnd

Este proyecto es una aplicación Java Spring Boot que implementa una API REST para manejar usuarios.

## Estructura del Proyecto

El proyecto sigue una estructura MVC (Modelo-Vista-Controlador), organizada de la siguiente manera:

-   **Modelo**: Contiene la definición de la entidad `Usuario`, que representa los datos de los usuarios en la base de datos.
-   **Repositorio**: Define la interfaz `UsuarioRepository` para acceder a los datos de los usuarios en la base de datos.
-   **Servicio**: Contiene la clase `UsuarioService` que implementa la lógica de negocio relacionada con los usuarios.
-   **Controlador**: Contiene el `UsuarioController`, que maneja las peticiones relacionadas con los usuarios.

## Dependencias

El proyecto utiliza las siguientes dependencias principales:

-   Spring Boot
-   Spring Data JPA
-   Hibernate
-   H2 Database (para propósitos de demostración)

## Ejecución

Para ejecutar la aplicación, puedes usar el siguiente comando:

    `mvn spring-boot:run` 

Esto iniciará la aplicación en un servidor embebido Tomcat en el puerto por defecto 8080.

## Uso

Una vez que la aplicación esté en funcionamiento, puedes enviar peticiones HTTP a los endpoints definidos en el `UsuarioController` para realizar operaciones como iniciar sesión, crear, actualizar o eliminar usuarios.

### Ejemplo de Endpoint

#### Iniciar Sesión

    `POST /api/login` 

Parámetros de solicitud:

-   `username`: Nombre de usuario
-   `password`: Contraseña

Respuesta:

-   200 OK: Usuario encontrado y autenticado correctamente.
-   401 Unauthorized: Nombre de usuario o contraseña incorrectos.
![Swager del APi funcionado](https://imgur.com/a/YvN37UJ)
## Contribución

Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

1.  Haz un fork del repositorio.
2.  Crea una rama (`git checkout -b feature/MyFeature`).
3.  Realiza tus cambios y haz commit de ellos (`git commit -am 'Add some feature'`).
4.  Haz push de la rama (`git push origin feature/MyFeature`).
5.  Abre un Pull Request.

¡Esperamos tus contribuciones!
