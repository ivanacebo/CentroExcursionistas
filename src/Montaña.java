/**
 * Representa una montaña registrada en el sistema.
 */
public class Montaña {
    private final int id; // ID único (inmutable)
    private String nombre;
    private int altura;
    private String localizacion;

    public Montaña(int id, String nombre, int altura, String localizacion) {
        this.id = id;
        this.nombre = nombre;
        this.altura = altura;
        this.localizacion = localizacion;
    }

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
