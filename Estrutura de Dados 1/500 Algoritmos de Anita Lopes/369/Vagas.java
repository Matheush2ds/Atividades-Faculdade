import javax.swing.JOptionPane;

public class Vagas {
    public static void main(String[] args) throws Exception {
        
        Variaveis var = new Variaveis();

        for(int i = 0; i<30; i++){
            var.mesa[i] = 100 + i;
            var.qtde[i] = 5;
        }
        var.lugares = 150;
        var.codigo = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Código (100 - 129) ou 0 para Finalizar programa: "));

        while(var.codigo > 0 && var.lugares != 0){
            int i = 0;
            while(var.codigo != var.mesa[i] && i < 29){
                i++;
            }
            if(var.codigo == var.mesa[i]){
                var.lugaresMesa = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de lugares a reservar: "));
                if(var.qtde[i] >= var.lugaresMesa){
                    var.qtde[i] = var.qtde[i] - var.lugaresMesa;
                    var.lugares = var.lugares - var.lugaresMesa;
                }else{
                    JOptionPane.showMessageDialog(null, "Não á lugares à reservar");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Codigo de mesa invalido");
            }
            var.codigo = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Código (100 - 129) ou 0 para terminar: "));
            if(var.lugares == 0){
                JOptionPane.showMessageDialog(null, "Esgotado");
            }else{
                JOptionPane.showMessageDialog(null, "Lugares Vagos");
                for(i=0; i<30; i++){
                    if(var.qtde[i]!=0){
                        JOptionPane.showMessageDialog(null, "Mesa " + var.mesa[i] + " total de lugares: " + var.qtde[i]);
                    }
                }
            }
        }
    }
}