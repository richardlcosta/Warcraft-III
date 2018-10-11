package warcraft.objetos.construcoes;

import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para as torres do jogo
 */

public class Torre extends Construcao {

    public Torre(String posicao, Raca raca) {
        super(new Posicao(posicao), "torre.jpg", new Custo(0, 0, 70, 0), true, 200, 20, 7, raca);
    }
}
