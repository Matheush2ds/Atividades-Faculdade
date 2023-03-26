public class App {
    public static void main(String[] args) throws Exception {
        ListaDupla listaC = new ListaDupla();
        ListaDupla listaD = new ListaDupla();
        int [] vetor = new int[1000];

        for(int i = 0; i<100; i++){
            int randomNumber=(int)((Math.random() * 9999) - 4545);
            vetor[i] = randomNumber;
        }

        for(int i = 0; i<100; i++){
            System.out.println(vetor[i]);
        }

        //Funcao para decrescente
        int n = 100;
        int min = 0;
        
        for(int i = 0; i < (n-1); i++){
        
            min = i;
            
            //Encontra o menor elemento
            for(int j = (i+1); j < n; j++){
                if(vetor[j] < vetor[min]){
                    min = j;
                }
            }
            
            //realiza a troca, colocando o menor elemento, na posição correta
            if(vetor[i] != vetor[min]){
                int aux = vetor[i];
                vetor[i] = vetor[min];
                vetor[min] = aux;
            }
        }

        for(int i = 0; i<100; i++){
            listaD.AdicionarNoComeco(vetor[i]);
        }
        
        System.out.println("-----------------------------------------------------------");
        System.out.println("Decrescente: " +  listaD.Imprimir());
        //Funcao para crescente 
        for(int i = 99; i>=0; i--){
            listaC.AdicionarNoComeco(vetor[i]);
        }
        System.out.println("Crescente: " +  listaC.Imprimir());
    }
}