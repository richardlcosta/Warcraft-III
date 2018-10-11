package warcraft.objetos.unidades;

import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para os guerreiros do jogo
 */

public class Guerreiro extends Unidade {

    public Guerreiro(String posicao, Raca raca) {
        super(new Posicao(posicao), "guerreiro.jpg", new Custo(35, 15, 0, 0), true, 160, 13, 1.8, 1, 2, raca);
    }
}
