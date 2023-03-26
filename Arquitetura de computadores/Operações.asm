#2 numeros e operações
.data
opcao: .asciiz "digite\n 1 para SOMA\n 2 para SUBTRAIR\n 3 para MULTIPLICAR \n 4 para DIVIDIR: "
valor1: .asciiz "digite um valor: "
valor2: .asciiz "digite um valor: "
resultado: .asciiz "O resultado e: "

	.text

li $v0, 4
la $a0, opcao
syscall

addi $s1, $zero,1
addi $s2, $zero,2
addi $s3, $zero,3
addi $s4, $zero,4

    li $v0,5
    syscall

	beq $v0,$s1,soma
	beq $v0,$s2,subtrair  
	beq $v0,$s3,multiplicar
	beq $v0,$s4,dividir

	soma:

	li $v0, 4
	la $a0, valor1
	syscall
	li $v0, 5
	syscall
	move $t2, $v0

	li $v0, 4
	la $a0, valor2
	syscall
	li $v0, 5
	syscall
	move $t3, $v0
	
	add $t4, $t2,$t3
	
	li $v0, 4
	la $a0, resultado
	syscall
	li $v0, 1
	move $a0, $t4
	syscall
	
	li $v0, 10
	syscall
		
	subtrair:
	
	li $v0, 4
	la $a0, valor1
	syscall
	li $v0, 5
	syscall
	move $t2, $v0

	li $v0, 4
	la $a0, valor2
	syscall
	li $v0, 5
	syscall
	move $t3, $v0
	
	sub $t4, $t2,$t3
	
	li $v0, 4
	la $a0, resultado
	syscall
	li $v0, 1
	move $a0, $t4
	syscall
	
	li $v0, 10
	syscall
	
	multiplicar:
	
	li $v0, 4
	la $a0, valor1
	syscall
	li $v0, 5
	syscall
	move $t2, $v0

	li $v0, 4
	la $a0, valor2
	syscall
	li $v0, 5
	syscall
	move $t3, $v0
	
	mul $t4, $t2,$t3
	
	li $v0, 4
	la $a0, resultado
	syscall
	li $v0, 1
	move $a0, $t4
	syscall
	
	li $v0, 10
	syscall
	
	dividir:
	
	li $v0, 4
	la $a0, valor1
	syscall
	li $v0, 5
	syscall
	move $t2, $v0

	li $v0, 4
	la $a0, valor2
	syscall
	li $v0, 5
	syscall
	move $t3, $v0
	
	div $t4, $t2,$t3
	
	li $v0, 4
	la $a0, resultado
	syscall
	li $v0, 1
	move $a0, $t4
	syscall
