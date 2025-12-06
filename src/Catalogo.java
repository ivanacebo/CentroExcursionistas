import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private int id;
    private List<Montaña> montañasDisponibles;

    public Catalogo(int id) {
        this.id = id;
        this.montañasDisponibles = new ArrayList<>();
    }

    // --- Metodos de acceso getters ---
    public int getId() {
        return id;
    }

    public List<Montaña> getMonstañasDisponibles() {
        return montañasDisponibles;
    }
// ----------------------------------------------------- MODIFICAR -------------------------
    /**
     * Agrega una montaña al catalogo.
     * @param montaña Clase montaña que la crea y la añade al catalogo.
     */
    public void agregarAlCatalogo(Montaña montaña) {
        if (montaña != null && !montañasDisponibles.add(montaña)) {
            montañasDisponibles.add(montaña);
        }
    }
// ------------------------------------------------------------------------

    /**
     * Quita una montaña del catalogo mediante la identificación de su id.
     * @param id parametro que identifica la montaña.
     * @return true o false si se elimina un elemento de la lista.
     */
    public boolean quitarDelCatalogo (int id) {
        return montañasDisponibles.removeIf(m -> m.getId() == id);
    }

    /**
     * Sacamaos una lista de todas las montañas disponibles.
     * @return lista de todas las montañas disponibles en el catalogo.
     */
    public List<Montaña> listarDisponibles() {
        return new ArrayList<>(montañasDisponibles);
    }

    /**
     * Comprobamos si una montaña está disponible en el catálogo por su id.
     * @param id atributo que identifica a la montaña.
     * @return true o false si la montaña esta disponible.
     */
    public boolean estaDisponible (int id) {
        for (Montaña montaña : montañasDisponibles) {
            if(montaña.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca una montaña en el catalogo por su id.
     * @param id parametro que identifica la montaña.
     * @return null si no existe o la montaña que encuentra por su id.
     */
    public Montaña buscarMontaña (int id) {
        for (Montaña montaña : montañasDisponibles) {
            if (montaña.getId() == id) {
                return montaña;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Catálogo [ID=" + id + ", Montañas Disponibles=" + montañasDisponibles.size() + "]";
    }
}
