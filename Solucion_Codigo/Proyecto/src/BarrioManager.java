
public class BarrioManager {

    public static String[] inicializarBarrios() {
        return new String[]{
            "Agencia Banco de Loja", "Av. 8 de Diciembre", "Av. Eloy Alfaro", "Av. Kigman",
            "Cabo Minacho", "Calasanz", "Casa de Enfermeros Terminales", "Ciudad Alegria",
            "Clinica Natali", "Colegio Beatriz Cueva de Ayora", "Coliseo Ciudad de Loja",
            "Estadio", "Hipervalle", "Hotel La Castellana", "Iglesia Verbo", "Jose A. Eguiguren",
            "La Salle", "Las Pitas", "Lauro Guerrero", "Los Cocos", "Mercadillo", "Migas",
            "Parque Infantil", "Parque Polideportivo", "Parqueadero Polideportivo", "Pradera",
            "Predesur", "Puerta de la Ciudad", "Redondel del Soldado", "Rosales",
            "Sauces Norte", "Tame", "Tebaida Baja", "Terminal Terrestre", "Tnte. Geovany Calle",
            "Urna", "Zona Militar"
        };
    }

    public static void mostrarBarrios(String[] barrios) {
        for (int i = 0; i < barrios.length; i++) {
            System.out.println((i + 1) + ") " + barrios[i]);
        }
    }
}
