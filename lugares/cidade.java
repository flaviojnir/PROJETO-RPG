package lugares;
import estruturas.*;

public class cidade implements lugares_interface {
    private String nome;
    private estrutura_interface[] estabelecimentos;
    ferreiro f;
    hotel h;
    taverna t;

    public cidade(String nome){
        this.nome = nome;
        estabelecimentos = new estrutura_interface[2];
        
    }

    @Override
    public String getNome(){
        return nome;
    }
}
