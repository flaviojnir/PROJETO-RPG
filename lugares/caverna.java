package lugares;

public class caverna implements lugares_interface {
    private String nome;

    public caverna(String nome){
        this.nome = nome;
    }

    @Override
    public String getNome(){
        return nome;
    }
}
