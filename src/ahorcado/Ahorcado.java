package ahorcado;

import java.util.Scanner;

public class Ahorcado {
	public static String[] palabras = { "humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna",
			"cabeza", "brazo", "familia" };

	final static int NUMINTENTOS = 7;
	static String palabraSecreta;
	static String palabraPista = "";
	static String noAcertadas = "";
	
	static Scanner sc = new Scanner(System.in);
	
	static void generaPalabra() {
		int posicion = (int)(Math.random()*palabras.length);
		palabraSecreta = palabras[posicion];
		
		for(int i=0; i<palabraSecreta.length(); i++) {
			palabraPista += "_";
		}
	}
	
	static int menu() {
		int opcion;
		
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Introducir letra");
		System.out.println("2. Introducir palabra");
		
		opcion = sc.nextInt();
		return opcion;
	}
	
	static void compruebaLetra(String letra) {
		int posFinal = palabraSecreta.indexOf(letra);
		int posInicio = 0;
		String copia = "";
		String letraMinuscula = letra.toLowerCase();
		
		if(posFinal<0) { 
			// Si no está la letra se añade a noAcertadas
			noAcertadas += letraMinuscula + " ";
		} else {
			while(posFinal>=0) {
				// Si está la letra construimos la pista
				// Hacemos un substring que contiene los guiones y a
				// continuación le añadimos la letra
				copia += palabraPista.substring(posInicio, posFinal) + letraMinuscula;
				
				// Actualizmos posInicio a la posición siguiente de la posición donde
				// se encontró la letra
				posInicio = posFinal + 1;
				
				// Volvemos a buscar la letra desde la posición siguiente
				// de donde la encontramos
				posFinal = palabraSecreta.indexOf(letraMinuscula, posInicio);
			}
			copia += palabraPista.substring(posInicio, palabraSecreta.length());
			palabraPista = copia;
		} 
	}
	
	static void compruebaLetra2(String letra) {
		char[] pista = palabraPista.toCharArray();
		boolean enc = false; 
		
		for(int i=0; i<palabraSecreta.length(); i++) {
			char caracter = palabraSecreta.charAt(i);
			if(letra.equalsIgnoreCase(String.valueOf(caracter))) {
				enc = true;
				pista[i] = caracter;
			}
		}
		palabraPista = String.valueOf(pista);
		
		if(!enc && !noAcertadas.contains(letra)) {
			noAcertadas += letra + " ";
		}
	}
	
	static void compruebaPalabra(String palabra) {
		if(palabra.equalsIgnoreCase(palabraSecreta)) {
			palabraPista = palabra;
		}
	}
	
	static void pintaPista() {
		System.out.println("No acertadas: " + noAcertadas);
		System.out.println("Pista: " + palabraPista);
	}
}
