package warcraft.objetos;

import warcraft.objetos.construcoes.Construcao;
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
    protected boolean unidadeAerea = false;
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
     *
     * @param objeto {Objeto}
     */

    public void atacar(Objeto objeto) {
        if (getEstado()) { //VERIFICA SE VOCÊ ESTÁ USANDO OBJETO 'VIVO' PARA ATACAR
            if (verificaDistancia(objeto)) { //VERIFICA SE A DISTANCIA É COMPATÍVEL ENTRE OS DOIS OBJETOS
                if (this.ataque == 0) { //VERIFICA SE ESSE OBJETO É DO TIPO QUE ATACA
                    Erro.imprimeMensagemErro("NO_ATTACK");
                } else {
                    if (this.raca.equals(objeto.raca)) { //VERIFICA SE VOCÊ ESTÁ TENTANDO ATACAR UM ALIADO
                        Erro.imprimeMensagemErro("IS_FRIEND");
                    } else if (!objeto.estado) { //VERIFICA SE VOCÊ ESTÁ ATACANDO UM OBJETO 'MORTO'
                        if (objeto instanceof Unidade) {
                            Erro.imprimeMensagemErro("UNIT_DEAD");
                        } else {
                            Erro.imprimeMensagemErro("BUILD_BROKED");
                        }
                    } else if (objeto.unidadeAerea && alcance == 1) { //VERIFICA SE ESTA ATACANDO UMA UNIDADE AÉREA
                        Erro.imprimeMensagemErro("FLY_UNIT");
                    } else {
                        int armadura = objeto instanceof Unidade ? ((Unidade) objeto).getArmadura() : 0;
                        int dano = this.ataque - armadura > 0 ? this.ataque - armadura : 0;
                        objeto.vida -= dano;
                        System.out.printf("Ataque efetuado, infligiu %d de dano.\n", dano);
                        objeto.atualizaEstado();
                        if (this instanceof Grifo){ //CASO O ATAQUE VENHA DE UM GRIFO, A LISTA DE UNIDADES E CONSTRUÇÕES É VARRIDA NA BUSCA DE OBJETOS NUM RAIO DE TRÊS METROS
                            for(Unidade unidade : objeto.raca.listaDeUnidades()){
                                if (verificaDistanciaAreaGrifo(unidade) && !unidade.equals(objeto) && unidade.getVida() > 0){
                                    armadura = unidade.getArmadura();
                                    dano = this.ataque - armadura;
                                    unidade.setVida(unidade.getVida() - dano);
                                    unidade.atualizaEstado();
                                    if (unidade.getEstado()){
                                        System.out.println("Uma unidade foi atingida pelo ataque em área do grifo");
                                    }else{
                                        System.out.println("Uma unidade foi abatida pelo ataque em área do grifo");
                                    }
                                }
                            }
                            for(Construcao construcao : objeto.raca.listaDeConstrucoes()){
                                if (verificaDistanciaAreaGrifo(construcao) && !construcao.equals(objeto) && construcao.getVida() > 0){
                                    dano = this.ataque;
                                    construcao.setVida(construcao.getVida() - dano);
                                    construcao.atualizaEstado();
                                    if (!construcao.getEstado()){
                                        System.out.println("Uma construção foi destruída pelo ataque em área do grifo");
                                    }
                                }
                            }
                        }
                        if (objeto instanceof Unidade) { //VERIFICA SE É UMA UNIDADE OU UMA CONSTRUÇÃO
                            if (!objeto.estado) { //VERIFICA SE FOI ABATIDA OU SE PERMANECE VIVO
                                System.out.println("O alvo foi abatido");
                                objeto.raca.verificaExtincao();
                            } else {
                                System.out.println("O alvo permanece vivo");
                            }
                        } else {
                            if (!objeto.estado) { //VERIFICA SE FOI DESTRUÍDA OU AINDA SE MANTÉM DE PÉ
                                System.out.println("A construção foi destruída");
                                objeto.raca.verificaExtincao();
                            } else {
                                System.out.println("A construção permanece erguida");
                            }
                        }
                    }
                }
            } else {
                Erro.imprimeMensagemErro("TARGET_FAR", (distanciaAtual - alcance));
            }
        } else {
            Erro.imprimeMensagemErro("UNIT_DEAD");
        }
    }

    /**
     * Informa se um objeto está no alcance de outro no mapa
     *
     * @param objeto {Objeto}
     * @return boolean
     */
    public boolean verificaDistancia(Objeto objeto) {
        distanciaAtual = posicao.calculaDistancia(posicao, objeto.posicao);
        return alcance >= distanciaAtual;
    }

    protected boolean verificaDistanciaAreaGrifo(Objeto objeto) {
        distanciaAtual = posicao.calculaDistancia(posicao, objeto.posicao);
        return distanciaAtual <= 3;
    }

    /**
     * Atualiza após cada ataque, o estado de um objeto
     */

    protected void atualizaEstado() {
        if (vida < 0) {
            vida = 0;
        }
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
