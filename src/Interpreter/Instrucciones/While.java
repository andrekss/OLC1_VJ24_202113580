package Interpreter.Instrucciones;
import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;
import java.util.LinkedList;

public class While extends Instruccion {
    private Expresion Condicion;
    private LinkedList<Instruccion> Sentencia_Entorno;
    private String TipoWhile;
    public boolean AvisoBreak = false;

    public While(Expresion Condicion,LinkedList<Instruccion> Sentencia_Entorno,String TipoWhile, int linea, int col) {
        super(Instruccion.nombres[7], linea, col);
        this.Condicion = Condicion;
        this.Sentencia_Entorno = Sentencia_Entorno;
        this.TipoWhile = TipoWhile;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        this.Condicion.interpretar(entorno);
        
        while (true) {
            if (this.Condicion.getValor().equalsIgnoreCase("false") && this.TipoWhile.equals("While")){
                break;
            }
            

            Entorno if_Entorno = new Entorno(Instruccion.nombres[7], entorno);
                
            for ( Instruccion instruccion : this.Sentencia_Entorno) {
                   instruccion.interpretar(if_Entorno);
                   if(instruccion.getTipo().equals("BREAK")){
                    this.AvisoBreak = true;
                    this.setTipo("IF");
                         
                    break;
                } 
                if(instruccion.getTipo().equals("CONTINUE")){
                    this.setTipo("CONTINUE");
                    break; // detenemos las instrucciones pero el ciclo sigue
                } 
                   /*if(instruccion.getTipo().equals("CONTINUE")){
                     break; // detenemos las instrucciones pero el ciclo sigue
                   } */
            }
            if (AvisoBreak){
                this.AvisoBreak = false;
                break;
            }
            this.Condicion.interpretar(entorno); // Actualizamos la condicion

            if (this.Condicion.getValor().equalsIgnoreCase("false") && this.TipoWhile.equals("Do")){
                break;
            }

        }
        return this;
        
    }
    
}
