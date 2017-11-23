package model;

import java.math.BigDecimal;

import javax.persistence.*;

import org.uqbar.commons.utils.Observable;


@Observable
@Entity
@Table(name = "Cuenta")
public class Cuenta implements OperandoDeIndicador{
	
	//------------------------------------ ATRIBUTOS --------------------------------
	
	@Id @GeneratedValue
	@Column(name="idCuenta")
	private int idCuenta;
	
	@Column(name = "nombre")
	private String nombre;
	
	private int anio;
	
	private BigDecimal monto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEmpresa")
	private Empresa empresa;
	
	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public Cuenta(String nombre, int anio, String monto, Empresa unaEmpresa) {
		this.nombre = nombre;
		this.anio = anio;
		this.monto = new BigDecimal(monto);
		this.empresa = unaEmpresa;
	}
	
	public Cuenta() {
		
	}
	
	//------------------------------------ GETTERS Y SETTERS --------------------------------

	public String getNombre() {
		return nombre;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public BigDecimal getMonto() {
		return monto;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	//------------------------------------ METODOS --------------------------------
	
	@Override
	public String toString() {
		return "Cuenta [nombre=" + nombre + ", anio=" + anio + ", monto=" + monto + "]";
	}
	
	public BigDecimal calcularMonto(Empresa empresa, String anio) {
		return monto;
	}
	
	public boolean periodoEntre(int anioMin, int anioMax) {
		return anio >= anioMin && anio <=anioMax;
	}
	

	public boolean mismaPK(Cuenta otraCuenta)
	{
		return this.empresa.equals(otraCuenta.getEmpresa()) && this.anio == otraCuenta.getAnio() && this.nombre.equalsIgnoreCase(otraCuenta.getNombre());
	}
	
	public boolean mismoMonto(Cuenta otraCuenta)
	{
		if(this.monto.compareTo(otraCuenta.getMonto()) == 0)
		{

			return true;
		}
		else
			{
			System.out.println(this);
			System.out.println(otraCuenta);
				return false;
			}
		
	}
	
	public boolean cuentaActualizada(Cuenta otraCuenta)
	{
		return this.mismaPK(otraCuenta) && !this.mismoMonto(otraCuenta);
	}

	public boolean equals(Cuenta otraCuenta)
	{
		return this.mismaPK(otraCuenta) && this.mismoMonto(otraCuenta);
	}

}
