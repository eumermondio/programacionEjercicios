package pruebasVarias;

public class PiExamen {
	public static void main(String[] args) {
		double pi = 3;
		int signo = 1;
		double termino;

		for (int i = 2; i < 1000; i += 2) {
			termino = 4f / (i * (i + 1) * (i + 2));
			pi += signo * termino;
			signo *= -1;
		}
		System.out.println("PI: " + pi);

	}

}