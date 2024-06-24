package Interpreter;

import Interpreter.Entornos.Entorno;
import Interpreter.Entornos.Simbolo;
import client.Errors;
import client.TextEditor;

public class Utils {
    public static void ErroresSemánticosInstruccion(Instruccion Object, String Error){
        Object.setTipo("ERROR");
        System.out.println("Error Semántico: "+Error);
        // Interfaz
        Errors error = new Errors("Error semántico",Error, Object.getFila(),Object.getColumna());
        TextEditor.Errores.add(error);
        TextEditor.Print+="Error Semántico: "+Error + " | Fila:" +Object.getFila() + " | Columna: " + Object.getColumna()+"\n";
        
    }
    public static void ErroresSemánticosExpresion(Expresion Object, String Error){
        Object.setTipo("ERROR");
        System.out.println("Error Semántico: "+Error);
        // Interfaz
        Errors error = new Errors("Error semántico",Error, Object.getFila(),Object.getColumna());
        TextEditor.Errores.add(error);
        TextEditor.Print+="Error Semántico: "+Error + " | Fila:" +Object.getFila() + " | Columna: " + Object.getColumna()+"\n";
    }

    public static void ReporteSyms(Entorno entorno){
        for (Simbolo Sym : entorno.getTablaSimbolos().values()) {
            TextEditor.TablaSimbolos.add(Sym);
        }
    }
    
}
