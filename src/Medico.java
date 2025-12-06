/**
 * Clase que representa un médico en el sistema del centro de excursionistas Carlemany
 *
 * Hereda sus atributos de la blase abstracta Expedicionario.
 */
public class Medico extends Expedicionario{

    private String licencia;
    private String especialidad;

    public Medico(String dni, String nombre, int edad, String telefono, String rol, String licencia, String especialidad) {
        super(dni, nombre, edad, telefono, rol);
        this.licencia = licencia;
        this.especialidad = especialidad;
    }

    // --- Metodos de acceso getters ---
    public String getLicencia() {
        return licencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    // --- Metodos de modificación setters ---
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Médico [DNI=" + getDni() + ", Nombre=" + getNombre() + ", Edad=" + getEdad() +
                ", Teléfono=" + getTelefono() + ", Licencia=" + licencia + ", Especialidad=" + especialidad + ", Rol=" + getRol() + "]";
    }
}
