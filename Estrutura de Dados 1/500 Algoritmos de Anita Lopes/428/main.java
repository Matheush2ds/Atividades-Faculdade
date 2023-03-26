import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        Variaveis var = new Variaveis();

        for(var.linha=0; var.linha<10; var.linha++){
            var.dados[var.linha][0] = Integer.parseInt(JOptionPane.showInputDialog("Digite a matricula formato aascccnnn: "));
            var.aux = var.dados[var.linha][0] / 1000000;
            var.aux = var.dados[var.linha][0] - var.aux * 1000000;
            var.dados[var.linha][2] = var.aux / 1000;
            var.dados[var.linha][1] = Integer.parseInt(JOptionPane.showInputDialog("Sexo (0 - Fem/1 - Masc)"));
            var.dados[var.linha][3] = Integer.parseInt(JOptionPane.showInputDialog("CR Do aluno(a): "));
        }
        var.codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo do curso"));
        var.pos = 0;
        for(var.linha=0; var.linha<10; var.linha++){
            if(var.dados[var.linha][2] == var.codigo && var.dados[var.linha][0]==0){
                var.pos = var.linha;
            }else if(var.dados[var.linha][3]>var.dados[var.pos][3]){
                var.pos = var.linha;
            }
        }
        JOptionPane.showMessageDialog(null, "Aluno(a) premiada matricula: " + var.dados[var.pos][0] + " teve CR: " + var.dados[var.pos][3]);   
    }
}