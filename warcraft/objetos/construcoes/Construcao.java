package warcraft.objetos.construcoes;

import warcraft.objetos.*;
import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para as construções do jogo
 */

public class Construcao extends Objeto {

    public Construcao(Posicao posicao, String imagem, Custo custo, boolean estado, int vidaMax, int ataque, int alcance, Raca raca) {
        super(posicao, imagem, custo, estado, vidaMax, ataque, alcance, raca);
    }
}
