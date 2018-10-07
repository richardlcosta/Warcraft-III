package warcraft;

import warcraft.objetos.construcoes.*;
import warcraft.racas.*;

public class Main {

    public static void main(String[] args) {
        //INICIALIZANDO A HUMANIDADE
        Humano humanos = new Humano();

        //CRIANDO UM CENTRO DE CIDADE
        CentroDaCidade centro = new CentroDaCidade("10 10");

        //USANDO O CENTRO DE CIDADE PARA CRIAR UM CAMPONES NA POSIÇÃO 25 23
        humanos.adicionarUnidade(centro.criarCampones("25 23"));

        //MOVENDO O CAMPONES PARA O NORTE
        humanos.getUnidades().get(0).mover("Norte");

        //CONFERINDO SE DEU CERTO
        humanos.getUnidades().get(0).getPosicao().mostrarPosicao();


    }
}
