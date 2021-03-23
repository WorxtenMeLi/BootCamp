public class Circulo extends FiguraGeometrica{
    private float radio;
    public Circulo(float radio){
        this.radio=radio;
        setNombre("Circulo");
    }
    @Override
    public double getArea() {
        return Math.PI*Math.pow(radio,2);
    }
}
