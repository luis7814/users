# users

Microservicio en springboot, que registra la información de un usuario en una base de datos.
La información quedará registrada en tres tablas, Person, User y Phone.

#### Controller: Maneja la solicitud de entrada como servicio REST

#### Facade: Se encarga de distribuir la información a las diferentes entidades y de construir el objeto que va a visualizar el usuario.

#### Service: Lógica de negocio de cada entidad.

#### Repository: Interfaz que interactua con la base de datos.


Al ejecutar la aplicación desde el IDE o ejecutando el jar, se deberá ingresar desde la siguiente url:
http://localhost:8090/user 

Al ser un servicio POST, se recomienda ejecutarlo desde POSTMAN.

{
    "name": "Luis Barrear",
    "email": "luis@barreraaa.org",
    "password": "Hunter2*",
    "phones": [
        {
            "number": "1234567",
            "cityCode": "1",
            "countryCode": "57"
        },
    ]
}

Para visualizarlo desde swagger http://localhost:8090/swagger-ui/index.html

# Validaciones:
 - Se valida que el nombre, correo electrónico y contraseña como obligatorios.
 - Se valida el formato del correo electrónico.
 - Se valida la contraseña de la siguiente forma: Debe tener mínimo ocho caracteres, mayúsculas, minúsculas y un caracter especial (ejemplo en las pruebas unitarias).

# Tipos de respuesta HTTP:
- 200: Si se realiza el registro correctamente.
- 400: Validación de datos de negocio.
- 404: Datos obligatorios.

# Base de datos
- Se utilizó springdata JPA.
- La información de conexión a la base de datos H2, está en el application.properties.
- Al momento de levantar la aplicación, se crearán las tablas
- La url de acceso a la parte gráfica de H2 es http://localhost:8090/h2-console

 