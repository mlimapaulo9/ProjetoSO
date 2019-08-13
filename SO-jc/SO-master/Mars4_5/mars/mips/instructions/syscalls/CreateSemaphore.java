package mars.mips.instructions.syscalls;
import mars.util.*;

import java.util.LinkedList;
import java.util.Queue;

import mars.*;
import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.PCB;
import mars.mips.so.ProcessManager.Semaforo;
import mars.mips.so.ProcessManager.TabeladeSemaforos;

public class CreateSemaphore extends AbstractSyscall
{
	
	
	
	public CreateSemaphore() {
		 super(22, "CreateSemaphore");
		 }
	
	public void simulate(ProgramStatement statement)
			throws ProcessingException {

			//O semaforo recebe o endereço ($a2)e o valor ($a3)
			criaSemaforo(RegisterFile.getValue(6),RegisterFile.getValue(7));
		
			 }
	
	public static void criaSemaforo(int end, int valor) { 
		
		Semaforo sem = new Semaforo();
		sem.endereco = end;
		sem.valor = valor;
		
		TabeladeSemaforos.AddSemaforo(sem); //Adiciona à tabela de semaforos
		
		SystemIO.printString("Semaforo "+sem.endereco+" criado com valor "+sem.valor+"\n");
		
	}

}
