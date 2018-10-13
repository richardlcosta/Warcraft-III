package warcraft.racas;

import warcraft.util.Recurso;

/**
 * Molde para os orcs do jogo
 */

public class Orc extends Raca {

    public Orc(int comida, int ouro,int madeira, int mana, String posicao) {
        super(new Recurso(comida, ouro, madeira, mana), posicao);
    }
}
