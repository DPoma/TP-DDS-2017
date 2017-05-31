package parserIndicador;

public class Visitador extends IndicadorBaseVisitor<Double>{
	
	@Override public Double visitNUMERO(IndicadorParser.NUMEROContext ctx) {
		return Double.valueOf(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Double visitCUENTA(IndicadorParser.CUENTAContext ctx) { 
		return 0.0;
		}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Double visitOperacion(IndicadorParser.OperacionContext ctx) {
	     double left = visit(ctx.left);
	     double right = visit(ctx.right);
	     String op = ctx.op.getText();
	     switch (op.charAt(0)) {
	     	case '*': return left * right;
	        case '/': return left / right;
	        case '+': return left + right;
	        case '-': return left - right;
	        default: throw new IllegalArgumentException("Operador desconocido " + op);
	    }
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Double visitIND(IndicadorParser.INDContext ctx) {
		return this.visit(ctx.indicador());
		}
}
