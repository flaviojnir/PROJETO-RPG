import java.util.Scanner;

public class RPG {

    private static void criacao_personagem(){ //metodo para criar o personagem do jogador
        try (Scanner input = new Scanner(System.in)) {
            String nome;
            float altura;

            System.out.println(
                    "Bem-vindo a sua nova aventura, aventureiro. Conclua sua inscricao para que possamos comecar a aventura");
            System.out.println(
                    "Escolha sua raca: \n1 - Anao\n2 - Elfo\n3 - Halfling\n4 - Humano\n5 - Draconato\n6 - Gnomo");
            int n1 = input.nextInt();

            switch(n1){ //switch para determinar raca
                case 1:
                    anao an = new anao(null, n1, null, n1);
                    break;

                case 2:
                    elfo ef = new elfo(null, n1, null);
                    break;

                default:
                    System.out.println("Ainda nao feito / invalido");
            }
            //apos determinar raca, coleta nome e altura
            input.nextLine();
            System.out.println("Qual sera seu nome?");
            nome = input.nextLine();
            System.out.println("Qual sera sua altura?");
            altura = input.nextFloat();

            System.out.printf("Seja Bem-vindo,%s. Voce mede %.2f de altura. \n",nome,altura);
            input.close();
        }
    }

    public static void main(String[] args) {
        criacao_personagem();
    }
}
