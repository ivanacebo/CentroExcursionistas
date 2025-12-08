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
    private String cimaAlcanzada;
    private List<Expedicionario> participantes;

    public Expedicion(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, Montaña montañaDestino, String cimaAlcanzada) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montañaDestino = montañaDestino;
        this.cimaAlcanzada = cimaAlcanzada;
        this.participantes = new ArrayList<>();
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

    public String getCimaAlcanzada() {return cimaAlcanzada; }

    public List<Expedicionario> getParticipantes() {
        return participantes;
    }

    public void setCimaAlcanzada(String cimaAlcanzada) {this.cimaAlcanzada = cimaAlcanzada; }

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
     * Verificación de la expedición tiene al menos un alpinista.
     */
    public boolean tieneAlpinista() {
        for (Expedicionario e: participantes) {
            if (e instanceof  Alpinista) {
                return true;
            }
        }
        return false;
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
                ", Hicieron cima= " + cimaAlcanzada + "]";
    }
}
