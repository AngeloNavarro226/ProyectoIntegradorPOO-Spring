
# 🚦 Sistema de Gestión de Actas de Constatación (Proyecto Integrador POO - Spring)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-Database-blue.svg)](https://www.mysql.com/)
[![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3-purple.svg)](https://getbootstrap.com/)


Este proyecto es una aplicación web desarrollada con **Spring Boot** y **Thymeleaf** para la gestión y administración de actas de constatación de tránsito (multas). Permite a las autoridades de tránsito registrar infracciones, autoridades, vehículos, conductores y emitir actas detalladas con el cálculo automático de los montos a pagar.

## 📋 Características Principales

* **Gestión de Infracciones:** Creación y listado del catálogo de infracciones de tránsito con sus respectivos importes.
* **Gestión de Autoridades:** Registro de los oficiales de tránsito (autoridades de constatación) con sus datos personales e institucionales (placa y legajo).
* **Gestión de Actas:**  Emisión de nuevas actas asociando fecha, lugar, vehículo, infractor (conductor y licencia) y la autoridad que realiza la multa.
    * Posibilidad de asociar múltiples infracciones a una sola acta.
    * Cálculo automático del total a pagar según las infracciones cometidas.
* **Auditoría de Datos:** Integración con **Hibernate Envers** para mantener un registro histórico (auditoría) de los cambios en las entidades de la base de datos.
* **Autolaunch:** La aplicación está configurada para abrir automáticamente tu navegador web predeterminado en `http://localhost:9000/actas` una vez que el servidor se inicia.

## ☕ Tecnologías y Herramientas

**Backend:**
* **Java 21:** Lenguaje de programación principal.
* **Spring Boot:** Framework para el desarrollo de la aplicación.
* **Spring Data JPA & Hibernate:** ORM para la persistencia de datos.
* **Hibernate Envers:** Para el versionado y auditoría de entidades (`REVISION_INFO`).
* **Lombok:** Para reducir el código repetitivo (getters, setters, constructores).
* **Gradle:** Herramienta de automatización de compilación y construcción.

**Frontend:**
* **Thymeleaf:** Motor de plantillas para el renderizado del lado del servidor.
* **Bootstrap 5.3.0:** Framework CSS para un diseño responsive, moderno y amigable.

**Base de Datos:**
* **MySQL:** Sistema de gestión de bases de datos relacional.

## 🗺️ Modelo del sistema (UML)

El sistema sigue una arquitectura orientada a objetos (POO). A continuación se muestra el diagrama UML del modelo de datos:

![UML del Modelo](./uml%20del%20modelo.jpeg) 

## ⚙️ Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

1.  **Java Development Kit (JDK) 21**
2.  **MySQL Server** (funcionando en el puerto `3306`)
3.  **Git** (para clonar el repositorio)

## 🚀 Instalación y Ejecución

**1. Clonar el repositorio**
```bash
git clone https://github.com/AngeloNavarro226/ProyectoIntegradorPOO-Spring/
```

**2. Configurar la Base de Datos**
Ingresa a tu gestor de MySQL y ejecuta el siguiente script para crear la base de datos:

```SQL
CREATE DATABASE acta_springbd;
```

***Nota:** La aplicación utiliza `spring.jpa.hibernate.ddl-auto=update`, por lo que las tablas se crearán de forma automática al iniciar la aplicación.*

Si tu usuario o contraseña de MySQL es distinto al predeterminado (`root` sin contraseña), debes actualizar el archivo `src/main/resources/application.properties:`

```Properties
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

**3. Ejecuta la Aplicacion**
Desde tu IDE favorito ejecuta `src/main/resources/java/ActaSpring/Packages.Main`

**4. Acceso a la aplicación**
Gracias a la configuración de inicio, la aplicación intentará abrir automáticamente una pestaña en tu navegador web. En caso de que no se abra, ingresa manualmente a la siguiente ruta:

`👉 http://localhost:9000/actas`

## 📂 Estructura del Proyecto

* `src/main/java/.../Packages/entities/`: Clases del modelo de dominio (ActaDeConstatacion, Vehiculo, Infraccion, etc.).

* `src/main/java/.../Packages/repositories/`: Interfaces JPA para la conexión con la base de datos.

* `src/main/java/.../Packages/services/`: Lógica de negocio (con una implementación base genérica BaseServiceImpl).

* `src/main/java/.../Packages/controllers/`: Controladores Spring MVC que gestionan las peticiones web y las vistas.

* `src/main/resources/templates/`: Plantillas HTML desarrolladas con Thymeleaf.

* `src/main/resources/application.properties `: Configuración de puertos, base de datos y comportamiento de Spring.

## 🎓 Sobre el Proyecto
Este sistema fue desarrollado como *Proyecto Integrador* para la cátedra de Programación Orientada a Objetos. Representa la culminación de los conocimientos adquiridos durante el cursado, aplicando patrones de diseño, buenas prácticas de desarrollo y tecnologías actuales del ecosistema Java.

¡Gracias por visitar y explorar el código! 🚀
