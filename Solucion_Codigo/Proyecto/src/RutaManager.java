
import java.util.Scanner;

public class RutaManager {

    static String[] horas = {
        "06:30", "07:30", "08:00", "09:00", "09:30",
        "12:30", "13:00", "16:30", "18:00", "20:00"
    };

    public static String[][] inicializarParadas(String[] barrios) {
        String[][] paradas = new String[barrios.length][51];
        for (int i = 0; i < paradas.length; i++) {
            paradas[i][0] = barrios[i];
            for (int j = 1; j < paradas[0].length; j++) {
                paradas[i][j] = barrios[(int) (Math.random() * barrios.length)];
            }
        }
        return paradas;
    }

    public static void mostrarRutasEntrada(int barrio, String[][] paradas, int[][] personas) {
        Scanner tcl = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + ") " + paradas[barrio][0] + ", ");
            for (int j = 1 + i * 5; j < 1 + (i + 1) * 5; j++) {
                System.out.print(paradas[barrio][j] + ", ");
            }
            System.out.println("Utpl " + horas[i] + " personas: (" + personas[barrio][i] + ")");
        }

        System.out.println("Deseas entrar a una ruta?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int op = tcl.nextInt();
        if (op == 1) {
            System.out.print("Cual ruta deseas tomar (1-5)? ");
            int ruta = tcl.nextInt();
            int index = ruta - 1;
            if (personas[barrio][index] < 50) {
                personas[barrio][index]++;
                System.out.println("Subiste a la ruta " + ruta + " a las " + horas[index] + ". Ahora hay " + personas[barrio][index] + " personas. ");
            } else {
                System.out.println("Lo siento papu , esa ruta ya esta llena.");
            }
        }
    }

    public static void mostrarRutasSalida(int barrio, String[][] paradas, int[][] personas) {
        Scanner tcl = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + ") Utpl, ");
            for (int j = 26 + i * 5; j < 26 + (i + 1) * 5; j++) {
                System.out.print(paradas[barrio][j] + ", ");
            }
            System.out.println(paradas[barrio][0] + " " + horas[i + 5] + " personas: (" + personas[barrio][i + 5] + ")");
        }

        System.out.println("Deseas entrar a una ruta?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int op = tcl.nextInt();
        if (op == 1) {
            System.out.print("Cual ruta deseas tomar (1-5)? ");
            int ruta = tcl.nextInt();
            int index = ruta + 4; // porque están del 5 al 9
            if (personas[barrio][index] < 50) {
                personas[barrio][index]++;
                System.out.println("Subiste a la ruta " + ruta + " a las " + horas[index] + ". Ahora hay " + personas[barrio][index] + " personas.");
            } else {
                System.out.println("Lo siento papu , esa ruta ya esta llena.");
            }
        }
    }
}
