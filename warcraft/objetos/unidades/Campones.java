package warcraft.objetos.unidades;

import warcraft.objetos.construcoes.*;
import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para os camponeses do jogo
 */

public class Campones extends Unidade {

    /**
     * Adiciona uma casa na lista de construções da sua respectiva raça
     * @param posicao {String}
     */

    public void construirCasa(String posicao) {
        if (getEstado()) {
            Casa casa = new Casa(posicao, raca);
            if (raca.getRecursos().compararRecursos(casa.getRecurso())) {
                raca.addConstrucao(casa);
                raca.getRecursos().consumirRecursos(casa.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    /**
     * Adiciona um centro de cidade na lista de construções da sua respectiva raça
     * @param posicao {String}
     */

    public void construirCentro(String posicao) {
        if (getEstado()) {
            CentroDaCidade centro = new CentroDaCidade(posicao, raca);
            if (raca.getRecursos().compararRecursos(centro.getRecurso())) {
                raca.addConstrucao(centro);
                raca.getRecursos().consumirRecursos(centro.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    /**
     * Adiciona um templo na lista de construções da sua respectiva raça
     * @param posicao {String}
     */

    public void construirTemplo(String posicao) {
        if (getEstado()) {
            Templo templo = new Templo(posicao, raca);
            if (raca.getRecursos().compararRecursos(templo.getRecurso())) {
                raca.addConstrucao(templo);
                raca.getRecursos().consumirRecursos(templo.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    /**
     * Adiciona um quartel na lista de construções da sua respectiva raça
     * @param posicao {String}
     */

    public void construirQuartel(String posicao) {
        if (getEstado()) {
            Quartel quartel = new Quartel(posicao, raca);
            if (raca.getRecursos().compararRecursos(quartel.getRecurso())) {
                raca.addConstrucao(quartel);
                raca.getRecursos().consumirRecursos(quartel.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    /**
     * Adiciona uma torre na lista de construções da sua respectiva raça
     * @param posicao {String}
     */

    public void construirTorre(String posicao) {
        if (getEstado()) {
            Torre torre = new Torre(posicao, raca);
            if (raca.getRecursos().compararRecursos(torre.getRecurso())) {
                raca.addConstrucao(torre);
                raca.getRecursos().consumirRecursos(torre.getRecurso());
            } else {
                Erro.imprimeMensagemErro("RECURSOS_404");
            }
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    /**
     * Adiciona 1 de comida, no total de sua raça
     */

    public void colher() {
        if (getEstado()) {
            raca.addComida();
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    /**
     * Adiciona 1 de madeira, no total de sua raça
     */

    public void cortar() {
        if (getEstado()) {
            raca.addMadeira();
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    /**
     * Adiciona 1 de ouro, no total de sua raça
     */

    public void minerar() {
        if (getEstado()) {
            raca.addOuro();
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    public Campones(String posicao, Raca raca) {
        super(new Posicao(posicao), "campones.jpg", new Custo(50, 0, 0, 0), true, 50, 3, 2.0, 1, 0, raca);
    }
}
