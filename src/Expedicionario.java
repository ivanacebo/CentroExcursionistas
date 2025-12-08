/**
 * Clase abstracta que representa un expedicionario del centro de excursionistas Carlemany
 *
 * Cada expedicionario se identficara por su dni de forma unica.
 * Cada expedicionario tendra que ser definido por nombre, edad, telefono y su rol.
 */
public abstract class Expedicionario {

    private String dni;
    private String nombre;
    private int edad;
    private String telefono;
    private String rol;

    public Expedicionario(String dni, String nombre, int edad, String telefono, String rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.rol = rol;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Expedicionario{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
