package warcraft.objetos.unidades;

import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para os andarilhos do jogo
 */

public class AndarilhoEspiritual extends Unidade {

    /**
     * Revive um aliado, ou um inimigo, neste caso, trazendo-o para a sua lista de unidades
     * @param unidade {Unidade}
     */

    public void revive(Unidade unidade) {
        if (getEstado()) {
            if (unidade.getEstado()) {
                Erro.imprimeMensagemErro("IS_ALIVE");
            } else if (raca.getRecursos().getMana() < 5) {
                Erro.imprimeMensagemErro("RECURSOS_404");
            } else {
                unidade.setEstado(true);
                unidade.setVida(unidade.getVidaMax());
                System.out.println("O alvo foi revivido com vida máxima");
                raca.getRecursos().consumirRecursos(0, 0, 0, 5);
                if (!(unidade.getRaca().equals(raca))) {
                    raca.trocarRaca(raca, unidade);
                    System.out.println("A unidade inimiga agora está sob seus comandos");
                }
            }
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    public AndarilhoEspiritual(Posicao posicao, Raca raca) {
        super(posicao, "andarilho.jpg", new Custo(170, 40, 0, 0), true, 100, 2, 1.0, 10, 2, raca);
    }
}
