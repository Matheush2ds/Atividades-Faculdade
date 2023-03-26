.data

msg1: .asciiz "Digite um valor inteiro: "
msg_dobro: .asciiz "O dobro é "

.text

li $v0, 4
la $a0, msg1
syscall 

li $v0, 5
syscall
move $t1, $v0

mul $t2, $t1, 2

li $v0, 4
la $a0, msg_dobro
syscall

li $v0, 1
move $a0, $t2
syscall