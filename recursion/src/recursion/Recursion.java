package recursion;

import java.util.Scanner;

public class Recursion {

	public static long fibonacci(int num) {
		long solucio = 0, siguiente = 1, temp;

		for (long i = 1; i <= num; i++) {
			System.out.print(solucio + ", ");
			temp = solucio;
			solucio = siguiente;
			siguiente += temp;
		}

		return solucio;
	}

	public static long fibonacciR(int num) {
		long fibonacci;
		if (num < 2) {
			fibonacci = num;
		} else {
			fibonacci = fibonacciR(num - 1) + fibonacciR(num - 2);
		}
		return fibonacci;
	}

	public static boolean capicua(int num, int a) {
		String n = String.valueOf(num);

		if (a == (n.length() / 2 + 1)) {
			return true;
		} else if (n.charAt(a) == n.charAt(n.length() - 1 - a)) {
			return capcua(n, a + 1);
		} else {
			return false;
		}
	}

	public static boolean capcua(String n, int a) {
		boolean capicua;
		if (a == (n.length() / 2 + 1)) {
			capicua = true;
		} else if (n.charAt(a) == n.charAt(n.length() - 1 - a)) {
			capicua = capcua(n, a + 1);
		} else {
			capicua = false;
		}
		return capicua;
	}

	public static String quitarEspacios(String n) {
		char[] sinEspacios = new char[n.length()];
		int contadorString = 0;
		String paraDevolver;

		for (int i = 0; i < n.length(); i++) {
			if (n.codePointAt(i) >= 97 && n.codePointAt(i) <= 122) {
				sinEspacios[contadorString] = n.charAt(i);
				contadorString++;
			}
		}
		char[] ultimo = new char[contadorString];
		System.arraycopy(sinEspacios, 0, ultimo, 0, ultimo.length);
		paraDevolver = String.copyValueOf(ultimo);
		return paraDevolver;
	}

	/*
    public static int sumarXifres(int n, int a, int b) {
        int retornable;
        if (a == b) {
            retornable = 0;
        } else {
            retornable = sumarXifres((n / (10 ^ (a))) % 10, a + 2, b) + sumarXifres((n / (10 ^ (a))) % 10, a + 1, b);
        }
        return retornable;
    }
	 */
	public static int sumarXifres(int n) {
		int sumar = 0;

		if (n > 0) {
			sumar += (n % 10);
			sumar += sumarXifres(n / 10);
		}

		return sumar;
	}
	
	public static int demanarNumero (){
		int n;
		boolean on = true;
		do{
			n = Teclat.llegirInt();
			if (n>25) {
				System.out.println("No es pot calcular tant. Es pot fins el 25");
			} else if (n<0){
				System.out.println("El numero ha de ser positiu");
			} else{
				on = false;
			}
		} while(on);
		return n;
	}

	public static void main(String[] args) {
	
		int fibonacci, numero;
		System.out.println("Introdueix l'index fins on calcular la succeció de Fibonacci");
		fibonacci = demanarNumero();
		System.out.println(fibonacciR(fibonacci));
		System.out.println("Introdueix una frase/paraula (sense accents)");
		String n = Teclat.llegirString();
		n = n.toLowerCase();
		n = quitarEspacios(n);
		//NO FUNCIONA SI HAY TILDES
		if (capcua(n, 0)) {
			System.out.println("Aquesta paraula/frase/numero és un pal·líndrom");
		} else {
			System.out.println("Aquesta paraula/frase/numero NO és un pal·líndrom");
		}
		System.out.println("Introdueix un número enter");
		numero = Teclat.llegirInt();
		System.out.println("La suma de cadascuna de les xifres és: " + sumarXifres(numero));

	}

}
