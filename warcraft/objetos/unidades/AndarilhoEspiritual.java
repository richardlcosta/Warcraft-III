package warcraft.objetos.unidades;

import warcraft.util.Custo;
import warcraft.util.Posicao;

public class AndarilhoEspiritual extends Unidade{

    public AndarilhoEspiritual(String posicao) {
        super(new Posicao(posicao), "andarilho.jpg", new Custo(170,0,40,0), true, 100,2,1.0,10,2);
    }
}
