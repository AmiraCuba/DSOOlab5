public class Paciente {
    // Atributos privados
    private int codigo;
    private String nombre;
    private int edad;
    private String dni;

    // Constructor
    public Paciente(int codigo, String nombre, int edad, String dni) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    // Métodos Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDni() {
        return dni;
    }

    // Métodos Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método toString
    @Override
    public String toString() {
        return "Paciente{" +
               "codigo=" + codigo +
               ", nombre='" + nombre + '\'' +
               ", edad=" + edad +
               ", dni='" + dni + '\'' +
               '}';
    }
}
