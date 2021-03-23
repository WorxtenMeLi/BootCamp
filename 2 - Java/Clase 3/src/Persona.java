public class Persona implements Precedable<Persona>{
    private String nombre;
    private int dni;

    public Persona(String n, int d){
        nombre=n;
        dni=d;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public static void imprimirPersonas(Persona[] personas){
        for(Persona persona: personas){
            System.out.println("DNI: "+persona.getDni()+", Nombre: "+persona.getNombre());
        }
    }

    @Override
    public int precedeA(Persona o) {
        return this.getDni() - o.getDni();
    }
}