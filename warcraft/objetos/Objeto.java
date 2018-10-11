package warcraft.objetos;

import warcraft.objetos.unidades.Unidade;
import warcraft.racas.Raca;
import warcraft.util.Recurso;
import warcraft.util.Posicao;

public abstract class Objeto {
    protected Posicao posicao;
    protected Raca raca;
    private Recurso recurso;
    private String imagem;
    private boolean estado;
    private int vidaMax;
    private int vida;
    private int ataque;

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
    public Recurso getRecurso() {
        return recurso;
    }

    //SETTERS
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void atacar(Objeto objeto){
        if(this.ataque == 0) {
            System.out.println("Não é possível atacar");
        }else{
            if (this.raca.equals(objeto.raca)) {
                System.out.println("O QUE??? Não se deve atacar um companheiro!!!");
            } else if (!objeto.estado) {
                if (objeto instanceof Unidade) {
                    System.out.println("Onde está o seu respeito? O alvo já está morto.");
                } else {
                    System.out.println("A construção já foi destruída.");
                }
            } else {
                int armadura = objeto instanceof Unidade ? ((Unidade) objeto).getArmadura() : 0;
                int dano = (this.ataque - armadura);
                objeto.vida -= dano;
                System.out.printf("Ataque efetuado, infligiu %d de dano. ", dano);
                objeto.atualizaEstado();
                if (objeto instanceof Unidade) {
                    System.out.println(objeto.estado ? "O alvo permanece vivo" : "O alvo foi abatido");
                } else {
                    System.out.println(objeto.estado ? "A construção permanece erguida" : "A construção foi destruída");
                }
            }
        }
    }

    private void atualizaEstado(){
        this.estado = vida > 0;
    }

    public Objeto(Posicao posicao, String imagem, Recurso recurso, boolean estado, int vidaMax, int ataque, Raca raca) {
        this.posicao = posicao;
        this.imagem = imagem;
        this.recurso = recurso;
        this.estado = estado;
        this.vidaMax = vidaMax;
        this.vida = vidaMax;
        this.ataque = ataque;
        this.raca = raca;
    }
}
