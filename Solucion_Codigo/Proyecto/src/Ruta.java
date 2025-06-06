
import java.util.ArrayList;

public class Ruta {

    private int numeroRuta;
    private ArrayList<Parada> paradas;

    public Ruta(int numeroRuta, ArrayList<Parada> paradas) {
        this.numeroRuta = numeroRuta;
        this.paradas = paradas;
    }

    public int getNumeroRuta() {
        return numeroRuta;
    }

    public ArrayList<Parada> getParadas() {
        return paradas;
    }
}
