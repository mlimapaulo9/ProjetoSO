.macro done
li $v0,10
syscall
.end_macro

.macro print_int (%x)
li $v0, 1
add $a0, $zero, %x
syscall
.end_macro

.macro print_char (%x)
li $v0, 11
add $a0, $zero, %x
syscall
.end_macro

.macro print_string(%str)
.data
	mystring: .asciiz %str
.text
li $v0, 4
la $a0, mystring
syscall
.end_macro 

.macro read_int
li $v0,5
syscall
.end_macro 

.macro read_char
li $v0, 12
syscall
.end_macro 

.macro read_string(%str)
.data
	mystring: .asciiz %str
	tam: .space 50
.text 
	li $v0, 8
	la $a0, tam
	li $a1, 50
	move $t0, $a0
	syscall
.end_macro 

