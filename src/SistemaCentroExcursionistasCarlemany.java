import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Gestiona las entidades principales del Centro de Excursionistas Carlemany.
 * Contiene la lógica para gestionar montañas, expediciones catálogo y expedicionarios.
 */
public class SistemaCentroExcursionistasCarlemany {

    private Map<String, Expedicionario> expedicionarios;
    private Map<Integer, Montaña> montañas;
    private List<Expedicion> historialExpediciones;
    private Catalogo catalogo;
    private int contadorExpediciones;
    private int contadorMontañas;
    private int contadorCatalogo;

    public SistemaCentroExcursionistasCarlemany() {
        this.expedicionarios = new HashMap<>();
        this.montañas = new HashMap<>();
        this.historialExpediciones = new ArrayList<>();
        this.catalogo = new Catalogo(1);
        this.contadorExpediciones = 1;
        this.contadorMontañas = 1;
        this.contadorCatalogo = 1;
    }


// GESTIÓN DE MONTAÑAS

    /**
     * Registra una nueva montaña en el sistema
     * Genera automaticamente un ID único para la montaña
     * @param nombre nombre de la montaña
     * @param altura altura de la montaña
     * @param localizacion localización de la montaña
     * @return la montaña creada
     */
    public Montaña registrarMontaña (String nombre, int altura, String localizacion) {
        int id = contadorMontañas++;

        Montaña montaña = new Montaña(id, nombre, altura, localizacion);
        montañas.put(id, montaña);
        return montaña;
    }

    /**
     * Busca una montaña por su identificador id
     * @param id el id de la montaña a buscar
     * @return la montaña encontrada o null si no existe
     */
    public Montaña buscarMontaña (int id) {
        return montañas.get(id);
    }

    /**
     * Actualiza los datos de una montaña existente
     * @param id id de la montaña a actualizar
     * @param nombre nombre de la montaña
     * @param altura altura de la montaña
     * @param localizacion localización de la montaña
     */
    public void actualizarMontaña(int id, String nombre, int altura, String localizacion) {
        Montaña montaña = montañas.get(id);

        if ( montaña != null) {
           montaña.setNombre(nombre);
           montaña.setAltura(altura);
           montaña.setLocalizacion(localizacion);
        }
    }

    /**
     * listar todas las montañas registradas en el sistema (cambio map a list para iteración)
     * @return lista de todas las montañas.
     */
    public List<Montaña> listarMontañas () {
        return new ArrayList<>(montañas.values());
    }

// GESTIÓN DE CATALOGO



}
