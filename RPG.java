import java.util.Scanner;

public class RPG {

    private static void criacao_personagem(){ //metodo para criar o personagem do jogador
        try (Scanner input = new Scanner(System.in)) {
            String nome;
            float altura;
            int idade;

            System.out.println(
                    "Bem-vindo a sua nova aventura, aventureiro. Conclua sua inscricao para que possamos comecar a aventura");
            System.out.println(
                    "Escolha sua raca: \n1 - Anao\n2 - Elfo\n3 - Halfling\n4 - Humano\n5 - Draconato\n6 - Gnomo");
            int escolha_raca = input.nextInt();

            //apos determinar raca, coleta nome e altura
            input.nextLine();
            System.out.println("Qual sera seu nome?");
            nome = input.nextLine();
            System.out.println("Qual sera sua altura?");
            altura = input.nextFloat();
            System.out.println("E a sua idade?");
            idade = input.nextInt();

            //cria personagem
            jogador player = new jogador(nome,idade,altura,escolha_raca);

            System.out.printf("Seja Bem-vindo,%s. Voce mede %.2f de altura. \nTem %d anos.\n",nome,altura,idade);
            input.close();
        }
    }

    public static void main(String[] args) {
        criacao_personagem();
    }
}
