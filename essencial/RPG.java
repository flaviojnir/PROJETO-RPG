package essencial;
import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Random;
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
            System.out.println("--------------------------");
        
    }

    private static int selecionar_cenario(){ //selecionar cidade/caverna/campo aberto
            System.out.println("Para onde voce quer ir?");
            System.out.println("1 - Cidade\n2 - Floresta\n3 - Caverna");
            int selecao = input.nextInt();
            System.out.println("--------------------------");
            return selecao;
        }

    private static void em_cidade(cidade c,jogador[]personagens){
            System.out.printf("Bem vindo a %s! Aqui voce pode visitar os seguintes estabelecimentos:\n",c.get_nome());
            System.out.println("1 - Ferreiro (comprar equipamentos)\n2 - Hotel (recuperar vida)\n3 - Taverna (quests)");
            int escolha = input.nextInt();
            switch(escolha){
                case 1:
                    //menu de itens do ferreiro
                    break;
                case 2:
                    //restora a vida de todos personagens
                    for(jogador j : personagens){
                        j.restore_HP();
                    }
                    System.out.println("A vida de seu grupo foi restorada!");
                    break;
                case 3:
                    //lista de quests
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
    }

    public static void main(String[] args) {
        int game_status = 0;
        /*
         * Game status:
         * 0 - criacao de personagem
         * 1 - selecao de cenario
         * 2 - em luta
         * 3 - sair do jogo (salva progresso)
         */
        
        while(game_status != 3){
            switch(game_status){
            case 0:
                criacao_personagem();
                
                ArrayList<Object> mapa = new ArrayList<>();
                cidade viamao = new cidade("Viamao");
                mapa.add(viamao);
                caverna cv1 = new caverna();
                mapa.add(cv1);
                campo camp1 = new campo();
                mapa.add(camp1);
                game_status = 1;
                break;

            case 1:
                switch(selecionar_cenario()){
                    case 1:
                        //em_cidade();
                        break;
                    case 2:
                        //em_floresta();
                        break;
                    case 3:
                        //em_caverna();
                        break;
                    default:
                        System.out.println("Selecao invalida");
                        break;
                }
                game_status = 3;
                break;

            case 2:
                
            }
        }
    
    
    }
}