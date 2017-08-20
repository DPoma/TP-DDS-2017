package model;

import java.util.Comparator;

//este diseño se queda corto con el tema de taxativas vs por prioridad vs combinacion de ambas
//lo veo después con diego porque me quede sin tiempo

public interface Condicion {
	
	public Comparator<? super Empresa> esMejor(Empresa a, Empresa b);

}
