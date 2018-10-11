package warcraft.objetos.construcoes;

import warcraft.objetos.unidades.*;
import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para os templos do jogo
 */

public class Templo extends Construcao {

    /**
     * Adiciona um sacerdote na lista de sua respectiva raça
     * @param posicao {String}
     */

    public void criarSacerdote(String posicao) {
        if (getEstado()) {
            Sacerdote sacerdote = new Sacerdote(posicao, raca);
            if (raca.getRecursos().compararRecursos(sacerdote.getRecurso())) {
                if (raca.calculaPopulacaoMaxima()) {
                    raca.addUnidade(new Sacerdote(posicao, raca));
                } else {
                    Erro.imprimeMensagemErro("POPULACAO_FULL");
                }
                raca.getRecursos().consumirRecursos(sacerdote.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("BUILD_BROKED");
        }
    }

    /**
     * Adiciona um andarilho na lista de sua respectiva raça
     * @param posicao {String}
     */

    public void criarAndarilho(String posicao) {
        if (getEstado()) {
            AndarilhoEspiritual andarilhoEspiritual = new AndarilhoEspiritual(posicao, raca);
            if (raca.getRecursos().compararRecursos(andarilhoEspiritual.getRecurso())) {
                if (raca.calculaPopulacaoMaxima()) {
                    if (raca instanceof Humano) {
                        Erro.imprimeMensagemErro("ORCS_ONLY");
                    } else {
                        raca.addUnidade(new AndarilhoEspiritual(posicao, raca));
                    }
                } else {
                    Erro.imprimeMensagemErro("POPULACAO_FULL");
                }
                raca.getRecursos().consumirRecursos(andarilhoEspiritual.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("BUILD_BROKED");
        }
    }

    public Templo(String posicao, Raca raca) {
        super(new Posicao(posicao), "templo.jpg", new Custo(0, 0, 250, 0), true, 350, 0, 0, raca);
    }
}
