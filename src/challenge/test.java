package challenge;

import java.io.IOException;

import javax.swing.JOptionPane;
//7QSiLVMUC5CXSjBmDKuzmiOGQI1FaApM

public class test {

	public static void main(String[] args) {

//		String[][] creandoMatriz = {{"Dolar","USD"},{"Euro","EUR"},{"Sol","PEN"}};
//		System.out.println(creandoMatriz[0][1]);

		String[] opciones = { "Convertir monedas", "Calcular IMC" };
		String valor = (String) JOptionPane.showInputDialog(null, "¿Qué deseas hacer?", null,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		switch (valor) {
		case "Convertir monedas":
			double cantidad, result = 0;
			String penCodigo, codigo = null;

			penCodigo = "PEN";
			cantidad = Double
					.parseDouble(JOptionPane.showInputDialog(null, "Ingresa la cantidad(solo números): ", null));

			String[] tipoMoneda = { "Soles(S/) a alguna moneda", "Alguna moneda a Soles(S/)" };
			String selMoneda = (String) JOptionPane.showInputDialog(null, "Convertir de...", "CONVERSOR DE MONEDAS",
					JOptionPane.QUESTION_MESSAGE, null, tipoMoneda, tipoMoneda[0]);

//			String[][] dolaresMessage = { { "Dolares americanos", "USD" }, { "Euros", "EUR" },{ "Libras esterlinas", "GBP" }, { "Yen japones", "JPY" }, { "Won sur-coreano", "KRW" } };
			String[] solesMessage = { "Dolares americanos", "Euros", "Libras esterlinas", "Yen japones",
					"Won sur-coreano" };
			String[] codigos = { "USD", "EUR", "GBP", "JPY", "KRW" };
			if (selMoneda == tipoMoneda[0]) {
				String paraOtraMoneda = (String) JOptionPane.showInputDialog(null, "Convertir de soles(S/.) a ...",
						"CONVERSOR DE OTRA MONEDA", JOptionPane.QUESTION_MESSAGE, null, solesMessage, solesMessage[0]);

				codigo = mainApi.coincidirCodigo(paraOtraMoneda, solesMessage, codigos);
				try {
					result = mainApi.recuperar(penCodigo, codigo, cantidad);
				} catch (IOException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, cantidad + " Soles(PEN) a " + paraOtraMoneda + "(" + codigo + "):\n"
						+ "Resultado = " + result + " " + codigo);

			} else if (selMoneda == tipoMoneda[1]) {
				String paraSoles = (String) JOptionPane.showInputDialog(null, "Convertir a Soles(S/.) de...",
						"CONVERTIR A SOLES", JOptionPane.QUESTION_MESSAGE, null, solesMessage, solesMessage[0]);
				codigo = mainApi.coincidirCodigo(paraSoles, solesMessage, codigos);
				try {
					result = mainApi.recuperar(codigo, penCodigo, cantidad);
				} catch (IOException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, cantidad + " " + paraSoles + "(" + codigo + ") a Soles(PEN)\n"
						+ "Resultado = " + result + " PEN");
			} else {
				JOptionPane.showMessageDialog(null, "UPS! OCURRIO UN ERROR");
			}

			break;

		case "Calcular IMC":
			double peso, talla, imc;
			String[] mensajes = { "Buu! Tienes PESO BAJO", "Exelente! tu peso es el ideal",
					"Ups! estas comiendo de mas, tienes SOBREPESO",
					"Atencion! tienes OBESIDAD I, procura hacer ejercicio y llevar una diata mas saludable" };
			
			try {
				peso = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu peso en kg (solo numeros y \".\") :"));
				talla = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu talla en metros (solo numeros y \".\") :"));
				imc = peso/(talla*talla);
				if (imc < 18.5) {
					JOptionPane.showMessageDialog(null, mensajes[0]);
//					System.out.println("estamos desnutridos");
				}else if (imc < 24.9) {
					JOptionPane.showMessageDialog(null, mensajes[1]);
				}else if (imc < 29.9) {
					JOptionPane.showMessageDialog(null, mensajes[2]);
				}else if (imc < 34.9) {
					JOptionPane.showMessageDialog(null, mensajes[3]);
				}else {
					System.out.println("Ocurrio un error");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR: "+e);
			}
			break;
		}
	}
}
