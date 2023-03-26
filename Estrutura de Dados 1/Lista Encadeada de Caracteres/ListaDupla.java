import.java.util.scanner;
import.java.util.ArrayList;
import.java.util.List;

public class ListaDupla {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<Integer>();
        while (true) {
            int index = 0;

        System.out.println("Digite Numero/Caracteres: ");
        String InputSrt = input.nextLine();
        for (char c : InputSrt.toCharArray()) {
            if (Integer.isDigit(c)) {
                char.add(index++, c);

               }   else if (Character.isDigit (c))

               {
                char.add(index, c);
               } else {
                System.out.println("Digite um ");
               }
               }
            }




    }

}