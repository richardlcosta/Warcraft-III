package warcraft.racas;

import warcraft.util.Recurso;

/**
 * Molde para os humanos do jogo
 */

public class Humano extends Raca {

    public Humano(int comida, int ouro, int madeira, int mana) {
        super(new Recurso(comida, ouro, madeira, mana));
    }
}
