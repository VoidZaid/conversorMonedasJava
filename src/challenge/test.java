package challenge;

import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class test {

	public static void main(String[] args) {
//		7QSiLVMUC5CXSjBmDKuzmiOGQI1FaApM
		int confirm = 0;
		
		while (confirm == 0) {
			String[] opciones = { "Convertir monedas", "Calcular IMC" };
			String valor = (String) JOptionPane.showInputDialog(null, "¿Qué deseas hacer?", null,
					JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

			switch (valor) {
			case "Convertir monedas":
				double cantidad, result = 0;
				String codigo = null;

				String[] tipoMoneda = { "Soles(S/) a alguna moneda", "Alguna moneda a Soles(S/)" };
				String[] solesMessage = { "Dolares americanos", "Euros", "Libras esterlinas", "Yen japones","Won sur-coreano" };
				String[] codigos = { "USD", "EUR", "GBP", "JPY", "KRW" };
				
				cantidad = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa la cantidad(solo números): ", null));
				String selMoneda = (String) JOptionPane.showInputDialog(null, "Convertir de...", "CONVERSOR DE MONEDAS",
						JOptionPane.QUESTION_MESSAGE, null, tipoMoneda, tipoMoneda[0]);

				if (selMoneda == tipoMoneda[0]) {
					String paraOtraMoneda = (String) JOptionPane.showInputDialog(null, "Convertir de soles(S/.) a ...",
							"CONVERSOR DE OTRA MONEDA", JOptionPane.QUESTION_MESSAGE, null, solesMessage, solesMessage[0]);

					codigo = mainApi.coincidirCodigo(paraOtraMoneda, solesMessage, codigos);
					try {
						result = mainApi.recuperar("PEN", codigo, cantidad);
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
						result = mainApi.recuperar(codigo, "PEN", cantidad);
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
				try {
					peso = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu peso en Kilogramos (solo numeros con \".\") :"));
					talla = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu talla en Metros (solo numeros con \".\") :"));
					imc = peso/(talla*talla);
					DecimalFormat decimal = new DecimalFormat("#.0");
					JOptionPane.showMessageDialog(null, calcImc.getImc(imc)+"\nTu IMC es de: "+decimal.format(imc)+" kg/m2");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR, NO SE PERMITE TEXTO :\n"+e);
				}
				break;
			}
			
			confirm = JOptionPane.showConfirmDialog(null, "Deseas continuar?");
			if(confirm == 1) {
				JOptionPane.showMessageDialog(null, "Estas saliendo del programa");
			}
		}

		
	}
}
