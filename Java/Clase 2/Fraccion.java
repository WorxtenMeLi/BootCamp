package ej4;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public static Fraccion sumar(Fraccion f1, Fraccion f2) {
        Fraccion resultado = new Fraccion((f1.getNumerador() * f2.getDenominador())
                + (f2.getNumerador() * f1.getDenominador()), f1.getDenominador() * f2.getDenominador());
        return resultado;
    }

    public static Fraccion sumar(int numero, Fraccion f2) {
        Fraccion f1 = new Fraccion(numero, 1);
        return sumar(f1,f2);
    }

    public static Fraccion restar (Fraccion f1, Fraccion f2) {
        Fraccion resultado = new Fraccion((f1.getNumerador() * f2.getDenominador())
                - (f2.getNumerador() * f1.getDenominador()), f1.getDenominador() * f2.getDenominador());
        return resultado;
    }

    public static Fraccion multiplicar (Fraccion f1, Fraccion f2) {
        int numerador = f1.getNumerador() * f2.getNumerador();
        int denominador = f1.getDenominador() * f2.getDenominador();

        return new Fraccion(numerador, denominador);
    }

    public static Fraccion dividir (Fraccion f1, Fraccion f2) {
        int numerador = f1.getNumerador() * f2.getDenominador();
        int denominador = f1.getDenominador() * f2.getNumerador();

        return new Fraccion(numerador, denominador);
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

}
