package estruturas;
import java.util.HashMap;

public class ferreiro {
    HashMap<String,Integer>itens;

    public ferreiro(int numero_itens){
        itens = new HashMap<String,Integer>(numero_itens);
    }

    public void add_item(String nome,int atributo){
        itens.put(nome, atributo);
    }
}
