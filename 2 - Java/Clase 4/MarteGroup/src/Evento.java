import java.util.List;
public class Evento {
    List<Invitado> invitados;
    List<FuegosArtificiales> fuegos;
    private String evento;

    public Evento(List<Invitado> invitados, List<FuegosArtificiales> fuegos, String evento) {
        this.invitados = invitados;
        this.fuegos = fuegos;
        this.evento = evento;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    private void repartirPastel(){
        for (Invitado invitado: invitados) {
            invitado.comer();
        }
    }
    private void explotarFuegos(){
        for (FuegosArtificiales fuego: fuegos) {
            fuego.explotar();
        }
    }
    public void apagarVelas(){
        explotarFuegos();
        repartirPastel();
    }
}
