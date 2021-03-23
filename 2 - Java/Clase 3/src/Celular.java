public class Celular implements Precedable<Celular>{
    private String titular;
    private int numero;

    public Celular(String t, int n){
        titular=t;
        numero=n;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public static void imprimirCelulares(Celular[] celulares){
        for(Celular celular: celulares){
            System.out.println("Titular: "+celular.getTitular()+", Numero: "+celular.getNumero());
        }
    }

    @Override
    public int precedeA(Celular o) {
        return this.getNumero() - o.getNumero();
    }
}
