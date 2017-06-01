package parserIndicador;



import java.math.BigDecimal;
import java.util.NoSuchElementException;

import model.Cuenta;
import model.Empresa;
import model.Indicador;
import model.OperandoDeIndicador;
import repositories.RepositorioIndicadores;
import repositories.Repositorios;

public class Visitador extends IndicadorBaseVisitor<BigDecimal>{
	
	private Empresa empresa;
	private String anio;
	
	public Visitador(Empresa unaEmpresa, String anio)
	{
		this.empresa = unaEmpresa;
		this.anio = anio;
	}
	
	@Override public BigDecimal visitNUMERO(IndicadorParser.NUMEROContext ctx) {
		return new BigDecimal(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public BigDecimal visitCUENTA(IndicadorParser.CUENTAContext ctx) { 
		OperandoDeIndicador operando;
		try 
		{
			operando = empresa.encontrarCuenta(ctx.getText(), this.anio);

		}
		catch(NoSuchElementException e)
		{
			operando = Repositorios.repositorioIndicadores.find(unIndicador -> unIndicador.getNombre().equals(ctx.getText()));
			
		}
		System.out.println(operando);
		return operando.calcularMonto(this.empresa, this.anio);
		}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public BigDecimal visitOperacion(IndicadorParser.OperacionContext ctx) {
		BigDecimal left = visit(ctx.left);
		BigDecimal right = visit(ctx.right);
	     String op = ctx.op.getText();
	     switch (op.charAt(0)) {
	     	case '*': return left.multiply(right);
	        case '/': return left.divide(right);
	        case '+': return left.add(right);
	        case '-': return left.subtract(right);
	        default: throw new IllegalArgumentException("Operador desconocido " + op);
	    }
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public BigDecimal visitIND(IndicadorParser.INDContext ctx) {
		return this.visit(ctx.indicador());
		}
}