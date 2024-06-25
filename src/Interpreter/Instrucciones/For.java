package Interpreter.Instrucciones;
import java.util.LinkedList;
import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;
import Interpreter.Utils;

public class For extends Instruccion{
    private LinkedList<Instruccion> Sentencia_Entorno;
    private Instruccion Asignacion;
    private Expresion Condicion;
    private Instruccion Actualizar;
    private boolean AvisoBreak;
    
    public For( LinkedList<Instruccion> Sentencia_Entorno,Instruccion Asignacion,Expresion Condicion,Instruccion Actualizar,int linea, int col) {
        super(Instruccion.nombres[6], linea, col);
        this.Sentencia_Entorno = Sentencia_Entorno;
        this.Asignacion = Asignacion;
        this.Condicion = Condicion;
        this.Actualizar = Actualizar;
        this.AvisoBreak= false;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        Entorno For_Entorno = new Entorno(Instruccion.nombres[6], entorno);
        this.Asignacion.interpretar(For_Entorno);

        while (Boolean.parseBoolean(this.Condicion.interpretar(For_Entorno).getValor().toLowerCase())) { // Ciclo principal
            For_Entorno = new Entorno(Instruccion.nombres[6], entorno);
            String Tipo;
            
            for ( Instruccion instruccion : this.Sentencia_Entorno) {             
                    instruccion.interpretar(For_Entorno);
                    Tipo =instruccion.getTipo();
                    
                        //System.out.println(Tipo);
                    
                    if(instruccion.getTipo().equals("BREAK")){ 
                        instruccion.setTipo(Tipo);
                        this.AvisoBreak = true;
                        break;
                    } 
                    if(instruccion.getTipo().equals("CONTINUE")){
                        instruccion.setTipo(Tipo);
                        break; // detenemos las instrucciones pero el ciclo sigue
                    }  
            }
        
            this.Actualizar.interpretar(For_Entorno);
            
            if(this.AvisoBreak==true){ // Rompemos el ciclo principal
                this.AvisoBreak = false;
                break;
            }       
        }
        Utils.ReporteSyms(For_Entorno);
        return this;
    }

}
