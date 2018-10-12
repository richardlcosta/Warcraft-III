package warcraft;

import warcraft.objetos.construcoes.*;
import warcraft.objetos.unidades.*;
import warcraft.racas.*;

/**
 *
 * @author Richard
 * @version 2.0
 */

public class Main {

    /**
     * Método Principal
     * @param args {String[]}
     */

    public static void main(String[] args) {
        //AO INSTANCIAR UMA RAÇA, O JOGADOR INICIARÁ POR PADRÃO COM UM CENTRO DE CIDADE E DOIS CAMPONESES
        //CADA RAÇA TAMBÉM INICIA COM A UMA CERTA QUANTIDADE DE RECURSOS

        //INICIALIZANDO A HUMANIDADE
        Humano humanos = new Humano(800,800,800,5);

        //VISUALIZANDO OS MANTIMENTOS INICIAIS
        humanos.verRecursos();

        //ACESSANDO O CENTRO "DE FÁBRICA" PARA CRIAR UM TERCEIRO CAMPONES
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("0 0");

        //ACESSANDO O CAMPONES "DE FÁBRICA" NÚMERO 1, PARA CRIAR UMA CASA
        ((Campones) humanos.getUnidades(0)).construirCasa("0 0");

        //ACESSANDO O CAMPONES NÚMERO 2, PARA CRIAR UM TEMPLO E UM QUARTEL
        ((Campones) humanos.getUnidades(1)).construirTemplo("0 0");
        ((Campones) humanos.getUnidades(1)).construirQuartel("0 0");

        //CRIANDO UM GUERREIRO
        ((Quartel) humanos.getConstrucoes(3)).criarGuerreiro("0 0");

        //ACESSANDO O CAMPONES NÚMERO 3, PARA COLHER, CORTAR E MINERAR
        ((Campones) humanos.getUnidades(2)).colher();
        ((Campones) humanos.getUnidades(2)).cortar();
        ((Campones) humanos.getUnidades(2)).minerar();

        //CONFERINDO O RESULTADOS
        humanos.verRecursos();

        //ACESSANDO O TEMPLO PARA TENTAR CRIAR UM ANDARILHO E CONFERINDO MENSAGEM DE ERRO
        ((Templo) humanos.getConstrucoes(2)).criarAndarilho("0 0");

        //TESTANDO LIMITE DE POPULAÇÃO
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("0 0");
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("0 0");
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("0 0");
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("0 0");
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("0 0");
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("0 0");
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("0 0");
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("0 0");
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("0 0");

        //INICIALIZANDO ORCS
        Orc orcs = new Orc(500,500,500,15);
        ((Campones) orcs.getUnidades(0)).construirQuartel("0 0");

        //TESTANDO ATAQUES CONSECUTIVOS ATÉ A MORTE
        humanos.getUnidades(3).atacar(orcs.getUnidades(0));
        humanos.getUnidades(3).atacar(orcs.getUnidades(0));
        humanos.getUnidades(3).atacar(orcs.getUnidades(0));

        //ATAQUE FINAL
        humanos.getUnidades(3).atacar(orcs.getUnidades(0));
        //TENTANDO ATACAR ALVO MORTO
        humanos.getUnidades(3).atacar(orcs.getUnidades(0));

        //TENTANDO ATACAR UM COMPANHEIRO
        humanos.getUnidades(3).atacar(humanos.getUnidades(0));

        //TENTANDO ATACAR USANDO UMA CASA
        humanos.getConstrucoes(1).atacar(orcs.getUnidades(0));

        //CRIANDO MAIS UM CENTRO PARA AUMENTAR A CAPACIDADE MÁXIMA DE POPULAÇÃO HUMANA
        ((Campones) humanos.getUnidades(0)).construirCentro("0 0");

        //CRIANDO UM SACERDOTE
        ((Templo) humanos.getConstrucoes(2)).criarSacerdote("0 0");

        //RECEBENDO UM ATAQUE DE UM ORC E SENDO CURADO POR UM SACERDOTE
        orcs.getUnidades(1).atacar(humanos.getUnidades(1));
        ((Sacerdote) humanos.getUnidades(12)).curar(humanos.getUnidades(1));

        //TENTANDO CURAR UMA CONSTRUÇÃO
        ((Sacerdote) humanos.getUnidades(12)).curar(humanos.getConstrucoes(1));

        //VERIFICANDO A QUANTIDADE DE MANA
        humanos.verRecursos();

        //REZANDO PARA RECUPERAR MANA
        ((Sacerdote) humanos.getUnidades(12)).rezar();

        //CONFERINDO
        humanos.verRecursos();

        //TENTANDO CURAR UMA UNIDADE COM A VIDA JÁ COMPLETA
        ((Sacerdote) humanos.getUnidades(12)).curar(humanos.getUnidades(1));

        //TENTANDO CURAR SEM MANA
        orcs.getUnidades(1).atacar(humanos.getUnidades(1)); //LEVA ATAQUE
        ((Sacerdote) humanos.getUnidades(12)).curar(humanos.getUnidades(1)); //CURA
        orcs.getUnidades(1).atacar(humanos.getUnidades(1)); //LEVA ATAQUE
        ((Sacerdote) humanos.getUnidades(12)).curar(humanos.getUnidades(1)); //SEM MANA SUFICIENTE

        //TENTANDO CRIAR CONSTRUÇÕES SEM RECURSOS
        ((Campones) humanos.getUnidades(0)).construirCentro("0 0");

        //TENTANDO REALIZAR AÇÕES COM UNIDADES MORTAS
        ((Campones) orcs.getUnidades(0)).construirTorre("0 0");

        //TENTANDO REALIZAR AÇÕES COM CONSTRUÇÕES DESTRUÍDAS
        ((Quartel) orcs.getConstrucoes(1)).criarCavaleiro("0 0");
        for (int i = 0; i < 50; i++) {
            orcs.getUnidades(2).atacar(humanos.getConstrucoes(0));
        }
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("0 0");

        //MOVENDO UM HUMANO
        for (int i = 0; i < 2; i++) {
            humanos.getUnidades(0).mover("Sul");
            humanos.getUnidades(0).mover("Leste");
        }

        //TENTANDO ATACAR UM INIMIGO DISTANTE
        humanos.getUnidades(0).atacar(orcs.getUnidades(1));

        //CRIANDO UM ARQUEIRO E ATACANDO O ALVO DISTANTE
        ((Quartel) orcs.getConstrucoes(1)).criarArqueiro("0 0");
        for (int i = 0; i < 10; i++) {
            orcs.getUnidades(3).atacar(humanos.getUnidades(0));
        }

        //CRIANDO UM TEMPLO ORCS, UM ANDARILHO E TESTANDO SEUS MÉTODOS
        ((Campones) orcs.getUnidades(1)).construirTemplo("0 0");
        ((Templo) orcs.getConstrucoes(2)).criarAndarilho("0 0");

        //REVIVENDO UMA UNIDADE ALIADA
        ((AndarilhoEspiritual) orcs.getUnidades(4)).revive(orcs.getUnidades(0));

        //VERIFICANDO A QUANTIDADE DE UNIDADES HUMANAS e ORCS VIVAS OU MORTAS ANTES DE REVIVER UM CAMPONES HUMANO
        System.out.println("Total de unidades humanas: " + humanos.totalUnidades());
        System.out.println("Total de unidades orcs: " + orcs.totalUnidades());

        //REVIVENDO UMA UNIDADE INIMIGA
        ((AndarilhoEspiritual) orcs.getUnidades(4)).revive(humanos.getUnidades(0));

        //TESTANDO SE A UNIDADE FOI REALMENTE DOMINADA
        System.out.println("Total de unidades humanas: " + humanos.totalUnidades());
        System.out.println("Total de unidades orcs: " + orcs.totalUnidades());

        //CRIANDO UM GRIFO E TESTANDO SE RECEBE ATAQUE DE UNIDADES DE CURTO ALCANCE
        for (int i = 0; i < 1000; i++) {
            ((Campones) humanos.getUnidades(0)).colher();
            ((Campones) humanos.getUnidades(0)).cortar();
            ((Campones) humanos.getUnidades(0)).minerar();
        }
        ((Campones) humanos.getUnidades(0)).construirCentro("0 0");
        ((Quartel) humanos.getConstrucoes(3)).criarGrifo("0 0");
        orcs.getUnidades(0).atacar(humanos.getUnidades(12));

        //TESTANDO O ATAQUE EM ÁREA DO GRIFO
        System.out.println(orcs.getUnidades(0).getVida()); //CAMPONES - POSIÇÃO ATUAL 0 0 - VIDA 50
        orcs.getUnidades(0).mover("Sul");
        orcs.getUnidades(0).mover("Sul"); //POSIÇÃO ATUAL 0 -4 NÃO SERÁ AFETADO PELO DANO EM ÁREA

        System.out.println(orcs.getUnidades(1).getVida()); //CAMPONES 2 - POSIÇÃO ATUAL 0 0 - VIDA 50
        orcs.getUnidades(1).mover("Sul"); //POSIÇÃO ATUAL 0 -2 DEVERÁ SER AFETADO PELO DANO EM ÁREA

        humanos.getUnidades(12).atacar(orcs.getUnidades(2)); //GRIFO POSIÇÃO 0 0 ATACA UM CAVALEIRO ORC TAMBÉM POSIÇÃO 0 0

        //VERIFICANDO A VIDA DO PRIMEIRO CAMPONES
        System.out.println(orcs.getUnidades(0).getVida());//NÃO FOI AFETADO

        //VERIFICANDO A VIDA DO SEGUNDO CAMPONES
        System.out.println(orcs.getUnidades(1).getVida());//FOI AFETADO

        //TESTANDO SE O ATAQUE EM ÁREA DO GRIFO "REALMENTE MATA UNIDADES"
        humanos.getUnidades(12).atacar(orcs.getUnidades(2));
        humanos.getUnidades(12).atacar(orcs.getUnidades(2));

        //TENTANDO USAR A UNIDADE QUE FOI MORTA PELO ATAQUE EM ÁREA
        orcs.getUnidades(1).mover("Norte");

        //TESTANDO EXTINÇÃO DE UMA RAÇA, USAREI VÁRIOS LAÇOS FOR PARA FACILITAR A ELIMINAÇÃO
        orcs.getUnidades(0).mover("Norte");
        orcs.getUnidades(0).mover("Norte");
        for (int i = 0; i < 4; i++) {
            humanos.getUnidades(2).atacar(orcs.getUnidades(0));
        }
        for (int i = 0; i < 13; i++) {
            humanos.getUnidades(2).atacar(orcs.getUnidades(2));
        }
        for (int i = 0; i < 5; i++) {
            humanos.getUnidades(2).atacar(orcs.getUnidades(4));
        }
        orcs.getUnidades(5).mover("Norte");
        orcs.getUnidades(5).mover("Norte");
        orcs.getUnidades(5).mover("Oeste");
        orcs.getUnidades(5).mover("Oeste");
        for (int i = 0; i < 4; i++) {
            humanos.getUnidades(2).atacar(orcs.getUnidades(5));
        }
        for (int i = 0; i < 42; i++) {
            humanos.getUnidades(2).atacar(orcs.getConstrucoes(0));
        }
        for (int i = 0; i < 23; i++) {
            humanos.getUnidades(2).atacar(orcs.getConstrucoes(1));
        }
        for (int i = 0; i < 23; i++) {
            humanos.getUnidades(2).atacar(orcs.getConstrucoes(2));
        }
    }
}
