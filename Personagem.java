import java.util.Random;

public class Personagem{
  //variáveis de instância(objeto)
  String nome;
  int energia;
  private int fome;
  private int sono;
  private static final String[] ITENS = {"Javali Selvagem", "Amora", "Batata Frita", "Peixe", "Raízes"};


  //esse é o construtor padrão
  //criado automaticamente pelo compilador, ainda que não seja escrito explicitamente
  Personagem(String string){
    nome = null;
    energia = 10;
    fome = 0;
    sono = 0;
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

  void cacar(){
    if(energia >= 2){
      System.out.printf("%s esta cacando...\n", nome);
      energia -= 2; // energia = energia - 2;
    }
    else{
      System.out.printf("%s sem energia para cacar...\n", nome);
    }
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

  void oQueFazer(Personagem p1){

    var gerador = new Random();
    int oQueFazer = gerador.nextInt(4);
    if (energia>0) {
      
      switch(oQueFazer){

        case 0:
        cacar();
        break;

        case 1:
        comer();
        break;

        case 2:
        dormir();
        break;
        
      }
      
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