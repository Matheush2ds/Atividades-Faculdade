#include<iostream>
#include<time.h>
#include<locale>
#include<stdlib.h>
using namespace std;

main(){
    setlocale(LC_ALL, "Portuguese");

    int  minado[10][10], linha, coluna, le, ce;
    // o campo minado vai ser numa matriz de 10x10
    char ex[10][10];
    int x = 0;
    int bomba = 0;

    srand(time(NULL));

/*/Entra a ideia do Prototype: (permite copiar objetos existentes sem fazer seu código ficar dependente de suas classes.)
neste caso ele copia as colunas e linhas com  "*"
/*/
    for(linha=0; linha<10;linha++){
        for(coluna=0;coluna<10;coluna++){
            minado[linha][coluna] = rand()%2;
            minado[0][coluna] = 10;
            minado[linha][0] = 10;
            ex[linha][coluna] = '*';
        }
    }

// definindo os numeros de cada possição
    ex[0][0] = '0';
    ex[0][1] = '1';
    ex[0][2] = '2';
    ex[0][3] = '3';
    ex[0][4] = '4';
    ex[0][5] = '5';
    ex[0][6] = '6';
    ex[0][7] = '7';
    ex[0][8] = '8';
    ex[0][9] = '9';
    ex[0][10] = '10';

    ex[1][0] = '1';
    ex[2][0] = '2';
    ex[3][0] = '3';
    ex[4][0] = '4';
    ex[5][0] = '5';
    ex[6][0] = '6';
    ex[7][0] = '7';
    ex[8][0] = '8';
    ex[9][0] = '9';
    ex[10][0] = '10';


    /*/ Padrão State: (padrão de projeto comportamental que permite que um objeto altere o comportamento quando seu estado interno for alterado.)
    enquanto o x for igual a 0 ele irá continuar jogando
    /*/

    while(x == 0){
        //imprime a matriz
        for(linha=0;linha<10;linha++){
            cout<<"\n\n";
            for(coluna=0;coluna<10;coluna++){
                cout<<"   ";
                cout<<ex[linha][coluna];
            }
        }
        
        /*/
        * A partir daqui entra a ideia dos padrões Prototype na copia da bomba e Decorator (padrão que adicionar novos comportamentos aos objetos dinamicamente)
        // nesse padrão o comportamento da bomba se encaixa nele
        /*/
        
        cout<<"\n\n";
        cout<<" Digite um numero para coordenada y: ";
        cin>>le;
        // VAI LER A LINHA ESCOLHIDA
        cout<<"\n";
        cout<<" Digite um numero para cordenada x: ";
        cin>>ce;

        //Tratamento de erro: caso o numero seja maior que 10 e menor que 1 irá mostrar a mensagem
        if(le > 10 && le < 1){
             system("cls");
            cout<<"Escolha outra linha";
            system("cls");
        }
        else
            {

            if(ce > 10 && ce < 1){
            system("cls");
            cout<<"Escolha outra coluna";
            system("cls");
            }
            // caso o usuario nao digite a linha ou a coluna permitida o codigo ira pro else logo abaixo e testara se a linha ja foi jogada
            else{
            if(minado[le][ce] == 3){
            cout<<"\n\n";
            cout<<"Posição ja escolhida selecione outra!";
            system("cls");
            }else{

            if(minado[le][ce] == 1){
            system("cls");
            cout<<"\n\n\n";
            // se o jogador acerta uma bomba o jogo ira finalizar
            cout<<"KABUUM";
            cout<<"\n\n";
            cout<<" 'x' são Bomba\n";
            cout<<"\n\n";
            cout<<" 'o' são os campos sem bomba\n";

            for(linha=0;linha<5;linha++){
            cout<<"\n\n";
            for(coluna=0;coluna<5;coluna++){
                cout<<"   ";
                // vai mostrar os campos com bomba e sem bomba após perder
                if (minado[linha][coluna] == 0 or minado[linha][coluna] == 3) ex[linha][coluna] = 'o';
                cout<<ex[linha][coluna];
            }
        }
            x = 1;
            }else{

            //Muda de 0 para 3 para saber se ja foi jogado
             minado[le][ce] = 3;
             ex[le][ce] = 'o';

             for(linha=0; linha<10; linha++){
             for(coluna=0; coluna<10; coluna++){
             if(minado[linha][coluna] == 0){ bomba++; }
            }
            // se usuario nao acertou nenhuma bomba "chegar a 0", ele venceu o jogo e mostrará a mensagem
            }
             if(bomba == 0){
             cout<<"Você ganhou";
             x = 1;
             }
             bomba = 0;

                }
            }
        }
    }
}  }
