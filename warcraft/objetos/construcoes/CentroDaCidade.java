package warcraft.objetos.construcoes;

import warcraft.objetos.unidades.*;
import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para os centros de cidade do jogo
 */

public class CentroDaCidade extends Construcao {

    /**
     * Adiciona um camponês na lista de sua respectiva raça
     * @param posicao {String}
     */

    public void criarCampones(String posicao) {
        if (getEstado()) {
            Campones campones = new Campones(posicao, raca);
            if (raca.getRecursos().compararRecursos(campones.getRecurso())) {
                if (raca.calculaPopulacaoMaxima()) {
                    raca.addUnidade(new Campones(posicao, raca));
                } else {
                    Erro.imprimeMensagemErro("POPULACAO_FULL");
                }
                raca.getRecursos().consumirRecursos(campones.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("BUILD_BROKED");
        }
    }

    public CentroDaCidade(String posicao, Raca raca) {
        super(new Posicao(posicao), "centro.jpg", new Custo(0, 0, 200, 0), true, 600, 10, 8, raca);
    }
}
