package warcraft.objetos.unidades;

import warcraft.racas.Raca;
import warcraft.util.*;

public class AndarilhoEspiritual extends Unidade {

    public AndarilhoEspiritual(String posicao, Raca raca) {
        super(new Posicao(posicao), "andarilho.jpg", new Recurso(170, 40, 0, 0), true, 100, 2, 1.0, 10, 2, raca);
    }
}
