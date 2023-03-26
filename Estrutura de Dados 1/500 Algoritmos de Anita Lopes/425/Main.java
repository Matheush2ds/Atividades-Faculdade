import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        //Floricultura
        Variaveis var = new Variaveis();

        for(var.linha=0; var.linha<50; var.linha++){
            var.nome[var.linha] = JOptionPane.showInputDialog("Nome da Planta!: ");
            var.quantidade[var.linha][0] = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em estoque: "));
            var.quantidade[var.linha][1] = Integer.parseInt(JOptionPane.showInputDialog("Quantidade ideal: "));
            if(var.quantidade[var.linha][0] < var.quantidade[var.linha][1]){
                var.quantidade[var.linha][2] = var.quantidade[var.linha][1] - var.quantidade[var.linha][0];
            }else{
                var.quantidade[var.linha][2] = 0;
            }
        }

        JOptionPane.showMessageDialog(null, "Total de compras!");
        for(var.linha=0; var.linha<50; var.linha++){
            System.out.println(var.nome[var.linha] + " - " + var.quantidade[var.linha][2]);
        }   
    }
}