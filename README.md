<div align="center">
  <img alt="banner" src="src/main/resources/static/img/logo-l.png?raw=true">
</div>

## Table of Contents
- [Brand Concept](#brand-concept)
    - [Colour Palette](#colour-palette)
    - [Typography](#typography)
- [Website Development](#website-development)
    - [Programming Language](#programming-language)
    - [Architecture](#architecture)
    - [Database Management System](#database-management-system)
    - [Hosting](#hosting)
    - [Testing](#testing)
- [Work Methodology](#work-methodology)
    - [Task Organisation](#task-organisation)
    - [Version Control System](#version-control-system)
- [Collaborators](#collaborators)

## Brand Concept

### Colour Palette

After conducting a market study, we have chosen the following colours because they reflect market trends and our values:

- ![#66b6ab](https://placehold.co/15x15/66b6ab/66b6ab.png) `#66b6ab`
- ![#ff5959](https://placehold.co/15x15/ff5959/ff5959.png) `#ff5959`
- ![#464646](https://placehold.co/15x15/464646/464646.png) `#464646`
- ![#ececec](https://placehold.co/15x15/ececec/ececec.png) `#ececec`
- ![#e6e5e5](https://placehold.co/15x15/e6e5e5/e6e5e5.png) `#e6e5e5`

`#66b6ab` Colour used as the main colour for our website. Mainly in the navigation bar, subcategories, and some other buttons.

`#ff5959` Colour used to contrast the main one. Used in areas we want to highlight.

`#464646` Colour for typography and the footer. We wanted to choose a dark and minimalist colour to combine with the previous colours.

`#ececec` Colour used for the background of the boxes or frames of the categories or photos.

`#e6e5e5` Colour used for the website background.

### Typography

For the typography of the logo and different titles of the website, we have used `Carter One`.
The secondary typography we have used is: `Open Sans Hebrew Condensed`.

## Website Development

### Programming Language

We have chosen `Java` to program the backend of our website due to its advantages as a programming language. Firstly, Java is known for being a reliable and stable language, which gives us the security that our code will be less prone to failure or causing problems. In addition, Java is a scalable and object-oriented language, which makes writing and maintaining code easier in the long run. Another advantage is that Java has a vast amount of resources and an active and committed community of developers, which will make learning and problem-solving easier for us.

We have used `Spring` as the framework for our Java website due to its modularity, ease of integration, strong focus on object-oriented programming and its large community of developers. Spring is a popular and reliable choice for developing scalable and high-quality web applications.

### Architecture

We have chosen the `layered architecture`. It is a common way of structuring code in software applications. In this approach, functions and responsibilities are divided into different layers, which allows for better organisation, scalability, and maintainability of the code. Below, we explain the responsibilities of the different layers:

- Controller Layer: This layer is responsible for receiving HTTP requests and sending the corresponding responses. Here is where the logic to handle requests is defined, and the structure and format of the responses are set.
- Business Layer: In this layer, business rules are implemented, data is processed, and application logic is carried out. This layer is essential for separating concerns between the user interface and business logic.
- Repository Layer: This layer is responsible for interaction with the database. Here is where read and write operations on the database are performed. This layer is used to abstract the complexity of the database and make it easier to interact with.

By using interfaces in the business and repository layers, you can easily change the implementation of a component using polymorphism without affecting other parts of the system as long as the same interface is implemented.

### Database Management System

As a Database Management System (DBMS), we have chosen `MySQL` due to its availability, reliability, scalability, flexibility, and community support. Additionally, MySQL is capable of handling large amounts of data and is compatible with various operating systems and programming languages, which allows us to develop our website using the programming language and tools we prefer.

We have chosen InnoDB as the engine for our database because it can efficiently handle transactions and can manage a high volume of concurrent users, making it suitable for a reliable and scalable online shop.

### Hosting

We have chosen `Amazon Web Services (AWS)` to host our website because AWS is a cloud platform that offers high availability, scalability, and security. AWS allows us to scale our server resources as needed, enabling us to handle traffic spikes and ensure that our website is always available to users. Additionally, AWS also provides us with security and compliance options to ensure that our customers' data is protected.

### Testing

We have used `JUnit` to create and run different types of tests to ensure that the website works correctly under different situations and conditions. Utilising various types of tests has allowed us to validate the code at different levels and ensure that the software meets user requirements and expectations.

## Work Methodology

### Task Organisation

To organise our tasks, we have used a `Trello` board. Trello is an online tool that helps teams organise and collaborate on projects visually and efficiently. It allows you to create task lists and cards, add deadlines and labels, comment on cards, and attach files. It is flexible and customisable to suit the needs of the team and project.

### Version Control System

For version control, we have used `Git` and `Github`. Git is a version control system for tracking and managing changes in a software project's source code. Github is an online platform for sharing and collaborating on projects using Git. The advantages they offer are: version control, team collaboration, backup and recovery, branching, and working on new features or problem-solving without affecting the main source code.

## Collaborators

- [Ismael Callado](https://github.com/ismael1DAW)
- [Iván Hernández](https://github.com/ivher-dev)
- [María Fandos](https://github.com/MariaMFM)
- [Roberto Murcia](https://github.com/robeermurciia)
