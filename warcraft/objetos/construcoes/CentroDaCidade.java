package warcraft.objetos.construcoes;

import warcraft.objetos.unidades.*;
import warcraft.util.*;

public class CentroDaCidade extends Construcao {

    public Campones criarCampones(String posicao) {
        return new Campones(posicao);
    }

    public CentroDaCidade(String posicao) {
        super(new Posicao(posicao), "centro.jpg", new Custo(0,0,200,0), true, 600, 10, 8);
    }
}
