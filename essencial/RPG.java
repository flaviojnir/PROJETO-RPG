package essencial;

import estruturas.*;
import lugares.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class RPG {

    public enum game_status{
        CRIACAO,SELECAO_CENARIO,LUTA,SAVE,SAIR
    }

    static Scanner input = new Scanner(System.in);
    static ArrayList<lugares_interface> mapa;
    static jogador player;
    static ArrayList<jogador> companions;

    private static void criacao_personagem() { // metodo para criar o personagem do jogador
        String nome;
        float altura;
        int idade;
        companions = new ArrayList<jogador>();

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
        player = new jogador(nome, idade, altura, escolha_raca);

        System.out.printf("Seja Bem-vindo a cidade de Portus Alegris,%s. Voce mede %.2f de altura. \nTem %d anos ",
                nome, altura, idade);
        System.out.println("E sua sua raça eh " + player.getRaca());
        System.out.printf(
                "Ola, %s. Me chame de Mestre. Voce foi chamado até aqui pois estamos tendo problemas com pragas... Bom, esta é a forma qual chamamos os saqueadores que andam tomando conta da região. \nVoce terá uma equipe, conhecerá ela depois. Vá conhecer o local e depois tome suas decisões.\n",
                nome);
        System.out.println("--------------------------");

    }

    private static ArrayList<jogador> gen_npcs(int num){
        ArrayList<jogador>npcs = new ArrayList<jogador>();
        try{
        File f = new File("data\\NPC.txt");
        Random sd = new Random();
        for(int i = 0;i < num;i++){
            Scanner sc = new Scanner(f);
            int random = sd.nextInt(5)+1;
            for(int j = 0;j < random;j++){
                sc.nextLine();
            }
            String[] linha = sc.nextLine().split(";");
            jogador n = new jogador(linha[0], 20, 1.70f, 4);
            npcs.add(n);
            sc.close();
        }
        } catch(FileNotFoundException e){System.out.println("Erro com arquivo txt");}
        return npcs;
    }

    private static void save_game(){
        try{
        File f = new File("data\\save.txt");
        PrintWriter pw = new PrintWriter(f,"UTF-8");
        pw.write(player.ToString().toString()); 
        pw.close();
        } catch(FileNotFoundException | UnsupportedEncodingException u){System.out.println("Erro com arquivo txt");}
    }

    private static int selecionar_cenario() { // selecionar cidade/caverna/campo aberto
        System.out.println(
                "Para onde voce quer ir? Cidades podem ser lugares mais tranquilos e com opcoes seguras de compras e vendas. Florestas sao lugares imprevisiveis onde voce pode ser consumido pela noite.");
        System.out.println("1 - Cidade\n2 - Floresta\n3 - Sair do jogo");
        int selecao = input.nextInt();
        System.out.println("--------------------------");
        return selecao;
    }

    private static void em_cidade(String nome_cidade,ArrayList<lugares_interface>map){
        //busca cidade no mapa baseado em seu nome
        lugares_interface cidade = map.stream().filter(a -> ((lugares_interface) a).getNome().equals(nome_cidade)).findAny().orElse(null);

        System.out.println("Bem vindo a " + ((lugares_interface)cidade).getNome());

        System.out.println("Onde deseja ir?");
        System.out.println("1 - Ferreiro, 2 - Hotel, 3 - Taverna");

        int escolha = input.nextInt();

        if(escolha == 1){
            ferreiro fer = ((cidade)cidade).get_Ferreiro();
            fer.generate_all_items(3);
                while(true){
                    System.out.println("Os seguintes itens estao disponiveis: ");
                    System.out.println("--------------------");
                    fer.menu();
                    System.out.println("--------------------");

                    System.out.println("Digite o indice do equipamento que deseja comprar,0 p/ sair");
                    int indice = input.nextInt();
                    if(indice == 0) break;
                    equipamento e = fer.get_Equipamento(indice);
                    player.add_equip(e);
                    fer.remove_Equipamento(indice);
                    System.out.println("O seguinte item foi adicionado com sucesso!");
                    e.tostring();
                    System.out.println("Continuar comprando? S/N");
                    input.nextLine();
                    String c = input.nextLine();
                    if(c.equalsIgnoreCase("s"))   continue;
                        else break;
            }
        }
        //--implementar save--
        else if(escolha == 3){
            if(companions.size() == 0){
                System.out.println("Voce encontrou aventureiros que querem se juntar a vc.");
                companions = gen_npcs(3);
                for(jogador j : companions){
                    System.out.println(j.ToString().toString());
                }
            }
        }
    }

    public static void main(String[] args) {
            game_status status = game_status.CRIACAO;
        
            /*
             * Game status:
             * 0 - criacao de personagem
             * 1 - selecao de cenario
             * 2 - em luta
             * 3 - sair do jogo (salva progresso)
             */

            while (status != game_status.SAIR) {
                switch (status) {
                    case CRIACAO:
                        criacao_personagem();

                        mapa = new ArrayList<lugares_interface>();

                        // florestas
                        floresta recanto_gauderio = new floresta("recanto_gauderio");
                        mapa.add(recanto_gauderio);

                        floresta estacionamento_rainha = new floresta("estacionamento_rainha");
                        mapa.add(estacionamento_rainha);

                        floresta recanto_do_palhaco = new floresta("recanto_do_palhaco");
                        mapa.add(recanto_do_palhaco);

                        // cidades
                        cidade viamao = new cidade("viamao");
                        mapa.add(viamao);

                        cidade novos_hamburgos = new cidade("novos_hamburgo");
                        mapa.add(novos_hamburgos);

                        cidade cachoeirinhas = new cidade("cachoeirinhas");
                        mapa.add(cachoeirinhas);

                        // cavernas
                        caverna gruta_do_jairo = new caverna("gruta_do_jairo");
                        mapa.add(gruta_do_jairo);

                        caverna retiro_do_gera = new caverna("retiro_do_gera");
                        mapa.add(retiro_do_gera);

                        caverna covil_da_rejane = new caverna("covil_da_rejane");
                        mapa.add(covil_da_rejane);

                        // campos
                        campo casa_das_irmas = new campo("casa_das_irmas");
                        mapa.add(casa_das_irmas);

                        campo purgatorio = new campo("purgatorio");
                        mapa.add(purgatorio);

                        campo dachau = new campo("dachau");
                        mapa.add(dachau);

                        status = game_status.SELECAO_CENARIO;
                        break;

                    case SELECAO_CENARIO:
                        switch (selecionar_cenario()) {
                            case 1:
                                // em cidade
                                boolean nome_valido = false;
                                String escolha = "";
                                System.out.println(
                                        "Espere, jovem. Voce pode ir a apenas tres lugares neste momento, viamao, novos hamburgos ou cachoeirinhas. A escolha e sua. Eu recomendaria manter distancia de viamao.");
                                while(!nome_valido){
                                    input.nextLine();
                                    escolha = input.nextLine();
                                    if (escolha.equalsIgnoreCase("viamao")) {
                                        System.out.println("Voce tem coragem, nao muita inteligencia. Boa sorte.");
                                        nome_valido = true;
                                    }
                                    else if (escolha.equalsIgnoreCase("novos hamurgos")) {
                                        System.out.println("Siga sua trilha com cuidado, ha pessoas maldosas em todas regioes.");
                                        nome_valido = true;
                                    }
                                    else if (escolha.equalsIgnoreCase("cachoeirinha")) {
                                        System.out.println("Perfeito. Va com cuidado em Lembre-se. Confie em Ninguem.");
                                        nome_valido = true;
                                    }
                                    else{
                                        System.out.println("Nome invalido,tente novamente");
                                    }
                            }
                             em_cidade(escolha,mapa);
                             break;
                             
                            case 2:
                                // em_floresta();
                                break;

                            case 3:
                                status = game_status.SAVE;
                                break;

                            default:
                                System.out.println("Selecao invalida");
                                break;
                        }
                        status = game_status.SAVE;
                        break;

                    case LUTA:


                    case SAVE:
                        save_game();
                        status = game_status.SAIR;
                        break;

                }
            

        }
    }
}