import java.sql.SQLOutput;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InterfazConsola {

    // Contraseña de acceso y maximo de intentos para ella
    private static final String PASSWORD = "carlemany2025";
    private static final int MAX_INTENTOS_LOGIN = 3;

    // Formateador de fechas que define el patrón "día/mes/año" (por ejemplo: 25/12/2025).
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
     * Inicia la aplicación, llama al metodo de bienvenida y pedir contraseña.
     * Si la contraseña falla los tres intentos nos echaria del sistema.
     * Si la contraseña es la adecuada nos deberia mostrar el primer menu que es el principal.
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


    /**
     * Mensaje de bienvenida.
     */
    public void bienvenida() {
        System.out.println("================================================================================");
        System.out.println("           SISTEMA DE GESTIÓN - CENTRO DE EXCURSIONISTAS CARLEMANY              ");
        System.out.println("================================================================================");
    }

    /**
     * Metodo de acceso al sistema donde solicita la contraseña para poder acceder al sistema.
     * Tenemos 3 intentos maximo para poder acceder si fallamos los 3 intentos nos devuelve un false.
     * Si acertamos la contraseña tenemos un true.
     * @return true o false si la contraseña esta bien escrita y coincide con la que tenemos antes puesta "carlemany2025".
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

/**
 * A PARTIR DE AQUI PROGRAMAMOS LA LOGICA PARA LOS DISTINTOS MENUS.
 * 1. MENU PRINCIPAL DE ACCESO.
 * 2. MENU DE GESTION DE MONTAÑAS
 * 3. MENU DE GESTION DE CATALOGOS
 * 4. MENU GESTION DE EXPEDICIONARIOS
 * 5. MENU GESTION DE EXPEDICIONES
 * 6. MENU DE CONSULTAS
 */

    /**
     * Muestra el menú principal y es el punto de acceso a los distintos menús
     */
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

    /**
     * Menu de gestión de montañas que accedemos desde el menu principal.
     * Nos permite hacer ciertas cosas en este menu como registrar, buscar por ide actualizar datos listas montañas
     * volveriamos al anterior menú una vez acabemos aquí
     */
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
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 0: volver = true; break;
                default:
                    System.out.println(" Opción no válida");
            }
        }
    }

    /**
     * Menu de gestión de catalogo al cual accedemos desde el menú principal.
     * Nos permite hacer ciertas funciones como añadir Montaña por id,  quitar montaña por id, listar todas las montañas disponibles dentro del catálogo, ver alpinistas que tengan cima en una montaña.
     * Volveremos al menú principal una vez acabemos de usar este menú.
     */
    public void menuGestionCatalogo() {
        boolean volver = false;

        while (!volver) {
            System.out.println("================================================================================");
            System.out.println("                            GESTIÓN DE CATÁLOGO                                 ");
            System.out.println("================================================================================");
            System.out.println("1. Añadir Montaña al Catálogo por id");
            System.out.println("2. Quitar Montaña del Catálogo por id");
            System.out.println("3. Listar Montañas Disponibles");
            System.out.println("4. Ver Alpinistas con cima en Montaña");
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

    /**
     * Menú de gestión de Expedicionarios accesible a través del menú principal.
     * Podremos registrar Alpinistas, Médicos, sacar una lista de todos los Expedicionarios disponibles y podremos consultar la ficha de uno de ellos por su id.
     * Volveremos al menú principal una vez acabaemos de usar este menú.
     */
    public void menuGestionExpedicionarios() {
        boolean volver = false;

        while (!volver) {
            System.out.println("================================================================================");
            System.out.println("                          GESTIÓN DE EXPEDICIONARIOS                            ");
            System.out.println("================================================================================");
            System.out.println("1. Registrar nuevo Alpinista");
            System.out.println("2. Registrar nuevo Médico");
            System.out.println("3. Listar todos los Expedicionarios del sistema");
            System.out.println("4. Consultar ficha de Expedicionario por id");
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

    /**
     * Menú de gestión de Expediciones accesible a través del menú principal
     * Podremos realizar la creación de Expediciones, añadir participantes, registar si se alcanzo la cima o listar todas las expediciones.
     * Volveremos al menú principal una vez se acabe de realizar todas las operaciones necesarias aquí
     */
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

    /**
     * Menú de consultas accesible a través del menú principal.
     * Podremos consultar las expediciones realizadas por un expedicionario por su id, verificar si se alcanzo la cima, listar participantes de una expedición por su id.
     * Volveremos al menú principal una vez acabemos de consultar los datos que necesitemos saber.
     */
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

            int opcion = leerOpcion(0, 4);

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

    /**
     * Metodo que utilizamos para pausar el programa en algún momento
     */
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
