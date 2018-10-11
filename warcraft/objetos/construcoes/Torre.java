package warcraft.objetos.construcoes;

import warcraft.racas.Raca;
import warcraft.util.*;

public class Torre extends Construcao {

    public Torre(String posicao, Raca raca) {
        super(new Posicao(posicao), "torre.jpg", new Recurso(0, 0, 70, 0), true, 200, 20, 7, raca);
    }
}
