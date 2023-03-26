public class Personagens {
    public static void main(String[] args) throws Exception {
        ListaDuplamente lista = new ListaDuplamente();

        lista.AdicionarNoComeco("Homer");
        lista.AdicionarNoComeco("Marge");
        System.out.println(lista.Imprimir());

        lista.EsvaziaLista();
        System.out.println(lista.Imprimir());

        lista.AdicionarNoComeco("Homer");
        lista.Adiciona(0, "Bart");
        lista.Adiciona(1, "Moll");

        //8
        lista.EsvaziaLista();

        lista.AdicionarNoComeco("Homer");
        lista.AdicionarNoComeco("Bart");
        System.out.println(lista.Imprimir() +  " " + lista.tamanho());

        System.out.println(lista.Contem("Marge"));
        System.out.println(lista.Contem("Homer"));
        System.out.println(lista.Contem("Bart"));
        System.out.println(lista.Contem("Maggie"));
        System.out.println(lista.Contem(lista.tamanho()));

        //11
        lista.EsvaziaLista();
        lista.AdicionarNoComeco("Homer");
        lista.AdicionarNoComeco("Bart");
        lista.AdicionarNoComeco("Marge");
        lista.Adiciona(1, "Maggie");
        lista.Adiciona(0, "Ned Flanders");
        lista.Adiciona(lista.tamanho(), "Sr. Burns");
        System.out.println(lista.Imprimir());

        lista.RemovendoFim();
        System.out.println(lista.Imprimir());

        lista.Remove(1);
        System.out.println(lista.Imprimir() + " " + lista.tamanho());

        System.out.println(lista.Contem("Marge"));
        System.out.println(lista.Contem("Homer"));
        System.out.println(lista.Contem("Bart"));
        System.out.println(lista.Contem("Maggie"));
        System.out.println(lista.Contem(lista.tamanho()));

        lista.EsvaziaLista();
        System.out.println(lista.Imprimir());

    }
}