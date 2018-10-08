package warcraft.objetos.construcoes;

import warcraft.util.*;

public class Casa extends Construcao{

    public Casa(String posicao) {
        super(new Posicao(posicao), "casa.jpg", new Custo(0,0,30,0), true, 75,0,0);
    }
}
