package warcraft.objetos.construcoes;

import warcraft.racas.Raca;
import warcraft.util.*;

public class Casa extends Construcao {

    public Casa(String posicao, Raca raca) {
        super(new Posicao(posicao), "casa.jpg", new Recurso(0, 0, 30, 0), true, 75, 0, 0, raca);
    }
}
