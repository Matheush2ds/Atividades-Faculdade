import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        //Somar matrizes
        Variaveis var = new Variaveis();

        for(var.linha = 0; var.linha<4; var.linha++){
            for(var.coluna = 0; var.coluna<4; var.coluna++){
                var.a[var.linha][var.coluna] = Integer.parseInt(JOptionPane.showInputDialog("Digite elemento A: "));
            }
        }
        for(var.linha = 0; var.linha<4; var.linha++){
            for(var.coluna = 0; var.coluna<4; var.coluna++){
                var.b[var.linha][var.coluna] = Integer.parseInt(JOptionPane.showInputDialog("Digite elemento B: "));
                var.soma[var.linha][var.coluna] = var.a[var.linha][var.coluna] + var.b[var.linha][var.coluna];
            }
        }
        JOptionPane.showMessageDialog(null, "Toda a Matriz Soma");
        for(var.linha = 0; var.linha<4; var.linha++){
            for(var.coluna = 0; var.coluna <4; var.coluna++){
                System.out.print(var.soma[var.linha][var.coluna] + "\t");
            }
            System.out.print("\n");
        }
    }
}