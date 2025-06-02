import java.util.Scanner;

public class RutaManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] barrios = BarrioManager.inicializarBarrios();
        String[][] paradas = RutaManager.inicializarParadas(barrios);
        int[][] personas = PersonaManager.inicializarPersonas();

        boolean seguir = true;
       
        while (seguir) {
            BarrioManager.mostrarBarrios(barrios);
            System.out.print("Seleccione un barrio: ");
            int barrio = scanner.nextInt() - 1;

            System.out.println("1. Ver rutas de entrada");
            System.out.println("2. Ver rutas de salida");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                RutaManager.mostrarRutasEntrada(barrio, paradas, personas);
            } else {
                RutaManager.mostrarRutasSalida(barrio, paradas, personas);
            }

            System.out.println("\nDesea buscar otro barrio?");
            System.out.println("1. Si");
            System.out.println("2. No");
            int decision = scanner.nextInt();
            if (decision==2){
            seguir=false;
            }
        }
        System.out.println("Se ha finalizado el sistema");


    }
}

