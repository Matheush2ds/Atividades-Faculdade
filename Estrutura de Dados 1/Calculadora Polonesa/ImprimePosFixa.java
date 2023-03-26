import EstrurasDeDados.Fila;
public class ImprimePosFixa {
    
    public static String imprimePosFixa (Fila f) throws Exception{
     String expressao = "";
     Fila aux = f.clonar();
     char c;
     
     while (!aux.filaVazia()){
        c = (char)aux.consultaPrimeiro();
        aux.desenfileirar();
        expressao += (char)c;
 }
 return expressao;
}
}