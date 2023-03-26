#Programa Estoque
	.data		
	est:.asciiz	"Informe o estoque Inicial: "
	menu:.asciiz	"\n### ESTOQUE ###\n1 - Mostrar o estoque\n2 - Inserir\n3 - Remover\n0 - Sair\nOpção: "
	outsal:.asciiz	"QUANTIDADE DE ITENS: "
	outdep:.asciiz	"Quantidade inserida:  "
	outdep2:.asciiz "Insira quantidade do estoque: "
	outsaq:.asciiz	"Seu estoque após remoção é: "
	outsaq2:.asciiz "Digite para remover item: "
	out:.asciiz	"Sistema Encerrado!\n"


	.text		
	.globl main
	main:		

	li $v0, 4	
	la $a0, est	
	syscall

	li $v0, 5	
	syscall
	move $t0, $v0	


	rep:
	li $v0, 4		
	la $a0, menu	
	syscall	

	li $v0, 5
	syscall
	move $t1, $v0	

	beq $t1, 0, sair
	jal opmenu
	j rep


	opmenu:	
	beq $t1, 1, saldo
	beq $t1, 2, deposito	
	beq $t1, 3, saque		

	saldo:		
	li $v0, 4	
	la $a0, outsal
	syscall

	li $v0, 1	
	move $a0, $t0	
	syscall
	jr $ra


	deposito:			
	li $v0, 4			
	la $a0, outdep2	
	syscall

	li $v0, 5		
	syscall
	move $t2, $v0	

	add $t0, $t0, $t2	
	li $v0, 4	
	la $a0, outdep
	syscall

	li $v0, 1
	move $a0, $t0		
	syscall
	jr $ra


	saque:
	li $v0, 4
	la $a0, outsaq2	
	syscall

	li $v0, 5			
	syscall
	move $t4, $v0		

	sub $t0, $t0, $t4
	li $v0, 4	
	la $a0, outsaq
	syscall

	li $v0, 1
	move $a0, $t0		
	syscall
	jr $ra


	sair:
	li $v0, 4
	la $a0, out
	syscall

	li $v0, 10
	syscall
