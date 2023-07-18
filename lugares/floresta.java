package lugares;

public class floresta implements lugares_interface {

    private String nome;

    public floresta(String nome){
        this.nome = nome;
    }

    @Override
    public String getNome(){
        return nome;
    }
}
