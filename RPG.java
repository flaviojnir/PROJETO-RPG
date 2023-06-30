import java.util.Scanner;

public class RPG {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            String anao;
            String altanao;
            String elfo;
            String elfoaltura;

            System.out.println(
                    "Bem-vindo a sua nova aventura, aventureiro. Conclua sua inscricao para que possamos comecar a aventura");
            System.out.println(
                    "Escolha sua raca: \n1 - Anao\n2 - Elfo\n3 - Halfling\n4 - Humano\n5 - Draconato\n6 - Gnomo");
            int n1 = input.nextInt();
            if (n1 == 1) {
                anao an = new anao(null, n1, null, n1);
                anao = an.getNome();
                altanao = an.getAltura();

                System.out.println("Qual sera seu nome?");
                anao = input.nextLine();

                System.out.println("Qual sera sua altura?");
                altanao = input.nextLine();

                System.out.println("Seja Bem-vindo, " + anao + " voce mede " + altanao + " seus bonus de anao sao: ");

            }

            if (n1 == 2) {
                elfo ef = new elfo(null, n1, null);
                elfo = ef.getNome();
                elfoaltura = ef.getAltura();

                System.out.println("Qual sera seu nome?");
                elfo = input.nextLine();

                System.out.println("Qual sera sua altura?");
                elfoaltura = input.nextLine();

                System.out
                        .println("Seja Bem-vindo, " + elfo + " voce mede " + elfoaltura + " seus bonus de anao sao: ");
            }

        }
    }
}
