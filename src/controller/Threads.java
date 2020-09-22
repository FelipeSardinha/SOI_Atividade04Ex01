package controller;
import java.util.concurrent.Semaphore;
public class Threads extends Thread{
	private Semaphore semaforo;
	private int pessoa;
	private int percurso = 200;
	private int distancia;
	private static int posicao = 0;
	
	public Threads(Semaphore semaforo, int pessoa) {
		this.semaforo = semaforo;
		this.pessoa = pessoa;
	}
	
		public void run() {
			andaCorredor();
			try {
				semaforo.acquire();
				abrePorta();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
		
		private void andaCorredor() {
			while (distancia < percurso) {
				distancia = distancia + (int) (Math.random() * 2) + 4;
				System.out.println("A pessoa " + pessoa + " andou " + distancia + " metros.");
			}
		}
		
		private void abrePorta() {
			posicao ++;
			int tempo = (int)(Math.random() + 1);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A pessoa " + pessoa + " foi a " + posicao + "° a passar pela porta.");
		}
}