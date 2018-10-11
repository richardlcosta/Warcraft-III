package warcraft.objetos.unidades;

import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para os arqueiros do jogo
 */

public class Arqueiro extends Unidade {

    public Arqueiro(String posicao, Raca raca) {
        super(new Posicao(posicao), "arqueiro.jpg", new Custo(40, 20, 0, 0), true, 45, 5, 2.0, 7, 0, raca);
    }
}
