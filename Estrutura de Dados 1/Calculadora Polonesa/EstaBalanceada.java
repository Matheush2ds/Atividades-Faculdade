import EstrurasDeDados.Pilha;
public class EstaBalanceada {

    public static boolean estaBalanceada(String E) throws Exception{
    Pilha p = new Pilha(E.length());
   
    for(int i=0; i<E.length(); i++){
    if( E.charAt(i) == '('){
    p.empilhar(i);
    }
    if( E.charAt(i) == ')'){
    p.desempilhar();
    }
    }
    return p.pilhaVazia();
    }
 }   