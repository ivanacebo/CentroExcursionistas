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

    /**
     * Agrega un expedicionario a la lista de participantes
     * @param expedicionario clase Expedicionario hay que crearlo.
     */
    public void agregarParticipante (Expedicionario expedicionario) {
        if (!participantes.contains(expedicionario)) {
            participantes.add(expedicionario);
        }
    }

    /**
     * Elimina un expedicionario de la lista de participantes.
     * @param dni dni por el que se busca al participante a eliminar.
     * @return true o false si se elimina un elemento.
     */
    public boolean eliminarParticipante (String dni) {
        return participantes.removeIf(e -> e.getDni().equals(dni));
    }

// ------------------------------------------ MODICIAR NO ME CONVENCE -------------------------------

    /**
     * Registra un alpinista que logró alcanzar la cima.
      * @param alpinista Clase alpinista hay que crearlo.
     */
    public void registrarCima (Alpinista alpinista) {
        if (participantes.contains(alpinista) && !cimasLogradas.contains(alpinista)) {
            cimasLogradas.add(alpinista);
        }
    }
// -----------------------------------------------------------------------

    /**
     * Verificación de la expedición tiene al menos un médico.
     * @return verdadero o falso si la lista de participantes tiene al menos un medico en ella.
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
     * @param dni metodo de identificación de un expedicionario.
     * @return lista de expediciones realizadas por el expedicionario.
     */
    public List<Expedicion> consultarExpediciones (String dni) {
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
     * @return lista de cimas logradas por todos los alpinistas.
     */
    public List<Alpinista> getAlpinistasConCima () {
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
