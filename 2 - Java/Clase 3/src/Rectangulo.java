public class Rectangulo extends FiguraGeometrica{
    private float base;
    private float altura;
    public Rectangulo(float b,  float h){
        this.altura=h;
        this.base=b;
        setNombre("Rectangulo");
    }
    @Override
    public double getArea() {
        return base*altura;
    }
}
