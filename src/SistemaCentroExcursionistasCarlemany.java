import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que gestiona el sistema del centro de excursionistas Carlemany
 */
public class SistemaCentroExcursionistasCarlemany {

    private Map<String, Expedicionario> expedicionarios;
    private Map<Integer, Montaña> montañas;
    private List<Expedicion> historialExpediciones;
    private Catalogo catalogo;
    private int contadorExpediciones;
    private int contadorMontañas;

    public SistemaCentroExcursionistasCarlemany() {
        this.expedicionarios = new HashMap<>();
        this.montañas = new HashMap<>();
        this.historialExpediciones = new ArrayList<>();
        this.catalogo = new Catalogo(1);
        this.contadorExpediciones = 1;
        this.contadorMontañas = 1;
    }


}
