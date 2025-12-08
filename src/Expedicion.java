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
    private List<Expedicionario> cimasLogradas;

    public Expedicion(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, Montaña montañaDestino) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montañaDestino = montañaDestino;
        this.participantes = new ArrayList<>();
        this.cimasLogradas = new ArrayList<>();
    }

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

    public List<Expedicionario> getCimasLogradas() {
        return cimasLogradas;
    }

    /**
     * Agrega un expedicionario a la lista de participantes
     */
    public void agregarParticipante (Expedicionario expedicionario) {
        if (!participantes.contains(expedicionario)) {
            participantes.add(expedicionario);
        }
    }

    /**
     * Elimina un expedicionario de la lista de participantes.
     */
    public boolean eliminarParticipante (String dni) {
        return participantes.removeIf(e -> e.getDni().equals(dni));
    }

    /**
     * Registra un alpinista que logró alcanzar la cima.
     */
    public void registrarCima (Expedicionario expedicionario) {
        if (participantes.stream().anyMatch(p -> p.getDni().equals(expedicionario.getDni())) && cimasLogradas.stream().noneMatch(a -> a.getDni().equals(expedicionario.getDni()))) {
            cimasLogradas.add(expedicionario);
        }
    }

    /**
     * Verificación de la expedición tiene al menos un médico.
     */
    public boolean tieneMedico() {
        for (Expedicionario exp: participantes) {
            if (exp instanceof Medico) {
                return true;
            }
        }
        return false;
    }

    /**
     * Consulta de las expediciones en las que participo un determinado expedicionario por su dni.
     */
    public List<Expedicion> consultarExpedicionesDe (String dni) {
        List<Expedicion> expediciones = new ArrayList<>();

        for (Expedicionario exp : participantes) {
            if(exp.getDni().equals(dni)) {
                expediciones.add(this);
                break;
            }
        }
        return expediciones;
    }

    /**
     *  Lista de todos los alpinistas que tienen cimas logradas
     */
    public List<Expedicionario> getAlpinistasConCima () {
        return new ArrayList<>(cimasLogradas);
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
