package warcraft.racas;

import warcraft.objetos.construcoes.*;
import warcraft.objetos.unidades.*;
import warcraft.util.*;
import java.util.ArrayList;

/**
 * Molde para as raças do jogo
 */

public abstract class Raca {
    private Recurso recursos;
    private int capacidadeMax;
    private int numeroUnidades;
    private int numeroConstrucoes;
    private Posicao posicaoInicial;
    private ArrayList<Unidade> unidades = new ArrayList<>();
    private ArrayList<Construcao> construcoes = new ArrayList<>();

    public ArrayList<Unidade> listaDeUnidades() {
        return unidades;
    }

    public ArrayList<Construcao> listaDeConstrucoes() {
        return construcoes;
    }

    public Unidade getUnidades(int index) {
        return unidades.get(index);
    }

    public Construcao getConstrucoes(int index) {
        return construcoes.get(index);
    }

    public void addUnidade(Unidade unidade) {
        unidades.add(unidade);
    }

    public void addConstrucao(Construcao construcao) {
        construcoes.add(construcao);
    }

    public Recurso getRecursos() {
        return recursos;
    }

    public int addComida() {
        int quant = (int) (Math.random() * (50 - 20)) + 20;
        this.recursos.addRecursos(quant, 0, 0, 0);
        return quant;
    }

    public int addOuro() {
        int quant = (int) (Math.random() * (50 - 20)) + 20;
        this.recursos.addRecursos(0, quant, 0, 0);
        return quant;
    }

    public int addMadeira() {
        int quant = (int) (Math.random() * (50 - 20)) + 20;
        this.recursos.addRecursos(0, 0, quant, 0);
        return quant;
    }

    public void addMana(int quant) {
        this.recursos.addRecursos(0, 0, 0, quant);
    }

    /**
     * Consome recursos para a criação de unidades e construções
     * @param quant {int}
     */

    public void consumirMana(int quant) {
        this.recursos.consumirRecursos(new Recurso(0, 0, 0, quant));
    }

    /**
     * Exibe na tela os recursos atuais
     */

    public void verRecursos() {
        System.out.printf("Comida:%d Ouro:%d Madeira:%d Mana:%d\n", recursos.getComida(), recursos.getOuro(), recursos.getMadeira(), recursos.getMana());
    }

    /**
     * Verifica se é possível criar unidades
     * @return boolean
     */

    public boolean calculaPopulacaoMaxima() {
        capacidadeMax = 0;
        for (Construcao construcao : construcoes) {
            if (construcao.getEstado()) {
                if (construcao instanceof Casa) {
                    capacidadeMax += 2;
                } else if (construcao instanceof CentroDaCidade) {
                    capacidadeMax += 10;
                }
            }
        }
        return unidades.size() < capacidadeMax;
    }

    /**
     * Calcula o número de unidades vivas
     */

    private void calculaNumeroUnidades() {
        numeroUnidades = 0;
        for (Unidade unidade : unidades) {
            if (unidade.getEstado()) {
                numeroUnidades++;
            }
        }
    }

    /**
     * Calcula o número de construções ativas
     */

    private void calculaNumeroConstrucoes() {
        numeroConstrucoes = 0;
        for (Construcao construcao : construcoes) {
            if (construcao.getEstado()) {
                numeroConstrucoes++;
            }
        }
    }

    /**
     * Verifica se a raça se extinguiu e finaliza o jogo
     */

    public void verificaExtincao() {
        calculaNumeroUnidades();
        calculaNumeroConstrucoes();
        if (numeroUnidades == 0 && numeroConstrucoes == 0) {
            throw new RuntimeException("Fim de jogo a raça " + this + " foi extinta");
        }
    }

    /**
     * Informa o total de unidades vivas ou mortas de uma raça
     * @return {int}
     */

    public int totalUnidades() {
        return unidades.size();
    }

    /**
     * Efetua a troca de raças de uma unidade e move para a respectiva lista
     * @param raca {Raca}
     * @param unidade {Unidade}
     */

    public void trocarRaca(Raca raca, Unidade unidade) {
        unidade.getRaca().unidades.remove(unidade);
        unidade.setRaca(raca);
        raca.unidades.add(unidade);
    }

    public Raca(Recurso recursos, String posicao) {
        this.recursos = recursos;
        this.posicaoInicial = new Posicao(posicao);
        construcoes.add(new CentroDaCidade(posicaoInicial, this));
        unidades.add(new Campones(posicaoInicial, this));
        unidades.add(new Campones(posicaoInicial, this));
    }
}
