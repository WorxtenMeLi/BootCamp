package repaso2;

public abstract class VehiculoSocorrista extends Vehiculo{


    protected VehiculoSocorrista() {
        super(100.00,2.00,  0.0, "socorrista", 0.0, 4);
    }



    public abstract void socorrer(Vehiculo v);
}
