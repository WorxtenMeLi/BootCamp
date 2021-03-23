public class Triangulo extends FiguraGeometrica{
    private float base;
    private float altura;
    public Triangulo(float b,  float h){
        this.altura=h;
        this.base=b;
        setNombre("Triangulo");
    }
    @Override
    public double getArea() {
        return (base*altura)/2;
    }
}