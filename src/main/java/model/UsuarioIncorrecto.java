package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import scala.Console;


public class UsuarioIncorrecto extends Usuario {
	
	private String username;
	
	public String getUsername() {
		return username;
	}

	private String password;
	@OneToMany(mappedBy="usuario",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Indicador> indicadores;
	
	public UsuarioIncorrecto()
	{

	}
	
	public UsuarioIncorrecto(String usr, String pass)
	{
		this.username = usr;
		this.password = pass;
	}
	
	public boolean loginCorrecto(String pass)
	{
		return false;
	}

}