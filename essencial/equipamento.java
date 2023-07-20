package essencial;

public class equipamento {
    String nome;
    String tipo;
    int stat;

    public equipamento(String nome,String tipo,int stat){
        this.nome = nome;
        this.tipo = tipo;
        this.stat = stat;
    }

    public void tostring(){
        System.out.printf("%s ",nome);
        if(tipo.equalsIgnoreCase("Armadura"))
            System.out.printf("+ %d defesa\n",stat);
        else
            System.out.printf("+ %d ataque\n",stat);
    }
}
