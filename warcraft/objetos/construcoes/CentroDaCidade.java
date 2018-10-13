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
     */

    public void criarCampones() {
        if (getEstado()) {
            Campones campones = new Campones(posicao, raca);
            if (raca.getRecursos().compararRecursos(campones.getRecurso())) {
                if (raca.calculaPopulacaoMaxima()) {
                    raca.addUnidade(new Campones(new Posicao(String.format("%.0f %.0f",posicao.getX(), posicao.getY())), raca));
                    System.out.println("Campones criado com sucesso");
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

    public CentroDaCidade(Posicao posicao, Raca raca) {
        super(posicao, "centro.jpg", new Custo(0, 0, 200, 0), true, 600, 10, 8, raca);
    }
}
