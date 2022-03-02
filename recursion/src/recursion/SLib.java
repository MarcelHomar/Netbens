/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 * Una clase per ajudar a treballar amb matrius.
 *
 * @version 0.1, 31/01/22
 * @author Marcel Homar
 */
public class SLib {

	/**
	 * Conta les vegades que apareix un caràcter concret en un String.
	 *
	 * @param userText String amb el que es vol treballar.
	 * @param userChar Char per buscar.
	 * @return el número de vegades que es repeteix el caràcter
	 */
	public static int contarLletra(String userText, char userChar) {

		int count = 0;
		userChar = Character.toLowerCase(userChar);
		userText = userText.toLowerCase();

		for (int i = 0; i < userText.length(); i++) {
			if (userText.charAt(i) == userChar) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Busca el primer cop que apareix un caràcter concret.
	 *
	 * @param userText String amb el que es vol treballar.
	 * @param userChar Char per buscar.
	 * @return La posició del primer cop que es troba el caràcter introduït En
	 * cas de no ser-hi, ens retorna un -1
	 */
	public static int lletraPrincipi(String userText, char userChar) {

		userChar = Character.toLowerCase(userChar);
		userText = userText.toLowerCase();
		return userText.indexOf(userChar);

	}

	/**
	 * Busca l'últim cop que apareix un caràcter concret.
	 *
	 * @param userText String amb el que es vol treballar.
	 * @param userChar Char per buscar.
	 * @return La posició de l'últim cop que es troba el caràcter introduït En
	 * cas de no ser-hi, ens retorna un -1
	 */
	public static int lletraFinal(String userText, char userChar) {

		userChar = Character.toLowerCase(userChar);
		userText = userText.toLowerCase();
		return userText.lastIndexOf(userChar);
	}

	/**
	 * Busca tots els cop que apareix un caràcter concret.
	 *
	 * @param userText String amb el que es vol treballar.
	 * @param userChar Char per buscar.
	 * @return Les posicions que es troba el caràcter introduït en forma de
	 * array.
	 *
	 */
	public static int[] totesPosicions(String userText, char userChar) {
		int i = 0;
		int[] array = new int[userText.length()];
		userChar = Character.toLowerCase(userChar);
		userText = userText.toLowerCase();

		if (userText.indexOf(userChar) != -1) {
			for (int j = 0; j < userText.length(); j++) {
				if (userText.charAt(j) == userChar) {
					array[i] = j;
					i++;
				}
			}
			int[] newArray = new int[i];

			for (int j = 0; j < i; j++) {
				newArray[j] = array[j];
			}

			return newArray;
		} else {
			System.err.println("No hay " + userChar + " en esta frase");
			int[] noArray = new int[0];
			return noArray;
		}

	}

	/**
	 * Separa el String indicat per paraules.
	 *
	 * @param userText String amb el que es vol treballar.
	 * @return array String separat per paraules
	 */
	public static String[] separarParaules(String userText) {

		userText = userText.trim();
		int[] a = new int[userText.length()];
		int i = 0;
		for (int j = 0; j < userText.length(); j++) {
			if (userText.charAt(j) != ' ') {
				a[i] = j;
			} else if (userText.charAt(j + 1) != ' ') {
				i++;
			}
		}
		
		String[] paraules = new String[i + 1];
		paraules[0] = userText.substring(0, a[0] + 1);

		for (int k = 1; k < i + 1; k++) {
			paraules[k] = userText.substring(a[k - 1] + 2, a[k] + 1);
			paraules[k] = paraules[k].trim();
		}
		return paraules;
	}

	/**
	 * Ens diu quantes paraules té el String.
	 *
	 * @param userText String amb el que es vol treballar.
	 * @return el número de paraules que té el String
	 */
	public static int contarParaules(String userText) {
		int paraules;
		if (userText.startsWith(" ")) {
			paraules = 0;
		} else{
			paraules = 1;
		}
		if (userText.isEmpty()) {
			System.err.println("Eres bobi");
		} else {
			for (int j = 0; j < userText.length(); j++) {
				if (userText.charAt(j) == '\n') {
					if (userText.charAt(j + 1) != '\n') {
						paraules++;
					}
				}
			}
		}
		return paraules;
	}

}
