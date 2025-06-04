
public class Ruta {

    String parada1;
    String parada2;
    String parada3;
    String parada4;
    String parada5;
    String UTPL;

    public Ruta(String parada1, String parada2, String parada3, String parada4, String parada5) {
        this.parada1 = parada1;
        this.parada2 = parada2;
        this.parada3 = parada3;
        this.parada4 = parada4;
        this.parada5 = parada5;
        this.UTPL = "UTPL";
    }

    public String[] getRuta() {
        return new String[]{parada1, parada2, parada3, parada4, parada5, UTPL};       
    }    
}
