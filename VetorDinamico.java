import java.util.Arrays;

public class VetorDinamico {
 
    public int qtde;
    private int cap;
    private String[] elementos;

    
    private static final int CAP_MINIMA = 4;

    
    VetorDinamico() {
        cap = CAP_MINIMA;
        qtde = 0;
        elementos = new String[CAP_MINIMA];
    }

  
    VetorDinamico(int capMinima) {
        double aux = capMinima;
        while (aux >= 2)
            aux /= 2;
        cap = aux == 1 && capMinima > 3 ? capMinima : CAP_MINIMA;
    }

  void adicionar(String elemento){
  
    if(estaCheio())redimensionar();
    elementos[qtde] = elemento;
    qtde++;
  }

  boolean estaCheio(){

    return qtde == cap;
  }


  private void redimensionar(){

    String [] aux = new String[cap * 2];

    for(int i = 0; i < cap; i++){
      aux[i] = elementos[i];
    }

    cap *= 2;

    elementos = aux;
   
  }

 
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


  boolean estaVazio(){

    return qtde == 0;

  }

  boolean estaUmQuartoCheio(){
    return qtde >= cap / 4;
    
  }

  void reduzirTamanho(){
    if (qtde < cap / 4 && cap > CAP_MINIMA) {
      cap /= 2;
      elementos = Arrays.copyOf(elementos, cap);
  }

  }

  void removerUltimoItem() {
    if (qtde > 0) {
        qtde--;
        elementos[qtde] = null;
    }
}

String ultimoItem() {
    if (qtde > 0) {
        return elementos[qtde - 1];
    }
    return null;
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