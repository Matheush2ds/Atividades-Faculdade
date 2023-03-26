import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        Fila F = new Fila();
        Lavados Fl = new Lavados();
        Carros Resp = new Carros();

        String modelo[] = {"Polo", "Concel2", "Fusca", "Ranger Rover", "Evoque", "Civic", "Corsa", "Gran Siena", "Jeep", "Hilux", "Camaro", "Tesla", "Gol", "Dodge Ram", "Parati"};
        String dono = "Dono";

        Carros a1 = new Carros (); // 01
            a1.id = 01; 
            a1.modelo = modelo[0];
            a1.dono = dono.concat("1");
            F.insere(a1);
            Fl.insere(a1);
            
        Carros a2 = new Carros (); // 02
            a2.id = 02;
            a2.modelo = modelo[1];
            a2.dono = dono.concat("2");
            F.insere(a2);
            Fl.insere(a2);
        
        Carros a3 = new Carros (); // 03
            a3.id = 03;
            a3.modelo = modelo[2];
            a3.dono = dono.concat("3");
            F.insere(a3);
            Fl.insere(a3);
        
        Carros a4 = new Carros (); // 04
            a4.id = 04;
            a4.modelo = modelo[3];
            a4.dono = dono.concat("4");
            F.insere(a4);
            Fl.insere(a4);
            
        Carros a5 = new Carros (); // 05
            a5.id = 05;
            a5.modelo = modelo[4];
            a5.dono = dono.concat("5");
            F.insere(a5);   
            Fl.insere(a5); 
            
        Carros a6 = new Carros (); // 06
            a6.id = 06;
            a6.modelo = modelo[5];
            a6.dono = dono.concat("6");
            F.insere(a6);
            Fl.insere(a6);
            
        Carros a7 = new Carros (); // 07
            a7.id = 07;
            a7.modelo = modelo[6];
            a7.dono = dono.concat("7");
            F.insere(a7);
            Fl.insere(a7);
            
        Carros a8 = new Carros (); // 08
            a8.id = 010;
            a8.modelo = modelo[7];
            a8.dono = dono.concat("8");
            F.insere(a8);
            Fl.insere(a8);
            
        Carros a9 = new Carros (); // 09
            a9.id = 011;
            a9.modelo = modelo[8];
            a9.dono = dono.concat("9");
            F.insere(a9);
            Fl.insere(a9);
            
        Carros a10 = new Carros (); // 10
            a10.id = 012;
            a10.modelo = modelo[9];
            a10.dono = dono.concat("10");
            F.insere(a10);
            Fl.insere(a10);
            
        Carros a11 = new Carros (); // 11
            a11.id = 013;
            a11.modelo = modelo[10];
            a11.dono = dono.concat("11");
            F.insere(a11);
            Fl.insere(a11);
            
        Carros a12 = new Carros (); // 12
            a12.id = 014;
            a12.modelo = modelo[11];
            a12.dono = dono.concat("12");
            F.insere(a12);
            Fl.insere(a12);
        
        Carros a13 = new Carros (); // 13
            a13.id = 015;
            a13.modelo = modelo[12];
            a13.dono = dono.concat("13");
            F.insere(a13);
            Fl.insere(a13);
            
        Carros a14 = new Carros (); // 14
            a14.id = 016;
            a14.modelo = modelo[13];
            a14.dono = dono.concat("14");
            F.insere(a14);
            Fl.insere(a14);
            
        Carros a15 = new Carros (); // 15
            a15.id = 017;
            a15.modelo = modelo[14];
            a15.dono = dono.concat("15");
            F.insere(a15);
            Fl.insere(a15);
        
        int contador = 0;
        for(int i = 0;i < 3;i++){
            System.out.println("Entrando Carro...");
            contador+=1;
        }
        while(!F.fila_vazia()){
            Resp = (Carros) F.remove();
            System.out.println("Saindo carro: ");
            System.out.println("Identificador " + Resp.id);
            System.out.println("Modelo: " + Resp.modelo);
            System.out.println("Dono: " + Resp.dono);
            System.out.println("Entrando Carro fila Limpo...");

            if(contador != 15){
                System.out.println("----------------------------");
                System.out.println("Entrando Carro...");
                System.out.println("----------------------------");
                contador+=1;
            }
        }
        int op = Integer.parseInt(JOptionPane.showInputDialog("Fila de carros limpos Completa e ordenada!\nDeseja Ver? (1 - S)"));
        if(op == 1){
            while(!Fl.fila_vazia()){
                Resp = (Carros) Fl.remove();
                System.out.println("----------------------------");
                System.out.println("Identificador " + Resp.id);
                System.out.println("Modelo: " + Resp.modelo);
                System.out.println("Dono: " + Resp.dono);
                System.out.println("----------------------------");
            }
        }
    }
}