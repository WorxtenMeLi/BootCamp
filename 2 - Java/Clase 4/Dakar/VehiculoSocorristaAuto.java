package repaso2;

public class VehiculoSocorristaAuto extends VehiculoSocorrista{

    protected VehiculoSocorristaAuto() {
        super();
    }

    @Override
    public void socorrer(Vehiculo unAuto){
        if(unAuto instanceof Auto){
        System.out.println("Socorriendo auto: "+unAuto.getPatente());

        }else {
            System.out.println("no se puede socorrer");
        }

    }

}
