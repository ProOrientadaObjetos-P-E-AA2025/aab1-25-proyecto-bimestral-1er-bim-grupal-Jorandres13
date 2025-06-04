
import java.util.Scanner;

public class RutasEntrada {

    String[] rutasEntrada;

    public RutasEntrada(String parada1, String parada2, String parada3, String parada4, String parada5) {
        this.rutasEntrada = new String[]{parada1, parada2, parada3, parada4, parada5, "UTPL"};
    }

    public void tiempoDeViaje() {
    Scanner tcl = new Scanner(System.in);
    System.out.println("Seleccione de que parada (1-5) desea calcular el tiempo hasta la UTPL:");
    for (int i = 0; i < 5; i++) {
        System.out.println((i + 1) + ") " + rutasEntrada[i]);
    }
    int opcion = tcl.nextInt();
    if (opcion >= 1 && opcion <= 5) {
        int tiempo = (6 - opcion) * 5;
        System.out.println("Tiempo estimado: " + tiempo + " minutos.");
        System.out.println("Ruta desde " + rutasEntrada[opcion - 1] + " hasta UTPL:");
        for (int i = opcion - 1; i < rutasEntrada.length; i++) {
            System.out.println("  - " + rutasEntrada[i]);
        }
    } else {
        System.out.println("Parada invalida.");
    }
}


