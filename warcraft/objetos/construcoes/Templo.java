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
     */

    public void criarSacerdote() {
        if (getEstado()) {
            Sacerdote sacerdote = new Sacerdote(posicao, raca);
            if (raca.getRecursos().compararRecursos(sacerdote.getRecurso())) {
                if (raca.calculaPopulacaoMaxima()) {
                    raca.addUnidade(new Sacerdote(posicao, raca));
                    System.out.println("Sacerdote criado com sucesso");
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
     */

    public void criarAndarilho() {
        if (getEstado()) {
            AndarilhoEspiritual andarilhoEspiritual = new AndarilhoEspiritual(posicao, raca);
            if (raca.getRecursos().compararRecursos(andarilhoEspiritual.getRecurso())) {
                if (raca.calculaPopulacaoMaxima()) {
                    if (raca instanceof Humano) {
                        Erro.imprimeMensagemErro("ORCS_ONLY");
                    } else {
                        raca.addUnidade(new AndarilhoEspiritual(posicao, raca));
                        System.out.println("Andarilho criado com sucesso");
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

    public Templo(Posicao posicao, Raca raca) {
        super(posicao, "templo.jpg", new Custo(0, 0, 250, 0), true, 350, 0, 0, raca);
    }
}
