import java.sql.SQLOutput;
import java.time.LocalDate;
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

    public SistemaCentroExcursionistasCarlemany() {
        this.expedicionarios = new HashMap<>();
        this.montañas = new HashMap<>();
        this.historialExpediciones = new ArrayList<>();
        this.catalogo = new Catalogo(1);
        this.contadorExpediciones = 1;
        this.contadorMontañas = 1;

        // Cargar datos iniciales para prueba
        cargaDatos();
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

    /**
     * Agrega una montaña existente al catálogo.
     */
    public boolean agregarMontañaAlCatalogo (int idMontaña) {
        Montaña montaña = montañas.get(idMontaña);

        if (montaña == null) return false;

        return catalogo.agregarMontañaCatalogo(montaña);
    }

    public boolean quitarMontañaCatalogo (int idMontaña) {
        return catalogo.quitarMontañaCatalogo(idMontaña);
    }

    public List<Montaña> listarCatalogo() {
        return catalogo.listarMontañasDisponiblesEnCatalogo();
    }

// GESTIÓN DE EXPEDICIONARIOS

    /**
     * Registramos un nuevo expedicionario en el sistema pudiendo ser Médico o Alpinista
     * Tenemos en cuenta que no sea nulo o que no exista un expedicionario con el mismo DNI
     * @param expedicionario el expedicionario a registrar.
     */
    public void registrarExpedicionario (Expedicionario expedicionario) {
        if ( (expedicionario != null && !expedicionarios.containsKey(expedicionario.getDni()))) {
            expedicionarios.put(expedicionario.getDni(), expedicionario);
        }
    }

    /**
     * Permite buscar un expedicionario por su DNI
     * @param dni DNI identificativo del expedicionario
     * @return expedicionario encontrado o null
     */
    public Expedicionario burcarExpedicionario (String dni) {
        return expedicionarios.get(dni);
    }

    /**
     * Borrar un expedicionario del sistema
     * @param dni Identificación del expedicionario a borrar
     * @return Expedicionario borrado o null
     */
    public Expedicionario borrarExpedicionario (String dni) {
        return expedicionarios.remove(dni);
    }

    /**
     * Listado de todos los expedicionarios.
     */
    public List<Expedicionario> listarExpedicionarios() {
        return new ArrayList<>(expedicionarios.values());
    }

    /**
     * Consulta de la ficha de un expedicionario en concreto por su DNI
     * @param dni identificativo del expedicionario
     * @return información del expedicionario
     */
    public Expedicionario consultarExpedicionario (String dni) {
        return expedicionarios.get(dni);
    }

    /**
     * Modificación de los datos de un Alpinista
     */
    public void modificarAlpinista (String dni, String nombre, int edad, String telefono) {
        Expedicionario expedicionario = expedicionarios.get(dni);

        if (expedicionario != null) {
            expedicionario.setNombre(nombre);
            expedicionario.setEdad(edad);
            expedicionario.setTelefono(telefono);
        }
    }

    /**
     * Modificación de los datos de un Médico
     */
    public void modificarMedico (String dni, String nombre, int edad, String telefono, String licencia, String especialidad) {
        Expedicionario expedicionario = expedicionarios.get(dni);

        if (expedicionario instanceof Medico) {
            Medico medico = (Medico) expedicionario;
            expedicionario.setNombre(nombre);
            expedicionario.setEdad(edad);
            expedicionario.setTelefono(telefono);
            ((Medico) expedicionario).setLicencia(licencia);
            ((Medico) expedicionario).setEspecialidad(especialidad);
        }
    }

// CARGA DE DATOS A MODO DE BASE DE DATOS PARA REALIZAR PRUEBAS MÁS FACILMENTE

    private void cargaDatos() {
        System.out.println("--- Cargando datos iniciales de la base de datos --- \n");

        System.out.println("\n Creando montañas");
        Montaña everest = registrarMontaña("Monte Everest", 8849, "Nepal/China - Himalaya");
        Montaña k2 = registrarMontaña("K2", 8611, "Pakistán/China - Karakórum");
        Montaña kangchenjunga = registrarMontaña("Kangchenjunga", 8586, "Nepal/India - Himalaya");
        Montaña aconcagua = registrarMontaña("Aconcagua", 6961, "Argentina - Andes");
        Montaña montblanc = registrarMontaña("Mont Blanc", 4808, "Francia/Italia - Alpes");
        Montaña matterhorn = registrarMontaña("Matterhorn", 4478, "Suiza/Italia - Alpes");
        Montaña denali = registrarMontaña("Denali", 6190, "Alaska, EE.UU.");

        System.out.println("\n Añadiendo montañas al catálogo");
        agregarMontañaAlCatalogo(everest.getId());
        agregarMontañaAlCatalogo(k2.getId());
        agregarMontañaAlCatalogo(aconcagua.getId());
        agregarMontañaAlCatalogo(montblanc.getId());
        agregarMontañaAlCatalogo(matterhorn.getId());


        System.out.println("\n Creando alpinistas");
        Alpinista alp1 = new Alpinista("12345678A", "Carlos Martínez López", 32, "600123456");
        Alpinista alp2 = new Alpinista("23456789B", "María García Ruiz", 28, "600234567");
        Alpinista alp3 = new Alpinista("34567890C", "Juan Pérez Sánchez", 35, "600345678");
        Alpinista alp4 = new Alpinista("45678901D", "Laura Fernández Gil", 29, "600456789");
        Alpinista alp5 = new Alpinista("56789012E", "Pedro González Torres", 41, "600567890");
        Alpinista alp6 = new Alpinista("67890123F", "Ana Rodríguez Vega", 26, "600678901");

        registrarExpedicionario(alp1);
        registrarExpedicionario(alp2);
        registrarExpedicionario(alp3);
        registrarExpedicionario(alp4);
        registrarExpedicionario(alp5);
        registrarExpedicionario(alp6);

        System.out.println("\n Crando médicos");
        Medico med1 = new Medico("78901234G", "Dr. Roberto Jiménez Cruz", 45, "600789012",
                "MED-12345", "Medicina de Montaña");
        Medico med2 = new Medico("89012345H", "Dra. Isabel Moreno Díaz", 38, "600890123",
                "MED-23456", "Traumatología");
        Medico med3 = new Medico("90123456I", "Dr. Francisco López Ramos", 52, "600901234",
                "MED-34567", "Cardiología");

        registrarExpedicionario(med1);
        registrarExpedicionario(med2);
        registrarExpedicionario(med3);

        System.out.println("\n Creando expediciones");

// --- FALTA PODER CREAR EXPEDICIONES Y AÑADIR PARTICIPANTES A ESTAS ---
    }
}
