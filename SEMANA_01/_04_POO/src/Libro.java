public class Libro {

    // 1. Atributos
    private String titulo;
    private String autor;
    private String publication;
    private boolean prestado;

    // 2. Constructor
    public Libro(String titulo, String autor, boolean prestado, String publication ){
        this.titulo = titulo;
        this.autor = autor;
        this.publication = publication;
        this.prestado = prestado;
    }

    // 3. Métodos para obtener Valores de atributos

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return  this.autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public String getPublication() {
        return publication;
    }

    // Métodos para guardar los valores de los tributos


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    // Método para cambiar estado de prestado
    public void cambiarEstado(){
        /* forma normal de principiante
        if (this.prestado){
            this.prestado = false;
        } else {
            this.prestado = true;
        }
         */
        this.prestado = !this.prestado; //Profesionales

        System.out.println("Estado del libro actualizado correctamente.");
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", publication='" + publication + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}
