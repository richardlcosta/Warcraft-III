package warcraft.objetos.unidades;

import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para os grifos do jogo
 */

public class Grifo extends Unidade {

    public Grifo(String posicao, Raca raca) {
        super(new Posicao(posicao), "grifo.jpg", new Custo(200, 40, 0, 0), true, 300, 20, 4.0, 7, 7, raca);
        this.unidadeAerea = true;
    }
}
