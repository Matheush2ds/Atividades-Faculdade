	.data
	n: .asciiz "Digite um valor inteiro: "
	msg: .asciiz "O Fatorial de" 

	.text
	li $v0, 4
	la $a0, n
	syscall
	li $v0, 5
	syscall
	li $t3,1 
	li $t0,1
	lw $t1, 
	
	fatorialN: 
	 beq $t0,$t1,saida
	 addi $t0,$t0,1
	 mult $t3, $t0
         mflo $t3
         j fatorialN
	
	saida:
		 
	move $a0, $t3
	li $v0,1
	syscall 