package clase2_java_tm.src.ej5;

import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
    }

    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    public boolean esBisiesto() {
        return new GregorianCalendar().isLeapYear(this.dia);
    }

    public static boolean esBisiesto(int anio) {
        return new GregorianCalendar().isLeapYear(anio);
    }

    public static boolean esFechaValida(int dia, int mes, int anio) {
        int[] cantDias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (mes > 12 || anio < 1)
            return false;
        if (mes == 2 && dia == 29) return esBisiesto(anio);
        return dia <= cantDias[mes - 1];
    }

    private void sumarDia() {
        int[] normal = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] bisiesto = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] arr;
        if (Fecha.esBisiesto(anio))
            arr = bisiesto;
        else
            arr = normal;
        if (dia == arr[mes - 1]) {
            dia = 1;
            mes = (mes % 12) + 1;
            if (mes==12) anio++;
        } else dia++;
    }
}