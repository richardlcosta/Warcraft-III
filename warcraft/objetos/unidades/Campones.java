package warcraft.objetos.unidades;

import warcraft.objetos.construcoes.*;
import warcraft.racas.Raca;
import warcraft.util.*;

public class Campones extends Unidade {

    public void construirCasa(String posicao) {
        Casa casa = new Casa(posicao, raca);
        if(raca.getRecursos().compararRecursos(casa.getRecurso())) {
            raca.addConstrucao(casa);
            raca.getRecursos().consumirRecursos(casa.getRecurso());
        }else{
            Erro.imprimeMensagemErro("RECURSOS_404");
        }
    }

    public void construirCentro(String posicao) {
        CentroDaCidade centro = new CentroDaCidade(posicao, raca);
        if(raca.getRecursos().compararRecursos(centro.getRecurso())) {
            raca.addConstrucao(centro);
            raca.getRecursos().consumirRecursos(centro.getRecurso());
        }else{
            Erro.imprimeMensagemErro("RECURSOS_404");
        }
    }

    public void construirTemplo(String posicao) {
        Templo templo = new Templo(posicao, raca);
        if(raca.getRecursos().compararRecursos(templo.getRecurso())) {
            raca.addConstrucao(templo);
            raca.getRecursos().consumirRecursos(templo.getRecurso());
        }else{
            Erro.imprimeMensagemErro("RECURSOS_404");
        }
    }

    public void construirQuartel(String posicao) {
        Quartel quartel = new Quartel(posicao, raca);
        if(raca.getRecursos().compararRecursos(quartel.getRecurso())) {
            raca.addConstrucao(quartel);
            raca.getRecursos().consumirRecursos(quartel.getRecurso());
        }else{
            Erro.imprimeMensagemErro("RECURSOS_404");
        }
    }

    public void construirTorre(String posicao) {
        Torre torre = new Torre(posicao, raca);
        if(raca.getRecursos().compararRecursos(torre.getRecurso())) {
            raca.addConstrucao(torre);
            raca.getRecursos().consumirRecursos(torre.getRecurso());
        }else{
            Erro.imprimeMensagemErro("RECURSOS_404");
        }
    }

    public void colher(){
        raca.addComida();
    }
    public void cortar(){
        raca.addMadeira();
    }
    public void minerar(){
        raca.addOuro();
    }

    public Campones(String posicao, Raca raca) {
        super(new Posicao(posicao), "campones.jpg", new Recurso(50, 0, 0, 0), true, 50, 3, 2.0, 0, 0, raca);
    }
}
