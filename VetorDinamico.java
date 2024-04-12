import java.util.Arrays;

public class VetorDinamico {
    // variáveis de instância
    private int qtde; // quantidade de elementos no vetor
    private int cap; // capacidade atual do vetor
    private String[] elementos; // array para armazenar os elementos do vetor

    // variável de classe
    private static final int CAP_MINIMA = 4; // capacidade mínima do vetor

    // Construtor padrão
    VetorDinamico() {
        cap = CAP_MINIMA;
        qtde = 0;
        elementos = new String[CAP_MINIMA];
    }

    // Construtor com capacidade mínima personalizada
    VetorDinamico(int capMinima) {
        double aux = capMinima;
        while (aux >= 2)
            aux /= 2;
        cap = aux == 1 && capMinima > 3 ? capMinima : CAP_MINIMA;
    }
  //terminar esse método
  void adicionar(String elemento){
    //se estiver cheio, redimensionar antes de adicionar
    if(estaCheio())redimensionar();
    elementos[qtde] = elemento;
    qtde++;
  }

  //escrever esse aqui também
  boolean estaCheio(){
    //decidir se o vetor está cheio ou não olhando para cap e qtde
    // if(qtde == cap)
    //   return true;
    // return false;
    // return qtde == cap ? true : false;
    return qtde == cap;
  }

  //escrever esse método
  private void redimensionar(){
    //alocar um vetor com o dobro da capacidade atual chamado auxiliar
    String [] aux = new String[cap * 2];
    //copiar todo mundo do vetor elementos para o vetor auxiliar
    for(int i = 0; i < cap; i++){
      aux[i] = elementos[i];
    }
    //ajustar a capacidade para que ela tenha o valor novo, dobrado
    cap *= 2;

    //ajustar o ponteiro elementos para que ele aponte para o novo vetor
    elementos = aux;
    // System.gc();
  }

  //implemente esse método
  void adicionarSemRepeticao(String e){
    if(!existe(e)) adicionar(e);
  }

  boolean existe(String e){
    for (int i = 0; i < qtde; i++)
      if (e == elementos[i])
        return true;
    return false;
  }

  int tamanho(){
    return qtde;
  }

  void removerNoFinal(){

  }

  boolean estaVazio(){

  }

  boolean estaUmQuartoCheio(){
    
  }

  void reduzirTamanho(){

  }

  String[] getElementos(){
    return Arrays.copyOf(elementos, cap);
    // return elementos;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("");
    sb.append("Qtde: ").append(qtde);
    sb.append("\n");
    sb.append("Cap: ").append(cap);
    sb.append(qtde > 0 ? "\nElementos: " : "");
    for (int i = 0; i < qtde; i++) {
        sb.append(elementos[i]).append(" ");
    }
    return sb.toString();
  }
}
