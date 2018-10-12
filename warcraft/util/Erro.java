package warcraft.util;

/**
 * Contém todos os erros apresentados no jogo
 */

public abstract class Erro {

    /**
     * Imprime uma mensagem de erro na tela
     * @param erro {String}
     * @param passos {double}
     */

    public static void imprimeMensagemErro(String erro, double passos) {
        switch (erro) {
            case "TARGET_FAR":
                System.out.printf("O alvo está longe demais. Preciso andar %.2f passos em direção ao alvo\n", passos);
                break;
        }
    }

    /**
     * Imprime uma mensagem de erro na tela
     * @param erro {String}
     */

    public static void imprimeMensagemErro(String erro) {
        switch (erro) {
            case "POPULACAO_FULL":
                System.out.println("Você atingiu o limite máximo de unidades");
                break;
            case "RECURSOS_404":
                System.out.println("Você não possui recursos suficientes para realizar essa ação");
                break;
            case "HUMANOS_ONLY":
                System.out.println("Apenas humanos podem criar grifos");
                break;
            case "ORCS_ONLY":
                System.out.println("Apenas orcs podem criar andarilhos espirituais");
                break;
            case "BUILD_BROKED":
                System.out.println("Tá maluco? Essa construção já está destruída");
                break;
            case "UNIT_DEAD":
                System.out.println("Perdeu o senso é? Esta unidade já está morta");
                break;
            case "IS_ALIVE":
                System.out.println("To vendo que você não bate bem, o alvo não está morto");
                break;
            case "NO_ATTACK":
                System.out.println("Como você esperava fazer isso? Não é possível atacar");
                break;
            case "IS_FRIEND":
                System.out.println("O QUE??? Não se deve atacar um companheiro!!!");
                break;
            case "FLY_UNIT":
                System.out.println("Apenas unidades de longo alcance podem atacar unidades aéreas");
        }
    }
}
