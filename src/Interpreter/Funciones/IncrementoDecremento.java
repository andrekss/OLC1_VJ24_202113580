package Interpreter.Funciones;

import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Entorno;


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
                  int ValorAnterior = Integer.parseInt((String) entorno.getTablaSimbolos().get(this.id).getValor());
                  if(this.señal == "++"){
                   entorno.getTablaSimbolos().get(this.id).setValor(String.valueOf(ValorAnterior+1));
                  }else{
                      entorno.getTablaSimbolos().get(this.id).setValor(String.valueOf(ValorAnterior-1));  
                      return this;
                  }
              } else if ( entorno.getTablaSimbolos().get(this.id).getTipo() =="DOUBLE"){
                  double ValorAnterior = Double.parseDouble((String)entorno.getTablaSimbolos().get(this.id).getValor());
                  if(this.señal == "++"){
                   entorno.getTablaSimbolos().get(this.id).setValor(String.valueOf(ValorAnterior+1.0));
                  }else{
                      entorno.getTablaSimbolos().get(this.id).setValor(String.valueOf(ValorAnterior-1.0));  
                      return this;
                  }
              }else{
                  Utils.ErroresSemánticosInstruccion(this,"El tipo de dato no es int o double. ");
                  return this;
                  
              }
              // Asignamos el valor
              return this;
          }else{
              Utils.ErroresSemánticosInstruccion(this,"La Mutabilidad es Constante no se puede asignar un valor nuevo. ");
              return this;
          }
        }else if (entorno.getAnterior() != null){
            this.interpretar(entorno.getAnterior());  // irá retrocediendo hasta encontrar la variable en otro entorno
            return this;

        }else if(entorno.getAnterior() ==null){
            Utils.ErroresSemánticosInstruccion(this,"La Mutabilidad es Constante no se puede asignar un valor nuevo. ");
            return this;
        }
        return this;
        
    }
}
