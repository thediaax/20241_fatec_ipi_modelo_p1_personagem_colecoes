import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception {
        var p1 = new Personagem("Machion");
        var gerador = new Random();
        p1.nome = "Machion";

        while(true){
            int oQueFazer = gerador.nextInt(4);

        }
    }
}
