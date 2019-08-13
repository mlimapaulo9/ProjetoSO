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
	SyscallFork(Consumidor,Idle, 1)
	SyscallFork(Idle, Fim,2)
	SyscallProcessChange
	
	
	Produtor:
loop1:
	DownSemaphore(empty)
	DownSemaphore(mutex)
	
        addi $s4, $s4, 1 #Coloca um item no buffer

	
	
	UpSemaphore(mutex)
	UpSemaphore(full)
	
	beq $s3, $s4 loop1 #Verifica se o contador atingiu o valor do buffer
	j loop1
	
	 
 Consumidor:
 loop2:
 	DownSemaphore(full) #Decrementa lugares no buffer
 	DownSemaphore(mutex) #Decrementa o mutex
        
	
       subi $s4, $s4, 1 #decrementar o buffer
      #SE BUFFER ATINGIR O TAMANHO MÍNIMMO CHAMA DOWN FULL E MUTEX PRA BLOQUEAR ELE - O TAMANHO MINIMO AQUI É 0
      
      la $t0, full #Carrega o endereço do full
      lw $s7 ,0($t0)#Carrega o valor do full
      beqz $s7, loop2
       
       UpSemaphore(mutex)
       UpSemaphore(empty)
       
       j loop2


Idle:							
	loop:	NOP				
		j loop
Fim: NOP		





