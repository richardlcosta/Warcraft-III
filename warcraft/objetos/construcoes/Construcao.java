package warcraft.objetos.construcoes;

import warcraft.objetos.Objeto;
import warcraft.util.*;

public class Construcao extends Objeto {
    private int ataque = 0;
    private int alcance = 0;

    @Override
    public void setPosicao(Posicao posicao) {
        System.out.println("Não é possível mover uma construção");
    }

    public Construcao(Posicao posicao, String imagem, Custo custo, int estado, int vida, int ataque, int alcance) {
        super(posicao, imagem, custo, estado, vida);
    }
}
