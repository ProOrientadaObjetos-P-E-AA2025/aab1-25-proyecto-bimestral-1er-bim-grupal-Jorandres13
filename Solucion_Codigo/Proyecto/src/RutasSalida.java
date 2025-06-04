
import java.util.Scanner;

public class RutasSalida {

    String[] rutasSalida;

    public RutasSalida(String parada1, String parada2, String parada3, String parada4, String parada5) {
        this.rutasSalida = new String[]{"UTPL", parada5, parada4, parada3, parada2, parada1};
    }

    public void tiempoDeViaje() {
    Scanner tcl = new Scanner(System.in);
    System.out.println("Seleccione a que parada desea llegar desde la UTPL (1-5):");
    for (int i = 1; i <= 5; i++) {
        System.out.println((i) + ") " + rutasSalida[i]);
    }
    int opcion = tcl.nextInt();
    if (opcion >= 1 && opcion <= 5) {
        int tiempo = opcion * 5;
        System.out.println("Tiempo estimado: " + tiempo + " minutos.");
        System.out.println("Ruta desde UTPL hasta " + rutasSalida[opcion] + ":");
        for (int i = 0; i <= opcion; i++) {
            System.out.println("  - " + rutasSalida[i]);
        }
    } else {
        System.out.println("Parada invalida.");
    }
}

}
