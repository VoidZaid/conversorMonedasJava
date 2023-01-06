package challenge;

public class calcImc {
	private static String[] mensajes = { "Buu! Tienes PESO BAJO", "Exelente! tu peso es el ideal",
	"Ups! estas comiendo de mas, tienes SOBREPESO",
	"Atencion! tienes OBESIDAD I, procura hacer ejercicio y llevar una diata mas saludable" };
	
	public static String getImc(double imc) {
		if (imc < 18.5) {
			return mensajes[0];
		}else if (imc < 24.9) {
			return mensajes[1];
		}else if (imc < 29.9) {
			return mensajes[2];
		}else if (imc < 34.9) {
			return mensajes[3];
		}else {
			System.out.println("Ocurrio un error");
			return null;
		}
		
	}
}
