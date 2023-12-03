
# MyStore

## Descripción

MyStore es una aplicación de comercio electrónico que simula una tienda en línea. Permite a los usuarios explorar una variedad de productos, agregar artículos a la cesta de compras, acceder a descuentos, realizar pagos y recibir mensajes de agradecimiento.

## Tabla de Contenidos

- [Requisitos](#requisitos)
- [Configuración del Proyecto](#configuración-del-proyecto)
- [Ejecución](#ejecución)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Clases Principales](#clases-principales)
  - [`HelloApplication`](#helloapplication)
  - [`LoginViewController`](#loginviewcontroller)
  - [`Home`](#home)
  - [Otras Clases](#otras-clases)
- [Funcionalidades Principales](#funcionalidades-principales)
- [Contribuir](#contribuir)
- [Diagrama UML](#diagrama-UML)

## Requisitos

Asegúrate de tener los siguientes requisitos instalados en tu entorno de desarrollo:

- [JDK 8 o superior](https://www.oracle.com/java/technologies/javase-downloads.html)
- IDE compatible con Java y JavaFX (por ejemplo, IntelliJ IDEA, Eclipse)

## Configuración del Proyecto

1. Clona el repositorio de GitHub:

   ```bash
   git clone https://github.com/tu-usuario/MyStore.git
   ```

2. Abre el proyecto en tu IDE.

## Ejecución

1. Ejecuta la clase `HelloApplication` para iniciar la aplicación.

## Estructura del Proyecto

```
MyStore/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── mystore/
│       │               ├── HelloApplication.java
│       │               ├── LoginViewController.java
│       │               ├── Home.java
│       │               ├── Product.java
│       │               ├── CestaViewController.java
│       │               ├── DescuentosController.java
│       │               ├── GraciasController.java
│       │               ├── MainViewController.java
│       │               ├── MetodoPagoController.java
│       │               └── ProductDetailsViewController.java
│       └── resources/
│           ├── Vid/
│           │   └── VideoPrincipal.mp4
│           ├── fxml/
│           │   ├── MainView.fxml
│           │   ├── LoginView.fxml
│           │   ├── HomeView.fxml
│           │   ├── ... (otros archivos FXML)
│           └── ... (otros recursos)
│
├── .gitignore
└── README.md
```

## Clases Principales

### `HelloApplication`

La clase principal que inicia la aplicación. Contiene métodos para mostrar páginas y cerrar ventanas.

### `LoginViewController`

Controla la vista de inicio de sesión. Permite a los usuarios iniciar sesión y acceder a la página principal.

### `Home`

Controla la vista principal de la tienda. Muestra productos, detalles del producto y permite la navegación.

### Otras Clases

- `Product`, `CestaViewController`, `DescuentosController`, `GraciasController`, `MainViewController`, `MetodoPagoController`, `ProductDetailsViewController`, `RegistroViewController`: Otros controladores y clases relacionadas con la lógica de la aplicación.

## Funcionalidades Principales

- **Inicio de Sesión y Registro**: Los usuarios pueden iniciar sesión con sus credenciales existentes o registrarse para crear una cuenta nueva.

- **Exploración de Productos**: La página principal muestra una variedad de productos. Los usuarios pueden ver detalles de cada producto haciendo clic en ellos.

- **Cesta de Compras**: Los usuarios pueden agregar productos a la cesta de compras y proceder al proceso de pago.

- **Descuentos**: La aplicación proporciona descuentos especiales que los usuarios pueden aplicar durante el proceso de pago.

- **Proceso de Pago**: La aplicación simula un proceso de pago donde los usuarios ingresan detalles de la tarjeta y completan la transacción.

- **Mensaje de Agradecimiento**: Después de realizar un pago exitoso, se muestra un mensaje de agradecimiento y se ofrece la opción de regresar a la página principal.

## Contribuir

Si deseas contribuir a este proyecto, sigue estos pasos:

1. Realiza un fork del proyecto.
2. Crea una rama para tu contribución: `git checkout -b tu-funcionalidad`
3. Realiza tus cambios y haz commit: `git commit -m "Agrega tu funcionalidad"`
4. Sube tus cambios a tu repositorio: `git push origin tu-funcionalidad`
5. Abre un pull request.

¡Gracias por contribuir!
## Diagrama UML
![image](https://github.com/laragonza/MyStore2/assets/16885317/07bc6670-2e00-4b68-8b5d-fa7dbdab72da)
