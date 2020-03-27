// Generated from C:/Users/Ryan/OneDrive/Source/DroidScript/app/src/main/antlr\DroidScript.g4 by ANTLR 4.7.2
package me.rmullin.droidscript.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DroidScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DroidScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DroidScriptParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(DroidScriptParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroidScriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DroidScriptParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroidScriptParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(DroidScriptParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroidScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(DroidScriptParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroidScriptParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(DroidScriptParser.SymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroidScriptParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(DroidScriptParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroidScriptParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(DroidScriptParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroidScriptParser#boolFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFalse(DroidScriptParser.BoolFalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroidScriptParser#boolTrue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTrue(DroidScriptParser.BoolTrueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroidScriptParser#intLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(DroidScriptParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DroidScriptParser#floatLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(DroidScriptParser.FloatLiteralContext ctx);
}