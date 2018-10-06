package warcraft;

import warcraft.objetos.construcoes.*;
import warcraft.racas.*;

public class Main {

    public static void main(String[] args) {
        Humano humanos = new Humano();
        CentroDaCidade centro = new CentroDaCidade("10 10");
        humanos.adicionarUnidade(centro.criarCampones("25 23"));


    }
}
