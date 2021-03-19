package ej2;

public class Contador {

    private int valor;

    public Contador(int valor) {
        this.valor = valor;
    }

    public Contador(Contador contador) {
        this.valor = contador.getValor();
    }

    public Contador() {}

    public void incremetar(int valor) {
        this.valor += valor;
    }

    public void decremetar(int valor) {
        this.valor -= valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
