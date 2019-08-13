.include "macros.asm"
	.data
mutex: .word 1 #sessão critica
empty: .word 10 #Lugares vazios no buffer
full: .word 0 #Lugares preenchidos no buffer
buffer:	.word 10
contador : .word 0 #Inicia o contador com 0
       .text
       
                                            
	CreateSemaphore(mutex)   #declaracao dos semáforos mutex
	CreateSemaphore(empty)   #empty
	CreateSemaphore(full)  # e o full
	
	
	la $t0, buffer #Carrega o endereço do buffer
	lw $s3 ,0($t0)  #careega o o valor do bufer
	la $t0 contador #Carrega o endereço do contador
	lw $s4 ,0($t0)  #careega o o valor do contador
	
	SyscallFork(Produtor, Consumidor, 1)
	SyscallFork(Consumidor,fim2, 1)
	#SyscallFork(Idle, Fim,2)
	SyscallProcessChange
	
	
	Produtor:
loop1:
	DownSemaphore(empty)
	DownSemaphore(mutex)
	
        addi $s4, $s4, 1 #Coloca um item no buffer

	
	
	UpSemaphore(mutex)
	UpSemaphore(full)

	j loop1
	
	 
 Consumidor:
 loop2:
 	DownSemaphore(full) #Decrementa lugares no buffer
 	DownSemaphore(mutex) #Decrementa o mutex
        
	
       subi $s4, $s4, 1 #decrementar o buffer
     
    
       UpSemaphore(mutex)
       UpSemaphore(empty)
       
       j loop2
       
fim2:




