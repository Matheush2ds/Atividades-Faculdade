package ;
import EstrurasDeDados.*;

public class ConvertePosFixa {

public static Fila convertePosFixa(String e) throws Exception{

    String s="";
    Fila f = new Fila(e.length()*2);
    Pilha p = new Pilha(e.length()*2);
    char c;

    for (int i=0; i<e.length(); i++){
    c=e.charAt(i);
    if (c == '('){
    p.empilhar(c);
    }else
 if (c == ')'){
 while (p.consultaTopo() != '(')
 f.enfileirar(p.desempilhar());
 p.desempilhar();
 }else
 if (c == '*'){
 p.empilhar(c);
 }else
 if (c == '/'){
 p.empilhar(c);
 }else
 if (c == '+'){
 if(p.pilhaVazia() || p.consultaTopo()=='+' || p.consulta
Topo()=='-'){
 p.empilhar(c);
 }else{
 while(p.consultaTopo()=='*' || p.consultaTopo()=='/'
){
 f.enfileirar(p.desempilhar());
 }
 p.empilhar(c);
 }
 }else
 if (c == '-'){
 if(p.pilhaVazia() || p.consultaTopo()=='+' || p.consulta
Topo()=='-'){
 p.empilhar(c);
 }else{
 while(p.consultaTopo()=='*' || p.consultaTopo()=='/'
){
 f.enfileirar(p.desempilhar());
 }
 p.empilhar(c);
 }
}
    }
}
}
