import java.util.ArrayList;
import java.util.List;

public class DemoMarteGroup {
    public static void main (String [] args){
        List<Invitado> invitados = new ArrayList<Invitado>();
        List<FuegosArtificiales> fuegosArtificiales = new ArrayList<FuegosArtificiales>();
        invitados.add(new InvitadoMeli("Carlos"));
        invitados.add(new InvitadoMeli("Lucas"));
        invitados.add(new InvitadoMeli("Marcelo"));
        invitados.add(new InvitadoEstandar("Sebastian"));

        fuegosArtificiales.add(new FuegosArtificialesIndiv("Puuum"));

        List<FuegosArtificialesIndiv> pack = new ArrayList<FuegosArtificialesIndiv>();
        pack.add(new FuegosArtificialesIndiv("Cabum!"));
        pack.add(new FuegosArtificialesIndiv("Boom!"));
        pack.add(new FuegosArtificialesIndiv("ksjdfh!"));

        fuegosArtificiales.add(new FuegosArtificialesPack(pack));

        Evento evento = new Evento(invitados,fuegosArtificiales,"Dia de la memoria");
        evento.apagarVelas();
    }

}
