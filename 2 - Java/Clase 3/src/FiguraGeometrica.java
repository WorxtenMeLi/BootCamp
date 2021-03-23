public abstract class FiguraGeometrica {
    private String nombre;
    public abstract double getArea();
    public String getNombre() {
        return nombre;
    }
    public static double areaPromedio(FiguraGeometrica[] arr){
        double promedio=0,suma=0;
        for(FiguraGeometrica fig: arr){
            suma+=fig.getArea();
        }
        promedio=suma/arr.length;
        return promedio;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return nombre;
    }
}
