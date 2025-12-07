import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private final int id; // Se puede usar en un futuro de cara a montañas peligrosas, montañas faciles, montañas de cursos...
    private List<Montaña> montañasDisponibles;

    public Catalogo(int id) {
        this.id = id; // ID único (inmutable)
        this.montañasDisponibles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Montaña> getMontañasDisponibles() {
        return new ArrayList<>(montañasDisponibles);
    }

    /**
     * Añade una montaña al catalogo si no esta previemante
     * @param montaña la montaña que queremos añadir
     * @return true si se añade o false si es null o ya esta añadida antes.
     */
    public boolean agregarMontañaCatalogo (Montaña montaña) {
        if (montaña == null) return false;

        for (Montaña m : montañasDisponibles) {
            if (m.getId() == montaña.getId()) {
                return false;
            }
        }

        montañasDisponibles.add(montaña);
        return true;
    }

    /**
     * Quitamos la montaña del catalogo por ID
     */
    public boolean quitarMontañaCatalogo (int id) {
        return montañasDisponibles.removeIf(m -> m.getId() == id);
    }

    /**
     * Lista de montañas que hay en catálogo
     */
    public List<Montaña> listarMontañasDisponiblesEnCatalogo() {
        return new ArrayList<>(montañasDisponibles);
    }

    /**
     * Verifica si una montaña esta en el catalogo con este ID
     */
    public boolean estaDisponible (int id) {
        return montañasDisponibles.stream()
                .anyMatch(m -> m.getId() == id);
    }

    /**
     * Busca una montaña por su ID devolviendo la instancia de montaña o null
     */
    public Montaña buscarMontaña (int id) {
        return montañasDisponibles.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Catálogo [ID=" + id + ", Montañas Disponibles=" + montañasDisponibles.size() + "]";
    }
}
