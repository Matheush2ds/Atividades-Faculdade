public class Celula {
    Celula proxima;
    Celula anterior;
    Object Elemento;

    Celula(Celula prox, Object ele){
        this.proxima = prox;
        this.anterior = null;
        this.Elemento = ele;
    }

    Celula(Object ele){
        this.proxima = null;
        this.anterior = null;
        this.Elemento = ele;
    }

    void setProxima(Celula prox){
        this.proxima = prox;
    }

    void setAnterior(Celula ant){
        this.anterior = ant;
    }

    Celula getProxima(){
        return(this.proxima);
    }

    Celula getAnterior(){
        return(this.anterior);
    }

    Object getElemento(){
        return(this.Elemento);
    }
}