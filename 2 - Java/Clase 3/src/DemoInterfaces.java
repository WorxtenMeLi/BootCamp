public class DemoInterfaces {
    public static void main(String[] args){
        Persona[] personas = new Persona[3];
        personas[0] = new Persona("Juan",123);
        personas[1] = new Persona("Carlos",567);
        personas[2] = new Persona("Pedro",12);
        System.out.println("Antes");
        Persona.imprimirPersonas(personas);
        SortUtil.ordenar(personas);
        System.out.println("Despues");
        Persona.imprimirPersonas(personas);
        System.out.println("______Celular_____");
        Celular[] celulares = new Celular[3];
        celulares[0] = new Celular("Sebas",320304104);
        celulares[1] = new Celular("Vivi",311461230);
        celulares[2] = new Celular("Dani",320318198);
        System.out.println("Antes");
        Celular.imprimirCelulares(celulares);
        SortUtil.ordenar(celulares);
        System.out.println("Despues");
        Celular.imprimirCelulares(celulares);
    }
}
