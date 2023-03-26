#include <stdio.h>
#include <stdlib.h>

int print_campo(int tamanho, int tabuleiro[tamanho][tamanho]){

	int confere = 1;
	for(int i = 0; i < tamanho; i++){
		for(int j = 0; j < tamanho; j++){

			
			if(tabuleiro[i][j] < 10 && tabuleiro[i][j] != -1){
				printf("%d\t", tabuleiro[i][j]);
			}else if(tabuleiro[i][j] == -1){
				 
				printf("*\t");
			}
			else{
				
				confere = 0;
				printf("*\t");
			}

		}
		printf("\n");
	}
	return confere;

}

void enumera_campo(int tamanho, int x, int y, int tabuleiro[tamanho][tamanho]){
	if(x-1 >= 0){
		if (tabuleiro[x-1][y] != -1) {
				tabuleiro[x-1][y] += 1;
		}
		if(y-1 >= 0 && tabuleiro[x-1][y-1] != -1){
			tabuleiro[x-1][y-1] += 1;
		}
		if(y+1 < tamanho && tabuleiro[x-1][y+1] != -1){
			tabuleiro[x-1][y+1] += 1;
		}
	}
	if(x+1 < tamanho){
		if(tabuleiro[x+1][y] != -1){
			tabuleiro[x+1][y] += 1;
		}
		if (y+1 < tamanho && tabuleiro[x+1][y+1] != -1){
			tabuleiro[x+1][y+1] += 1;
		}
		if (y-1 >=0 && tabuleiro[x+1][y-1] != -1){
			tabuleiro[x+1][y-1] += 1;
		}
	}
	if (y-1 >=0 && tabuleiro[x][y-1] != -1){
		tabuleiro[x][y-1] += 1;
	}
	if (y+1 < tamanho && tabuleiro[x][y+1] != -1){
		tabuleiro[x][y+1] += 1;
	}

}

void zera_campo(int tamanho, int tabuleiro[tamanho][tamanho]){
	for(int i = 0; i < tamanho; i++){
		for(int j = 0; j < tamanho; j++){
			tabuleiro[i][j] = 10;
		}
	}
}


void revela_campo(int tamanho, int tabuleiro[tamanho][tamanho], int x, int y){
	if(x-1 >= 0 && tabuleiro[x-1][y] != 0){
		tabuleiro[x-1][y] %= 10;

		if(tabuleiro[x-1][y] == 0){
			revela_campo(tamanho,tabuleiro, x-1, y);
		}

		if(y+1 < tamanho && tabuleiro[x-1][y+1] != 0){
			tabuleiro[x-1][y+1] %= 10;
			if (tabuleiro[x-1][y+1] == 0) {
				revela_campo(tamanho, tabuleiro, x-1, y+1);
			}
		}
		if(y-1 >= 0 && tabuleiro[x-1][y-1] != 0){
				tabuleiro[x-1][y-1] %= 10;
				if (tabuleiro[x-1][y-1] == 0) {
					revela_campo(tamanho, tabuleiro, x-1, y-1);
				}
		}
	}

	if(x+1 < tamanho && tabuleiro[x+1][y] != 0){
		tabuleiro[x+1][y] %= 10;
		if(tabuleiro[x+1][y] == 0){
			revela_campo(tamanho,tabuleiro, x+1, y);
		}

		if(y+1 < tamanho && tabuleiro[x][y+1] != 0){
			tabuleiro[x+1][y+1] %= 10;
			if (tabuleiro[x+1][y+1] == 0) {
				revela_campo(tamanho, tabuleiro, x+1, y+1);
			}
		}
		if(y-1 >= 0 && tabuleiro[x+1][y-1] != 0){
				tabuleiro[x+1][y-1] %= 10;
				if (tabuleiro[x+1][y-1] == 0) {
					revela_campo(tamanho, tabuleiro, x+1, y-1);
				}
		}
	}

	if(y-1 >=0 && tabuleiro[x][y-1] != 0){
		tabuleiro[x][y-1] %= 10;
		if (tabuleiro[x][y-1] == 0) {
			revela_campo(tamanho, tabuleiro, x, y-1);
		}
	}
	if (y+1 < tamanho && tabuleiro[x][y+1] != 0) {
		tabuleiro[x][y+1] %= 10;
		if (tabuleiro[x][y+1] == 0) {
			revela_campo(tamanho, tabuleiro, x, y+1);
		}
	}
}

void jogada(int tamanho, int tabuleiro[tamanho][tamanho], int x, int y){
	if (tabuleiro[x][y] == -1){

		printf("\n\n**KABUM**\n\n");
		exit(1);
	}else if(tabuleiro[x][y] > 0){

		tabuleiro[x][y] %= 10;
		if (tabuleiro[x][y] == 0){

			revela_campo(tamanho,tabuleiro,x,y);
		}
	}
}

int main()
{
    int tamanho;
    while(1) {
        printf("Insira o tamanho do campo: ");
        scanf("%d", &tamanho);
        fflush(stdin);
        
        if(tamanho >= 2 && tamanho <= 10){
            break; 
        }
        printf("Tamanho mínimo do tabuleiro é 2x2 e o máximo 10x10");
    }

    int tabuleiro[tamanho][tamanho];

    zera_campo(tamanho, tabuleiro);

    int bombas = tamanho + 1; 


    for (int i = 0; i < bombas; i++){
        int x, y;
	while (1){
		x = rand() % tamanho;
        	y = rand() % tamanho;

		if (tabuleiro[x][y] != -1){
			break;
		}
	}

	printf("x: %d, y: %d\n", x+1, y+1);

  	tabuleiro [x][y] = -1;

	enumera_campo(tamanho, x, y, tabuleiro);

    }

    int x, y;

    print_campo(tamanho, tabuleiro);

    while (1){
        printf ("Digite a coordenada X: ");
        scanf("%d", &x);
        printf("Digite a coordenada Y: ");
        scanf("%d", &y);

        if(x > tamanho || y > tamanho || x < 1 || y < 1){
            printf ("coordenadas incongruentes");
        }else {

		jogada(tamanho, tabuleiro, x-1, y-1);
	}
	  

	if (print_campo(tamanho, tabuleiro)){
		printf("Ganhou!!");
		return 0;
	}
    }
    return 0;
}