package warcraft.objetos.construcoes;

import warcraft.objetos.unidades.*;
import warcraft.racas.Humano;
import warcraft.racas.Raca;
import warcraft.util.*;

public class Templo extends Construcao {

    public void criarSacerdote(String posicao) {
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
    }

    public void criarAndarilho(String posicao) {
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
    }

    public Templo(String posicao, Raca raca) {
        super(new Posicao(posicao), "templo.jpg", new Recurso(0, 0, 250, 0), true, 350, 0, 0, raca);
    }
}
