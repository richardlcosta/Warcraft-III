package warcraft.objetos.construcoes;

import warcraft.objetos.Objeto;
import warcraft.racas.Raca;
import warcraft.util.*;

public class Construcao extends Objeto {
    private int alcance = 0;

    public Construcao(Posicao posicao, String imagem, Recurso recurso, boolean estado, int vidaMax, int ataque, int alcance, Raca raca) {
        super(posicao, imagem, recurso, estado, vidaMax, ataque, raca);
    }
}
