package warcraft.objetos.unidades;

import warcraft.racas.Raca;
import warcraft.util.Custo;
import warcraft.util.Posicao;

public class Grifo extends Unidade {

    public Grifo(String posicao, Raca raca) {
        super(new Posicao(posicao), "grifo.jpg", new Custo(200, 0, 40, 0), true, 300, 20, 4.0, 7, 7, raca);
    }
}
