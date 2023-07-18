package lugares;

public class campo implements lugares_interface {
    private String nome;

    public campo(String nome){
        this.nome = nome;
    }

    @Override
    public String getNome(){
        return nome;
    }
}
