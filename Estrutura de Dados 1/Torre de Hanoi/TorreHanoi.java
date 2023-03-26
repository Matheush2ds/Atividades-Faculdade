import javax.swing.JOptionPane;

public class TorreHanoi {
    
    public static void main(String[] args) throws Exception {

        double discos = Double.parseDouble(JOptionPane.showInputDialog("Entre com quantidade de discos: "));
        double contador = Math.pow(2, discos)-1;
        long tempoInicial = System.currentTimeMillis();
        hanoi(discos, 'A', 'B', 'C');
        JOptionPane.showMessageDialog(null, "Quantidade de movimentos: " +  contador);
        long tempoFinal = System.currentTimeMillis();
        System.out.printf("O tempo total da execução foi de %.3f s%n" , (tempoFinal - tempoInicial)/1000d);
    }

    private static void hanoi(double discos, char pInicial, char pAux, char pFinal){
        if(discos > 0){
            hanoi(discos-1, pInicial, pFinal, pAux);
            System.out.printf("Movendo %s para %s\n" , pInicial, pFinal);
            hanoi(discos-1, pAux, pInicial, pFinal);
        }
    }
}


//Tempo:
//1 disco: 4,317 s
//10 discos: 4,231s
//20 Discos: 541.132s = 0,15 horas
//30 Discos: 16,243.96s = 4,51×10-3 horas
//40 Discos: 649,708.0s = 0,18 horas
//41 Discos: 6,497,031s = 1,8×10-3 horas
