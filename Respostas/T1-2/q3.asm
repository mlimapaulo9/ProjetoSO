# Calcula f = (g+h)-(i+j)
.include "macros.asm"
.data
      g: .word  5	# valor 5 armazenado em g
      h: .word  2	# valor 2 armanazenado em h
      i: .word  1	# valor 1 armanazenado em i
      j: .word  3	# valor 3 armanazenado em j
      f: .word  0	# valor 0 armanazenado em f
.macro return (%z) 
  add $t0,$zero,%z	
  beqz $t0,sucesso
  li $v0, 17
  li $a0, %z
  syscall
  
  sucesso:
  	done  
.end_macro 
	
	
.text
      # carrengando os valores da memoria
#      la  $t0, g        # carrega o endereco de g em $t0
#      lw  $s1, 0($t0)	# carrega o valor de g em $s1
      load_var(g,$s1)	
#      la  $t0, h        # carrega o endereco de h em $t0
#      lw  $s2, 0($t0)	# carrega o valor de h em $s2
      load_var(h, $s2)	
#      la  $t0, i        # carrega o endereco de i em $t0
#      lw  $s3, 0($t0)	# carrega o valor de i em $s3
      load_var(i, $s3)	
#      la  $t0, j        # carrega o endereco de j em $t0
#      lw  $s4, 0($t0)	# carrega o valor de j em $s4
      load_var(j,$s4)
      
      #Realizando o calculo
      add $t0, $s1, $s2	#soma g e h
      add $t1, $s3, $s4	#soma i e j
      sub $s0, $t0, $t1	#(g+h)-(i+j)
      
      #Armazena o resultado na memoria
      la  $t0, f        # carrega o endereco de f em $t0
      sw $s0, 0($t0)	# armazena o valor
      
      print_int($s0)					
      
      return(-2)	
