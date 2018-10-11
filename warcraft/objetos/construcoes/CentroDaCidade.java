package warcraft.objetos.construcoes;

import warcraft.objetos.unidades.*;
import warcraft.racas.Raca;
import warcraft.util.*;

public class CentroDaCidade extends Construcao {

    public void criarCampones(String posicao) {
        Campones campones = new Campones(posicao, raca);
        if(raca.getRecursos().compararRecursos(campones.getRecurso())) {
            if(raca.calculaPopulacaoMaxima()) {
                raca.addUnidade(new Campones(posicao, raca));
            }else{
                Erro.imprimeMensagemErro("POPULACAO_FULL");
            }
            raca.getRecursos().consumirRecursos(campones.getRecurso());
        }else{
            Erro.imprimeMensagemErro("RECURSOS_404");
        }
    }

    public CentroDaCidade(String posicao, Raca raca) {
        super(new Posicao(posicao), "centro.jpg", new Recurso(0, 0, 200, 0), true, 600, 10, 8, raca);
    }
}
