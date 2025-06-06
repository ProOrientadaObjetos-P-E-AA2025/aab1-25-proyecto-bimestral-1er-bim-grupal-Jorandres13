
public class Personas {
    String nombre;
    int edad;

    public Personas(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void mostrarDatos(){
        System.out.println("Nombre: " + nombre + " Edad: " + edad);
    }
    public void cambiarDatos(String nuevoNombre, int nuevaEdad){
        nombre = nuevoNombre;
        edad = nuevaEdad;
    }
    
    
    
}
