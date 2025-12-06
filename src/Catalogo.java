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


    @Override
    public String toString() {
        return "Catálogo [ID=" + id + ", Montañas Disponibles=" + montañasDisponibles.size() + "]";
    }
}
