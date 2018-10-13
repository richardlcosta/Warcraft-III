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
     */

    public void construirCasa() {
        if (getEstado()) {
            Casa casa = new Casa(posicao, raca);
            if (raca.getRecursos().compararRecursos(casa.getRecurso())) {
                raca.addConstrucao(casa);
                System.out.println("Casa construída com sucesso");
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
     */

    public void construirCentro() {
        if (getEstado()) {
            CentroDaCidade centro = new CentroDaCidade(posicao, raca);
            if (raca.getRecursos().compararRecursos(centro.getRecurso())) {
                raca.addConstrucao(centro);
                System.out.println("Centro construído com sucesso");
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
     */

    public void construirTemplo() {
        if (getEstado()) {
            Templo templo = new Templo(posicao, raca);
            if (raca.getRecursos().compararRecursos(templo.getRecurso())) {
                raca.addConstrucao(templo);
                System.out.println("Templo construído com sucesso");
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
     */

    public void construirQuartel() {
        if (getEstado()) {
            Quartel quartel = new Quartel(posicao, raca);
            if (raca.getRecursos().compararRecursos(quartel.getRecurso())) {
                raca.addConstrucao(quartel);
                System.out.println("Quartel construído com sucesso");
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
     */

    public void construirTorre() {
        if (getEstado()) {
            Torre torre = new Torre(posicao, raca);
            if (raca.getRecursos().compararRecursos(torre.getRecurso())) {
                raca.addConstrucao(torre);
                System.out.println("Torre construída com sucesso");
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
            int quant = raca.addComida();
            System.out.printf("O campones colheu %d quilos de comida\n", quant);
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    /**
     * Adiciona 1 de madeira, no total de sua raça
     */

    public void cortar() {
        if (getEstado()) {
            int quant = raca.addMadeira();
            System.out.printf("O campones cortou %d troncos de madeira\n", quant);
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    /**
     * Adiciona 1 de ouro, no total de sua raça
     */

    public void minerar() {
        if (getEstado()) {
            int quant = raca.addOuro();
            System.out.printf("O campones minerou %d pepitas de ouro\n", quant);
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    public Campones(Posicao posicao, Raca raca) {
        super(posicao, "campones.jpg", new Custo(50, 0, 0, 0), true, 50, 3, 2.0, 1, 0, raca);
    }
}
