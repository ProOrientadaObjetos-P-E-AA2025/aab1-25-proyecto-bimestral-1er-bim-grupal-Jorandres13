
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);

        ArrayList<Ruta> rutas = new ArrayList<>();
        rutas.add(new Ruta("Agencia Banco de Loja", "Av. 8 de Diciembre", "Cabo Minacho", "Calasanz", "Hipervalle"));
        rutas.add(new Ruta("Av. Eloy Alfaro", "Colegio Beatriz Cueva de Ayora", "Clinica Natali", "Rosales", "Parque Polideportivo"));
        rutas.add(new Ruta("Av. Kigman", "Sauces Norte", "Urna", "Tebaida Baja", "Zona Militar"));
        rutas.add(new Ruta("Ciudad Alegria", "Tnte. Geovany Calle", "Parque Infantil", "Los Cocos", "Redondel del Soldado"));
        rutas.add(new Ruta("Casa de Enfermeros Terminales", "Coliseo Ciudad de Loja", "Parqueadero Polideportivo", "Predesur", "Lauro Guerrero"));
        rutas.add(new Ruta("Jose A. Eguiguren", "Iglesia Verbo", "Mercadillo", "Pradera", "Migas"));
        rutas.add(new Ruta("Estadio", "La Salle", "Las Pitas", "Hotel La Castellana", "Puerta de la Ciudad"));
        rutas.add(new Ruta("Terminal Terrestre", "Tame", "Clinica Natali", "Calasanz", "Ciudad Alegria"));
        rutas.add(new Ruta("Parque Polideportivo", "Rosales", "Colegio Beatriz Cueva de Ayora", "Hipervalle", "Jose A. Eguiguren"));
        rutas.add(new Ruta("Pradera", "Parque Infantil", "Urna", "Estadio", "Redondel del Soldado"));

        boolean op = true;
        do {
            System.out.println("----- BIENVENIDO AL SISTEMA DE BUSES UTPL -----");
            System.out.println("-------------- Que desea hacer? --------------");
            System.out.println("1. Ver paradas");
            System.out.println("2. Ver rutas de entrada");
            System.out.println("3. Ver rutas de salida");
            System.out.print("Seleccione una opcion: ");
            int pe = tcl.nextInt();

            switch (pe) {
                case 1:
                    System.out.println("Mostrando todas las paradas disponibles...");
                    String[] barrios = Paradas.inicializarBarrios();
                    Paradas.mostrarBarrios(barrios);
                    break;

                case 2:
                    System.out.println("Mostrando rutas de entrada...");
                    for (int i = 0; i < rutas.size(); i++) {
                        Ruta r = rutas.get(i);
                        System.out.println("Ruta " + (i + 1) + ":");
                        for (String parada : r.getRuta()) {
                            System.out.println("  - " + parada);
                        }
                    }

                    System.out.print("Desea calcular el tiempo desde una parada especifica? (s/n): ");
                    char calcEntrada = tcl.next().charAt(0);
                    if (calcEntrada == 's' || calcEntrada == 'S') {
                        System.out.print("Seleccione el numero de ruta: ");
                        int rutaIndex = tcl.nextInt() - 1;

                        if (rutaIndex >= 0 && rutaIndex < rutas.size()) {
                            String[] r = rutas.get(rutaIndex).getRuta();
                            RutasEntrada entrada = new RutasEntrada(r[0], r[1], r[2], r[3], r[4]);
                            entrada.tiempoDeViaje();
                        } else {
                            System.out.println("Numero de ruta inválido.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Mostrando rutas de salida...");
                    int x = 1;
                    for (int i = 0 ; i < rutas.size(); i++) {
                        Ruta r = rutas.get(i);
                        System.out.println("Ruta " + (x) + ":");

                        String[] paradas = r.getRuta();
                        x++;
                        for (int j = paradas.length - 1; j >= 0; j--) {
                            System.out.println("  - " + paradas[j]);
                        }
                    }

                    System.out.print("Desea calcular el tiempo hacia una parada especifica? (s/n): ");
                    char calcSalida = tcl.next().charAt(0);
                    if (calcSalida == 's' || calcSalida == 'S') {
                        System.out.print("Seleccione el numero de ruta: ");
                        int rutaIndex = tcl.nextInt() - 1;

                        if (rutaIndex >= 0 && rutaIndex < rutas.size()) {
                            String[] r = rutas.get(rutaIndex).getRuta();
                            RutasSalida salida = new RutasSalida(r[0], r[1], r[2], r[3], r[4]);
                            salida.tiempoDeViaje();
                        } else {
                            System.out.println("Numero de ruta inválido.");
                        }
                    }
                    break;

                default:
                    System.out.println("Opcion no válida. Intente de nuevo.");
                    break;
            }

            System.out.print("Desea realizar otra operacion? (s/n): ");
            char continuar = tcl.next().charAt(0);
            if (continuar == 'n' || continuar == 'N') {
                op = false;
            }

        } while (op);
    }
}
