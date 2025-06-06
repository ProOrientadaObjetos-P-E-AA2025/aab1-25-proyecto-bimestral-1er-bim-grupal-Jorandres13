
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Ruta> rutasEntrada = new ArrayList<>();

        String[] todosLosBarrios = Paradas.inicializarBarrios();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            ArrayList<String> paradasUnicas = new ArrayList<>();
            while (paradasUnicas.size() < 5) {
                String nombre = todosLosBarrios[random.nextInt(todosLosBarrios.length)];
                if (!paradasUnicas.contains(nombre)) {
                    paradasUnicas.add(nombre);
                }
            }
            ArrayList<Parada> paradasRuta = new ArrayList<>();
            for (String nombre : paradasUnicas) {
                paradasRuta.add(new Parada(nombre));
            }
            paradasRuta.add(new Parada("UTPL"));
            rutasEntrada.add(new Ruta(i + 1, paradasRuta));
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- SISTEMA DE GESTION DE BUSES UTPL ---");
            System.out.println("1. Ver rutas de entrada");
            System.out.println("2. Ver rutas de salida");
            System.out.println("3. Evento aleatorio (reduccion de parada o tiempo)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarRutas(rutasEntrada);
                    consultarTiempo(scanner, rutasEntrada, true);
                    break;
                case 2:
                    mostrarRutasSalida(rutasEntrada);
                    consultarTiempo(scanner, rutasEntrada, false);
                    break;
                case 3:
                    eventoAleatorio(rutasEntrada);
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    private static void mostrarRutas(ArrayList<Ruta> rutas) {
        for (Ruta ruta : rutas) {
            System.out.println("Ruta " + ruta.getNumeroRuta() + ":");
            for (Parada p : ruta.getParadas()) {
                System.out.println("  - " + p.getNombre());
            }
        }
    }

    private static void mostrarRutasSalida(ArrayList<Ruta> rutas) {
        for (Ruta ruta : rutas) {
            System.out.println("Ruta " + ruta.getNumeroRuta() + " (salida):");
            List<Parada> inversa = new ArrayList<>(ruta.getParadas());
            Collections.reverse(inversa);
            for (Parada p : inversa) {
                System.out.println("  - " + p.getNombre());
            }
        }
    }

    private static void consultarTiempo(Scanner scanner, ArrayList<Ruta> rutas, boolean entrada) {
        System.out.print("Seleccione numero de ruta: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < rutas.size()) {
            Ruta ruta = rutas.get(index);
            List<Parada> paradas = entrada ? ruta.getParadas() : new ArrayList<>(ruta.getParadas());
            if (!entrada) {
                Collections.reverse(paradas);
            }

            System.out.println("Paradas:");
            for (int i = 0; i < paradas.size(); i++) {
                System.out.println((i + 1) + ") " + paradas.get(i).getNombre());
            }

            System.out.print("Seleccione parada de inicio: ");
            int paradaInicio = scanner.nextInt();
            if (paradaInicio >= 1 && paradaInicio <= paradas.size()) {
                int tiempo = (paradas.size() - paradaInicio) * 5;
                System.out.println("Tiempo estimado: " + tiempo + " minutos");
                System.out.println("Recorrido:");
                for (int i = paradaInicio - 1; i < paradas.size(); i++) {
                    System.out.println("  - " + paradas.get(i).getNombre());
                }
            } else {
                System.out.println("Parada invalida");
            }
        } else {
            System.out.println("Ruta invalida");
        }
    }

    private static void eventoAleatorio(ArrayList<Ruta> rutas) {
        Random rand = new Random();
        int index = rand.nextInt(rutas.size());
        Ruta ruta = rutas.get(index);
        ArrayList<Parada> paradas = new ArrayList<>(ruta.getParadas());

        int tipoEvento = rand.nextInt(2);

        System.out.println("\nEvento aleatorio en Ruta " + ruta.getNumeroRuta() + "!");

        if (tipoEvento == 0 && paradas.size() > 2) {
            int eliminar = rand.nextInt(paradas.size() - 1); // evitar eliminar UTPL
            Parada removida = paradas.remove(eliminar);
            System.out.println("Evento: Menos trafico. Se omite la parada " + removida.getNombre());
        } else {
            System.out.println("Evento: El bus tomo un atajo. Se reducen 10 minutos del tiempo total.");
        }

        System.out.println("Ruta resultante:");
        for (Parada p : paradas) {
            System.out.println("  - " + p.getNombre());
        }

        int nuevoTiempo = (paradas.size() - 1) * 5;
        if (tipoEvento == 1) {
            nuevoTiempo = Math.max(0, nuevoTiempo - 10);
        }

        System.out.println("Nuevo tiempo estimado: " + nuevoTiempo + " minutos\n");
    }
}
