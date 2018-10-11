package warcraft;

import warcraft.objetos.construcoes.*;
import warcraft.objetos.unidades.*;
import warcraft.racas.*;

public class Main {

    public static void main(String[] args) {
        //AO INSTANCIAR UMA RAÇA, O JOGADOR INICIARÁ POR PADRÃO COM UM CENTRO DE CIDADE E DOIS CAMPONESES

        //INICIALIZANDO A HUMANIDADE
        Humano humanos = new Humano();

        //ACESSANDO O CENTRO "DE FÁBRICA" PARA CRIAR UM TERCEIRO CAMPONES
        ((CentroDaCidade) humanos.getConstrucoes(0)).criarCampones("10 10");

        //ACESSANDO O CAMPONES "DE FÁBRICA" NÚMERO 1, PARA CRIAR UMA CASA
        ((Campones) humanos.getUnidades(0)).construirCasa("15 15");

        //ACESSANDO O CAMPONES NÚMERO 3, PARA CRIAR UM TEMPLO
        ((Campones) humanos.getUnidades(2)).construirTemplo("20 20");

        //ACESSANDO O TEMPLO PARA TENTAR CRIAR UM ANDARILHO E CONFERINDO MENSAGEM DE ERRO
        ((Templo) humanos.getConstrucoes(2)).criarAndarilho("5 5");


    }
}
