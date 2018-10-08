package warcraft.objetos.construcoes;

import warcraft.util.*;

public class Quartel extends Construcao{

    public Quartel(String posicao) {
        super(new Posicao(posicao), "quartel.jpg", new Custo(0,0,125,0), true, 350,0,0);
    }
}
