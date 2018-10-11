package warcraft.objetos.unidades;

import warcraft.racas.Raca;
import warcraft.util.Recurso;
import warcraft.util.Posicao;

public class Grifo extends Unidade {

    public Grifo(String posicao, Raca raca) {
        super(new Posicao(posicao), "grifo.jpg", new Recurso(200, 40, 0, 0), true, 300, 20, 4.0, 7, 7, raca);
    }
}
