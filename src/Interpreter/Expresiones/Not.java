package Interpreter.Expresiones;
import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;
import client.Errors;
import client.TextEditor;

public class Not extends Expresion{

    private Expresion Exp;
    public Not(String valor, String tipo, Expresion Exp,int fila, int columna){
        super(valor, tipo, fila, columna);
        this.Exp= Exp;
    }
    @Override
    public Expresion interpretar(Entorno entorno) {

        this.Exp.interpretar(entorno);

        if (this.Exp.getTipo().equals("BOOL")) {
            if (this.Exp.getValor().equalsIgnoreCase("true")){
                
             this.setValor("false");
             return this;
            }else{
                this.setValor("true");
                return this;
            } 
        } 
        System.out.println("Error Semántico: Error en la operacion Not.");
                                        // Interfaz
            Errors error = new Errors("Semántico","Error en la operacion Not",this.getFila() ,this.getColumna());
            TextEditor.Errores.add(error);
            TextEditor.Consola.setText("Error Semántico: Error en la operacion Not." + " | Fila:" +this.getFila() + " | Columna: " + this.getColumna());


        
        return this;
    }
}