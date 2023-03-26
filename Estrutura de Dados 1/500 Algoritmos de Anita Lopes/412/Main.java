import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        //Matriz tamanho 5x5
        Variaveis var = new Variaveis();

        for(var.linha = 0; var.linha<5; var.linha ++){
            for(var.coluna = 0; var.coluna <5; var.coluna++){
                var.n[var.linha][var.coluna] = Integer.parseInt(JOptionPane.showInputDialog("Digite elemento: "));
            }
        }
        JOptionPane.showMessageDialog(null, "Toda a Matriz");
        for(var.linha = 0; var.linha<5; var.linha++){
            for(var.coluna = 0; var.coluna <5; var.coluna++){
                System.out.print(var.n[var.linha][var.coluna] + "\t");
            }
            System.out.print("\n");
        }
        JOptionPane.showMessageDialog(null, "Os elementos nas posições cuja linha + coluna resulta num par");
        for(var.linha=0; var.linha<5; var.linha++){
            for(var.coluna=0; var.coluna<5; var.coluna++){
                if((var.linha+var.coluna)%2 == 0){
                    System.out.print(var.n[var.linha][var.coluna]);
                }
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }
}