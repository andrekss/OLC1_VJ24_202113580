package Interpreter.Expresiones;

import Interpreter.Expresion;

public class Funciones {
    public static Aritmeticas Suma(Expresion izq,String Operacion,Expresion der,Aritmeticas object){
        
        
        if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT") || izq.getTipo() .equals( "INT") && der.getTipo() .equals( "CHAR") || izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "INT")){
            object.setTipo("INT"); 
            object.setValor(String.valueOf(Integer.parseInt(izq.getValor())+Integer.parseInt(der.getValor())));  
            return object;
        }else if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "INT") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "CHAR") || izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "DOUBLE")){
            object.setTipo("DOUBLE"); 
            object.setValor(String.valueOf(Double.parseDouble(izq.getValor())+Double.parseDouble(der.getValor())));
            return object;
        }else if(izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "CHAR") || izq.getTipo() .equals( "STRING") && der.getTipo() .equals( "STRING") || izq.getTipo() .equals( "INT") && der.getTipo() .equals( "STRING") || izq.getTipo() .equals( "STRING") && der.getTipo() .equals( "INT") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "STRING") || izq.getTipo() .equals( "STRING") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "BOOL") && der.getTipo() .equals( "STRING" )|| izq.getTipo() .equals( "STRING") && der.getTipo() .equals( "BOOL") || izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "STRING") || izq.getTipo() .equals( "STRING") && der.getTipo() .equals( "CHAR")){
            object.setTipo("STRING"); 
            object.setValor(izq.getValor()+der.getValor());
            return object;
        }else{
            object.setTipo("ERROR"); 
            System.err.println("Error Semántico: Error de tipo de Expresion");
            return object;
        }
        
    }

    public static Aritmeticas Resta(Expresion izq,String Operacion,Expresion der,Aritmeticas object){
        if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT") || izq.getTipo() .equals( "INT") && der.getTipo() .equals( "CHAR") || izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "INT")){
            object.setTipo("INT"); 
          
            object.setValor(String.valueOf(Integer.parseInt(izq.getValor())-Integer.parseInt(der.getValor())));
            return object;
        }else if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "INT") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "CHAR") || izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "DOUBLE")){
            object.setTipo("DOUBLE"); 
            object.setValor(String.valueOf(Double.parseDouble(izq.getValor())-Double.parseDouble(der.getValor())));
            return object;
        }else{
            object.setTipo("ERROR"); 
            System.err.println("Error Semántico: Error de tipo de Expresion");
            return object;
        }
        
    }
    public static Aritmeticas Multiplicación(Expresion izq,String Operacion,Expresion der,Aritmeticas object){
        if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT")|| izq.getTipo() .equals( "INT") && der.getTipo() .equals( "CHAR") || izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "INT")){
            object.setTipo("INT"); 
          
            object.setValor(String.valueOf(Integer.parseInt(izq.getValor())*Integer.parseInt(der.getValor())));
            return object;
        }else if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "INT") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "CHAR") || izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "DOUBLE")){
            object.setTipo("DOUBLE"); 
            object.setValor(String.valueOf(Double.parseDouble(izq.getValor())*Double.parseDouble(der.getValor())));
            return object;
        }else{
            object.setTipo("ERROR"); 
            System.err.println("Error Semántico: Error de tipo de Expresion");
            return object;
        }
        
    }

    public static Aritmeticas Division(Expresion izq,String Operacion,Expresion der,Aritmeticas object){
        if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT") || izq.getTipo() .equals( "INT") && der.getTipo() .equals( "CHAR") || izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "INT")){
            object.setTipo("INT"); 
          
            object.setValor(String.valueOf(Integer.parseInt(izq.getValor())/Integer.parseInt(der.getValor())));
            return object;
        }else if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "INT") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "CHAR") || izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "DOUBLE")){
            object.setTipo("DOUBLE"); 
            object.setValor(String.valueOf(Double.parseDouble(izq.getValor())/Double.parseDouble(der.getValor())));
            return object;
        }else{
            object.setTipo("ERROR"); 
            System.err.println("Error Semántico: Error de tipo de Expresion");
            return object;
        }
        
    }

    public static Aritmeticas Potencia(Expresion izq,String Operacion,Expresion der,Aritmeticas object){
        if (izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT")){
            object.setTipo("INT");
            object.setValor(String.valueOf(Math.pow(Integer.parseInt(izq.getValor()),Integer.parseInt(der.getValor()))));
            return object;
        }else if(izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "INT") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "INT" )){
            object.setTipo("DOUBLE"); 
            object.setValor(String.valueOf(Math.pow(Integer.parseInt(izq.getValor()),Integer.parseInt(der.getValor())))); // POR COMODIDAD INT
            return object;
        }else{ 
            object.setTipo("ERROR"); 
            System.err.println("Error Semántico: Error de tipo de Expresion");
            return object;
        }
    }

    public static Aritmeticas Modulo(Expresion izq,String Operacion,Expresion der,Aritmeticas object){
        if (izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT")){
            object.setTipo("INT"); 
            object.setValor(String.valueOf(Integer.parseInt(izq.getValor())%Integer.parseInt(der.getValor())));
            return object;
        }else if(izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "INT") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "INT") ){
            object.setTipo("DOUBLE"); 
            object.setValor(String.valueOf(Double.parseDouble(izq.getValor())%Double.parseDouble(der.getValor())));
            return object;
        }else{ 
            object.setTipo("ERROR"); 
            System.err.println("Error Semántico: Error de tipo de Expresion");
            return object;
        }
    }
    
    public static Relacionales Relacionar(Expresion izq,String Operacion,Expresion der,Relacionales object, boolean Condicion, boolean CondicionAscii, Boolean CondicionAscii2){
        
        if (izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "CHAR" )||izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "INT") || izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "DOUBLE") || izq.getTipo() .equals( "DOUBLE") && der.getTipo() .equals( "CHAR")){
            
            object.setTipo("BOOL");

            if(Condicion){
                object.setValor("true");
               return object;
            }else{
                object.setValor("false");
               return object;
            }
        }else if ( izq.getTipo() .equals( "CHAR") && der.getTipo() .equals( "INT")){  // Código Ascii
            object.setTipo("BOOL");
            if(CondicionAscii){
                object.setValor("true");
               return object;
            }else{
                object.setValor("false");
               return object;
            }
        
        }else if ( izq.getTipo() .equals( "INT") && der.getTipo() .equals( "CHAR") ){ // Código Ascii
            
            object.setTipo("BOOL");
            if(CondicionAscii2){
                object.setValor("true");
               return object;
            }else{
                object.setValor("false");
               return object;
            }
        }else{
            object.setTipo("ERROR"); 
            System.err.println("Error Semántico: Error de tipo de Expresion");
            return object;
        }

    }

    // Entra aqui cuando haya un error booleano de lenght y un error string en el parseo a int
    public static Relacionales RelacionarBoolean(Expresion izq,String Operacion,Expresion der,Relacionales object, boolean Condicion){
        if (izq.getTipo() .equals( "BOOL") && der.getTipo() .equals( "BOOL") || izq.getTipo() .equals( "STRING") && der.getTipo() .equals( "STRING")){
            object.setTipo("BOOL");
            System.out.println("I am here");
            if(Condicion){
               object.setValor("true");
              return object;
            }else{
               object.setValor("false");
              return object;
            }
        }else {
            object.setTipo("ERROR"); 
            System.err.println("Error Semántico: Error de tipo de Expresion");
            return object;
        } 
    }
    
    public static Logicas OperacionesLogicas(Expresion izq,String Operacion,Expresion der,Logicas object, boolean Condicion){
        if (izq.getTipo() .equals( "BOOL") && der.getTipo() .equals( "BOOL")){
            if(Condicion){
               object.setTipo("BOOL");
               object.setValor("true");
              return object;
            }else{
               object.setTipo("BOOL");
               object.setValor("false");
              return object;
            }
        }else {
            object.setTipo("ERROR"); 
            System.err.println("Error Semántico: Error de tipo de Expresion");
            return object;
        } 
    }

    public static String eliminarComillas(String input) {
        if (input .equals( null)) {
            return null;
        }
        return input.replaceAll("[\"']", "");
    }
   
}