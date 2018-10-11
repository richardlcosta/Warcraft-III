package warcraft.objetos.construcoes;

import warcraft.objetos.unidades.*;
import warcraft.racas.Raca;
import warcraft.util.*;

public class CentroDaCidade extends Construcao {

    public void criarCampones(String posicao) {
        raca.addUnidade(new Campones(posicao, raca));
    }

    public CentroDaCidade(String posicao, Raca raca) {
        super(new Posicao(posicao), "centro.jpg", new Custo(0, 0, 200, 0), true, 600, 10, 8, raca);
    }
}
