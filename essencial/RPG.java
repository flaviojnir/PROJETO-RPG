package essencial;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import lugares.*;

public class RPG {
    static Scanner input = new Scanner(System.in);

    private static void criacao_personagem() { // metodo para criar o personagem do jogador
        String nome;
        float altura;
        int idade;

        System.out.println(
                "Bem-vindo a sua nova aventura, aventureiro. Conclua sua inscricao para que possamos comecar a aventura");
        System.out.println(
                "Escolha sua raca: \n1 - Anao\n2 - Elfo\n3 - Halfling\n4 - Humano\n5 - Draconato\n6 - Gnomo");
        int escolha_raca = input.nextInt();

        // apos determinar raca, coleta nome e altura
        input.nextLine();
        System.out.println("Qual sera seu nome?");
        nome = input.nextLine();
        System.out.println("Qual sera sua altura?");
        altura = input.nextFloat();
        System.out.println("E a sua idade?");
        idade = input.nextInt();

        // cria personagem
        jogador player = new jogador(nome, idade, altura, escolha_raca);

        System.out.printf("Seja Bem-vindo a cidade de Portus Alegris,%s. Voce mede %.2f de altura. \nTem %d anos ",
                nome, altura, idade);
        System.out.println("E sua sua raça eh " + player.getRaca());
        System.out.printf(
                "Ola, %s. Me chame de Mestre. Voce foi chamado até aqui pois estamos tendo problemas com pragas... Bom, esta é a forma qual chamamos os saqueadores que andam tomando conta da região. \nVoce terá uma equipe, conhecerá ela depois. Vá conhecer o local e depois tome suas decisões.\n",
                nome);
        System.out.println("--------------------------");

    }

    private static int selecionar_cenario() { // selecionar cidade/caverna/campo aberto
        System.out.println(
                "Para onde voce quer ir? Cidades podem ser lugares mais tranquilos e com opcoes seguras de compras e vendas. Florestas sao lugares imprevisiveis onde voce pode ser consumido pela noite.");
        System.out.println("1 - Cidade\n2 - Floresta");
        int selecao = input.nextInt();
        System.out.println("--------------------------");
        return selecao;
    }

    public static void main(String[] args) {
        dado seis = new dado(6);
        int game_status = 0;
        try (Scanner input = new Scanner(System.in)) {
            /*
             * Game status:
             * 0 - criacao de personagem
             * 1 - selecao de cenario
             * 2 - em luta
             * 3 - sair do jogo (salva progresso)
             */

            while (game_status != 3) {
                switch (game_status) {
                    case 0:
                        criacao_personagem();

                        ArrayList<Object> mapa = new ArrayList<>();

                        // florestas
                        floresta recanto_gauderio = new floresta();
                        mapa.add(recanto_gauderio);

                        floresta estacionamento_rainha = new floresta();
                        mapa.add(estacionamento_rainha);

                        floresta recanto_do_autista = new floresta();
                        mapa.add(recanto_do_autista);

                        // cidades
                        cidade viamao = new cidade();
                        mapa.add(viamao);

                        cidade novos_hamburgos = new cidade();
                        mapa.add(novos_hamburgos);

                        cidade cachoeirinhas = new cidade();
                        mapa.add(cachoeirinhas);

                        // cavernas
                        caverna gruta_do_jairo = new caverna();
                        mapa.add(gruta_do_jairo);

                        caverna retiro_do_gera = new caverna();
                        mapa.add(retiro_do_gera);

                        caverna covil_da_rejane = new caverna();
                        mapa.add(covil_da_rejane);

                        // campos
                        campo casa_das_irmas = new campo();
                        mapa.add(casa_das_irmas);

                        campo purgatorio = new campo();
                        mapa.add(purgatorio);

                        campo dachau = new campo();
                        mapa.add(dachau);

                        game_status = 1;
                        break;

                    case 1:
                        switch (selecionar_cenario()) {
                            case 1:
                                // em_cidade();
                                System.out.println(
                                        "Espere, jovem. Voce pode ir a apenas tres lugares neste momento, viamao, novos hamburgos ou cachoeirinhas. A escolha e sua. Eu recomendaria manter distancia de viamao.");
                                String escolha = input.nextLine();
                                if (escolha.equals("viamao")) {
                                    System.out.println("Voce tem coragem, nao muita inteligencia. Boa sorte.");
                                }
                                if (escolha.equals("novos hamurgos")) {
                                    System.out
                                            .println(
                                                    "Siga sua trilha com cuidado, ha pessoas maldosas em todas regioes.");
                                }
                                if (escolha.equals("cachoeirinha")) {
                                    System.out.println("Perfeito. Va com cuidado em Lembre-se. Confie em Ninguem.");
                                }

                                break;
                            case 2:
                                // em_floresta();
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
}