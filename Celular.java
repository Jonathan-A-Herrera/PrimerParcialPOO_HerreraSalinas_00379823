class Celular extends Articulo {
    private String procesador;

    public Celular(String nombre, String procesador, String descripcion, double precio) {
        super(nombre, descripcion, precio);
        this.procesador = procesador;
    }

    public String obtenerProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
}
