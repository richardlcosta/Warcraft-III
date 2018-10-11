package warcraft.objetos.construcoes;

import warcraft.racas.*;
import warcraft.util.*;
import warcraft.objetos.unidades.*;

public class Quartel extends Construcao {

    public void criarGuerreiro(String posicao) {
        Guerreiro guerreiro = new Guerreiro(posicao, raca);
        if(raca.getRecursos().compararRecursos(guerreiro.getRecurso())) {
            if(raca.calculaPopulacaoMaxima()) {
                raca.addUnidade(new Guerreiro(posicao, raca));
            }else{
                Erro.imprimeMensagemErro("POPULACAO_FULL");
            }
            raca.getRecursos().consumirRecursos(guerreiro.getRecurso());
        }else{
            Erro.imprimeMensagemErro("RECURSOS_404");
        }
    }

    public void criarCavaleiro(String posicao) {
        Cavaleiro cavaleiro = new Cavaleiro(posicao, raca);
        if(raca.getRecursos().compararRecursos(cavaleiro.getRecurso())) {
            if(raca.calculaPopulacaoMaxima()) {
                raca.addUnidade(new Cavaleiro(posicao, raca));
            }else{
                Erro.imprimeMensagemErro("POPULACAO_FULL");
            }
            raca.getRecursos().consumirRecursos(cavaleiro.getRecurso());
        }else{
            Erro.imprimeMensagemErro("RECURSOS_404");
        }
    }

    public void criarArqueiro(String posicao) {
        Arqueiro arqueiro = new Arqueiro(posicao, raca);
        if(raca.getRecursos().compararRecursos(arqueiro.getRecurso())) {
            if(raca.calculaPopulacaoMaxima()) {
                raca.addUnidade(new Arqueiro(posicao, raca));
            }else{
                Erro.imprimeMensagemErro("POPULACAO_FULL");
            }
            raca.getRecursos().consumirRecursos(arqueiro.getRecurso());
        }else{
            Erro.imprimeMensagemErro("RECURSOS_404");
        }
    }

    public void criarGrifo(String posicao) {
        Grifo grifo = new Grifo(posicao, raca);
        if(raca.getRecursos().compararRecursos(grifo.getRecurso())) {
            if(raca.calculaPopulacaoMaxima()) {
                if (raca instanceof Orc) {
                    Erro.imprimeMensagemErro("HUMANOS_ONLY");
                } else {
                    raca.addUnidade(new Grifo(posicao, raca));
                }
            }else{
                Erro.imprimeMensagemErro("POPULACAO_FULL");
            }
            raca.getRecursos().consumirRecursos(grifo.getRecurso());
        }else{
            Erro.imprimeMensagemErro("RECURSOS_404");
        }
    }

    public Quartel(String posicao, Raca raca) {
        super(new Posicao(posicao), "quartel.jpg", new Recurso(0, 0, 125, 0), true, 350, 0, 0, raca);
    }
}
