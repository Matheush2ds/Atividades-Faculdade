import java.util.Scanner;

public class Conta {

    double saldo;
    String numeroConta;
    double limite;

    Conta[] registrar(Conta contas[]) {
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < contas.length; i++) {
            contas[i] = new Conta();
            System.out.println("Conta " + (i+1));
            System.out.print("Número da Conta: ");
            contas[i].numeroConta = scanner.nextLine();
            System.out.print("Saldo: R$");
            contas[i].saldo = scanner.nextDouble();
            System.out.print("Limite da conta: R$");
            contas[i].limite = scanner.nextDouble();
            scanner.nextLine();
        }
        return contas;
    }

    void exibirContas(Conta contas[]) {
        for(int i = 0; i < contas.length; i++) {
            System.out.println("Conta " + (i+1) + ": " + contas[i].numeroConta);
        }
    }

    void sacar(Conta contas[], Conta c) {
        Scanner scanner = new Scanner(System.in);
        int contaSacar;
        System.out.println("Escolha a conta:");
        c.exibirContas(contas);
        contaSacar = scanner.nextInt();
        double retirar;
        System.out.print("Valor do saque: R$");
        retirar = scanner.nextDouble();
        if((contas[contaSacar-1].saldo - retirar) >= contas[contaSacar-1].limite) {
            contas[contaSacar-1].saldo = contas[contaSacar-1].saldo - retirar;
            System.out.printf("Saque realizado!!\nSaldo: R$%.2f", contas[contaSacar-1].saldo);
        } else {
            System.out.println("Não é possível realizar saque!! Limite atingido!!");
        }
    }

    void depositar(Conta contas[], Conta c) {
        Scanner scanner = new Scanner(System.in);
        double valor;
        int contaDepositar;
        System.out.print("Valor do depósito: R$");
        valor = scanner.nextDouble();
        System.out.println("Escolha a conta:");
        c.exibirContas(contas);
        contaDepositar = scanner.nextInt();

        contas[contaDepositar-1].saldo = contas[contaDepositar-1].saldo + valor;
        System.out.printf("Deposito realizado!!\nSaldo: R$%.2f", contas[contaDepositar-1].saldo);
    }

    void transferir(Conta contas[], Conta c) {
        Scanner scanner = new Scanner(System.in);
        int escolhaSacar;
        int escolhaDepositar = 0;
        double valor;
        System.out.println("Escolha a conta que realizará a transferência:");
        c.exibirContas(contas);
        escolhaSacar = scanner.nextInt();

        do {
            System.out.println("Escolha a conta que receberá a transferência:");
            c.exibirContas(contas);
            escolhaDepositar = scanner.nextInt();
        }while(escolhaSacar == escolhaDepositar);

        System.out.println("Valor da transferência: R$");
        valor = scanner.nextDouble();
        if((contas[escolhaSacar-1].saldo - valor) >= limite) {
            contas[escolhaSacar-1].saldo = contas[escolhaSacar-1].saldo - valor;
            contas[escolhaDepositar-1].saldo = contas[escolhaDepositar-1].saldo + valor;
            System.out.printf("Transferência realizada!! Saldo do remetente: R$%.2f", contas[escolhaSacar-1].saldo);
            System.out.printf(" Saldo do destinatário: R$%.2f", contas[escolhaDepositar-1].saldo);
        } else {
            System.out.println("Não é possível realizar transferência!! Limite da conta remetente atingido!!");
        }
    }
}