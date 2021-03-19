package ej1;

import java.util.Random;

public class CuentaCorriente {

    private int numeroDeCuenta;
    private double saldo;

    public CuentaCorriente() {
        this.numeroDeCuenta = new Random(10).nextInt();
        this.saldo = 0;
    }

    public CuentaCorriente(int numeroDeCuenta, double saldo) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente) {
        new CuentaCorriente(cuentaCorriente.getNumeroDeCuenta(), cuentaCorriente.getSaldo());
    }


    public void ingreso(double cantindad) {
        this.saldo += cantindad;
    }

    public void egreso(double cantindad) {
        this.saldo -= cantindad;
    }

    public void transferencia(double cantindad, CuentaCorriente cuenta) {
        this.egreso(cantindad);
        cuenta.setSaldo(cuenta.getSaldo() + cantindad);
        System.out.println("Transferencia de $" + cantindad +
                " realizada a la cuenta " + cuenta.getNumeroDeCuenta());
    }

    public void reintegro(int cantindad) {
        this.ingreso(cantindad);
    }


    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta corriente nro: " + numeroDeCuenta +
                " - Saldo disponible en cuenta: $" + saldo;
    }
}