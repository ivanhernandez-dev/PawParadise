<div align="center">
  <img alt="banner" src="src/main/resources/static/img/logo-l.png?raw=true">
</div>

## Índice
- [Idea de marca](#idea-de-marca)
  - [Paleta de colores](#paleta-de-colores)
  - [Tipografías](#tipografías)
- [Desarrollo de la web](#desarrollo-de-la-web)
  - [Lenguaje de programación](#lenguaje-de-programación)
  - [Arquitectura](#arquitectura)
  - [Sistema gestor de base de datos](#sistema-gestor-de-base-de-datos)
  - [Hosting](#hosting)
  - [Testing](#testing)
- [Metodología de trabajo](#metodología-de-trabajo)
  - [Organización de tareas](#organización-de-tareas)
  - [Sistema de control de versiones](#sistema-de-control-de-versiones)
- [Colaboradores](#colaboradores)

## Idea de marca

### Paleta de colores

Tras realizar un estudio de mercado, hemos eleggido los siguientes colores porque reflejan las tendencias del mercado y nuestros valores:

- ![#66b6ab](https://placehold.co/15x15/66b6ab/66b6ab.png) `#66b6ab`
- ![#ff5959](https://placehold.co/15x15/ff5959/ff5959.png) `#ff5959`
- ![#464646](https://placehold.co/15x15/464646/464646.png) `#464646`
- ![#ececec](https://placehold.co/15x15/ececec/ececec.png) `#ececec`
- ![#e6e5e5](https://placehold.co/15x15/e6e5e5/e6e5e5.png) `#e6e5e5`

`#66b6ab` Color utilizado como principal para nuestra página web. Principalmente en la barra de navegación, en las subcategorías y algunos botones más.

`#ff5959` Color utilizado para dar contraste al principal. Utilizado en zonas que queremos destacar.

`#464646` Color para la tipografía y para el footer. Hemos querido elegir un color oscuro y minimalista para que combine con los colores anteriores.

`#ececec` Color utilizado para el fondo de los recuadros o marcos de las categorías o fotos.

`#e6e5e5` Color utilizado para el fondo de la web.

### Tipografías

Para la tipografía del logo y diferentes títulos de la página web hemos utilizado `Carter One`.
La tipografía secundaria que hemos utilizado es: `Open Sans Hebrew Condensed`.

## Desarrollo de la web

### Lenguaje de programación

Hemos elegido `Java` para programar el backend de nuestra página web debido a sus ventajas como lenguaje de programación. En primer lugar, Java es conocido por ser un lenguaje confiable y estable, lo que nos da la seguridad de que nuestro código será menos propenso a fallar o causar problemas. Además, Java es un lenguaje escalable y orientado a objetos, lo que facilita la escritura y el mantenimiento del código a largo plazo. Otra ventaja es que Java cuenta con una gran cantidad de recursos y una comunidad activa y comprometida de desarrolladores, lo que nos facilitará el aprendizaje y la solución de problemas.

Hemos usado `Spring` como framework para nuestra página web de Java debido a su modularidad, facilidad de integración, fuerte enfoque en la programación orientada a objetos y su gran comunidad de desarrolladores. Spring es una opción popular y confiable para el desarrollo de aplicaciones web escalables y de alta calidad.

### Arquitectura

Hemos elegido la `arquitectura por capas`. Es una forma común de estructurar el código en aplicaciones de software. En este enfoque, se dividen las funciones y responsabilidades en diferentes capas, lo que permite una mejor organización, escalabilidad y mantenibilidad del código. A continuación, te explicamos las responsabilidades de las diferentes capas:

- Capa de controlador (Controller): Esta capa es la encargada de recibir las solicitudes HTTP y enviar las respuestas correspondientes. Aquí es donde se define la lógica para manejar las solicitudes y se define la estructura y el formato de las respuestas.
- Capa de negocio (Business): En esta capa es donde se implementan las reglas de negocio, se procesan los datos y se lleva a cabo la lógica de la aplicación. Esta capa es esencial para separar las preocupaciones de la interfaz de usuario y la lógica empresarial.
- Capa de repositorio (Repository): Esta capa es la encargada de la interacción con la base de datos. Aquí es donde se realizan las operaciones de lectura y escritura en la base de datos. Esta capa se utiliza para abstraer la complejidad de la base de datos y hacer que sea más fácil interactuar con ella.

Al utilizar interfaces en las capas de negocio y repositorio, se puede cambiar fácilmente la implementación de un componente usando polimorfismo sin afectar a otras partes del sistema siempre y cuando se implemente la misma interfaz.

### Sistema gestor de base de datos

Como Sistema Gestor de Base de Datos (SGBD) hemos elegido `MySQL` debido a su disponibilidad, fiabilidad, escalabilidad, flexibilidad y soporte de la comunidad. Además, MySQL es capaz de manejar grandes cantidades de datos y es compatible con diferentes sistemas operativos y lenguajes de programación, lo que nos permite desarrollar nuestra página web utilizando el lenguaje de programación y herramientas que prefiramos.

Hemos elegido InnoDB como motor de nuestra base de datos porque es capaz de manejar transacciones de manera eficiente y puede manejar un alto volumen de usuarios concurrentes, lo que lo hace adecuado para un sistema de ventas en línea confiable y escalable.

### Hosting

Hemos elegido `Amazon Web Services (AWS)` para hostear nuestra página web porque AWS es una plataforma de nube que ofrece alta disponibilidad, escalabilidad y seguridad. AWS nos permite escalar los recursos de nuestro servidor según sea necesario, lo que nos permite manejar picos de tráfico y garantizar que nuestra página web esté siempre disponible para los usuarios. Además, AWS también nos brinda opciones de seguridad y cumplimiento para garantizar que los datos de nuestros clientes estén protegidos.

### Testing

Hemos utilizado `JUnit` para crear y ejecutar diferentes tipos de tests para garantizar que la página web funcione correctamente en diferentes escenarios y condiciones. La utilización de diferentes tipos de pruebas nos ha permitido validar el código en diferentes niveles y asegurarnos de que el software cumpla con los requisitos y expectativas del usuario.

## Metodología de trabajo

### Organización de tareas

Para organizar nuestras tareas hemos usado un tablero de `Trello`. Trello es una herramienta en línea que ayuda a los equipos a organizar y colaborar en proyectos de manera visual y eficiente. Permite crear listas de tareas y tarjetas, agregar fechas límite y etiquetas, comentar en tarjetas y adjuntar archivos. Es flexible y personalizable para adaptarse a las necesidades del equipo y proyecto.

### Sistema de control de versiones

Para el control de versiones hemos usado `Git` y `Github`. Git es un sistema de control de versiones para rastrear y gestionar cambios en el código fuente de un proyecto de software. Github es una plataforma en línea para compartir y colaborar en proyectos utilizando Git. Las ventajas que ofrecen son: control de versiones, colaboración en equipo, backup y recuperación, ramificación y trabajo en nuevas características o solución de problemas sin afectar el código fuente principal.

## Colaboradores

- [Ismael Callado](https://github.com/ismael1DAW)
- [Iván Hernández](https://github.com/ivher-dev)
- [María Fandos](https://github.com/MariaMFM)
- [Roberto Murcia](https://github.com/robeermurciia)
