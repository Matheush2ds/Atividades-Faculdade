public class ListaDupla {
    Celula primeira;
    Celula ultima;
    int totalDeElementos = 0;

    boolean PosicaoOcupada(int pos){
        return((pos>=0)&&(pos<this.totalDeElementos));
    }

    Celula PegaCelula(int pos){
        if(!this.PosicaoOcupada(pos)){
            throw new IllegalArgumentException("Não existe");
        }else{
            Celula atual = this.primeira;
            for(int i =0; i<pos; i++){
                atual = atual.getProxima();
            }
            return(atual);
        }
    }

    Object Pega(int pos){
        return(this.PegaCelula(pos).getElemento());
    }

    void AdicionarNoComeco(Object elemento){
        if(this.totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        }else{
            Celula nova = new Celula(this.primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        this.totalDeElementos++;
    }

    void Adicionar(Object elemento){
        if(this.totalDeElementos == 0){
            this.AdicionarNoComeco(elemento);
        }else{
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    void Adiciona(int pos, Object elemento){
        if(pos == 0){
            this.AdicionarNoComeco(elemento);
        }else if(pos == this.totalDeElementos){
            this.Adicionar(elemento);
        }else{
            Celula anterior = this.PegaCelula(pos-1);
            Celula proxima = anterior.getProxima();
            Celula nova = new Celula(anterior.getProxima(),elemento);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.totalDeElementos++;
        }
    }

    void RemovendoComeco(){
        if(!this.PosicaoOcupada(0)){
            throw new IllegalArgumentException("Não existe");
        }else{
            this.primeira = this.primeira.getProxima();
            this.totalDeElementos--;
        }
        if(this.totalDeElementos == 0){
            this.ultima = null;
        }
    }

    void RemovendoFim(){
        if(!this.PosicaoOcupada(totalDeElementos-1)){
            throw new IllegalArgumentException("Não existe");
        }else{
            if(this.totalDeElementos == 1){
                this.RemovendoComeco();
            }else{
                Celula penultima = this.ultima.getAnterior();
                penultima.setProxima(null);
                this.ultima = penultima;
                this.totalDeElementos--;
            }
        }
    }

    void Remove(int pos){
        if(!this.PosicaoOcupada(pos)){
            throw new IllegalArgumentException("Não existe");
        }else{
            if(pos == 0){
                this.RemovendoComeco();
            }else if(pos == this.totalDeElementos-1){
                this.RemovendoFim();
            }else{
                Celula anterior = this.PegaCelula(pos-1);
                Celula atual = anterior.getProxima();
                Celula proxima = atual.getProxima();
                anterior.setProxima(proxima);
                proxima.setAnterior(anterior);
                this.totalDeElementos--;
            }
        }
    }

    boolean Contem(Object elemento){
        Celula atual = this.primeira;
        while(atual != null){
            if(atual.getElemento().equals(elemento)){
                return true;
            }
            atual = atual.getProxima();
        }
        return false;
    }

    int tamanho(){
        return(this.totalDeElementos);
    }

    void EsvaziaLista(){
        this.primeira = null;
        this.ultima = null;
        this.totalDeElementos = 0;
    }

    String Imprimir(){
        if(this.totalDeElementos == 0){
            return("[]");
        }else{
            StringBuilder builder = new StringBuilder("[");
            Celula atual = this.primeira;
            for(int i = 0; i < this.totalDeElementos-1; i++){
                builder.append(atual.getElemento());
                builder.append(',');
                atual = atual.getProxima();
            }
            builder.append(atual.getElemento());
            builder.append(']');
            return(builder.toString());
        }
    }
}