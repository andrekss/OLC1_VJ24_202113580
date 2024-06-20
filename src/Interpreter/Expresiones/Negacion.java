package Interpreter.Expresiones;
import Interpreter.Entornos.Entorno;
import client.Errors;
import client.TextEditor;
import Interpreter.Expresion;

public class Negacion extends Expresion {


    public Negacion(String valor, String tipo, int fila, int columna){
        super(valor, tipo, fila, columna);
    }

    @Override
    public Expresion interpretar(Entorno entorno) {
        if (this.getTipo().equals("INT")) {
            this.setValor(String.valueOf(-1 * Integer.parseInt(this.getValor())));
            return this;
        } else if (this.getTipo().equals("DOUBLE")){
            this.setValor(String.valueOf(-1 * Double.parseDouble(this.getValor())));
            return this;
        }
        System.out.println("Error Semántico: Error en la operacion negativo.");
                                // Interfaz
            Errors error = new Errors("Semántico","Error en la operacion negativo",this.getFila() ,this.getColumna());
            TextEditor.Errores.add(error);
            TextEditor.Print+="Error Semántico: Error en la operacion negativo." + " | Fila:" +this.getFila() + " | Columna: " + this.getColumna()+"\n";

        return this;
        
    }
}
