import java.util.ArrayList;
import java.util.List;

public class Lavados {
    List <Object> obj = new ArrayList<>();
    
    void insere(Object A){
        this.obj.add(A);
    }
    Object remove(){
        return this.obj.remove(0);
    }
    
    boolean fila_vazia(){
        return(this.obj.isEmpty());
    }
}