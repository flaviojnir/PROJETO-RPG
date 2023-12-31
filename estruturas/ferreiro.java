package estruturas;
import essencial.equipamento;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ferreiro implements estrutura_interface{
    HashMap<Integer,equipamento>itens;
    File f;
    Random sd;

    public ferreiro(int numero_itens){
        itens = new HashMap<Integer,equipamento>(numero_itens);
        f = new File("data\\equipamentos.txt");
        sd = new Random();
    }

    public void generate_item(){
        int indice = sd.nextInt(5) + 1;

        try{
            Scanner scan = new Scanner(f);
            int aux = indice;
            
            while(aux-- != 0)
                scan.nextLine();
            
            String[] linha = scan.nextLine().split(";");
            equipamento x = new equipamento(linha[1], linha[2], Integer.parseInt(linha[3]));
            itens.put(indice, x);
            scan.close();


        } catch(FileNotFoundException e){
            System.out.println("erro com arquivo txt");
        }
    }

    public void generate_all_items(int numero_it){
        for (int i = numero_it;i > 0;i--)
            generate_item();
    }
    
    @Override
    public String get_tipo(){
        return "ferreiro";
    }

    @Override 
    public void menu(){
        for (Integer x : itens.keySet()){
            System.out.printf("[%d]",x);
            itens.get(x).tostring();
        }
    
    }

    public equipamento get_Equipamento(int index){
        return itens.get(index);
    }

    public void remove_Equipamento(int index){
        itens.remove(index);
    }

    /*public static void main (String[]args){
        ferreiro f = new ferreiro(3);
        f.menu(3);

    }*/

}
