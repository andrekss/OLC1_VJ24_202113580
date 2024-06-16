package Interpreter.Funciones;

import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;
import client.Errors;
import client.TextEditor;

public class IncrementoDecremento extends Instruccion{

    private String id;
    private String señal;

    public IncrementoDecremento(String id,String señal, int linea, int col) {
        super(Instruccion.nombres[4], linea, col);
        this.id = id;
        this.señal = señal;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        if(entorno.getTablaSimbolos().get(this.id) !=null) {
          if (entorno.getTablaSimbolos().get(this.id).getMutabilidad() =="VAR"){
              if (entorno.getTablaSimbolos().get(this.id).getTipo() =="INT"){
                  int ValorAnterior = Integer.parseInt(entorno.getTablaSimbolos().get(this.id).getValor());
                  if(this.señal == "++"){
                   entorno.getTablaSimbolos().get(this.id).setValor(String.valueOf(ValorAnterior+1));
                  }else{
                      entorno.getTablaSimbolos().get(this.id).setValor(String.valueOf(ValorAnterior-1));  
                      return this;
                  }
              } else if ( entorno.getTablaSimbolos().get(this.id).getTipo() =="DOUBLE"){
                  double ValorAnterior = Double.parseDouble(entorno.getTablaSimbolos().get(this.id).getValor());
                  if(this.señal == "++"){
                   entorno.getTablaSimbolos().get(this.id).setValor(String.valueOf(ValorAnterior+1.0));
                  }else{
                      entorno.getTablaSimbolos().get(this.id).setValor(String.valueOf(ValorAnterior-1.0));  
                      return this;
                  }
              }else{
                  System.out.println("Error semántico: El tipo de dato no es int o double");
                    // Interfaz
                    Errors error = new Errors("Semántico","El tipo de dato no es int o double", this.getFila(),this.getColumna());
                    TextEditor.Errores.add(error);
                    TextEditor.Consola.setText("Error Semántico: El tipo de dato no es int o double." + " | Fila:" +this.getFila() + " | Columna: " + this.getColumna());

                  return this;
                  
              }
              // Asignamos el valor
              return this;
          }else{
              System.out.println("Error semántico: La Mutabilidad es Constante no se puede asignar un valor nuevo");
                    // Interfaz
                    Errors error = new Errors("Semántico","La Mutabilidad es Constante no se puede asignar un valor nuevo", this.getFila(),this.getColumna());
                    TextEditor.Errores.add(error);
                    TextEditor.Consola.setText("Error Semántico: La Mutabilidad es Constante no se puede asignar un valor nuevo." + " | Fila:" +this.getFila() + " | Columna: " + this.getColumna());

              return this;
          }
        }else if (entorno.getAnterior() != null){
            this.interpretar(entorno.getAnterior());  // irá retrocediendo hasta encontrar la variable en otro entorno
            return this;

        }else if(entorno.getAnterior() ==null){
            System.out.println("Error semántico: La Mutabilidad es Constante no se puede asignar un valor nuevo");
                    // Interfaz
                    Errors error = new Errors("Semántico","La Mutabilidad es Constante no se puede asignar un valor nuevo", this.getFila(),this.getColumna());
                    TextEditor.Errores.add(error);
                    TextEditor.Consola.setText("Error Semántico: La Mutabilidad es Constante no se puede asignar un valor nuevo." + " | Fila:" +this.getFila() + " | Columna: " + this.getColumna());

            return this;
        }
        return this;
        
    }
}
