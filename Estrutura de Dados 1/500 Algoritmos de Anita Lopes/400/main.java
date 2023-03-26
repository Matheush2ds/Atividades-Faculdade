import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {

        Variaveis var = new Variaveis();

        var.op = Integer.parseInt(JOptionPane.showInputDialog("Hotel Fazenda Sucesso\n1. Cadastra quartos\n2. Lista todos os quartos\n3. Lista quartos desocupados\n4. Aluguel/Reserva quarto\n5. Entra despesas extra\n6. Calcular despesa do quarto\n7. Sair\n\nOpcao:"));

        if(var.op==1){
            if(var.chave == 1){
                JOptionPane.showMessageDialog(null, "Atencao. Ddos ja cadastrados");
            }else{
                for(int i = 0; i<50; i++){
                    var.sit[i] = "L";
                    var.nd[i] = 0;
                    var.despesas[i] = 0;
                    var.din[i] = "XXXX";
                    var.dout[i] = "XXXX";
                    var.nome[i] = "";
                    var.tel[i] = "";
                    var.leitos[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de leitos para o quarto " + (i+1)));
                    var.preco[i] = Double.parseDouble(JOptionPane.showInputDialog("Preço do quarto: "));
                }
                var.chave = 1;   
            }
        }else if(var.op == 2){
                if(var.chave == 0){
                    JOptionPane.showMessageDialog(null, "Escolha a opcao 1");
                }else{
                    for(int i = 0; i<50; i++){
                        JOptionPane.showMessageDialog(null, "Numero do quarto: " + (i+1));
                        JOptionPane.showMessageDialog(null, "Despesas: " + var.despesas[i]);
                        if(var.sit[i] == "A" || var.sit[i] == "R"){
                            JOptionPane.showMessageDialog(null, "Nome: " + var.nome[i] + "\nTelefone: " + var.tel[i]);
                            JOptionPane.showMessageDialog(null, "Quantidade de leitos: " + var.leitos[i]);
                            JOptionPane.showMessageDialog(null, "Preco do quarto" + var.preco[i]);
                            JOptionPane.showMessageDialog(null, "Despesas" + var.despesas[i]);
                            JOptionPane.showMessageDialog(null, "Data de entrada: " + var.din[i]);
                            JOptionPane.showMessageDialog(null, "Data de saída: " + var.dout[i]);
                            JOptionPane.showMessageDialog(null, "Numero de Dias: " + var.nd[i]);
                            var.respo = JOptionPane.showInputDialog("Pressione enter para continuar");
                        }
                    }
                }
        }else if(var.op == 3){
            if(var.chave == 0){
                JOptionPane.showMessageDialog(null, "Escolha a opcao 1"); 
            }else{
                for(int i=0; i<50; i++){
                    if(var.sit[i] == "A"){
                        JOptionPane.showMessageDialog(null, "Numero do quarto: " + (i+1));
                        JOptionPane.showMessageDialog(null, "Despesas: " + var.despesas[i]);
                        JOptionPane.showMessageDialog(null, "Data de entrada: " + var.din[i]);
                        JOptionPane.showMessageDialog(null, "Data de saída: " + var.dout[i]);
                        JOptionPane.showMessageDialog(null, "Numero de Dias: " + var.nd[i]);
                        var.respo = JOptionPane.showInputDialog("Pressione enter para continuar");
                    }
                }
            }
        }else if(var.op == 4){
            if(var.chave == 0){
                JOptionPane.showMessageDialog(null, "Escolha a opcao 1");  
            }else{
                var.resp = JOptionPane.showInputDialog("Digite A(aluguel) R(reserva): ");
                while(var.resp != "A" && var.resp != "a" && var.resp != "r" && var.resp != "R"){
                    var.resp = JOptionPane.showInputDialog("Resposta inválida! Digite A(aluguel) R(reserva): ");
                }if(var.resp == "A" || var.resp == "a"){
                    var.resp1 = JOptionPane.showInputDialog("Tinha reserva? (S/N)");
                    if(var.resp1 == "S" || var.resp1 == "s"){
                        var.nomep = JOptionPane.showInputDialog("Entre com nome: ");
                        int i = 0;
                        while(var.nomep != var.nome[i] && i <49){
                            i++;}
                        if(var.nomep == var.nome[i]){
                            var.quarto = i;
                            var.sit[i] = "A";
                            var.despesas[i] = 0;
                            JOptionPane.showMessageDialog(null, "Data de entrada: " + var.din[i]);
                            JOptionPane.showMessageDialog(null, "Data de saída: " + var.dout[i]);
                            JOptionPane.showMessageDialog(null, "Numero de Dias: " + var.nd[i]);
                        }else{
                            JOptionPane.showMessageDialog(null, "Reserva não encontrada");
                            var.resp1 = "N";
                        }
                    }else if(var.resp1 == "N" || var.resp1 == "n" || var.resp == "R" || var.resp == "r"){
                        for(int i = 0; i<50; i++){
                            if(var.sit[i] == "L"){
                                JOptionPane.showMessageDialog(null, "Numero do quarto: " + (i+1));
                                JOptionPane.showMessageDialog(null, "Quantidade de leitos: " + var.leitos[i]);
                                JOptionPane.showMessageDialog(null, "Preco do quarto: " + var.preco[i]);
                                var.respo = JOptionPane.showInputDialog("Pressione enter para continuar");
                            }
                        }
                        var.quarto = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do quarto para aluguel ou reserva"));
                        while(var.quarto <1 || var.quarto > 50){
                            var.quarto = Integer.parseInt(JOptionPane.showInputDialog("Quarto Inválido! Entre novamente: "));
                        }
                        while(var.sit[var.quarto - 1] == "A"){
                            var.quarto = Integer.parseInt(JOptionPane.showInputDialog("Quarto Ocupado! Entre novamente: "));
                        }
                        if(var.resp == "A" || var.resp == "a"){
                            var.sit[var.quarto-1] = "A";
                            var.despesas[var.quarto-1] = 0;
                        }else{
                            var.sit[var.quarto-1] = "R";
                            var.nome[var.quarto-1] = JOptionPane.showInputDialog("Digite o nome: ");
                            var.tel[var.quarto-1] = JOptionPane.showInputDialog("Digite o telefone: ");
                            var.din[var.quarto-1] = JOptionPane.showInputDialog("Data de entrada: ");
                            var.dout[var.quarto-1] = JOptionPane.showInputDialog("Data de saída: ");
                            var.nd[var.quarto-1] = Integer.parseInt(JOptionPane.showInputDialog("Numero de dias: "));
                        }
                    }
                }
            }
        }else if(var.op == 5){
            if(var.chave == 0){
                JOptionPane.showMessageDialog(null, "Escolha a opcao 1");  
            }else{
                var.quarto = Integer.parseInt(JOptionPane.showInputDialog("Entre numero quarto"));
                while(var.quarto < 1 || var.quarto > 50){
                    var.quarto = Integer.parseInt(JOptionPane.showInputDialog("Entre numero quarto"));
                }
                var.total = var.despesas[var.quarto-1] + var.preco[var.quarto-1];
                JOptionPane.showMessageDialog(null, "Despesas: R$" + var.total);
                var.sit[var.quarto-1] = "L";
                var.nd[var.quarto-1] = 0;
                var.despesas[var.quarto-1] = 0;
                var.din[var.quarto-1] = "XXXX";
                var.dout[var.quarto-1] = "XXXX";
                var.nome[var.quarto-1] = "";
                var.tel[var.quarto-1] = "";
            }
        }else if(var.op == 7){
            JOptionPane.showMessageDialog(null, "Finalizado!");
        }else{
            JOptionPane.showMessageDialog(null, "Opcao inválida");
        }
    }
}