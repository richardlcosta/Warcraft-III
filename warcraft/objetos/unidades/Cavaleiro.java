package warcraft.objetos.unidades;

import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para os cavaleiros do jogo
 */

public class Cavaleiro extends Unidade {

    public Cavaleiro(String posicao, Raca raca) {
        super(new Posicao(posicao), "cavaleiro.jpg", new Custo(70, 80, 0, 0), true, 180, 12, 4.0, 1, 3, raca);
    }
}
