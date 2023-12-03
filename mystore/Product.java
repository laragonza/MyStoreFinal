/**
 * Representa un producto en la tienda.
 */
public class Product {
    private String name;
    private double price;
    private String description;

    /**
     * Constructor de la clase Product.
     *
     * @param name        El nombre del producto.
     * @param price       El precio del producto.
     * @param description La descripción del producto.
     */
    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return La descripción del producto.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Devuelve una representación en cadena del objeto Product.
     *
     * @return Una cadena que representa el objeto Product.
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
