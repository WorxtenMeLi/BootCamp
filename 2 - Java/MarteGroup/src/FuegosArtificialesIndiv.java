public class FuegosArtificialesIndiv extends FuegosArtificiales{
    public FuegosArtificialesIndiv(String sonido){
        this.sonido=sonido;
    }

    @Override
    public void explotar() {
        System.out.println(sonido);
    }
}
