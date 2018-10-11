package warcraft.util;

public abstract class Erro {
    public static void imprimeMensagemErro(String erro){
        switch (erro){
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
        }
    }
}
