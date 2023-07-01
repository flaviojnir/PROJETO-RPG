package essencial;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import estruturas.*;
import lugares.*;

public class RPG {
    static Scanner input = new Scanner(System.in);
    
    private static void criacao_personagem(){ //metodo para criar o personagem do jogador
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
        
    }

    private static int selecionar_cenario(){ //selecionar cidade/caverna/campo aberto
            //x.nextLine();
            System.out.println("Para onde voce quer ir?");
            System.out.println("1 - Cidade\n2 - Floresta\n3 - Caverna");
            //x.nextLine();
            int selecao = input.nextInt();
            return selecao;
        }

    public static void main(String[] args) {
        int game_status = 0;
        /*
         * Game status:
         * 0 - criacao de personagem
         * 1 - selecao de cenario
         * 2 - em cidade / campo aberto / caverna
         * 3 - em luta
         * 4 - sair do jogo (salva progresso)
         */
        
        while(game_status != 4){
            switch(game_status){
            case 0:
                criacao_personagem();
                
                ArrayList<Object> mapa = new ArrayList<>();
                cidade viamao = new cidade();
                mapa.add(viamao);
                caverna cv1 = new caverna();
                mapa.add(cv1);
                campo camp1 = new campo();
                mapa.add(camp1);
                game_status = 1;
                break;

            case 1:
                selecionar_cenario();
                game_status = 4;
                break;
            }
        }
    
    
    }
}