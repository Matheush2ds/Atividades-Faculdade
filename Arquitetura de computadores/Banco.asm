.data		
sal:	.asciiz	"Informe o sado Inicial: "
menu: .asciiz	"\n### MENU ###\n1 - Mostrar o saldo\n2 - Depositar\n3 - Efeturar o saque\n0 - Sair\nOpção: "
outsal:	.asciiz	"SALDO = "
outdep:	.asciiz	"Seu NOVO SALDO após o Depósito é: "
outdep2: .asciiz"Informe seu Depósito: "
outsaq:	.asciiz	"Seu NOVO SALDO após o Saque é: "
outsaq2: .asciiz "Digite seu saque "
out:.asciiz	"Sistema Finalizado!\n"


.text		
.globl main	# Diretiva global

main:		

li $v0, 4	
la $a0, sal	
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
la $a0, outsal	# Carrega outsal no registrador a0
syscall

li $v0, 1	
move $a0, $t0	
syscall
jr $ra		# Volta para que o chamou (ja1)


deposito:			

li $v0, 4			
la $a0, outdep2	
syscall

li $v0, 5		
syscall
move $t2, $v0	

add $t0, $t0, $t2	
li $v0, 4	
la $a0, outdep	# Carrega otdep no registrador a0
syscall

li $v0, 1
move $a0, $t0		
syscall
jr $ra				# volta para que o chamou (ja1)


saque:

li $v0, 4			# Imprimi uma string
la $a0, outsaq2	# Carrega outdsaq2 no registrador a0
syscall

li $v0, 5			
syscall
move $t4, $v0		

sub $t0, $t0, $t4# SUBTRAI t0 = t0 - t4
li $v0, 4	
la $a0, outsaq	# Carrega otdep no registrador a0
syscall

li $v0, 1
move $a0, $t0		
syscall
jr $ra# volta para que o chamou


sair:

li $v0, 4
la $a0, out
syscall

li $v0, 10
syscall