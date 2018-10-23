package warcraft;

import warcraft.objetos.Objeto;
import warcraft.objetos.construcoes.*;
import warcraft.objetos.unidades.*;
import warcraft.racas.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal com os métodos para interação com o usuário
 * @author Richard
 * @version 2.0
 */

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static Raca racaP1;
    private static Raca racaP2;
    private static int pontosDeAcaoP1;
    private static int pontosDeAcaoP2;

    /**
     * Método Principal
     * @param args {String[]}
     */

    public static void main(String[] args) {
	//ADICIONANDO UM COMENTÁRIO PARA TESTAR UM PULL REQUEST
        String nomeP1;
        String nomeP2;
        boolean continuaJogo = true;

        Scanner scan = new Scanner(System.in);

        System.out.println("Bem vindo ao Warcraft III");

        System.out.print("Jogador 1, Qual é o seu nome? ");
        nomeP1 = scan.nextLine();

        System.out.print("Jogador 2, Qual é o seu nome? ");
        nomeP2 = scan.nextLine();

        System.out.print(nomeP1 + " com qual raça você irá jogar? [1] Humanos [2] Orcs: ");
        String opcaoP1 = selecionarOpcao("[12]");
        System.out.print("Em qual coordenada do mapa deseja iniciar? Ex: 10 10. Coordenada: ");
        String posicaoP1 = selecionarPosicao(scan.nextLine());
        racaP1 = criarRaca(opcaoP1, posicaoP1);

        System.out.print(nomeP2 + " com qual raça você irá jogar? [1] Humanos [2] Orcs: ");
        String opcaoP2 = selecionarOpcao("[12]");
        System.out.print("Em qual coordenada do mapa deseja iniciar? Ex: 20 20. Coordenada: ");
        String posicaoP2 = selecionarPosicao(scan.nextLine());
        racaP2 = criarRaca(opcaoP2, posicaoP2);

        System.out.println("Vocês iniciarão com 1 Centro de Cidade, 2 Camponeses, 500 de comida, 500 de madeira, 500 de ouro e 50 de mana.");
        System.out.println("Vence quem destruir todas as tropas e construções inimigas. Comecem!!!");

        while(continuaJogo){
            pontosDeAcaoP1 = 5;
            while(pontosDeAcaoP1 > 0){
                System.out.println();
                racaP1.verRecursos();
                System.out.printf("%s Você possui %d pontos de ação restantes. O que deseja fazer? [1] Acessar construções [2] Acessar unidades: ", nomeP1, pontosDeAcaoP1);
                switch (selecionarOpcao("[12]")){
                    case "1": escolhaConstrucoes(racaP1); break;
                    case "2": escolhaUnidades(racaP1); break;
                }
            }
            pontosDeAcaoP2 = 5;
            while(pontosDeAcaoP2 > 0){
                System.out.println();
                racaP2.verRecursos();
                System.out.printf("%s Você possui %d pontos de ação restantes. O que deseja fazer? [1] Acessar construções [2] Acessar unidades: ", nomeP2, pontosDeAcaoP2);
                switch (selecionarOpcao("[12]")){
                    case "1": escolhaConstrucoes(racaP2); break;
                    case "2": escolhaUnidades(racaP2); break;
                }
            }
        }
    }

    /**
     * Gerencia a escolha de opções limitadas
     * @param opcoes {String}
     * @return String
     */

    private static String selecionarOpcao(String opcoes){
        String escolha;
        escolha = scan.next();
        while(!escolha.matches(opcoes)){
            System.out.print("Por favor escolha corretamente: ");
            escolha = scan.next();
        }
        return escolha;
    }

    /**
     * Verifica a entrada de coordenadas
     * @param posicao {String}
     * @return String
     */

    private static String selecionarPosicao(String posicao){
        while(!posicao.matches("[0-9]+\\s[0-9]+")){
            System.out.print("Posição inválida, tente novamente: ");
            posicao = scan.nextLine();
        }
        return posicao;
    }

    /**
     * Cria um objeto da raça escolhida
     * @param num {String}
     * @param posicao {String}
     * @return Raca
     */

    private static Raca criarRaca(String num, String posicao){
        switch (num){
            case "1": return new Humano(500,500,500,50, posicao);
            case "2": return new Orc(500,500,500,50, posicao);
        }
        return null;
    }

    /**
     * Gerencia as opções referentes às construções
     * @param raca {Raca}
     */

    private static void escolhaConstrucoes(Raca raca){
        System.out.println("Selecione uma opção");
        System.out.print("[1] Centro da cidade [2] Quartel [3] Templo [4] Torre [5] Sair: ");
        switch (selecionarOpcao("[12345]")){
            case "1": opcoesCentro(raca); break;
            case "2": opcoesQuartel(raca); break;
            case "3": opcoesTemplo(raca); break;
            case "4": opcoesTorre(raca); break;
        }
    }

    /**
     * Gerencia as opções referentes às unidades
     * @param raca {Raca}
     */

    private static void escolhaUnidades(Raca raca){
        if(raca instanceof Humano){
            System.out.println("Selecione uma opção");
            System.out.print("[1] Campones [2] Guerreiro [3] Cavaleiro [4] Arqueiro [5] Sacerdote [6] Grifo [7] Sair: ");
            switch (selecionarOpcao("[1234567]")){
                case "1": opcoesCampones(raca); break;
                case "2": opcoesGuerreiro(raca); break;
                case "3": opcoesCavaleiro(raca); break;
                case "4": opcoesArqueiro(raca); break;
                case "5": opcoesSacerdote(raca); break;
                case "6": opcoesGrifo(raca); break;
            }
        }else{
            System.out.println("Selecione uma opção");
            System.out.print("[1] Campones [2] Guerreiro [3] Cavaleiro [4] Arqueiro [5] Sacerdote [6] Andarilho Espiritual [7] Sair: ");
            switch (selecionarOpcao("[1234567]")){
                case "1": opcoesCampones(raca); break;
                case "2": opcoesGuerreiro(raca); break;
                case "3": opcoesCavaleiro(raca); break;
                case "4": opcoesArqueiro(raca); break;
                case "5": opcoesSacerdote(raca); break;
                case "6": opcoesAndarilho(raca); break;
            }
        }

    }

    private static String selecionarDirecao(){
        System.out.print("Para qual direção? [1] Norte [2] Sul [3] Leste [4] Oeste: ");
        switch (selecionarOpcao("[1234]")){
            case "1": return "Norte";
            case "2": return "Sul";
            case "3": return "Leste";
            case "4": return "Oeste";
        }
        return null;
    }

    private static void deduzirPontosAcao(Raca raca){
        if (raca.equals(racaP1)) {
            pontosDeAcaoP1--;
        } else {
            pontosDeAcaoP2--;
        }
    }

    //=====================================================================================================//
    //==========================================SELEÇÃO DE ALVO============================================//
    //=====================================================================================================//

    /**
     * Realiza uma varredura completa, indicando os alvos próximos e retorna o alvo escolhido
     * @param objeto {Objeto}
     * @param raca {Raca}
     * @return Objeto
     */

    private static Objeto selecionarAlvo(Objeto objeto, Raca raca){
        String escolha, index;
        Raca racaTemp = raca.equals(racaP1) ? racaP2 : racaP1;
        int centros = 0, casas = 0, quarteis = 0, templos = 0, torres = 0, andarilhos = 0, arqueiros = 0, camponeses = 0, cavaleiros = 0, grifos = 0, guerreiros = 0, sacerdotes = 0;

        ArrayList<AndarilhoEspiritual> arrayAndarilhos = new ArrayList<>(); ArrayList<Arqueiro> arrayArqueiros = new ArrayList<>(); ArrayList<Campones> arrayCamponeses = new ArrayList<>();
        ArrayList<Cavaleiro> arrayCavaleiros = new ArrayList<>();           ArrayList<Grifo> arrayGrifos = new ArrayList<>();       ArrayList<Guerreiro> arrayGuerreiros = new ArrayList<>();
        ArrayList<Sacerdote> arraySacerdotes = new ArrayList<>();           ArrayList<Casa> arrayCasas = new ArrayList<>();         ArrayList<CentroDaCidade> arrayCentros = new ArrayList<>();
        ArrayList<Quartel> arrayQuarteis = new ArrayList<>();               ArrayList<Templo> arrayTemplos = new ArrayList<>();     ArrayList<Torre> arrayTorres = new ArrayList<>();

        for(Unidade unidade : racaTemp.listaDeUnidades()){
            if(objeto.verificaDistancia(unidade) && unidade.getEstado()){
                switch (unidade.getClass().getSimpleName()){
                    case "AndarilhoEspiritual": andarilhos++; arrayAndarilhos.add((AndarilhoEspiritual) unidade); break;
                    case "Arqueiro": arqueiros++; arrayArqueiros.add((Arqueiro) unidade); break;
                    case "Campones": camponeses++; arrayCamponeses.add((Campones) unidade); break;
                    case "Cavaleiro": cavaleiros++; arrayCavaleiros.add((Cavaleiro) unidade); break;
                    case "Grifo": grifos++; arrayGrifos.add((Grifo) unidade); break;
                    case "Guerreiro": guerreiros++; arrayGuerreiros.add((Guerreiro) unidade); break;
                    case "Sacerdote": sacerdotes++; arraySacerdotes.add((Sacerdote) unidade); break;
                }
            }
        }
        for(Construcao construcao : racaTemp.listaDeConstrucoes()){
            if(objeto.verificaDistancia(construcao) && construcao.getEstado()){
                switch (construcao.getClass().getSimpleName()){
                    case "Casa": casas++; arrayCasas.add((Casa) construcao); break;
                    case "CentroDaCidade": centros++; arrayCentros.add((CentroDaCidade) construcao); break;
                    case "Quartel": quarteis++; arrayQuarteis.add((Quartel) construcao); break;
                    case "Templo": templos++; arrayTemplos.add((Templo) construcao); break;
                    case "Torre": torres++; arrayTorres.add((Torre) construcao); break;
                }
            }
        }

        if (andarilhos + arqueiros + camponeses + cavaleiros + grifos + guerreiros + sacerdotes + casas + centros + quarteis + templos + torres > 0){
            System.out.println("Unidades e construções inimigas ao seu alcance:");
            System.out.print(andarilhos > 0 ? String.format("Andarilho Espiritual: %d\n",andarilhos) : "");
            System.out.print(arqueiros > 0 ? String.format("Arqueiros: %d\n",arqueiros) : "");
            System.out.print(camponeses > 0 ? String.format("Camponeses: %d\n",camponeses) : "");
            System.out.print(cavaleiros > 0 ? String.format("Cavaleiros: %d\n",cavaleiros) : "");
            System.out.print(grifos > 0 ? String.format("Grifos: %d\n",grifos) : "");
            System.out.print(guerreiros > 0 ? String.format("Guerreiros: %d\n",guerreiros) : "");
            System.out.print(sacerdotes > 0 ? String.format("Sacerdotes: %d\n",sacerdotes) : "");
            System.out.print(casas > 0 ? String.format("Casas: %d\n",casas) : "");
            System.out.print(centros > 0 ? String.format("Centros: %d\n",centros) : "");
            System.out.print(quarteis > 0 ? String.format("Quartéis: %d\n",quarteis) : "");
            System.out.print(templos > 0 ? String.format("Templos: %d\n",templos) : "");
            System.out.print(torres > 0 ? String.format("Torres: %d\n",torres) : "");

            System.out.print("Selecione uma unidade/construção: ");

            String regex = "(";
            if (andarilhos  > 0) { regex += "1";   System.out.print(" [1] Andarilho "); }
            if (arqueiros   > 0) { regex += "|2";  System.out.print(" [2] Arqueiro ");  }
            if (camponeses  > 0) { regex += "|3";  System.out.print(" [3] Campones ");  }
            if (cavaleiros  > 0) { regex += "|4";  System.out.print(" [4] Cavaleiro "); }
            if (grifos      > 0) { regex += "|5";  System.out.print(" [5] Grifo ");     }
            if (guerreiros  > 0) { regex += "|6";  System.out.print(" [6] Guerreiro "); }
            if (sacerdotes  > 0) { regex += "|7";  System.out.print(" [7] Sacerdote "); }
            if (casas       > 0) { regex += "|8";  System.out.print(" [8] Casa ");      }
            if (centros     > 0) { regex += "|9";  System.out.print(" [9] Centro ");    }
            if (quarteis    > 0) { regex += "|10"; System.out.print(" [10] Quartel ");  }
            if (templos     > 0) { regex += "|11"; System.out.print(" [11] Templo ");   }
            if (torres      > 0) { regex += "|12"; System.out.print(" [12] Torre ");    }
            regex += ")";
            escolha = selecionarOpcao(regex);

            switch (escolha){
                case "1": if(andarilhos > 1){System.out.print("Qual? ");return arrayAndarilhos.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", andarilhos))) -1);}else{return arrayAndarilhos.get(0);}
                case "2": if(arqueiros > 1){System.out.print("Qual? ");return arrayArqueiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", arqueiros))) -1);}else{return arrayArqueiros.get(0);}
                case "3": if(camponeses > 1){System.out.print("Qual? ");return arrayCamponeses.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", camponeses))) -1);}else{return arrayCamponeses.get(0);}
                case "4": if(cavaleiros > 1){System.out.print("Qual? ");return arrayCavaleiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", cavaleiros))) -1);}else{return arrayCavaleiros.get(0);}
                case "5": if(grifos > 1){System.out.print("Qual? ");return arrayGrifos.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", grifos))) -1);}else{return arrayGrifos.get(0);}
                case "6": if(guerreiros > 1){System.out.print("Qual? ");return arrayGuerreiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", guerreiros))) -1);}else{return arrayGuerreiros.get(0);}
                case "7": if(sacerdotes > 1){System.out.print("Qual? ");return arraySacerdotes.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", sacerdotes))) -1);}else{return arraySacerdotes.get(0);}
                case "8": if(casas > 1){System.out.print("Qual? ");return arrayCasas.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", casas))) -1);}else{return arrayCasas.get(0);}
                case "9": if(centros > 1){System.out.print("Qual? ");return arrayCentros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", centros))) -1);}else{return arrayCentros.get(0);}
                case "10": if(quarteis > 1){System.out.print("Qual? ");return arrayQuarteis.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", quarteis))) -1);}else{return arrayQuarteis.get(0);}
                case "11": if(templos > 1){System.out.print("Qual? ");return arrayTemplos.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", templos))) -1);}else{return arrayTemplos.get(0);}
                case "12": if(torres > 1){System.out.print("Qual? ");return arrayTorres.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", torres))) -1);}else{return arrayTorres.get(0);}
            }
        }
        return null;
    }

    private static Objeto selecionarAlvoMorto(Objeto objeto, Raca raca){
        String escolha, index;
        Raca racaTemp = raca.equals(racaP1) ? racaP2 : racaP1;
        int andarilhos = 0, arqueiros = 0, camponeses = 0, cavaleiros = 0, grifos = 0, guerreiros = 0, sacerdotes = 0;

        ArrayList<AndarilhoEspiritual> arrayAndarilhos = new ArrayList<>(); ArrayList<Arqueiro> arrayArqueiros = new ArrayList<>(); ArrayList<Campones> arrayCamponeses = new ArrayList<>();
        ArrayList<Cavaleiro> arrayCavaleiros = new ArrayList<>();           ArrayList<Grifo> arrayGrifos = new ArrayList<>();       ArrayList<Guerreiro> arrayGuerreiros = new ArrayList<>();
        ArrayList<Sacerdote> arraySacerdotes = new ArrayList<>();

        for(Unidade unidade : racaTemp.listaDeUnidades()){
            if(objeto.verificaDistancia(unidade) && !unidade.getEstado()){
                switch (unidade.getClass().getSimpleName()){
                    case "AndarilhoEspiritual": andarilhos++; arrayAndarilhos.add((AndarilhoEspiritual) unidade); break;
                    case "Arqueiro": arqueiros++; arrayArqueiros.add((Arqueiro) unidade); break;
                    case "Campones": camponeses++; arrayCamponeses.add((Campones) unidade); break;
                    case "Cavaleiro": cavaleiros++; arrayCavaleiros.add((Cavaleiro) unidade); break;
                    case "Grifo": grifos++; arrayGrifos.add((Grifo) unidade); break;
                    case "Guerreiro": guerreiros++; arrayGuerreiros.add((Guerreiro) unidade); break;
                    case "Sacerdote": sacerdotes++; arraySacerdotes.add((Sacerdote) unidade); break;
                }
            }
        }
        if (andarilhos + arqueiros + camponeses + cavaleiros + grifos + guerreiros + sacerdotes > 0){
            System.out.println("Unidades inimigas mortas ao seu alcance:");
            System.out.print(andarilhos > 0 ? String.format("Andarilho Espiritual: %d\n",andarilhos) : "");
            System.out.print(arqueiros > 0 ? String.format("Arqueiros: %d\n",arqueiros) : "");
            System.out.print(camponeses > 0 ? String.format("Camponeses: %d\n",camponeses) : "");
            System.out.print(cavaleiros > 0 ? String.format("Cavaleiros: %d\n",cavaleiros) : "");
            System.out.print(grifos > 0 ? String.format("Grifos: %d\n",grifos) : "");
            System.out.print(guerreiros > 0 ? String.format("Guerreiros: %d\n",guerreiros) : "");
            System.out.print(sacerdotes > 0 ? String.format("Sacerdotes: %d\n",sacerdotes) : "");

            System.out.print("Selecione uma unidade: ");

            String regex = "(";
            if (andarilhos  > 0) { regex += "1";   System.out.print(" [1] Andarilho "); }
            if (arqueiros   > 0) { regex += "|2";  System.out.print(" [2] Arqueiro ");  }
            if (camponeses  > 0) { regex += "|3";  System.out.print(" [3] Campones ");  }
            if (cavaleiros  > 0) { regex += "|4";  System.out.print(" [4] Cavaleiro "); }
            if (grifos      > 0) { regex += "|5";  System.out.print(" [5] Grifo ");     }
            if (guerreiros  > 0) { regex += "|6";  System.out.print(" [6] Guerreiro "); }
            if (sacerdotes  > 0) { regex += "|7";  System.out.print(" [7] Sacerdote "); }

            regex += ")";
            escolha = selecionarOpcao(regex);
            switch (escolha){
                case "1": if(andarilhos > 1){System.out.print("Qual? ");return arrayAndarilhos.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", andarilhos))) -1);}else{return arrayAndarilhos.get(0);}
                case "2": if(arqueiros > 1){System.out.print("Qual? ");return arrayArqueiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", arqueiros))) -1);}else{return arrayArqueiros.get(0);}
                case "3": if(camponeses > 1){System.out.print("Qual? ");return arrayCamponeses.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", camponeses))) -1);}else{return arrayCamponeses.get(0);}
                case "4": if(cavaleiros > 1){System.out.print("Qual? ");return arrayCavaleiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", cavaleiros))) -1);}else{return arrayCavaleiros.get(0);}
                case "5": if(grifos > 1){System.out.print("Qual? ");return arrayGrifos.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", grifos))) -1);}else{return arrayGrifos.get(0);}
                case "6": if(guerreiros > 1){System.out.print("Qual? ");return arrayGuerreiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", guerreiros))) -1);}else{return arrayGuerreiros.get(0);}
                case "7": if(sacerdotes > 1){System.out.print("Qual? ");return arraySacerdotes.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", sacerdotes))) -1);}else{return arraySacerdotes.get(0);}
            }
        }
        return null;
    }

    private static Objeto selecionarAliado(Objeto objeto, Raca raca){
        String escolha, index;
        int andarilhos = 0, arqueiros = 0, camponeses = 0, cavaleiros = 0, grifos = 0, guerreiros = 0, sacerdotes = 0;

        ArrayList<AndarilhoEspiritual> arrayAndarilhos = new ArrayList<>(); ArrayList<Arqueiro> arrayArqueiros = new ArrayList<>(); ArrayList<Campones> arrayCamponeses = new ArrayList<>();
        ArrayList<Cavaleiro> arrayCavaleiros = new ArrayList<>();           ArrayList<Grifo> arrayGrifos = new ArrayList<>();       ArrayList<Guerreiro> arrayGuerreiros = new ArrayList<>();
        ArrayList<Sacerdote> arraySacerdotes = new ArrayList<>();

        for(Unidade unidade : raca.listaDeUnidades()){
            if(objeto.verificaDistancia(unidade) && unidade.getEstado() && !unidade.equals(objeto)){
                switch (unidade.getClass().getSimpleName()){
                    case "AndarilhoEspiritual": andarilhos++; arrayAndarilhos.add((AndarilhoEspiritual) unidade); break;
                    case "Arqueiro": arqueiros++; arrayArqueiros.add((Arqueiro) unidade); break;
                    case "Campones": camponeses++; arrayCamponeses.add((Campones) unidade); break;
                    case "Cavaleiro": cavaleiros++; arrayCavaleiros.add((Cavaleiro) unidade); break;
                    case "Grifo": grifos++; arrayGrifos.add((Grifo) unidade); break;
                    case "Guerreiro": guerreiros++; arrayGuerreiros.add((Guerreiro) unidade); break;
                    case "Sacerdote": sacerdotes++; arraySacerdotes.add((Sacerdote) unidade); break;
                }
            }
        }

        System.out.println("Unidades aliadas ao seu alcance:");
        System.out.print(andarilhos > 0 ? String.format("Andarilho Espiritual: %d\n",andarilhos) : "");
        System.out.print(arqueiros > 0 ? String.format("Arqueiros: %d\n",arqueiros) : "");
        System.out.print(camponeses > 0 ? String.format("Camponeses: %d\n",camponeses) : "");
        System.out.print(cavaleiros > 0 ? String.format("Cavaleiros: %d\n",cavaleiros) : "");
        System.out.print(grifos > 0 ? String.format("Grifos: %d\n",grifos) : "");
        System.out.print(guerreiros > 0 ? String.format("Guerreiros: %d\n",guerreiros) : "");
        System.out.print(sacerdotes > 0 ? String.format("Sacerdotes: %d\n",sacerdotes) : "");

        System.out.print("Selecione uma unidade: ");

        String regex = "(";
        if (andarilhos  > 0) { regex += "1";   System.out.print(" [1] Andarilho "); }
        if (arqueiros   > 0) { regex += "|2";  System.out.print(" [2] Arqueiro ");  }
        if (camponeses  > 0) { regex += "|3";  System.out.print(" [3] Campones ");  }
        if (cavaleiros  > 0) { regex += "|4";  System.out.print(" [4] Cavaleiro "); }
        if (grifos      > 0) { regex += "|5";  System.out.print(" [5] Grifo ");     }
        if (guerreiros  > 0) { regex += "|6";  System.out.print(" [6] Guerreiro "); }
        if (sacerdotes  > 0) { regex += "|7";  System.out.print(" [7] Sacerdote "); }

        regex += ")";
        escolha = selecionarOpcao(regex);
        switch (escolha){
            case "1": if(andarilhos > 1){System.out.print("Qual? ");return arrayAndarilhos.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", andarilhos))) -1);}else{return arrayAndarilhos.get(0);}
            case "2": if(arqueiros > 1){System.out.print("Qual? ");return arrayArqueiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", arqueiros))) -1);}else{return arrayArqueiros.get(0);}
            case "3": if(camponeses > 1){System.out.print("Qual? ");return arrayCamponeses.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", camponeses))) -1);}else{return arrayCamponeses.get(0);}
            case "4": if(cavaleiros > 1){System.out.print("Qual? ");return arrayCavaleiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", cavaleiros))) -1);}else{return arrayCavaleiros.get(0);}
            case "5": if(grifos > 1){System.out.print("Qual? ");return arrayGrifos.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", grifos))) -1);}else{return arrayGrifos.get(0);}
            case "6": if(guerreiros > 1){System.out.print("Qual? ");return arrayGuerreiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", guerreiros))) -1);}else{return arrayGuerreiros.get(0);}
            case "7": if(sacerdotes > 1){System.out.print("Qual? ");return arraySacerdotes.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", sacerdotes))) -1);}else{return arraySacerdotes.get(0);}
        }
        return null;
    }

    private static Objeto selecionarAliadoMorto(Objeto objeto, Raca raca){
        String escolha, index;
        int andarilhos = 0, arqueiros = 0, camponeses = 0, cavaleiros = 0, grifos = 0, guerreiros = 0, sacerdotes = 0;

        ArrayList<AndarilhoEspiritual> arrayAndarilhos = new ArrayList<>(); ArrayList<Arqueiro> arrayArqueiros = new ArrayList<>(); ArrayList<Campones> arrayCamponeses = new ArrayList<>();
        ArrayList<Cavaleiro> arrayCavaleiros = new ArrayList<>();           ArrayList<Grifo> arrayGrifos = new ArrayList<>();       ArrayList<Guerreiro> arrayGuerreiros = new ArrayList<>();
        ArrayList<Sacerdote> arraySacerdotes = new ArrayList<>();

        for(Unidade unidade : raca.listaDeUnidades()){
            if(objeto.verificaDistancia(unidade) && !unidade.getEstado() && !unidade.equals(objeto)){
                switch (unidade.getClass().getSimpleName()){
                    case "AndarilhoEspiritual": andarilhos++; arrayAndarilhos.add((AndarilhoEspiritual) unidade); break;
                    case "Arqueiro": arqueiros++; arrayArqueiros.add((Arqueiro) unidade); break;
                    case "Campones": camponeses++; arrayCamponeses.add((Campones) unidade); break;
                    case "Cavaleiro": cavaleiros++; arrayCavaleiros.add((Cavaleiro) unidade); break;
                    case "Grifo": grifos++; arrayGrifos.add((Grifo) unidade); break;
                    case "Guerreiro": guerreiros++; arrayGuerreiros.add((Guerreiro) unidade); break;
                    case "Sacerdote": sacerdotes++; arraySacerdotes.add((Sacerdote) unidade); break;
                }
            }
        }

        System.out.println("Unidades aliadas mortas ao seu alcance:");
        System.out.print(andarilhos > 0 ? String.format("Andarilho Espiritual: %d\n",andarilhos) : "");
        System.out.print(arqueiros > 0 ? String.format("Arqueiros: %d\n",arqueiros) : "");
        System.out.print(camponeses > 0 ? String.format("Camponeses: %d\n",camponeses) : "");
        System.out.print(cavaleiros > 0 ? String.format("Cavaleiros: %d\n",cavaleiros) : "");
        System.out.print(grifos > 0 ? String.format("Grifos: %d\n",grifos) : "");
        System.out.print(guerreiros > 0 ? String.format("Guerreiros: %d\n",guerreiros) : "");
        System.out.print(sacerdotes > 0 ? String.format("Sacerdotes: %d\n",sacerdotes) : "");

        System.out.print("Selecione uma unidade: ");

        String regex = "(";
        if (andarilhos  > 0) { regex += "1";   System.out.print(" [1] Andarilho "); }
        if (arqueiros   > 0) { regex += "|2";  System.out.print(" [2] Arqueiro ");  }
        if (camponeses  > 0) { regex += "|3";  System.out.print(" [3] Campones ");  }
        if (cavaleiros  > 0) { regex += "|4";  System.out.print(" [4] Cavaleiro "); }
        if (grifos      > 0) { regex += "|5";  System.out.print(" [5] Grifo ");     }
        if (guerreiros  > 0) { regex += "|6";  System.out.print(" [6] Guerreiro "); }
        if (sacerdotes  > 0) { regex += "|7";  System.out.print(" [7] Sacerdote "); }

        regex += ")";
        escolha = selecionarOpcao(regex);
        switch (escolha){
            case "1": if(andarilhos > 1){System.out.print("Qual? ");return arrayAndarilhos.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", andarilhos))) -1);}else{return arrayAndarilhos.get(0);}
            case "2": if(arqueiros > 1){System.out.print("Qual? ");return arrayArqueiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", arqueiros))) -1);}else{return arrayArqueiros.get(0);}
            case "3": if(camponeses > 1){System.out.print("Qual? ");return arrayCamponeses.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", camponeses))) -1);}else{return arrayCamponeses.get(0);}
            case "4": if(cavaleiros > 1){System.out.print("Qual? ");return arrayCavaleiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", cavaleiros))) -1);}else{return arrayCavaleiros.get(0);}
            case "5": if(grifos > 1){System.out.print("Qual? ");return arrayGrifos.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", grifos))) -1);}else{return arrayGrifos.get(0);}
            case "6": if(guerreiros > 1){System.out.print("Qual? ");return arrayGuerreiros.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", guerreiros))) -1);}else{return arrayGuerreiros.get(0);}
            case "7": if(sacerdotes > 1){System.out.print("Qual? ");return arraySacerdotes.get(Integer.parseInt(selecionarOpcao(String.format("[1-%d]", sacerdotes))) -1);}else{return arraySacerdotes.get(0);}
        }
        return null;
    }

    private static boolean verificaAlvo(Objeto objeto, Raca raca){
        Raca racaTemp = raca.equals(racaP1) ? racaP2 : racaP1;
        int centros = 0, casas = 0, quarteis = 0, templos = 0, torres = 0, andarilhos = 0, arqueiros = 0, camponeses = 0, cavaleiros = 0, grifos = 0, guerreiros = 0, sacerdotes = 0;

        ArrayList<AndarilhoEspiritual> arrayAndarilhos = new ArrayList<>(); ArrayList<Arqueiro> arrayArqueiros = new ArrayList<>(); ArrayList<Campones> arrayCamponeses = new ArrayList<>();
        ArrayList<Cavaleiro> arrayCavaleiros = new ArrayList<>();           ArrayList<Grifo> arrayGrifos = new ArrayList<>();       ArrayList<Guerreiro> arrayGuerreiros = new ArrayList<>();
        ArrayList<Sacerdote> arraySacerdotes = new ArrayList<>();           ArrayList<Casa> arrayCasas = new ArrayList<>();         ArrayList<CentroDaCidade> arrayCentros = new ArrayList<>();
        ArrayList<Quartel> arrayQuarteis = new ArrayList<>();               ArrayList<Templo> arrayTemplos = new ArrayList<>();     ArrayList<Torre> arrayTorres = new ArrayList<>();

        for(Unidade unidade : racaTemp.listaDeUnidades()){
            if(objeto.verificaDistancia(unidade) && unidade.getEstado()){
                switch (unidade.getClass().getSimpleName()){
                    case "AndarilhoEspiritual": andarilhos++; arrayAndarilhos.add((AndarilhoEspiritual) unidade); break;
                    case "Arqueiro": arqueiros++; arrayArqueiros.add((Arqueiro) unidade); break;
                    case "Campones": camponeses++; arrayCamponeses.add((Campones) unidade); break;
                    case "Cavaleiro": cavaleiros++; arrayCavaleiros.add((Cavaleiro) unidade); break;
                    case "Grifo": grifos++; arrayGrifos.add((Grifo) unidade); break;
                    case "Guerreiro": guerreiros++; arrayGuerreiros.add((Guerreiro) unidade); break;
                    case "Sacerdote": sacerdotes++; arraySacerdotes.add((Sacerdote) unidade); break;
                }
            }
        }
        for(Construcao construcao : racaTemp.listaDeConstrucoes()){
            if(objeto.verificaDistancia(construcao) && construcao.getEstado()){
                switch (construcao.getClass().getSimpleName()){
                    case "Casa": casas++; arrayCasas.add((Casa) construcao); break;
                    case "CentroDaCidade": centros++; arrayCentros.add((CentroDaCidade) construcao); break;
                    case "Quartel": quarteis++; arrayQuarteis.add((Quartel) construcao); break;
                    case "Templo": templos++; arrayTemplos.add((Templo) construcao); break;
                    case "Torre": torres++; arrayTorres.add((Torre) construcao); break;
                }
            }
        }
        return (andarilhos + arqueiros + camponeses + cavaleiros + grifos + guerreiros + sacerdotes + casas + centros + quarteis + templos + torres > 0);
    }

    private static boolean verificaAliado(Objeto objeto, Raca raca){
        int andarilhos = 0, arqueiros = 0, camponeses = 0, cavaleiros = 0, grifos = 0, guerreiros = 0, sacerdotes = 0;

        ArrayList<AndarilhoEspiritual> arrayAndarilhos = new ArrayList<>(); ArrayList<Arqueiro> arrayArqueiros = new ArrayList<>(); ArrayList<Campones> arrayCamponeses = new ArrayList<>();
        ArrayList<Cavaleiro> arrayCavaleiros = new ArrayList<>();           ArrayList<Grifo> arrayGrifos = new ArrayList<>();       ArrayList<Guerreiro> arrayGuerreiros = new ArrayList<>();
        ArrayList<Sacerdote> arraySacerdotes = new ArrayList<>();

        for(Unidade unidade : raca.listaDeUnidades()){
            if(objeto.verificaDistancia(unidade) && unidade.getEstado()){
                switch (unidade.getClass().getSimpleName()){
                    case "AndarilhoEspiritual": andarilhos++; arrayAndarilhos.add((AndarilhoEspiritual) unidade); break;
                    case "Arqueiro": arqueiros++; arrayArqueiros.add((Arqueiro) unidade); break;
                    case "Campones": camponeses++; arrayCamponeses.add((Campones) unidade); break;
                    case "Cavaleiro": cavaleiros++; arrayCavaleiros.add((Cavaleiro) unidade); break;
                    case "Grifo": grifos++; arrayGrifos.add((Grifo) unidade); break;
                    case "Guerreiro": guerreiros++; arrayGuerreiros.add((Guerreiro) unidade); break;
                    case "Sacerdote": sacerdotes++; arraySacerdotes.add((Sacerdote) unidade); break;
                }
            }
        }
        return (andarilhos + arqueiros + camponeses + cavaleiros + grifos + guerreiros + sacerdotes > 0);
    }

    private static boolean verificaAlvoMorto(Objeto objeto, Raca raca){
        Raca racaTemp = raca.equals(racaP1) ? racaP2 : racaP1;
        int andarilhos = 0, arqueiros = 0, camponeses = 0, cavaleiros = 0, grifos = 0, guerreiros = 0, sacerdotes = 0;

        ArrayList<AndarilhoEspiritual> arrayAndarilhos = new ArrayList<>(); ArrayList<Arqueiro> arrayArqueiros = new ArrayList<>(); ArrayList<Campones> arrayCamponeses = new ArrayList<>();
        ArrayList<Cavaleiro> arrayCavaleiros = new ArrayList<>();           ArrayList<Grifo> arrayGrifos = new ArrayList<>();       ArrayList<Guerreiro> arrayGuerreiros = new ArrayList<>();
        ArrayList<Sacerdote> arraySacerdotes = new ArrayList<>();

        for(Unidade unidade : racaTemp.listaDeUnidades()){
            if(objeto.verificaDistancia(unidade) && !unidade.getEstado()){
                switch (unidade.getClass().getSimpleName()){
                    case "AndarilhoEspiritual": andarilhos++; arrayAndarilhos.add((AndarilhoEspiritual) unidade); break;
                    case "Arqueiro": arqueiros++; arrayArqueiros.add((Arqueiro) unidade); break;
                    case "Campones": camponeses++; arrayCamponeses.add((Campones) unidade); break;
                    case "Cavaleiro": cavaleiros++; arrayCavaleiros.add((Cavaleiro) unidade); break;
                    case "Grifo": grifos++; arrayGrifos.add((Grifo) unidade); break;
                    case "Guerreiro": guerreiros++; arrayGuerreiros.add((Guerreiro) unidade); break;
                    case "Sacerdote": sacerdotes++; arraySacerdotes.add((Sacerdote) unidade); break;
                }
            }
        }
        return (andarilhos + arqueiros + camponeses + cavaleiros + grifos + guerreiros + sacerdotes > 0);
    }

    private static boolean verificaAliadoMorto(Objeto objeto, Raca raca){
        int andarilhos = 0, arqueiros = 0, camponeses = 0, cavaleiros = 0, grifos = 0, guerreiros = 0, sacerdotes = 0;

        ArrayList<AndarilhoEspiritual> arrayAndarilhos = new ArrayList<>(); ArrayList<Arqueiro> arrayArqueiros = new ArrayList<>(); ArrayList<Campones> arrayCamponeses = new ArrayList<>();
        ArrayList<Cavaleiro> arrayCavaleiros = new ArrayList<>();           ArrayList<Grifo> arrayGrifos = new ArrayList<>();       ArrayList<Guerreiro> arrayGuerreiros = new ArrayList<>();
        ArrayList<Sacerdote> arraySacerdotes = new ArrayList<>();

        for(Unidade unidade : raca.listaDeUnidades()){
            if(objeto.verificaDistancia(unidade) && !unidade.getEstado()){
                switch (unidade.getClass().getSimpleName()){
                    case "AndarilhoEspiritual": andarilhos++; arrayAndarilhos.add((AndarilhoEspiritual) unidade); break;
                    case "Arqueiro": arqueiros++; arrayArqueiros.add((Arqueiro) unidade); break;
                    case "Campones": camponeses++; arrayCamponeses.add((Campones) unidade); break;
                    case "Cavaleiro": cavaleiros++; arrayCavaleiros.add((Cavaleiro) unidade); break;
                    case "Grifo": grifos++; arrayGrifos.add((Grifo) unidade); break;
                    case "Guerreiro": guerreiros++; arrayGuerreiros.add((Guerreiro) unidade); break;
                    case "Sacerdote": sacerdotes++; arraySacerdotes.add((Sacerdote) unidade); break;
                }
            }
        }
        return (andarilhos + arqueiros + camponeses + cavaleiros + grifos + guerreiros + sacerdotes > 0);
    }

    //=====================================================================================================//
    //============================================CONSTRUÇÕES==============================================//
    //=====================================================================================================//

    //************************* INICIO DOS MÉTODOS DE CENTRO DE CIDADE *************************
    private static CentroDaCidade selecionarCentro(Raca raca){
        ArrayList<CentroDaCidade> centros = listaDeCentros(raca);
        int quantidadeCentros = centros.size();
        int index;
        if (quantidadeCentros > 1) {
            System.out.printf("Você possui %d centros. Qual deles(as) deseja acessar? ", quantidadeCentros);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }else{
            index = 1;
        }
        while(index > quantidadeCentros){
            System.out.printf("Você possui apenas %d centros", quantidadeCentros);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }
        return centros.get(index - 1);
    }

    private static ArrayList<CentroDaCidade> listaDeCentros(Raca raca){
        ArrayList<CentroDaCidade> centros = new ArrayList<>();
        for(Construcao construcao : raca.listaDeConstrucoes()){
            if (construcao instanceof CentroDaCidade && construcao.getEstado()){
                centros.add((CentroDaCidade) construcao);
            }
        }
        return centros;
    }

    private static void opcoesCentro(Raca raca){
        if (listaDeCentros(raca).size() == 0){
            System.out.println("Você não possui nenhum centro");
        }else{
            CentroDaCidade centro = selecionarCentro(raca);
            System.out.println("Selecione uma opção");
            System.out.print("[1] Criar Campones [2] Atacar [3] Ver posição [4] Sair: ");
            switch (selecionarOpcao("[1-4]")){
                case "1": centro.criarCampones(); deduzirPontosAcao(raca); break;
                case "2": if (verificaAlvo(centro, raca)) {centro.atacar(selecionarAlvo(centro, raca)); deduzirPontosAcao(raca);} else {System.out.println("Nenhum alvo ao seu alcance");} break;
                case "3": centro.getPosicao().mostrarPosicao(); break;
            }
        }
    }

    //************************* INICIO DOS MÉTODOS DE QUARTEL *************************
    private static Quartel selecionarQuartel(Raca raca){
        ArrayList<Quartel> quarteis = listaDeQuarteis(raca);
        int quantidadeQuarteis = quarteis.size();
        int index;
        if (quantidadeQuarteis > 1) {
            System.out.printf("Você possui %d quartéis. Qual deles(as) deseja acessar? ", quantidadeQuarteis);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }else{
            index = 1;
        }
        while(index > quantidadeQuarteis){
            System.out.printf("Você possui apenas %d quartéis", quantidadeQuarteis);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }
        return quarteis.get(index - 1);
    }

    private static ArrayList<Quartel> listaDeQuarteis(Raca raca){
        ArrayList<Quartel> quarteis = new ArrayList<>();
        for(Construcao construcao : raca.listaDeConstrucoes()){
            if (construcao instanceof Quartel && construcao.getEstado()){
                quarteis.add((Quartel) construcao);
            }
        }
        return quarteis;
    }

    private static void opcoesQuartel(Raca raca){
        if (listaDeQuarteis(raca).size() == 0){
            System.out.println("Você não possui nenhum quartel");
        }else{
            Quartel quartel = selecionarQuartel(raca);
            System.out.println("Selecione uma opção");
            if(raca instanceof Humano) {
                System.out.print("[1] Criar Guerreiro [2] Criar Cavaleiro [3] Criar Arqueiro [4] Criar Grifo [5] Ver posição [6] Sair: ");
                switch (selecionarOpcao("[1-6]")){
                    case "1": quartel.criarGuerreiro(); deduzirPontosAcao(raca); break;
                    case "2": quartel.criarCavaleiro(); deduzirPontosAcao(raca); break;
                    case "3": quartel.criarArqueiro(); deduzirPontosAcao(raca); break;
                    case "4": quartel.criarGrifo(); deduzirPontosAcao(raca); break;
                    case "5": quartel.getPosicao().mostrarPosicao(); break;
                }
            }else{
                System.out.print("[1] Criar Guerreiro [2] Criar Cavaleiro [3] Criar Arqueiro [4] Ver posição [5] Sair: ");
                switch (selecionarOpcao("[1-5]")){
                    case "1": quartel.criarGuerreiro(); deduzirPontosAcao(raca); break;
                    case "2": quartel.criarCavaleiro(); deduzirPontosAcao(raca); break;
                    case "3": quartel.criarArqueiro(); deduzirPontosAcao(raca); break;
                    case "4": quartel.getPosicao().mostrarPosicao(); break;
                }
            }
        }
    }

    //************************* INICIO DOS MÉTODOS DE TEMPLO *************************
    private static Templo selecionarTemplo(Raca raca){
        ArrayList<Templo> templos = listaDeTemplos(raca);
        int quantidadeTemplos = templos.size();
        int index;
        if (quantidadeTemplos > 1) {
            System.out.printf("Você possui %d templos. Qual deles(as) deseja acessar? ", quantidadeTemplos);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }else{
            index = 1;
        }
        while(index > quantidadeTemplos){
            System.out.printf("Você possui apenas %d templos", quantidadeTemplos);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }
        return templos.get(index - 1);
    }

    private static ArrayList<Templo> listaDeTemplos(Raca raca){
        ArrayList<Templo> templos = new ArrayList<>();
        for(Construcao construcao : raca.listaDeConstrucoes()){
            if (construcao instanceof Templo && construcao.getEstado()){
                templos.add((Templo) construcao);
            }
        }
        return templos;
    }

    private static void opcoesTemplo(Raca raca){
        if (listaDeTemplos(raca).size() == 0){
            System.out.println("Você não possui nenhum templo");
        }else{
            Templo templo = selecionarTemplo(raca);
            System.out.println("Selecione uma opção");
            if (raca instanceof Orc){
                System.out.print("[1] Criar Sacerdote [2] Criar Andarilho [3] Ver posição [4] Sair: ");
                switch (selecionarOpcao("[1-4]")){
                    case "1": templo.criarSacerdote(); deduzirPontosAcao(raca); break;
                    case "2": templo.criarAndarilho(); deduzirPontosAcao(raca); break;
                    case "3": templo.getPosicao().mostrarPosicao(); break;
                }
            }else{
                System.out.print("[1] Criar Sacerdote [2] Ver posição [3] Sair: ");
                switch (selecionarOpcao("[1-3]")){
                    case "1": templo.criarSacerdote(); deduzirPontosAcao(raca); break;
                    case "2": templo.getPosicao().mostrarPosicao(); break;
                }
            }
        }
    }

    //************************* INICIO DOS MÉTODOS DE TORRE *************************
    private static Torre selecionarTorre(Raca raca){
        ArrayList<Torre> torres = listaDeTorres(raca);
        int quantidadeTorres = torres.size();
        int index;
        if (quantidadeTorres > 1) {
            System.out.printf("Você possui %d torres. Qual deles(as) deseja acessar? ", quantidadeTorres);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }else{
            index = 1;
        }
        while(index > quantidadeTorres){
            System.out.printf("Você possui apenas %d torres", quantidadeTorres);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }
        return torres.get(index - 1);
    }

    private static ArrayList<Torre> listaDeTorres(Raca raca){
        ArrayList<Torre> torres = new ArrayList<>();
        for(Construcao construcao : raca.listaDeConstrucoes()){
            if (construcao instanceof Torre && construcao.getEstado()){
                torres.add((Torre) construcao);
            }
        }
        return torres;
    }

    private static void opcoesTorre(Raca raca){
        if (listaDeTorres(raca).size() == 0) {
            System.out.println("Você não possui nenhuma torre");
        } else {
            Torre torre = selecionarTorre(raca);
            System.out.println("Selecione uma opção");
            System.out.print("[1] Atacar [2] Ver posição [3] Sair: ");
            switch (selecionarOpcao("[1-3]")) {
                case "1": if (verificaAlvo(torre, raca)) {torre.atacar(selecionarAlvo(torre, raca)); deduzirPontosAcao(raca);} else {System.out.println("Nenhum alvo ao seu alcance");} break;
                case "2": torre.getPosicao().mostrarPosicao(); break;
            }
        }
    }

    //=====================================================================================================//
    //==============================================UNIDADES===============================================//
    //=====================================================================================================//

    //************************* INICIO DOS MÉTODOS DE CAMPONES *************************
    private static Campones selecionarCampones(Raca raca){
        ArrayList<Campones> camponeses = listaDeCamponeses(raca);
        int quantidadeCamponeses = camponeses.size();
        int index;
        if (quantidadeCamponeses > 1) {
            System.out.printf("Você possui %d camponeses. Qual deles(as) deseja acessar? ", quantidadeCamponeses);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }else{
            index = 1;
        }
        while(index > quantidadeCamponeses){
            System.out.printf("Você possui apenas %d camponeses", quantidadeCamponeses);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }
        return camponeses.get(index - 1);
    }

    private static ArrayList<Campones> listaDeCamponeses(Raca raca){
        ArrayList<Campones> camponeses = new ArrayList<>();
        for(Unidade unidade : raca.listaDeUnidades()){
            if (unidade instanceof Campones && unidade.getEstado()){
                camponeses.add((Campones) unidade);
            }
        }
        return camponeses;
    }

    private static void opcoesCampones(Raca raca){
        if (listaDeCamponeses(raca).size() == 0){
            System.out.println("Você não possui nenhum camponês");
        }else{
            Campones campones = selecionarCampones(raca);
            System.out.println("Selecione uma opção");
            System.out.print("[1] Atacar [2] Colher [3] Cortar [4] Minerar [5] Construir [6] Mover [7] Ver posição [8] Sair ");
            switch (selecionarOpcao("([1-8])")){
                case "1": if (verificaAlvo(campones, raca)) {campones.atacar(selecionarAlvo(campones, raca)); deduzirPontosAcao(raca);} else {System.out.println("Nenhum alvo ao seu alcance");} break;
                case "2": campones.colher(); deduzirPontosAcao(raca); break;
                case "3": campones.cortar(); deduzirPontosAcao(raca); break;
                case "4": campones.minerar(); deduzirPontosAcao(raca); break;
                case "5":
                        System.out.println("Selecione uma opção");
                        System.out.print("[1] Casa [2] Centro [3] Quartel [4] Templo [5] Torre [6] Sair: ");
                        switch (selecionarOpcao("[1-6]")){
                            case "1": campones.construirCasa(); deduzirPontosAcao(raca); break;
                            case "2": campones.construirCentro(); deduzirPontosAcao(raca); break;
                            case "3": campones.construirQuartel(); deduzirPontosAcao(raca); break;
                            case "4": campones.construirTemplo(); deduzirPontosAcao(raca); break;
                            case "5": campones.construirTorre(); deduzirPontosAcao(raca); break;
                        }
                        break;
                case "6": campones.mover(selecionarDirecao()); deduzirPontosAcao(raca); break;
                case "7": campones.getPosicao().mostrarPosicao(); break;
            }
        }
    }

    //************************* INICIO DOS MÉTODOS DE ANDARILHO *************************
    private static AndarilhoEspiritual selecionarAndarilho(Raca raca){
        ArrayList<AndarilhoEspiritual> andarilhos = listaDeAndarilhos(raca);
        int quantidadeAndarilhos = andarilhos.size();
        int index;
        if (quantidadeAndarilhos > 1) {
            System.out.printf("Você possui %d andarilhos. Qual deles(as) deseja acessar? ", quantidadeAndarilhos);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }else{
            index = 1;
        }
        while(index > quantidadeAndarilhos){
            System.out.printf("Você possui apenas %d andarilhos", quantidadeAndarilhos);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }
        return andarilhos.get(index - 1);
    }

    private static ArrayList<AndarilhoEspiritual> listaDeAndarilhos(Raca raca){
        ArrayList<AndarilhoEspiritual> andarilhos = new ArrayList<>();
        for(Unidade unidade : raca.listaDeUnidades()){
            if (unidade instanceof AndarilhoEspiritual && unidade.getEstado()){
                andarilhos.add((AndarilhoEspiritual) unidade);
            }
        }
        return andarilhos;
    }

    private static void opcoesAndarilho(Raca raca){
        if (listaDeAndarilhos(raca).size() == 0){
            System.out.println("Você não possui nenhum andarilho");
        }else{
            AndarilhoEspiritual andarilho = selecionarAndarilho(raca);
            System.out.println("Selecione uma opção");
            System.out.print("[1] Atacar [2] Reviver [3] Mover [4] Ver posição [5] Sair: ");
            switch (selecionarOpcao("[1-5]")){
                case "1": if (verificaAlvo(andarilho, raca)) {andarilho.atacar(selecionarAlvo(andarilho, raca)); deduzirPontosAcao(raca);} else {System.out.println("Nenhum alvo ao seu alcance");} break;
                case "2":
                    if (verificaAlvoMorto(andarilho, raca) && verificaAliadoMorto(andarilho, raca)){
                        System.out.println("Existem aliados e inimigos mortos ao seu alcance, o que deseja reviver? [1] Aliados [2] Inimigos");
                        switch (selecionarOpcao("[12]")){
                            case "1": andarilho.revive((Unidade) selecionarAliadoMorto(andarilho, raca)); deduzirPontosAcao(raca); break;
                            case "2": andarilho.revive((Unidade) selecionarAlvoMorto(andarilho, raca)); deduzirPontosAcao(raca); break;
                        }
                    }else if(verificaAliadoMorto(andarilho, raca)){
                        andarilho.revive((Unidade) selecionarAliadoMorto(andarilho, raca)); deduzirPontosAcao(raca); break;
                    }else if(verificaAlvoMorto(andarilho, raca)){
                        andarilho.revive((Unidade) selecionarAlvoMorto(andarilho, raca)); deduzirPontosAcao(raca); break;
                    }else{
                        System.out.println("Não existem unidades ou inimigos mortos ao seu alcance");
                    }
                    break;
                case "3": andarilho.mover(selecionarDirecao()); deduzirPontosAcao(raca); break;
                case "4": andarilho.getPosicao().mostrarPosicao(); break;
            }
        }
    }

    //************************* INICIO DOS MÉTODOS DE ARQUEIRO *************************
    private static Arqueiro selecionarArqueiro(Raca raca){
        ArrayList<Arqueiro> arqueiros = listaDeArqueiros(raca);
        int quantidadeArqueiros = arqueiros.size();
        int index;
        if (quantidadeArqueiros > 1) {
            System.out.printf("Você possui %d arqueiros. Qual deles(as) deseja acessar? ", quantidadeArqueiros);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }else{
            index = 1;
        }
        while(index > quantidadeArqueiros){
            System.out.printf("Você possui apenas %d arqueiros", quantidadeArqueiros);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }
        return arqueiros.get(index - 1);
    }

    private static ArrayList<Arqueiro> listaDeArqueiros(Raca raca){
        ArrayList<Arqueiro> arqueiros = new ArrayList<>();
        for(Unidade unidade : raca.listaDeUnidades()){
            if (unidade instanceof Arqueiro && unidade.getEstado()){
                arqueiros.add((Arqueiro) unidade);
            }
        }
        return arqueiros;
    }

    private static void opcoesArqueiro(Raca raca){
        if (listaDeArqueiros(raca).size() == 0){
            System.out.println("Você não possui nenhum arqueiro");
        }else{
            Arqueiro arqueiro = selecionarArqueiro(raca);
            System.out.println("Selecione uma opção");
            System.out.print("[1] Atacar [2] Mover [3] Ver posição [4] Sair: ");
            switch (selecionarOpcao("[1-4]")){
                case "1": if (verificaAlvo(arqueiro, raca)) {arqueiro.atacar(selecionarAlvo(arqueiro, raca)); deduzirPontosAcao(raca);} else {System.out.println("Nenhum alvo ao seu alcance");} break;
                case "2": arqueiro.mover(selecionarDirecao()); deduzirPontosAcao(raca); break;
                case "3": arqueiro.getPosicao().mostrarPosicao(); break;
            }
        }
    }

    //************************* INICIO DOS MÉTODOS DE GUERREIRO *************************
    private static Guerreiro selecionarGuerreiro(Raca raca){
        ArrayList<Guerreiro> guerreiros = listaDeGuerreiros(raca);
        int quantidadeGuerreiros = guerreiros.size();
        int index;
        if (quantidadeGuerreiros > 1) {
            System.out.printf("Você possui %d guerreiros. Qual deles(as) deseja acessar? ", quantidadeGuerreiros);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }else{
            index = 1;
        }
        while(index > quantidadeGuerreiros){
            System.out.printf("Você possui apenas %d guerreiros", quantidadeGuerreiros);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }
        return guerreiros.get(index - 1);
    }

    private static ArrayList<Guerreiro> listaDeGuerreiros(Raca raca){
        ArrayList<Guerreiro> guerreiros = new ArrayList<>();
        for(Unidade unidade : raca.listaDeUnidades()){
            if (unidade instanceof Guerreiro && unidade.getEstado()){
                guerreiros.add((Guerreiro) unidade);
            }
        }
        return guerreiros;
    }

    private static void opcoesGuerreiro(Raca raca){
        if (listaDeGuerreiros(raca).size() == 0){
            System.out.println("Você não possui nenhum guerreiro");
        }else{
            Guerreiro guerreiro = selecionarGuerreiro(raca);
            System.out.println("Selecione uma opção");
            System.out.print("[1] Atacar [2] Mover [3] Ver posição [4] Sair: ");
            switch (selecionarOpcao("[1-4]")){
                case "1": if (verificaAlvo(guerreiro, raca)) {guerreiro.atacar(selecionarAlvo(guerreiro, raca)); deduzirPontosAcao(raca);} else {System.out.println("Nenhum alvo ao seu alcance");} break;
                case "2": guerreiro.mover(selecionarDirecao()); deduzirPontosAcao(raca); break;
                case "3": guerreiro.getPosicao().mostrarPosicao(); break;
            }
        }
    }

    //************************* INICIO DOS MÉTODOS DE CAVALEIRO *************************
    private static Cavaleiro selecionarCavaleiro(Raca raca){
        ArrayList<Cavaleiro> cavaleiros = listaDeCavaleiros(raca);
        int quantidadeCavaleiros = cavaleiros.size();
        int index;
        if (quantidadeCavaleiros > 1) {
            System.out.printf("Você possui %d cavaleiros. Qual deles(as) deseja acessar? ", quantidadeCavaleiros);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }else{
            index = 1;
        }
        while(index > quantidadeCavaleiros){
            System.out.printf("Você possui apenas %d cavaleiros", quantidadeCavaleiros);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }
        return cavaleiros.get(index - 1);
    }

    private static ArrayList<Cavaleiro> listaDeCavaleiros(Raca raca){
        ArrayList<Cavaleiro> cavaleiros = new ArrayList<>();
        for(Unidade unidade : raca.listaDeUnidades()){
            if (unidade instanceof Cavaleiro && unidade.getEstado()){
                cavaleiros.add((Cavaleiro) unidade);
            }
        }
        return cavaleiros;
    }

    private static void opcoesCavaleiro(Raca raca){
        if (listaDeCavaleiros(raca).size() == 0){
            System.out.println("Você não possui nenhum cavaleiro");
        }else{
            Cavaleiro cavaleiro = selecionarCavaleiro(raca);
            System.out.println("Selecione uma opção");
            System.out.print("[1] Atacar [2] Mover [3] Ver posição [4] Sair: ");
            switch (selecionarOpcao("[1-4]")){
                case "1": if (verificaAlvo(cavaleiro, raca)) {cavaleiro.atacar(selecionarAlvo(cavaleiro, raca)); deduzirPontosAcao(raca);} else {System.out.println("Nenhum alvo ao seu alcance");} break;
                case "2": cavaleiro.mover(selecionarDirecao()); deduzirPontosAcao(raca); break;
                case "3": cavaleiro.getPosicao().mostrarPosicao(); break;
            }
        }
    }

    //************************* INICIO DOS MÉTODOS DE SACERDOTE *************************
    private static Sacerdote selecionarSacerdote(Raca raca){
        ArrayList<Sacerdote> sacerdotes = listaDeSacerdotes(raca);
        int quantidadeSacerdotes = sacerdotes.size();
        int index;
        if (quantidadeSacerdotes > 1) {
            System.out.printf("Você possui %d sacerdotes. Qual deles(as) deseja acessar? ", quantidadeSacerdotes);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }else{
            index = 1;
        }
        while(index > quantidadeSacerdotes){
            System.out.printf("Você possui apenas %d sacerdotes", quantidadeSacerdotes);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }
        return sacerdotes.get(index - 1);
    }

    private static ArrayList<Sacerdote> listaDeSacerdotes(Raca raca){
        ArrayList<Sacerdote> sacerdotes = new ArrayList<>();
        for(Unidade unidade : raca.listaDeUnidades()){
            if (unidade instanceof Sacerdote && unidade.getEstado()){
                sacerdotes.add((Sacerdote) unidade);
            }
        }
        return sacerdotes;
    }

    private static void opcoesSacerdote(Raca raca){
        if (listaDeSacerdotes(raca).size() == 0){
            System.out.println("Você não possui nenhum sacerdote");
        }else{
            Sacerdote sacerdote = selecionarSacerdote(raca);
            System.out.println("Selecione uma opção");
            System.out.print("[1] Curar [2] Rezar [3] Mover [4] Ver posição [5] Sair: ");
            switch (selecionarOpcao("[1-5]")){
                case "1": if (verificaAliado(sacerdote, raca)) {sacerdote.curar(selecionarAliado(sacerdote, raca)); deduzirPontosAcao(raca);} else {System.out.println("Nenhum aliado ao seu alcance");} break;
                case "2": sacerdote.rezar(); deduzirPontosAcao(raca); break;
                case "3": sacerdote.mover(selecionarDirecao()); deduzirPontosAcao(raca); break;
                case "4": sacerdote.getPosicao().mostrarPosicao(); break;
            }
        }
    }

    //************************* INICIO DOS MÉTODOS DE GRIFO *************************
    private static Grifo selecionarGrifo(Raca raca){
        ArrayList<Grifo> grifos = listaDeGrifos(raca);
        int quantidadeGrifos = grifos.size();
        int index;
        if (quantidadeGrifos > 1) {
            System.out.printf("Você possui %d grifos. Qual deles(as) deseja acessar? ", quantidadeGrifos);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }else{
            index = 1;
        }
        while(index > quantidadeGrifos){
            System.out.printf("Você possui apenas %d grifos", quantidadeGrifos);
            index = Integer.parseInt(selecionarOpcao("[0-9]+"));
        }
        return grifos.get(index - 1);
    }

    private static ArrayList<Grifo> listaDeGrifos(Raca raca){
        ArrayList<Grifo> grifos = new ArrayList<>();
        for(Unidade unidade : raca.listaDeUnidades()){
            if (unidade instanceof Grifo && unidade.getEstado()){
                grifos.add((Grifo) unidade);
            }
        }
        return grifos;
    }

    private static void opcoesGrifo(Raca raca){
        if (listaDeGrifos(raca).size() == 0){
            System.out.println("Você não possui nenhum grifo");
        }else{
            Grifo grifo = selecionarGrifo(raca);
            System.out.println("Selecione uma opção");
            System.out.print("[1] Atacar [2] Mover [3] Ver posição [4] Sair: ");
            switch (selecionarOpcao("[1-4]")){
                case "1": if (verificaAlvo(grifo, raca)) {grifo.atacar(selecionarAlvo(grifo, raca)); deduzirPontosAcao(raca);} else {System.out.println("Nenhum alvo ao seu alcance");} break;
                case "2": grifo.mover(selecionarDirecao()); deduzirPontosAcao(raca); break;
                case "3": grifo.getPosicao().mostrarPosicao(); break;
            }
        }
    }
}
