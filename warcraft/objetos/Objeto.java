package warcraft.objetos;

import warcraft.objetos.unidades.*;
import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para os objetos do jogo
 */

public abstract class Objeto {

    //ATRIBUTOS
    final protected Custo custo;
    protected Posicao posicao;
    protected Raca raca;
    private String imagem;
    private boolean estado;
    private int vidaMax;
    private int vida;
    private int ataque;
    private int alcance;
    private double distanciaAtual;

    //GETTERS
    public Posicao getPosicao() {
        return posicao;
    }

    public boolean getEstado() {
        return estado;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public Custo getRecurso() {
        return custo;
    }

    public Raca getRaca() {
        return raca;
    }

    //SETTERS
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    /**
     * Torna possível um objeto atacar a outro
     * @param objeto {Objeto}
     */

    public void atacar(Objeto objeto) {
        if (getEstado()) {
            if (verificaDistancia(objeto)) {
                if (this.ataque == 0) {
                    Erro.imprimeMensagemErro("NO_ATTACK");
                } else {
                    if (this.raca.equals(objeto.raca)) {
                        Erro.imprimeMensagemErro("IS_FRIEND");
                    } else if (!objeto.estado) {
                        if (objeto instanceof Unidade) {
                            Erro.imprimeMensagemErro("UNIT_DEAD");
                        } else {
                            Erro.imprimeMensagemErro("BUILD_BROKED");
                        }
                    } else {
                        int armadura = objeto instanceof Unidade ? ((Unidade) objeto).getArmadura() : 0;
                        int dano = (this.ataque - armadura);
                        objeto.vida -= dano;
                        System.out.printf("Ataque efetuado, infligiu %d de dano. ", dano);
                        objeto.atualizaEstado();
                        if (objeto instanceof Unidade) {
                            if(!objeto.estado) {
                                System.out.println("O alvo foi abatido");
                                objeto.raca.verificaExtincao();
                            }else{
                                System.out.println("O alvo permanece vivo");
                            }
                        } else {
                            if(!objeto.estado) {
                                System.out.println("A construção foi destruída");
                                objeto.raca.verificaExtincao();
                            }else{
                                System.out.println("A construção permanece erguida");
                            }
                        }
                    }
                }
            } else {
                Erro.imprimeMensagemErro("TARGET_FAR", (distanciaAtual - alcance));
            }
        }else{
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    /**
     * Informa se um objeto está no alcance de outro no mapa
     * @param objeto {Objeto}
     * @return boolean
     */
    protected boolean verificaDistancia(Objeto objeto) {
        distanciaAtual = posicao.calculaDistancia(posicao, objeto.posicao);
        return alcance >= distanciaAtual;
    }

    /**
     * Atualiza após cada ataque, o estado de um objeto
     */

    private void atualizaEstado() {
        this.estado = vida > 0;
    }

    public Objeto(Posicao posicao, String imagem, Custo custo, boolean estado, int vidaMax, int ataque, int alcance, Raca raca) {
        this.posicao = posicao;
        this.imagem = imagem;
        this.custo = custo;
        this.estado = estado;
        this.vidaMax = vidaMax;
        this.vida = vidaMax;
        this.ataque = ataque;
        this.raca = raca;
        this.alcance = alcance;
    }
}
