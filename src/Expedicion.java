import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una expedición a una montaña del Centro de excursionistas Carlemany
 */
public class Expedicion {

    private int id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Montaña montañaDestino;
    private List<Expedicionario> participantes;
    private List<Alpinista> cimasLogradas;

    public Expedicion(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, Montaña montañaDestino) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montañaDestino = montañaDestino;
        this.participantes = new ArrayList<>();
        this.cimasLogradas = new ArrayList<>();
    }

    // --- Metodos de acceso getters ---
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Montaña getMontañaDestino() {
        return montañaDestino;
    }

    public List<Expedicionario> getParticipantes() {
        return participantes;
    }

    public List<Alpinista> getCimasLogradas() {
        return cimasLogradas;
    }


    @Override
    public String toString() {
        // Se formatea de tal forma que salga la fecha correcta de cuando fue
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Expedición [ID=" + id + ", Nombre=" + nombre +
                ", Inicio=" + fechaInicio.format(formatter) +
                ", Fin=" + fechaFin.format(formatter) +
                ", Destino=" + montañaDestino.getNombre() +
                ", Participantes=" + participantes.size() +
                ", Cimas=" + cimasLogradas.size() + "]";
    }
}
