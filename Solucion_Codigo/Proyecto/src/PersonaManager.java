
public class PersonaManager {

    public static int[][] inicializarPersonas() {
        int[][] personas = new int[37][10];

        for (int i = 0; i < 37; i++) {
            for (int j = 0; j < 10; j++) {
                personas[i][j] = (int) (Math.random() * 50);
            }
        }
        return personas;
    }
}
