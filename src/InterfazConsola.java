import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Interfaz de consola del sistema del Centro de Excursionistas Carlemany.
 * Gestiona el flujo de menús, entrada del usuario y comunicación con el sistema.
 */
public class InterfazConsola {

    // Autenticación
    private static final String PASSWORD = "carlemany2025";
    private static final int MAX_INTENTOS_LOGIN = 3;

    // Formato de fechas
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private SistemaCentroExcursionistasCarlemany sistema;
    private Scanner scanner;
    private boolean autenticado;

    public InterfazConsola() {
        this.sistema = new SistemaCentroExcursionistasCarlemany();
        this.scanner = new Scanner(System.in);
        this.autenticado = false;
    }

    /**
     * Inicia la aplicación y gestiona el flujo inicial.
     */
    public void iniciar() {
        bienvenida();

        if (autenticar()) {
            autenticado = true;
            mostrarMenuPrincipal();
        } else {
            System.out.println("\n Número máximo de intentos alcanzados. Saliendo del sistema.......");
        }
        scanner.close();
    }

    public void bienvenida() {
        System.out.println("================================================================================");
        System.out.println("           SISTEMA DE GESTIÓN - CENTRO DE EXCURSIONISTAS CARLEMANY              ");
        System.out.println("================================================================================");
    }

    /**
     * Solicita la contraseña hasta alcanzar el máximo de intentos.
     */
    public boolean autenticar() {
        int intentos = 0;

        while (intentos < MAX_INTENTOS_LOGIN) {
            System.out.println(" - Ingrese la contraseña de acceso: ");
            String password = scanner.nextLine();

            if (password.equals(PASSWORD)) {
                System.out.println("Acceso concedido. Bienvenido al sistema. \n");
                return true;
            } else {
                intentos++;
                int restantes = MAX_INTENTOS_LOGIN - intentos;
                if (restantes > 0) {
                    System.out.println("La contraseña es incorrecta. Intentos restantes: " + restantes + ". \n");
                }

            }
        }
        return false;
    }

// MENÚS

    public void mostrarMenuPrincipal() {
        boolean salir = false;

        while (!salir) {
            System.out.println("================================================================================");
            System.out.println("                                MENÚ PRINCIPAL                                   ");
            System.out.println("================================================================================");
            System.out.println("1. Gestión de Montañas");
            System.out.println("2. Gestión de Catálogo");
            System.out.println("3. Gestión de Expedicionarios");
            System.out.println("4. Gestión de Expediciones");
            System.out.println("5. Consultas");
            System.out.println("0. Salir del sistema");
            System.out.println("================================================================================");

            int opcion = leerOpcion(0, 5);

            switch (opcion) {
                case 1: menuGestionMontañas(); break;
                case 2: menuGestionCatalogo(); break;
                case 3: menuGestionExpedicionarios(); break;
                case 4: menuGestionExpediciones(); break;
                case 5: menuConsultas(); break;
                case 0:
                    salir = true;
                    System.out.println("\n Gracias por usar el sistema de Carlemany. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println(" Opción no válida");
            }
        }
    }

    private void menuGestionMontañas() {
        boolean volver = false;

        while (!volver) {
            System.out.println("================================================================================");
            System.out.println("                            GESTIÓN DE MONTAÑAS                                 ");
            System.out.println("================================================================================");
            System.out.println("1. Registrar nueva Montaña");
            System.out.println("2. Buscar Montaña por ID");
            System.out.println("3. Actualizar datos de la Montaña");
            System.out.println("4. Lista de todas las Montañas");
            System.out.println("0. Volver al menú principal");
            System.out.println("================================================================================");

            int opcion = leerOpcion(0, 4);

            switch (opcion) {
                case 1: registrarMontaña();break;
                case 2: buscarMontaña(); break;
                case 3: actualizarMontaña(); break;
                case 4: listarMontañas(); break;
                case 0: volver = true; break;
                default:
                    System.out.println(" Opción no válida");
            }
        }
    }

    public void menuGestionCatalogo() {
        boolean volver = false;

        while (!volver) {
            System.out.println("================================================================================");
            System.out.println("                            GESTIÓN DE CATÁLOGO                                 ");
            System.out.println("================================================================================");
            System.out.println("1. Añadir Montaña al Catálogo por id");
            System.out.println("2. Quitar Montaña del Catálogo por id");
            System.out.println("3. Listar Montañas Disponibles");
            System.out.println("0. Volver al menú principal");
            System.out.println("================================================================================");

            int opcion = leerOpcion(0, 3);

            switch (opcion) {
                case 1: agregarMontañaCatalogo(); break;
                case 2: quitarMontañaCatalogo(); break;
                case 3: listarMontañasCatalogo(); break;
                case 0: volver = true; break;
                default:
                    System.out.println("  Opción no válida");
            }
        }
    }

    public void menuGestionExpedicionarios() {
        boolean volver = false;

        while (!volver) {
            System.out.println("================================================================================");
            System.out.println("                          GESTIÓN DE EXPEDICIONARIOS                            ");
            System.out.println("================================================================================");
            System.out.println("1. Registrar nuevo Alpinista");
            System.out.println("2. Registrar nuevo Médico");
            System.out.println("3. Borrar Expedicionaro por su DNI");
            System.out.println("4. Listar todos los Expedicionarios del sistema");
            System.out.println("5. Consultar ficha de Expedicionario por DNI");
            System.out.println("6. Modificación del Expedicionaro por su DNI");
            System.out.println("0. Volver al menú principal");
            System.out.println("================================================================================");

            int opcion = leerOpcion(0, 6);

            switch (opcion) {
                case 1: registrarAlpinista(); break;
                case 2: registrarMedico(); break;
                case 3: borrarExpedicionario(); break;
                case 4: listarExpedicionarios(); break;
                case 5: buscarExpedicionario(); break;
                case 6: modificarExpedicionario(); break;
                case 0: volver = true; break;
                default:
                    System.out.println("  Opción no válida");
            }
        }
    }

    public void menuGestionExpediciones() {
        boolean volver = false;

        while (!volver) {
            System.out.println("================================================================================");
            System.out.println("                            GESTIÓN DE EXPEDICIONES                             ");
            System.out.println("================================================================================");
            System.out.println("1. Crear nueva Expedición");
            System.out.println("2. Añadir participantes a Expedición");
            System.out.println("3. Registrar cima alcanzada");
            System.out.println("4. Listar todas las Expediciones");
            System.out.println("0. Volver al menú principal");
            System.out.println("================================================================================");

            int opcion = leerOpcion(0, 4);

            switch (opcion) {
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 0: volver = true; break;
                default:
                    System.out.println("  Opción no válida");
            }
        }
    }

    public void menuConsultas() {
        boolean volver = false;

        while (!volver) {
            System.out.println("================================================================================");
            System.out.println("                                   CONSULTAS                                    ");
            System.out.println("================================================================================");
            System.out.println("1. Expediciones de un expedicionario por su id");
            System.out.println("2. Verificar si se alcanzo la cima ");
            System.out.println("3. Listar participantes de una Expedición por su id");
            System.out.println("0. Volver al menú principal");
            System.out.println("================================================================================");

            int opcion = leerOpcion(0, 3);

            switch (opcion) {
                case 1: break;
                case 2: break;
                case 3: break;
                case 0: volver = true; break;
                default:
                    System.out.println("  Opción no válida");
            }
        }
    }

// --- GESTIÓN DE MONTAÑAS ---

    /**
     * Solicita los datos al usuario y registra una nueva montaña en el sistema.
     * Valida entradas básicas y captura errores de conversión numérica.
     * la creación de la montaña se realiza en el sistema.
     */
    public void registrarMontaña() {
        System.out.println("\n --- REGISTRAR NUEVA MONTAÑA ---");

        try {
            System.out.println("Nombre de la montaña: ");
            String nombre = scanner.nextLine();
            System.out.println("Altura (metros): ");
            int altura = Integer.parseInt(scanner.nextLine());
            System.out.println("Localización: ");
            String localizacion = scanner.nextLine();

            Montaña montaña = sistema.registrarMontaña(nombre, altura, localizacion);
            System.out.println("Montaña registrada exitosamente con ID: " + montaña.getId());
            System.out.println(montaña);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            pausar();
        }
    }

    /**
     * Permite buscar una montaña por su ID. Muestra el resultado si existe.
     * Si el ID no corresponde a ninguna montaña, informa al usuario.
     */
    public void buscarMontaña() {
        System.out.println("\n --- BUSCAR MONTAÑA ---");

        try {
            System.out.println("ID de la montaña: ");
            int id = Integer.parseInt(scanner.nextLine());
            Montaña montaña = sistema.buscarMontaña(id);

            if (montaña != null){
                System.out.println("Montaña encontrada: ");
                System.out.println(montaña);
            } else {
                System.out.println("No se encontro ninguna montaña con el ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        pausar();
    }

    /**
     * Actualiza una montaña existente buscando primero su ID.
     * Si la montaña existe, solicita los nuevos valores y delega la actualización en el sistema.
     * Si no existe, finaliza el proceso sin modificar nada.
     */
    public void actualizarMontaña() {
        System.out.println("\n --- ACTUALIZAR MONTAÑA ---");

        try {
            System.out.println("ID de la montaña a actualizar");
            int id = Integer.parseInt(scanner.nextLine());
            Montaña montañaActual = sistema.buscarMontaña(id);

            if (montañaActual == null) {
                System.out.println("No se encontró ninguna montaña con el ID " + id);
                pausar();
                return;
            }

            System.out.println("Nombre de la montaña: ");
            String nombre = scanner.nextLine();
            System.out.println("Altura (metros): ");
            int altura = Integer.parseInt(scanner.nextLine());
            System.out.println("Localización: ");
            String localizacion = scanner.nextLine();

            sistema.actualizarMontaña(id, nombre, altura, localizacion);
            System.out.println("Montaña actualizada con exito");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        pausar();
    }

    /**
     * Muestra todas las montañas registradas en el sistema.
     * Si no hay ninguna, informa al usuario.
     */
    public void listarMontañas (){
        System.out.println("\n --- LISTADO DE TODAS LAS MONTAÑAS DISPONIBLES ---");

        List<Montaña> montañas = sistema.listarMontañas();

        if (montañas.isEmpty()) {
            System.out.println("No tenemos montañas registradas");
        } else {
            for (Montaña m : montañas) {
                System.out.println(" * " + m);
            }
        }
        pausar();
    }

// --- GESTIÓN DE CATÁLOGO ---

    /**
     * Solicita ID de una montaña ya registrada y la añade al catálogo
     * Si la montaña no existe o ya está en el catálogo, informa.
     */
    private void agregarMontañaCatalogo () {
        System.out.println("\n --- AÑADIR MONTAÑA AL CATÁLOGO ---");

        try {
            System.out.println("ID de la montaña que desea añadir al catálogo: ");
            int id = Integer.parseInt(scanner.nextLine());

            boolean agregada = sistema.agregarMontañaAlCatalogo(id);

            if (agregada) {
                System.out.println("La montaña con ID " + id + " ha sido añadida correctamente al catálogo");
            } else {
                System.out.println("No se pudo agregar la montaña porque o bien no exista o bien esta añadida ya");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        pausar();
    }

    /**
     * Solicita ID y elimina la montaña correspondiente del catálogo.
     * Mensaje si no se encuentra presente.
     */
    private void quitarMontañaCatalogo () {
        System.out.println("\n --- QUITAR MONTAÑA DEL CATÁLOGO ---");

        try {
            System.out.println("Id de la montaña que desea quitar del catálogo: ");
            int id = Integer.parseInt(scanner.nextLine());

            boolean eliminada = sistema.quitarMontañaCatalogo(id);

            if (eliminada) {
                System.out.println("La montaña con ID " + id + " ha sido eliminada del catálogo correctamente.");
            } else {
                System.out.println("No existe ninguna montaña con ese ID dentro del catálogo.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        pausar();
    }

    /**
     * Lista todas las montañas disponibles dentro del catálogo.
     * Mensaje si el catálogo se encuentra vacío.
     */
    private void listarMontañasCatalogo () {
        System.out.println("\n --- MONTAÑAS INCLUIDAS EN EL CATÁLOGO ---");
        List<Montaña> lista = sistema.listarCatalogo();

        if (lista.isEmpty()) {
            System.out.println("El catálogo no contiene ninguna montaña registrada.");
        } else {
            for (Montaña m : lista) {
                System.out.println(" * " + m);
            }
        }
        pausar();
    }

// --- GESTIÓN DE EXPEDICIONARIO (ALPINISTA O MÉDICO) ---

    /**
     * Registro de ALpinista en el sistema
     */
    private void registrarAlpinista() {
        System.out.println("\n --- REGISTRAR ALPINISTA ---");

        try {
            System.out.println("DNI: ");
            String dni = scanner.nextLine();
            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            System.out.println("Teléfono: ");
            String telefono = scanner.nextLine();

            Alpinista alpinista = new Alpinista(dni, nombre, edad, telefono);
            sistema.registrarExpedicionario(alpinista);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        pausar();
    }

    /**
     * Registro de médico en el sistema
     */
    private void registrarMedico() {
        System.out.println("\n --- REGISTRAR ALPINISTA ---");

        try {
            System.out.println("DNI: ");
            String dni = scanner.nextLine();
            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            System.out.println("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.println("Número de licencia: ");
            String licencia = scanner.nextLine();
            System.out.println("Especialidad: ");
            String especialidad = scanner.nextLine();

            Medico medico = new Medico(dni, nombre, edad, telefono, licencia, especialidad);
            sistema.registrarExpedicionario(medico);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        pausar();
    }

    /**
     * Borrar expedicionario por su DNI
     */
    private void borrarExpedicionario() {
        System.out.println("\n --- BORRAR EXPEDICIONARIO ---");

        try {
            System.out.println("DNI: ");
            String dni = scanner.nextLine();

            Expedicionario expedicionarioEliminado = sistema.borrarExpedicionario(dni);

            if (expedicionarioEliminado != null) {
                System.out.println("El expedicionario ha sido eliminado.");
            } else {
                System.out.println("No existe ningún expedicionario con el DNI " + dni);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        pausar();
    }

    /**
     * Listar todos los expedicionarios del sistema o mensaje de que no tenemos ninguno.
     */
    public void listarExpedicionarios() {
        System.out.println("\n --- LISTA DE EXPEDICIONARIOS ---");
        List<Expedicionario> expedicionarios = sistema.listarExpedicionarios();

        if (expedicionarios.isEmpty()) {
            System.out.println("No hay expedicionarios registrados");
        } else {
            for (Expedicionario e : expedicionarios) {
                System.out.println(" * " + e);
            }
        }
        pausar();
    }

    /**
     * Busqueda expedicionario por DNI
     */
    public void buscarExpedicionario() {
        System.out.println("\n --- FICHA DEL EXPEDICIONARIO ---");

        System.out.println("DNI: ");
        String dni = scanner.nextLine();
        Expedicionario expedicionario = sistema.burcarExpedicionario(dni);

        if (expedicionario != null) {
            System.out.println("--- FICHA DE " + dni + " ---");
            System.out.println(expedicionario);
        } else {
            System.out.println("No se encontró un expedicionario con el DNI " + dni);
        }
        pausar();
    }

    /**
     * Modificar espedicionario en concreto Médico o Alpinista
     */
    private void modificarExpedicionario () {
        System.out.println("\n --- MODIFICAR EXPEDICIONARIO ---");

        try {
            System.out.println("DNI: ");
            String dni = scanner.nextLine();

            Expedicionario expedicionarioModificar = sistema.consultarExpedicionario(dni);

            if(expedicionarioModificar == null) {
                System.out.println("No existe Expedicionario con el DNI " + dni);
                pausar();
                return;
            }

            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            System.out.println("Teléfono: ");
            String telefono = scanner.nextLine();

            if (expedicionarioModificar instanceof Medico) {
                System.out.println("Número de licencia: ");
                String licencia = scanner.nextLine();
                System.out.println("Especialidad: ");
                String especialidad = scanner.nextLine();

                sistema.modificarMedico(dni, nombre,edad, telefono, licencia, especialidad);
            } else {
                sistema.modificarAlpinista(dni, nombre, edad, telefono);
            }


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        pausar();
    }

// --- MÉTODOS AUXILIARES ---

    /**
     * Metodo para leer una opción dentro de un rango que estara permitido para los distintos menus
     * @param min minimo siempre va a ser 0
     * @param max el numero de opciones que tenga cada menu
     * @return la opción seleccionada o seguira en el bucle sino es una opción correcta
     */
    private int leerOpcion(int min, int max) {

        while(true) {
            System.out.println("\n -> Selecciona una opción:");
            String entrada = scanner.nextLine();

            try {
                int opcion = Integer.parseInt(entrada);
                if (opcion >= min && opcion <= max) {
                    return opcion;
                } else {
                    System.out.println("Error la opción seleccionada no es la correcta.");
                }
            } catch ( NumberFormatException e) {
                System.out.println("Error: Se debe introducir un número válido.");
            }
        }

    }

    private void pausar () {
        System.out.println("\n Presione enter para continuar....");
        scanner.nextLine();
    }

    /**
     * Metodo que inicia toda la aplicación.
     */
    public static void main(String[] args) {
        InterfazConsola interfaz = new InterfazConsola();
        interfaz.iniciar();
    }
}
