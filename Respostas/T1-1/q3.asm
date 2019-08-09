.data	
	b: .word 4
	c: .word 10
	d: .word 5
	e: .word 2			
.text
.globl main 
	main:
	#b= 4
	#c= 10
	#d= 5
	#e= 2
	
	li $s2, 5
	li $s3, 2
	li $s1, 9
	li $s4, 4
	
	sub $t1, $s2, $s3     
	sub $t1, $s1, $t1   
	add $s0, $s4, $t1
	
	li   $v0, 10
	syscall	