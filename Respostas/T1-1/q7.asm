.text

.globl main
	main:
	
	#a = 1
	#b = 2
	
	li $v0, 5
	syscall
	move $s1, $v0	
	
	li $v0, 5
	syscall
	move $s2, $v0	
	
	li $v0,1
	la $a0,($s1) 
	syscall

	li $v0,1
	la $a0,($s2) 
	syscall
	
	li $v0,10
	syscall