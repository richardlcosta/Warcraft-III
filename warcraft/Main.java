package warcraft;

import warcraft.objetos.construcoes.*;
import warcraft.objetos.unidades.*;
import warcraft.racas.*;

public class Main {

    public static void main(String[] args) {
        //AO INSTANCIAR UMA RAÇA, O JOGADOR INICIARÁ POR PADRÃO COM UM CENTRO DE CIDADE E DOIS CAMPONESES
        //PARA FINS DE TESTES O JOGADOR TAMBÉM INICIA COM 300 DE CADA MANTIMENTO E 5 DE MANA

        //INICIALIZANDO A HUMANIDADE
        Humano humanos = new Humano();

        //VISUALIZANDO OS MANTIMENTOS INICIAIS
        humanos.verRecursos();

        //ACESSANDO O CENTRO "DE FÁBRICA" PARA CRIAR UM TERCEIRO CAMPONES
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("10 10");

        //ACESSANDO O CAMPONES "DE FÁBRICA" NÚMERO 1, PARA CRIAR UMA CASA
        ((Campones) humanos.getUnidades(0)).construirCasa("15 15");

        //ACESSANDO O CAMPONES NÚMERO 2, PARA CRIAR UM TEMPLO E UM QUARTEL
        ((Campones) humanos.getUnidades(1)).construirTemplo("20 20");
        ((Campones) humanos.getUnidades(1)).construirQuartel("25 25");

        //CRIANDO UM GUERREIRO
        ((Quartel) humanos.getConstrucoes(3)).criarGuerreiro("0 0");

        //ACESSANDO O CAMPONES NÚMERO 3, PARA COLHER, CORTAR E MINERAR
        ((Campones) humanos.getUnidades(2)).colher();
        ((Campones) humanos.getUnidades(2)).cortar();
        ((Campones) humanos.getUnidades(2)).minerar();

        //CONFERINDO O RESULTADOS
        humanos.verRecursos();

        //ACESSANDO O TEMPLO PARA TENTAR CRIAR UM ANDARILHO E CONFERINDO MENSAGEM DE ERRO
        ((Templo) humanos.getConstrucoes(2)).criarAndarilho("5 5");

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
        Orc orcs = new Orc();
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
        ((Campones) humanos.getUnidades(0)).construirCentro("2 2");

        //CRIANDO UM SACERDOTE
        ((Templo) humanos.getConstrucoes(2)).criarSacerdote("30 30");

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
        ((Campones) humanos.getUnidades(0)).construirCentro("50 50");

    }
}
