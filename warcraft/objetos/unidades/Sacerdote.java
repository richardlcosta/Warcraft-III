package warcraft.objetos.unidades;

import warcraft.objetos.Objeto;
import warcraft.racas.Raca;
import warcraft.util.Recurso;
import warcraft.util.Posicao;

public class Sacerdote extends Unidade {

    public void curar(Objeto objeto){
        if(objeto instanceof Unidade) {
            if(this.raca.getRecursos().getMana() < 5){
                System.out.println("Sua raça não possui mana suficiente");
            }else if(objeto.getVida() == objeto.getVidaMax()) {
                System.out.println("A unidade já está com a vida completa");
            }else{
                objeto.setVida(objeto.getVidaMax());
                this.raca.consumirMana(5);
                System.out.println("A vida da unidade alvo foi restaurada");
            }
        }else{
            System.out.println("Não é possível curar construções");
        }
    }

    public void rezar(){
        this.raca.addMana(5);
    }

    public Sacerdote(String posicao, Raca raca) {
        super(new Posicao(posicao), "sacerdote.jpg", new Recurso(0, 125, 0, 0), true, 25, 0, 1.0, 10, 2, raca);
    }
}
