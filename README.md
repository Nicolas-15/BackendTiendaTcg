🎴 Backend Tienda TCG – API REST para Productos

Este proyecto corresponde al backend de una Tienda TCG (Trading Card Game), diseñada para administrar productos como cartas coleccionables de anime, Pokémon, Yu-Gi-Oh!, entre otros.
El objetivo del backend es subir, administrar y consultar productos dentro de la base de datos de la tienda mediante una API REST.

🚀 Tecnologías Utilizadas

Java 17

Spring Boot 3

Spring Web

Spring Data JPA

Oracle / MySQL (configurable)

Lombok

Maven

📦 Funcionalidades Principales

✔ Listar productos
✔ Registrar nuevos productos
✔ Eliminar productos
✔ Gestión simple a través de REST API
✔ Conexión a base de datos relacional
✔ Entidad optimizada usando @Data de Lombok

Este backend está enfocado en la administración de productos, pensado para gestionar una tienda de cartas TCG.

📂 Estructura del Proyecto
src/main/java/com/tienda/tcg/
├── model/            → Entidad Producto  
├── repository/       → Repositorio JPA  
├── service/          → Lógica de negocio  
└── controller/       → Endpoints REST  

🧩 Modelo de Datos
Entidad Producto
@Entity
@Table(name = "PRODUCTOS")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CATEGORY", length = 255)
    private String category;

    @Column(name = "IMG", length = 255)
    private String img;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "TITTLE", length = 255)
    private String tittle;
}


📌 Esta entidad permite guardar:

Categoría del producto (ej: Pokémon, Yu-Gi-Oh!, Demon Slayer, etc.)

URL de la imagen del producto

Precio

Título o nombre del producto

🔌 Endpoints Disponibles
GET /productos

Devuelve la lista completa de productos registrados.

POST /productos

Crea un nuevo producto.
Ejemplo body JSON:

{
  "category": "Pokemon",
  "img": "https://ejemplo.com/carta.png",
  "price": 4990,
  "tittle": "Carta Pikachu EX"
}

DELETE /productos/{id}

Elimina un producto por ID.
Si el producto no existe, lanza excepción explicando el error.

🧠 Servicio

El servicio implementa la lógica principal:

public List<Producto> listaProductos()
public Producto guardar(Producto p)
public void eliminar(Long id)

🗄 Configuración de Base de Datos

Ejemplo en application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/tienda_tcg
spring.datasource.username=root
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


Si usas Oracle, solo cambia la URL.

▶️ Cómo Ejecutar el Proyecto

Clona el repositorio:

git clone https://github.com/Nicolas-15/BackendTiendaTcg.git


Abre en IntelliJ IDEA o Spring Tools Suite.

Configura tu base de datos en application.properties.

Ejecuta:

mvn spring-boot:run


La API estará disponible en:

http://localhost:8080

📌 Estado del Proyecto

En desarrollo activo.
Actualmente implementa CRUD básico de productos, ideal para integrarlo con un frontend de tienda o panel de administración.
Posibles mejoras futuras:

Validaciones de producto

Actualizar producto (PUT)

Autenticación (Spring Security)

Paginación y filtros

Panel de carga de imágenes

🧑‍💻 Autor

Nicolás López
Estudiante de Analista Programador – FullStack / Backend
GitHub: https://github.com/Nicolas-15

Correo: nic.lopezp@duocuc.cl
