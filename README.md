<h1 style="text-align: center">Paw-Paradise</h1>

# Índice

- ¿Por qué elegimos java?
- ¿Qué arquitectura hemos elegido?
- ¿Por qué hemos elegido MySQL como SGBD?
- ¿Por qué hemos elegido AWS para hostear nuestra página web?

## ¿Por qué elegimos Java?

Hemos elegido Java para programar el backend de nuestra página web debido a sus ventajas como lenguaje de programación. En primer lugar, Java es conocido por ser un lenguaje confiable y estable, lo que nos da la seguridad de que nuestro código será menos propenso a fallar o causar problemas. Además, Java es un lenguaje escalable y orientado a objetos, lo que facilita la escritura y el mantenimiento del código a largo plazo. Otra ventaja es que Java cuenta con una gran cantidad de recursos y una comunidad activa y comprometida de desarrolladores, lo que nos facilitará el aprendizaje y la solución de problemas.

Hemos elegido Spring como framework para nuestra página web de Java debido a su modularidad, facilidad de integración, fuerte enfoque en la programación orientada a objetos y su gran comunidad de desarrolladores. Spring es una opción popular y confiable para el desarrollo de aplicaciones web escalables y de alta calidad.

## ¿Qué arquitectura hemos elegido?

Hemos elegido la arquitectura por capas. Es una forma común de estructurar el código en aplicaciones de software. En este enfoque, se dividen las funciones y responsabilidades en diferentes capas, lo que permite una mejor organización, escalabilidad y mantenibilidad del código. A continuación, te explicamos las responsabilidades de las diferentes capas:

- Capa de controlador (Controller): Esta capa es la encargada de recibir las solicitudes HTTP y enviar las respuestas correspondientes. Aquí es donde se define la lógica para manejar las solicitudes y se define la estructura y el formato de las respuestas.
- Capa de negocio (Business): En esta capa es donde se implementan las reglas de negocio, se procesan los datos y se lleva a cabo la lógica de la aplicación. Esta capa es esencial para separar las preocupaciones de la interfaz de usuario y la lógica empresarial.
- Capa de repositorio (Repository): Esta capa es la encargada de la interacción con la base de datos. Aquí es donde se realizan las operaciones de lectura y escritura en la base de datos. Esta capa se utiliza para abstraer la complejidad de la base de datos y hacer que sea más fácil interactuar con ella.

Al utilizar interfaces en las capas de negocio y repositorio, se puede cambiar fácilmente la implementación de un componente usando polimorfismo sin afectar a otras partes del sistema siempre y cuando se implemente la misma interfaz.

## ¿Por qué hemos elegido MySQL como SGBD?

Elegimos MySQL debido a su disponibilidad, fiabilidad, escalabilidad, flexibilidad y soporte de la comunidad. Además, MySQL es capaz de manejar grandes cantidades de datos y es compatible con diferentes sistemas operativos y lenguajes de programación, lo que nos permite desarrollar nuestra página web utilizando el lenguaje de programación y herramientas que prefiramos.

Hemos elegido InnoDB como motor de nuestra base de datos porque es capaz de manejar transacciones de manera eficiente y puede manejar un alto volumen de usuarios concurrentes, lo que lo hace adecuado para un sistema de ventas en línea confiable y escalable.

## ¿Por qué hemos elegido AWS para hostear nuestra página web?

Hemos elegido Amazon Web Services (AWS) para hostear nuestra página web porque AWS es una plataforma de nube que ofrece alta disponibilidad, escalabilidad y seguridad. AWS nos permite escalar los recursos de nuestro servidor según sea necesario, lo que nos permite manejar picos de tráfico y garantizar que nuestra página web esté siempre disponible para los usuarios. Además, AWS también nos brinda opciones de seguridad y cumplimiento para garantizar que los datos de nuestros clientes estén protegidos.
