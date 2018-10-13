package warcraft.objetos.construcoes;

import warcraft.racas.*;
import warcraft.util.*;
import warcraft.objetos.unidades.*;

/**
 * Molde para os quartéis do jogo
 */

public class Quartel extends Construcao {

    /**
     * Adiciona um guerreiro na lista de sua respectiva raça
     */

    public void criarGuerreiro() {
        if (getEstado()) {
            Guerreiro guerreiro = new Guerreiro(posicao, raca);
            if (raca.getRecursos().compararRecursos(guerreiro.getRecurso())) {
                if (raca.calculaPopulacaoMaxima()) {
                    raca.addUnidade(new Guerreiro(posicao, raca));
                    System.out.println("Guerreiro criado com sucesso");
                } else {
                    Erro.imprimeMensagemErro("POPULACAO_FULL");
                }
                raca.getRecursos().consumirRecursos(guerreiro.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("BUILD_BROKED");
        }
    }

    /**
     * Adiciona um cavaleiro na lista de sua respectiva raça
     */

    public void criarCavaleiro() {
        if (getEstado()) {
            Cavaleiro cavaleiro = new Cavaleiro(posicao, raca);
            if (raca.getRecursos().compararRecursos(cavaleiro.getRecurso())) {
                if (raca.calculaPopulacaoMaxima()) {
                    raca.addUnidade(new Cavaleiro(posicao, raca));
                    System.out.println("Cavaleiro criado com sucesso");
                } else {
                    Erro.imprimeMensagemErro("POPULACAO_FULL");
                }
                raca.getRecursos().consumirRecursos(cavaleiro.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("BUILD_BROKED");
        }
    }

    /**
     * Adiciona um arqueiro na lista de sua respectiva raça
     */

    public void criarArqueiro() {
        if (getEstado()) {
            Arqueiro arqueiro = new Arqueiro(posicao, raca);
            if (raca.getRecursos().compararRecursos(arqueiro.getRecurso())) {
                if (raca.calculaPopulacaoMaxima()) {
                    raca.addUnidade(new Arqueiro(posicao, raca));
                    System.out.println("Arqueiro criado com sucesso");
                } else {
                    Erro.imprimeMensagemErro("POPULACAO_FULL");
                }
                raca.getRecursos().consumirRecursos(arqueiro.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("BUILD_BROKED");
        }
    }

    /**
     * Adiciona um grifo na lista de sua respectiva raça
     */

    public void criarGrifo() {
        if (getEstado()) {
            Grifo grifo = new Grifo(posicao, raca);
            if (raca.getRecursos().compararRecursos(grifo.getRecurso())) {
                if (raca.calculaPopulacaoMaxima()) {
                    if (raca instanceof Orc) {
                        Erro.imprimeMensagemErro("HUMANOS_ONLY");
                    } else {
                        raca.addUnidade(new Grifo(posicao, raca));
                        System.out.println("Grifo criado com sucesso");
                    }
                } else {
                    Erro.imprimeMensagemErro("POPULACAO_FULL");
                }
                raca.getRecursos().consumirRecursos(grifo.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("BUILD_BROKED");
        }
    }

    public Quartel(Posicao posicao, Raca raca) {
        super(posicao, "quartel.jpg", new Custo(0, 0, 125, 0), true, 350, 0, 0, raca);
    }
}
