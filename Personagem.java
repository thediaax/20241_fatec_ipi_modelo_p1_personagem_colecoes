import java.util.Random;

public class Personagem{
  //variáveis de instância(objeto)
  String nome;
  int energia;
  private int fome;
  private int sono;
  private VetorDinamico estoque;


  //esse é o construtor padrão
  //criado automaticamente pelo compilador, ainda que não seja escrito explicitamente
  Personagem(String string){
    nome = "Machion";
    energia = 10;
    fome = 0;
    sono = 0;
    estoque = new VetorDinamico();
  }

  //construtor personalizado
  //o que viabiliza a sua existência é a sobrecarga de construtores
  Personagem(int energia, int fome, int sono){
    if (energia >= 0 && energia <= 10)
      this.energia = energia;
    if (fome >= 0 && fome <= 10)
      this.fome = fome;
    if (sono >= 0 && sono <= 10)
      this.sono = sono;
  }

  void cacar(String[] ITENS){
    if(energia >= 2){
      Random gerador = new Random();
      int oQueFazer = gerador.nextInt(5);
        if(oQueFazer == 0){
          System.out.printf("Cacar %s\n", ITENS[oQueFazer]);
        }
        else if (oQueFazer == 1){
          System.out.printf("Cacar %s", ITENS[oQueFazer]);
        }
        else if (oQueFazer == 2){
          System.out.printf("Cacar %s", ITENS[oQueFazer]);
        }
        else if (oQueFazer == 3){
          System.out.printf("Cacar %s", ITENS[oQueFazer]);
        }
        else if (oQueFazer == 4){
          System.out.printf("Cacar %s", ITENS[oQueFazer]);
        }
        else{
          System.out.printf("%s esta sem energia para cacar\n", nome);
        }


      System.out.printf("%s esta cacando...\n", nome);
      
    }
    energia -= 2; // energia = energia - 2;
    fome = Math.min(fome + 1, 10);
    //resolver com o ternário
    sono = sono < 10 ? sono + 1 : sono;
  }

  void comer() {
    //se tiver fome
      //comer e reduzir o valor de fome de 1
      //aumentar o valor de energia de 1
    //caso contrario
      //so vai avisar que esta sem fome
      switch(fome){
        case 0:
          System.out.printf("%s sem fome....\n", nome);
          break;
        default:
          System.out.printf("%s comendo...\n", nome);
          --fome;
          energia = (energia == 10 ? energia : energia + 1);
      }
  }

  void dormir(){
    if(sono >= 1){
      System.out.printf("%s esta dormindo...\n", nome);
      sono -= 1;
      energia = Math.min(energia + 1, 10);
    }
    else{
      System.out.printf("%s sem sono...\n", nome);
    }
  }

  void morrer(){
    if(energia<=0) {

      System.out.printf("%s morreu\n", nome);
      System.exit(0);
    }
  }

  public String toString(){
    return String.format(
      "%s: (e:%d, f:%d, s:%d)",
      nome, energia, fome, sono
    );
  }

}