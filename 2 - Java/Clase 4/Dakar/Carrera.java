package repaso2;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;


    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos=new ArrayList<>();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) throws Exception {
        if (listaVehiculos.size()<this.cantidadVehiculosPermitidos){
            listaVehiculos.add(new Auto(velocidad, aceleracion,  anguloDeGiro,patente));
        }else {
            throw new Exception("Cupo de la carrera lleno");
        }

    }
    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) throws Exception {
        if (listaVehiculos.size()<this.cantidadVehiculosPermitidos){
            listaVehiculos.add(new Moto(velocidad, aceleracion,  anguloDeGiro,patente));
        }else {
            throw new Exception("Cupo de la carrera lleno");
        }
    }

    public void eliminarVehiculo(Vehiculo v){
        listaVehiculos.remove(listaVehiculos.indexOf(v));
    }

    public void eliminarVehiculoConPatente(String patente){
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if(listaVehiculos.get(i).getPatente() == patente){
                listaVehiculos.remove(i);
            }
        }
    }

    public Vehiculo getWinner(){
        Double result =0.0;
        Vehiculo winner = null;
        Vehiculo v;
        Double performance;
        for (int i = 0; i < listaVehiculos.size(); i++) {
             v = listaVehiculos.get(i);
            performance = v.getVelocidad()*(v.getAceleracion()/2)/(v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100));
            if(performance>result){
                result=performance;
                winner=v;
            }

        }
        return winner;
    }

    public void socorrerAuto(String patente){
        Vehiculo v = getVehiculoByPatente(patente);
        if (v instanceof Auto){
            new VehiculoSocorristaAuto().socorrer(v);
        }
        else if (v instanceof Moto){
            new VehiculoSocorristaMoto().socorrer(v);
        }

    }

    public Vehiculo getVehiculoByPatente(String patente){
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if(listaVehiculos.get(i).getPatente() == patente){
                return  listaVehiculos.get(i);
            }
        }
        return null;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(Integer cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
