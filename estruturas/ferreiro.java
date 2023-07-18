package estruturas;
import java.util.HashMap;

public class ferreiro implements estrutura_interface{
    HashMap<String,Integer>itens;

    public ferreiro(int numero_itens){
        itens = new HashMap<String,Integer>(numero_itens);
    }

    public void add_item(String nome,int atributo){
        itens.put(nome, atributo);
    }
    
    @Override
    public String get_tipo(){
        return "ferreiro";
    }

    @Override 
    public void menu(){

    }


}
