package ahorcado;

public class Principal {

	public static void main(String[] args) {
		int intentos = Ahorcado.NUMINTENTOS;
		int opcion;
		String letra, palabra;
		System.out.println("¡¡BIENVENIDOS AL AHORCADO!!");
		Ahorcado.generaPalabra();
		Ahorcado.pintaPista();
		
		do {
			do {
				opcion = Ahorcado.menu();
				switch (opcion) {
				case 1:
					System.out.println("Introduzca una letra: ");
					letra = Ahorcado.sc.next();
					if (!Ahorcado.noAcertadas.contains(letra) && !Ahorcado.palabraPista.contains(letra)) {
						intentos--;
					}
					Ahorcado.compruebaLetra(String.valueOf(letra.charAt(0)));
					break;
				case 2:
					System.out.println("Introduzca una palabra: ");
					palabra = Ahorcado.sc.next();
					Ahorcado.compruebaPalabra(palabra);
					intentos--;
					break;
				}
			} while (opcion != 1 && opcion != 2);

			Ahorcado.pintaPista();
			System.out.println(intentos + " restantes");

		} while (!Ahorcado.palabraPista.equals(Ahorcado.palabraSecreta) && intentos > 0);

		System.out.println(Ahorcado.palabraPista.equals(Ahorcado.palabraSecreta) ? "¡HAS GANADO!" : "GAME OVER");

	}

}
