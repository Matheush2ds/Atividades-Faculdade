import javax.swing.JOptionPane;

public class Produto {
    public static void main(String[] args) throws Exception {
        Variaveis var = new Variaveis();

        var.codi = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto ou 0 para finalizar: "));
        while(var.k < 50 && var.codi != 0){
            var.cod[var.k] = var.codi;
            var.quant[var.k] = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto: "));
            var.preco[var.k] = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto: "));
            var.k++;
            var.codi = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto ou 0 para finalizar: "));
        }
        do{
            var.codi = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do produto para a venda"));
            if(var.codi != 0){
                for(var.k = 0; var.k<= 50; var.k++){
                    if(var.cod[var.k] == var.codi){
                        var.quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade para vender: "));
                        if(var.quantidade <= var.quant[var.k]){
                            var.venda += var.quantidade;
                            var.quant[var.k] -= var.quantidade;
                            var.geral += var.preco[var.k];
                            JOptionPane.showMessageDialog(null, "Vendido!");
                            var.k=51;
                        }else{
                            JOptionPane.showMessageDialog(null, "Quantidade indisponível");
                            var.k=51;
                        }
                    }else{
                        var.k=51;
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Código indisponível");
            }
        }while(var.codi != -1);
        
        System.out.println("QUANTIDADE - CODIGO");
        for(int i = 0; i<var.quant.length; i++){
            System.out.println(var.quant[i] + " - " + var.cod[i]);
        }
        System.out.println("TOTAL VENDIDO: " + var.geral + " - QUANTIDADE VENDIDA: " + var.venda);
    }
}