package estruturas;
import essencial.equipamento;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ferreiro implements estrutura_interface{
    HashMap<Integer,equipamento>itens;

    public ferreiro(int numero_itens){
        itens = new HashMap<Integer,equipamento>(numero_itens);
    }

    public void generate_item(){
        Random sd = new Random();
        int indice = sd.nextInt(3) + 1;

        try{
            File f = new File("data\\equipamentos.txt");
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
    
    @Override
    public String get_tipo(){
        return "ferreiro";
    }

    @Override 
    public void menu(int numero_it){
        for (int i = numero_it;i > 0;i--)
            generate_item();

        for (Integer x : itens.keySet())
            itens.get(x).tostring();
    
    }

    /*public static void main (String[]args){
        ferreiro f = new ferreiro(3);
        f.menu(3);

    }*/

}
