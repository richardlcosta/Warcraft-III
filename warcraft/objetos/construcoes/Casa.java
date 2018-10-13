package warcraft.objetos.construcoes;

import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para as casas do jogo
 */

public class Casa extends Construcao {

    public Casa(Posicao posicao, Raca raca) {
        super(posicao, "casa.jpg", new Custo(0, 0, 30, 0), true, 75, 0, 0, raca);
    }
}
