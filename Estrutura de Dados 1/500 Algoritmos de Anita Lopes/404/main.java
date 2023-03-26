import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        //Matriz 10x10 e escreve somente os elementos acima da diagonal principal
        Variaveis var = new Variaveis();

        for(var.linha = 0; var.linha <=9; var.linha++){
            for(var.coluna = 0; var.coluna <=9; var.coluna++){
                var.N[var.linha][var.coluna] = Integer.parseInt(JOptionPane.showInputDialog("Entre com elemento linha " + (var.linha+1) + " | coluna " + (var.coluna+1)));
            }
        }

        JOptionPane.showMessageDialog(null, "ACIMA DA DIAGONAL PRINCIPAL");
        for(var.linha = 0; var.linha <=8; var.linha++){
            for(var.coluna = var.linha+1; var.coluna <=9; var.coluna++){
                System.out.print("\t" + var.N[var.linha][var.coluna]);
            }
            System.out.print("\n");
            for(int t = 0; t <= var.linha; t++){
                System.out.print("\t");
            }
        }
    }
}