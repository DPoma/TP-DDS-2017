package model;

//este diseño se queda corto con el tema de taxativas vs por prioridad vs combinacion de ambas
//lo veo después con diego porque me quede sin tiempo

public interface Condicion {
	
	public boolean esMejor(Empresa a, Empresa b);

}
