/**
 * Clase que representa una montaña en el sistema del centro de excursionistas Carlemany
 *
 * Cada montaña se identifica de forma única por su id conteniendo información de nombre,
 * altura y localización.
 */
public class Montaña {
    private int id;
    private String nombre;
    private int altura;
    private String localizacion;

    public Montaña(int id, String nombre, int altura, String localizacion) {
        this.id = id;
        this.nombre = nombre;
        this.altura = altura;
        this.localizacion = localizacion;
    }

    // --- Metodos de acceso getters ---
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAltura() {
        return altura;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    // --- Metodos de modificación setters ---
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return "Montaña{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", altura=" + altura +
                ", localizacion='" + localizacion + '\'' +
                '}';
    }
}
