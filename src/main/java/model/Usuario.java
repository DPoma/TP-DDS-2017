package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import scala.Console;

@Entity
public class Usuario {
	@Id @GeneratedValue
	private int id;
	private String username;
	
	public String getUsername() {
		return username;
	}

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	private String password;
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	private List<Indicador> indicadores = new ArrayList<Indicador>();
	

	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	private List<Metodologia> metodologias = new ArrayList<Metodologia>();
	
	public Usuario()
	{
		 indicadores = new ArrayList<Indicador>();
		 metodologias = new ArrayList<Metodologia>();
	}
	
	public Usuario(String usr, String pass)
	{
		this.username = usr;
		this.password = pass;
		 indicadores = new ArrayList<Indicador>();
		metodologias = new ArrayList<Metodologia>();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}

	public boolean loginCorrecto(String pass)
	{
		if (password.equals(pass))
		{
			Console.println("OK");
			return true;
		}
		else {
			Console.println(password);
			Console.println(pass);
			return false;
		}
	}
	public void agregarIndicador(Indicador indicador)
	{
		indicador.setUsuario(this);
		this.indicadores.add(indicador);
	}
	
	public void agregarMetodologia(Metodologia metodologia)
	{
		metodologia.setUsuario(this);
		this.metodologias.add(metodologia);
	}

	public List<Metodologia> getMetodologias() {
		return metodologias;
	}

	public void setMetodologias(List<Metodologia> metodologias) {
		this.metodologias = metodologias;
	}

}
