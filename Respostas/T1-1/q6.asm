.text

.globl main
	main:
	
	#a = 1
	#b = 2
	
	li $s1, 1
	li $s2, 2
	
	ble $s1,$s2,L1
	
	
	li $v0,10
	syscall
	
	L1:
	
	add $s1,$s1,$s2
	
	L2:
	
	sub $s1,$s1,$s2	