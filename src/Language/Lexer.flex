// ------------  Paquete e importaciones ------------
package Language; 
import client.Errors;
import client.TextEditor;
import java_cup.runtime.*;

%%	
//-------> Directivas (No tocar)

%public 
%class Lexer
%cup
%char
%column
%line
%unicode
%ignorecase

%{ 
%} 

// ------> Expresiones Regulares 

entero = [0-9]+
Decimal = {entero} "." {entero}
booleano =    "true"|"false"
Cadena = \"[^\"]*\"

comentarios = "//" .* ("\n"|"")
comentariosM = "/*" ( [^!] | "!"[^>] )* "*/"
CARACTER  = "'"[^"'"]"'"| "'""'"
ID = [a-zA-Z_]+([a-zA-Z_]+|[0-9]+)* 


%%
// ------------  Reglas Lexicas -------------------

// Mutabilidad


"var"      { return new Symbol(sym.VAR, yycolumn, yyline, yytext()); }
"const"    { return new Symbol(sym.CONST, yycolumn, yyline, yytext()); }

"void"    { return new Symbol(sym.VOID, yycolumn, yyline, yytext()); }

// Tipos de dato
"int"      { return new Symbol(sym.INT, yycolumn, yyline, yytext()); }
"double"   { return new Symbol(sym.DOUBLE, yycolumn, yyline, yytext()); }
"bool"     { return new Symbol(sym.BOOL, yycolumn, yyline, yytext()); }
"char"     { return new Symbol(sym.CHAR, yycolumn, yyline, yytext()); }
"string"   { return new Symbol(sym.STRING, yycolumn, yyline, yytext()); }

"println"  { return new Symbol(sym.PRINT, yycolumn, yyline, yytext()); }
"if"       { return new Symbol(sym.IF, yycolumn, yyline, yytext()); }
"else"     { return new Symbol(sym.ELSE, yycolumn, yyline, yytext()); }

"while"    { return new Symbol(sym.WHILE, yycolumn, yyline, yytext()); }
"for"      { return new Symbol(sym.FOR, yycolumn, yyline, yytext()); }
"do"       { return new Symbol(sym.DO, yycolumn, yyline, yytext()); }

"remove"   { return new Symbol(sym.REMOVE, yycolumn, yyline, yytext()); }
"list"     { return new Symbol(sym.LIST, yycolumn, yyline, yytext()); }
"new"      { return new Symbol(sym.NEW, yycolumn, yyline, yytext()); }
"append"   { return new Symbol(sym.APPEND, yycolumn, yyline, yytext()); }

"struct"   { return new Symbol(sym.STRUCT, yycolumn, yyline, yytext()); }

"break"    { return new Symbol(sym.BREAK, yycolumn, yyline, yytext()); }
"continue" { return new Symbol(sym.CONTINUE, yycolumn, yyline, yytext()); }
"return"   { return new Symbol(sym.RETURN, yycolumn, yyline, yytext()); }

"match"     { return new Symbol(sym.MATCH, yycolumn, yyline, yytext()); }

"start_with" { return new Symbol(sym.START, yycolumn, yyline, yytext()); }

"_"         { return new Symbol(sym.DEFAULT, yycolumn, yyline, yytext()); }

":"        { return new Symbol(sym.Dos_Puntos, yycolumn, yyline, yytext()); }
"."        { return new Symbol(sym.Punto, yycolumn, yyline, yytext()); }
";"        { return new Symbol(sym.P_Coma, yycolumn, yyline, yytext()); }
","        { return new Symbol(sym.Coma, yycolumn, yyline, yytext()); }
"="        { return new Symbol(sym.IGUAL, yycolumn, yyline, yytext()); }

// Operadores
"+"        { return new Symbol(sym.MAS, yycolumn, yyline, yytext()); }
"-"        { return new Symbol(sym.MENOS, yycolumn, yyline, yytext()); }
"*"        { return new Symbol(sym.POR, yycolumn, yyline, yytext()); }
"/"        { return new Symbol(sym.DIVISION, yycolumn, yyline, yytext()); }
"**"       { return new Symbol(sym.POTENCIA, yycolumn, yyline, yytext()); }
"%"        { return new Symbol(sym.MODULO, yycolumn, yyline, yytext()); }

// Op Relaciones
"=="       { return new Symbol(sym.COMPARACION, yycolumn, yyline, yytext()); }
"!="       { return new Symbol(sym.DIFERENCIA, yycolumn, yyline, yytext()); }
"<"        { return new Symbol(sym.MENOR, yycolumn, yyline, yytext()); }
"<="       { return new Symbol(sym.MENOR_IGUAL, yycolumn, yyline, yytext()); }
">"        { return new Symbol(sym.MAYOR, yycolumn, yyline, yytext()); }
">="       { return new Symbol(sym.MAYOR_IGUAL, yycolumn, yyline, yytext()); }

// Op lógicos
"||"       { return new Symbol(sym.OR, yycolumn, yyline, yytext()); }
"&&"       { return new Symbol(sym.AND, yycolumn, yyline, yytext()); }
"^"        { return new Symbol(sym.XOR, yycolumn, yyline, yytext()); }
"!"        { return new Symbol(sym.NOT, yycolumn, yyline, yytext()); }

"("        { return new Symbol(sym.P_ABRE, yycolumn, yyline, yytext()); }
")"        { return new Symbol(sym.P_CIERRA, yycolumn, yyline, yytext()); }

"["        { return new Symbol(sym.C_ABRE, yycolumn, yyline, yytext()); }
"]"        { return new Symbol(sym.C_CIERRA, yycolumn, yyline, yytext()); }

"{"        { return new Symbol(sym.LLAVE_A, yycolumn, yyline, yytext()); }
"}"        { return new Symbol(sym.LLAVE_C, yycolumn, yyline, yytext()); }

{entero}   { return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{Decimal}  { return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext()); }
{booleano} { return new Symbol(sym.BOOLEAN, yycolumn, yyline, yytext()); }
{CARACTER} { return new Symbol(sym.CAR, yycolumn, yyline, yytext()); }
{Cadena}   { return new Symbol(sym.CAD, yycolumn, yyline, yytext()); }
{ID}       { return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext()); }

//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}
{comentarios}   {/* Ignore */} 
{comentariosM}  {/* Ignore */ }

//------> Errores Léxicos 
.           	{ 
    Errors error = new Errors("Lexico","Caracter no reconocido"+yytext(),yyline,yycolumn);
    TextEditor.Errores.add(error);
    System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); 
    TextEditor.Print+="Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn+"\n";
    }

