.data
	# Vetor 'dados' de bytes
	dados: .byte 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33, 10
.text
.globl main #deve ser global
	main: 

	li $v0, 4
	la $a0,dados	
	syscall

	jal func

	# Terminando o programa
	li   $v0, 10
	syscall
	
	func:
	#b= 4
	#c= 10
	#d= 5
	#e= 2
	
	li $s2, 5
	li $s3, 2
	li $s1, 10
	li $s4, 4
	
	sub $t1, $s2, $s3     
	sub $t1, $s1, $t1   
	add $s0, $s4, $t1
	
	li $v0, 1
	la   $a0, ($s0)
	syscall
	jr $ra