<h1 style="text-align: center">Paw-Paradise</h1>

# Índice

- ¿Por qué elegimos java?
- ¿Qué arquitectura hemos elegido?

## ¿Por qué elegimos Java?

Hemos elegido Java para programar el backend de nuestra página web debido a sus ventajas como lenguaje de programación. En primer lugar, Java es conocido por ser un lenguaje confiable y estable, lo que nos da la seguridad de que nuestro código será menos propenso a fallar o causar problemas. Además, Java es un lenguaje escalable y orientado a objetos, lo que facilita la escritura y el mantenimiento del código a largo plazo. Otra ventaja es que Java cuenta con una gran cantidad de recursos y una comunidad activa y comprometida de desarrolladores, lo que nos facilitará el aprendizaje y la solución de problemas.

Hemos elegido Spring como framework para nuestra página web de Java debido a su modularidad, facilidad de integración, fuerte enfoque en la programación orientada a objetos y su gran comunidad de desarrolladores. Spring es una opción popular y confiable para el desarrollo de aplicaciones web escalables y de alta calidad.

## ¿Qué arquitectura hemos elegido?

Hemos elegido la arquitectura por capas. Es una forma común de estructurar el código en aplicaciones de software. En este enfoque, se dividen las funciones y responsabilidades en diferentes capas, lo que permite una mejor organización, escalabilidad y mantenibilidad del código. A continuación, te explicamos las responsabilidades de las diferentes capas:

- Capa de controlador (Controller): Esta capa es la encargada de recibir las solicitudes HTTP y enviar las respuestas correspondientes. Aquí es donde se define la lógica para manejar las solicitudes y se define la estructura y el formato de las respuestas.
- Capa de negocio (Business): En esta capa es donde se implementan las reglas de negocio, se procesan los datos y se lleva a cabo la lógica de la aplicación. Esta capa es esencial para separar las preocupaciones de la interfaz de usuario y la lógica empresarial.
- Capa de repositorio (Repository): Esta capa es la encargada de la interacción con la base de datos. Aquí es donde se realizan las operaciones de lectura y escritura en la base de datos. Esta capa se utiliza para abstraer la complejidad de la base de datos y hacer que sea más fácil interactuar con ella.

Al utilizar interfaces en las capas de negocio y repositorio, se puede cambiar fácilmente la implementación de un componente usando polimorfismo sin afectar a otras partes del sistema siempre y cuando se implemente la misma interfaz.
