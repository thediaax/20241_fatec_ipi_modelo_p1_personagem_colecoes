import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        var p1 = new Personagem("Machion");
        var p2 = new Personagem("Bossini");
        Random gerador = new Random();
        p1.nome = "Machion";
        p2.nome = "Bossini";
        String[] ITENS =
        {"Javali Selvagem - ", "Amora - ", "Batata Frita - ", "Peixe - ", "Manga - "};//itens do jogo formatados
        
        p1.energia = Math.max(p1.energia, 0);
        p2.energia = Math.max(p2.energia, 0);

        while(p1.energia > 0 || p2.energia > 0){
            if(p1.energia > 0){ // Personagem 1 realiza uma atividade se energia for >0
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
                p1.morrer(p2);
            }

            if(p2.energia >0){ // Personagem 2 realiza uma atividade se energia for >0
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
            p2.morrer(p1);
            }   
            
            
            int quemAtaca = gerador.nextInt(2);
            switch (quemAtaca) {

                case 0:
                    p1.atacar(p2);
                    
                break;

                case 1:
                    p2.atacar(p1);
                break;
            }
            


            //formatação da saida
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