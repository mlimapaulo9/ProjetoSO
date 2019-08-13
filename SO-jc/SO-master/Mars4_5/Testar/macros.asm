# MACROS - As quest�es est�o quase todas nesse mesmo arquivo por se tratar da cria��o das Macros
.data
fim: .word 

 .macro SyscallFork(%a0, %k0, %k1)  # chamada para criar processo
 li $v0, 19
 la $a0, %a0 #Pega o endere�o inicial do programa
 la $k0, %k0 #Pega o endere�o final do programa (endere�o do pr�ximo programa - 4)

 subi $k0, $k0, 4
 li $k1, %k1 #Deffinie a prioridade
 syscall 
 .end_macro
 
  .macro SyscallProcessChange  # chamada para alternar entre processos
  li $v0, 20 
  syscall 
 .end_macro
 
  .macro SyscallProcessTerminate #Finalizar processo
  li $v0, 21
  syscall
 .end_macro
 
 .macro CreateSemaphore(%int) #Cria semaforo
  li $v0, 22
  la $a2, %int # $a2 recebe o endere�o da vari�vel inteira passada
  lw $a3, 0($a2) #Pega o valor da vari�vel int e guarda em $a3
  
  syscall
 .end_macro
 
 .macro TerminateSemaphore(%int) #Remover semaforos
  li $v0, 23
  la $a2, %int # $a2 recebe o endere�o da vari�vel inteira passada
  syscall
 .end_macro
 
 .macro DownSemaphore(%int) #Decrementa semaforo
  li $v0, 24
  la $a2, %int # $a2 recebe o endere�o da vari�vel inteira passada
  syscall
 .end_macro
 
 .macro UpSemaphore(%int) #incrementa semaforo
  li $v0, 25
  la $a2, %int # $a2 recebe o endere�o da vari�vel inteira passada
  syscall
 .end_macro
 
 .macro done #Finalizar
 li $v0, 10 # system call for exit
 syscall # we are out of here.
 .end_macro
 
 .macro return(%Cod_Erro) #Finalizar - QUEST�O 4
  li $a0, %Cod_Erro #Reccebe o c�digo de erro passado no par�metro
 
  blt $a0, $zero, Exit2   #Testa se $a0 � menor que zero   
  li $a0, 0  #Valor de retorno para encerramento normal do programa
  done
 
  Exit2:
  li $v0, 17 # system call for exit
  syscall # we are out of here.
 .end_macro 

#LEITURA E GRAVA��O
 .macro read_int #l� inteiro
 li $v0, 5 # system call for exit
 syscall # we are out of here.
 .end_macro

 .macro read_char #l� char
 li $v0, 8 # system call for exit
 li $a0, 0
 li $a1, 255
 syscall # we are out of here.
 .end_macro

 .macro read_string #l� string
 li $v0, 8 # system call for exit
 li $a0, 0
 li $a1, 255
 syscall # we are out of here.
 .end_macro
 
 .macro load_var(%var, %reg) #Carregar a vari�vel VAR no registrador REG
 la $t0, %var 
 lw %reg, 0($t0) 
 .end_macro

 .macro store_var(%var, %reg) #Gravar a vari�vel VAR no registrador REG
 la $t0, %var 
 sw %reg, 0($t0) 
 .end_macro
 



#IMPRESS�O
 .macro print_int #imprime inteiro
 li $v0, 1 # system call for exit
 syscall # we are out of here.
 .end_macro

 .macro print_char #imprime char
 li $v0, 4 # system call for exit
 syscall # we are out of here.
 .end_macro

 .macro print_string #imprime string
 li $v0, 8 # system call for exit
 syscall # we are out of here.
 .end_macro
