import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        var p1 = new Personagem("Machion");
        var p2 = new Personagem("Bossini");
        Random gerador = new Random();
        p1.nome = "Machion";
        p2.nome = "Bossini";
        String[] ITENS =
        {"Javali Selvagem - ", "Amora - ", "Batata Frita - ", "Peixe - ", "Manga - "};


        while(true){
            // Personagem 1 realiza uma atividade
            int oQueFazerP1 = gerador.nextInt(3);
            switch (oQueFazerP1) {
                case 0:
                    p1.cacar(ITENS);
                    break;
                case 1:
                    p1.comer();
                    break;
                case 2:
                    p1.dormir();
                    break;
            }

            // Personagem 2 realiza uma atividade
            int oQueFazerP2 = gerador.nextInt(3);
            switch (oQueFazerP2) {
                case 0:
                    p2.cacar(ITENS);
                    break;
                case 1:
                    p2.comer();
                    break;
                case 2:
                    p2.dormir();
                    break;
            }
            p1.morrer();
            p2.morrer();

            System.out.println();
            System.out.println("   Estado dos personagens");
            System.out.println(p1);
            System.out.println();
            System.out.println(p2);
            System.out.println();
            Thread.sleep(1000);//intervalo
        }
    }
}
