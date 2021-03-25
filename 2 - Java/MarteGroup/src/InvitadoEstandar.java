public class InvitadoEstandar extends Invitado{
    public InvitadoEstandar(String nombre) {
        super(nombre);
    }

    @Override
    public void comer() {
        System.out.println("Estoy comiendo");

    }
}
