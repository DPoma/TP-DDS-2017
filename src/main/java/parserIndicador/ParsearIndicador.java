package parserIndicador;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ParsearIndicador {
	public double reducirIndicador() {
		
		String query = "4/(10*(2+8))+";
		CharStream input = CharStreams.fromString(query);
		IndicadorLexer lexer = new IndicadorLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		IndicadorParser parser = new IndicadorParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new ParserErrorListener());
		ParseTree tree = parser.indicador(); 
		Visitador visitador = new Visitador();
		Double calculo = visitador.visit(tree);
		System.out.println(query + " = " + calculo.toString());
		System.out.println(tree.toStringTree(parser)); 
		return calculo;

		
	}
	
}
