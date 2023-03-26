.data
sistema:.asciiz "\nSISTEMA DE NOTAS"
nota1:.asciiz "\n Digite sua primeira nota: "
nota2:.asciiz "Digite a segunda nota: "
nota3:.asciiz "Digite a terceira nota: "
nota4:.asciiz "Digite a quarta nota: "
mediaFinal: .asciiz "Sua médiafinal é:  " 
paraMedia:.float 4.0

.text
li $v0, 4
la $a0, sistema
syscall

li $v0, 4
la $a0, nota1
syscall
li $v0, 6
syscall
mov.s  $f2, $f0

li $v0, 4
la $a0, nota2
syscall
li $v0, 6
syscall	
mov.s $f3, $f0

li $v0, 4
la $a0, nota3
syscall
li $v0, 6
syscall
mov.s $f4, $f0

li $v0, 4
la $a0, nota4
syscall
li $v0, 6
syscall
mov.s $f5, $f0

#SOMA NOTAS
add.s $f6, $f2, $f3
add.s $f7, $f4, $f5
add.s $f8, $f6, $f7

#DIVISÃO NOTAS
lwc1 $f9, paraMedia
div.s $f12, $f8, $f9

li $v0, 4 
la $a0, mediaFinal
syscall 
li $v0, 2 
mov.s  $f0, $f12
syscall