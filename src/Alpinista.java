/**
 * Clase que representa un alpinista dentro del sistema del centro de excursionistas Carlemany
 *
 * Hereda sus atributos de la blase abstracta Expedicionario.
 */
public class Alpinista extends Expedicionario{

    public Alpinista(String dni, String nombre, int edad, String telefono) {
        super(dni, nombre, edad, telefono, "Alpinista");
    }

    @Override
    public String toString() {
        return "Alpinista [DNI=" + getDni() + ", Nombre=" + getNombre() + ", Edad=" + getEdad() + ", Teléfono=" + getTelefono() + "]";
    }
}
