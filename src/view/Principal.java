package view;
import java.util.concurrent.Semaphore;
import controller.Threads;
public class Principal {
	public static void main(String[] args) {
		int cruzarPorta = 1;
		Semaphore semaforo = new Semaphore(cruzarPorta);
		for (int pessoa = 1; pessoa <= 4; pessoa ++) {
			Thread corredor = new Threads(semaforo, pessoa);
			corredor.start();
		}
	}
}