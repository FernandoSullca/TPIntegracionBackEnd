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


# Circuito de Controller, Service y Repository en Spring Boot
Este proyecto sigue la arquitectura de capas para separar las preocupaciones y mantener un código limpio y mantenible. A continuación se detalla cómo se implementan y se relacionan los controladores, servicios y repositorios para gestionar los datos de usuarios.

## 1. Arquitectura de Capas
El flujo de datos sigue esta estructura:

1. **Controller**: Maneja las solicitudes HTTP y las respuestas.

1. **Service**: Contiene la lógica de negocio.

1. **Repository**: Se comunica directamente con la base de datos.

## 2. Controlador (Controller)
El controlador maneja las solicitudes entrantes del front-end y las dirige al servicio correspondiente. Aquí tienes un ejemplo de un controlador de usuarios:

java

```
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
```
## 3. Servicio (Service)
El servicio contiene la lógica de negocio. Es el intermediario entre el controlador y el repositorio. Aquí tienes un ejemplo de un servicio de usuarios:

java

```
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
```
## 4. Repositorio (Repository)
El repositorio se encarga de interactuar con la base de datos. Utiliza JPA para realizar operaciones CRUD. Aquí tienes un ejemplo de un repositorio de usuarios:

```
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos de consulta personalizados si es necesario
}
```
## 5. Modelo (Model)
El modelo representa la estructura de los datos en la base de datos. Aquí tienes un ejemplo de una entidad de usuario:

java
```
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    // Getters y setters
}
```
## 6. Comunicación entre Front-end y Back-end
Para que el front-end pueda comunicarse con el back-end y obtener datos de usuarios, se deben seguir estos pasos:

1. Solicitud HTTP desde el Front-end: El front-end envía una solicitud HTTP al controlador del back-end. Por ejemplo, una solicitud GET para obtener información de un usuario específico.

typescript
```
// Angular Service para llamar a la API
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) { }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/${id}`);
  }
}
```
2. **Manejo de la solicitud en el Controlador**: El controlador recibe la solicitud, llama al servicio correspondiente y devuelve la respuesta al front-end.

1. **Procesamiento en el Servicio**: El servicio realiza la lógica de negocio necesaria y llama al repositorio para obtener o almacenar datos.

1. **Interacción con la Base de Datos a través del Repositorio**: El repositorio realiza las operaciones CRUD necesarias en la base de datos.

1. **Respuesta al Front-end:** El controlador recibe los datos del servicio y los envía de vuelta al front-end en forma de respuesta HTTP.


