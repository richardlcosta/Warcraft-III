package warcraft;

import warcraft.objetos.construcoes.*;
import warcraft.racas.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //INICIALIZANDO A HUMANIDADE
        Humano humanos = new Humano();

        //CRIANDO UM CENTRO DE CIDADE
        CentroDaCidade centro = new CentroDaCidade("10 10");
        humanos.addCentro(centro);

        //USANDO O CENTRO DE CIDADE PARA CRIAR UM CAMPONES NA POSIÇÃO 25 23
        humanos.addCampones(centro.criarCampones("25 23"));

        //MOVENDO O CAMPONES PARA O NORTE E PARA O LEST
        humanos.getCampones(1).mover("Norte");
        humanos.getCampones(1).mover("Leste");

        //CONFERINDO O MOVIMENTO
        humanos.getCampones(1).getPosicao().mostrarPosicao();

        //CONSTRUINDO OUTRO CENTRO A PARTIR DE UM CAMPONES
        humanos.addCentro(humanos.getCampones(1).construirCentro("25 27"));

    }
}
