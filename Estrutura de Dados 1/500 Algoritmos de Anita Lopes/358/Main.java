import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        //Ler o preço de compra e de venda de 100 mercadorias.
        Variaveis var = new Variaveis();

        for(int i = 0; i<5; i++){
            var.precoCompra[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Preco da Compra: "));
            var.precoVenda[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Preco da venda : "));
            
            var.lucro = var.precoVenda[i] - var.precoCompra[i];
            if(var.lucro<10.0){
                var.lucroMenor10++;
            }else if(var.lucro<=20.0){
                var.lucroMenor20++;
            }else{
                var.lucroMaior20++;
            }
        }
        JOptionPane.showMessageDialog(null, "Total de mercadorias com lucro < 10%: " + var.lucroMenor10);
        JOptionPane.showMessageDialog(null, "Total de mercadorias com 10% <= lucro <= 20% " + var.lucroMenor20);
        JOptionPane.showMessageDialog(null, "Total de mercadorias com lucro > 20%: " + var.lucroMaior20);        
    }
}
        //irei fazer somente 5 para uma execução mais rápida.