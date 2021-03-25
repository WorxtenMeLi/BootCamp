public class InvitadoMeli extends Invitado{
    public InvitadoMeli(String nombre) {
        super(nombre);
    }

    @Override
    public void comer() {
        System.out.println("Estoy comiendo "+this.nombre+".\nViva La Chiqui!");
    }
}
