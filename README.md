# 🤖 Primera evaluación de Back End

Este código permite implementar la gestión de odontólogos en un sistema de registro para una clínica odontológica.
Los dos métodos en cuestión son:
1. Guardar un odontólogo en una base de datos.
2. Listar todos los odontólogos guardados en la base de datos.

## 🔍 Enfoque
Para llegar a una solución, implementamos el Patrón de Diseño DAO; mediante él pudimos añadir las dos funcionalidades anteriores en dos tipos de sistemas:
- En una base de datos con H2.
- En la memoria de la aplicación.

## 🔨 Dependencias
Este código hace uso de tres dependencias para que funcione correctamente:
1. **Log4J**: para obtener Logs de todo tipo.
2. **H2 Database**: para almacenar datos en tablas con SQL.
3. **JUnit**: para realizar y probar los tests unitarios.

# 👨‍🏫 Lo que aprendimos
- Es muy importante añadir el sistema de bloques try/catch a lo largo de las conexiones entre Java y la base de datos.
- No se debe abrir la base de datos H2 en el navegador iniciando sesión y a la vez ejecutar el código que tiene que ver con SQL en Java porque obtendremos un error que dice que la tabla está en uso; aquí la única solución es cerrar del todo H2.
- Poner Logs informativos nos puede ser útil para saber si nuestro código está pasando por un lugar en específico.
- El constructor de Odontólogo que registra cada odontólogo en la base de datos H2 debe venir sin el campo ID, pasa que el sistema obtiene un número de ID automático y luego lo tenemos que asignar nosotros mismos.
- ⚠ Si no ejecutamos nunca el método Main, nunca tendremos nuestra tabla creada, por eso obteníamos errores a la hora de buscar, y es lógico, porque no existió nunca.
- Está bueno ir despacio y pensando en qué paso dar después.
- Tener una estructura mental definida ayuda a darle lógica al desafío, la nuestra fue:
  - Crear la Application con un breve código SQL para saber si H2 y Log4J funcionaban correctamente.
  - Modelar las entidades, en este caso, Odontólogo.
  - Crear la estructura del DAO mediante la Interface IDao.
  - Crear la conexión a la base de datos H2 mediante H2Connection.
  - Implementar los métodos de la IDao a las subclases OdontologoDaoH2 y OdontologoDaoEnMemoria.
  - Crear el servicio OdontologoService y llamar a los métodos de la implementación.
  - ⚠ Crear la conexión con la base de datos en la Application y ejecutar el método main.
  - Modelar los tests de los servicios, tanto en H2 como en Memoria.

## ¡Vamos por el siguiente reto! 🙌

## Integrantes
**Tomás Mataloni** (_@Tomasm1000_) & **Juan David García** (_@DavidGMont_)