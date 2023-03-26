import javax.swing.JOptionPane;
import java.util.ArrayDeque;
import java.util.Deque;

public class App {
    public static void main(String[] args) throws Exception {

        Pessoa pessoa = new Pessoa();
        Deque<Pessoa> dequep0 = new ArrayDeque<Pessoa>();
        Deque<Pessoa> dequep1 = new ArrayDeque<Pessoa>();
        Deque<Pessoa> dequep2 = new ArrayDeque<Pessoa>();
        Deque<Pessoa> dequep3 = new ArrayDeque<Pessoa>();
        for(int i = 1; i < 15 ; i++){
            pessoa.id = i;
            pessoa.sexo = JOptionPane.showInputDialog("Sexo");
            pessoa.idade = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
            int prioridade = Integer.parseInt(JOptionPane.showInputDialog("0 - Normal\n1 - Acima de 60 anos\n2 - Necessidades Especiais\n3 Gestante/lactante"));
            if(prioridade == 0){
                dequep0.addFirst(pessoa);
            }else if(prioridade == 1){
                dequep1.addFirst(pessoa);
            }else if(prioridade == 2){
                dequep2.addFirst(pessoa);
            }else if(prioridade == 3){
                dequep3.addFirst(pessoa);
            }
        }
        System.out.println("Iniciando atendimento\n----------------");
        while(!dequep0.isEmpty() && !dequep1.isEmpty() && !dequep2.isEmpty() && !dequep3.isEmpty()){
            if(dequep3.size()!=0){
                System.out.println("Atendendo gestantes/lactantes");
                dequep3.removeLast();
            }
            if(dequep2.size()!=0){
                System.out.println("Atendendo Pessoa com Necessidades Especiais");
                dequep2.removeLast();
            }
            if(dequep1.size()!=0){
                for(int i = 0; i<3; i++){
                    if(dequep1.size() != 0){
                        System.out.println("Atendendo Pessoa Acima de 60 anos");
                        dequep1.removeLast();
                    }
                }
            }
            if(dequep0.size()!=0){
                for(int i = 0; i<5; i++){
                    if(dequep0.size() != 0){
                        System.out.println("Atendimento Normal");
                        dequep0.removeLast();
                    }
                }
            }
        }
    }
}