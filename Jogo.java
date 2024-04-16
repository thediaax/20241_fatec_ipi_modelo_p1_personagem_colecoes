    import java.util.Random;

    public class Jogo {
        public static void main(String[] args) throws Exception {
            var p1 = new Personagem("Machion");
            Random gerador = new Random();
            p1.nome = "Machion";
            String[] ITENS =
            {"Javali Selvagem", "Amora", "Batata Frita", "Peixe", "Manga"};

            while(true){
                int oQueFazer = gerador.nextInt(3);
                switch (oQueFazer) {
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

                System.out.println(p1);
                Thread.sleep(1000);//intervalo
            }
        }
    }
