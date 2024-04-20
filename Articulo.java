abstract class Articulo {
    protected String nombre;
    protected String descripcion;
    protected double precio;

    public Articulo(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerDescripcion() {
        return descripcion;
    }

    public double obtenerPrecio() {
        return precio;
    }

    // Métodos para modificar los campos protegidos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
