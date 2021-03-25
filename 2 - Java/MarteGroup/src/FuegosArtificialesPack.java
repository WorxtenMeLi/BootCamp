import java.util.List;
public class FuegosArtificialesPack extends FuegosArtificiales{
    public List<FuegosArtificialesIndiv> getPack() {
        return pack;
    }

    public void setPack(List<FuegosArtificialesIndiv> pack) {
        this.pack = pack;
    }

    private List<FuegosArtificialesIndiv> pack;
    public FuegosArtificialesPack(List<FuegosArtificialesIndiv> pack){
        this.pack=pack;
    }
    @Override
    public void explotar() {
        for (FuegosArtificialesIndiv fuego: pack){
            fuego.explotar();
        }
    }
}
