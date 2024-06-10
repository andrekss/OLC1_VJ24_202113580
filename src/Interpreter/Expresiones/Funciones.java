package Interpreter.Expresiones;

import Interpreter.Expresion;

public class Funciones {
    public static Aritmeticas Suma(Expresion izq,String Operacion,Expresion der,Aritmeticas object){
        
        if(izq.getTipo() == "INT" && der.getTipo() == "INT" || izq.getTipo() == "INT" && der.getTipo() == "CHAR" || izq.getTipo() == "CHAR" && der.getTipo() == "INT"){
            object.setTipo("INT"); 
            object.setValor(String.valueOf(Integer.parseInt(izq.getValor())+Integer.parseInt(der.getValor())));  
            return object;
        }else if(izq.getTipo() == "INT" && der.getTipo() == "DOUBLE" || izq.getTipo() == "DOUBLE" && der.getTipo() == "INT" || izq.getTipo() == "DOUBLE" && der.getTipo() == "DOUBLE" || izq.getTipo() == "DOUBLE" && der.getTipo() == "CHAR" || izq.getTipo() == "CHAR" && der.getTipo() == "DOUBLE"){
            object.setTipo("DOUBLE"); 
            object.setValor(String.valueOf(Double.parseDouble(izq.getValor())+Double.parseDouble(der.getValor())));
            return object;
        }else if(izq.getTipo() == "CHAR" && der.getTipo() == "CHAR" || izq.getTipo() == "STRING" && der.getTipo() == "STRING" || izq.getTipo() == "INT" && der.getTipo() == "STRING" || izq.getTipo() == "STRING" && der.getTipo() == "INT" || izq.getTipo() == "DOUBLE" && der.getTipo() == "STRING" || izq.getTipo() == "STRING" && der.getTipo() == "DOUBLE" || izq.getTipo() == "BOOL" && der.getTipo() == "STRING" || izq.getTipo() == "STRING" && der.getTipo() == "BOOL" || izq.getTipo() == "CHAR" && der.getTipo() == "STRING" || izq.getTipo() == "STRING" && der.getTipo() == "CHAR"){
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
        if(izq.getTipo() == "INT" && der.getTipo() == "INT" || izq.getTipo() == "INT" && der.getTipo() == "CHAR" || izq.getTipo() == "CHAR" && der.getTipo() == "INT"){
            object.setTipo("INT"); 
          
            object.setValor(String.valueOf(Integer.parseInt(izq.getValor())-Integer.parseInt(der.getValor())));
            return object;
        }else if(izq.getTipo() == "INT" && der.getTipo() == "DOUBLE" || izq.getTipo() == "DOUBLE" && der.getTipo() == "INT" || izq.getTipo() == "DOUBLE" && der.getTipo() == "DOUBLE" || izq.getTipo() == "DOUBLE" && der.getTipo() == "CHAR" || izq.getTipo() == "CHAR" && der.getTipo() == "DOUBLE"){
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
        if(izq.getTipo() == "INT" && der.getTipo() == "INT" || izq.getTipo() == "INT" && der.getTipo() == "CHAR" || izq.getTipo() == "CHAR" && der.getTipo() == "INT"){
            object.setTipo("INT"); 
          
            object.setValor(String.valueOf(Integer.parseInt(izq.getValor())*Integer.parseInt(der.getValor())));
            return object;
        }else if(izq.getTipo() == "INT" && der.getTipo() == "DOUBLE" || izq.getTipo() == "DOUBLE" && der.getTipo() == "INT" || izq.getTipo() == "DOUBLE" && der.getTipo() == "DOUBLE" || izq.getTipo() == "DOUBLE" && der.getTipo() == "CHAR" || izq.getTipo() == "CHAR" && der.getTipo() == "DOUBLE"){
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
        if(izq.getTipo() == "INT" && der.getTipo() == "INT" || izq.getTipo() == "INT" && der.getTipo() == "CHAR" || izq.getTipo() == "CHAR" && der.getTipo() == "INT"){
            object.setTipo("INT"); 
          
            object.setValor(String.valueOf(Integer.parseInt(izq.getValor())/Integer.parseInt(der.getValor())));
            return object;
        }else if(izq.getTipo() == "INT" && der.getTipo() == "DOUBLE" || izq.getTipo() == "DOUBLE" && der.getTipo() == "INT" || izq.getTipo() == "DOUBLE" && der.getTipo() == "DOUBLE" || izq.getTipo() == "DOUBLE" && der.getTipo() == "CHAR" || izq.getTipo() == "CHAR" && der.getTipo() == "DOUBLE"){
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
        if (izq.getTipo() == "INT" && der.getTipo() == "INT"){
            object.setTipo("INT");
            object.setValor(String.valueOf(Math.pow(Integer.parseInt(izq.getValor()),Integer.parseInt(der.getValor()))));
            return object;
        }else if(izq.getTipo() == "DOUBLE" && der.getTipo() == "DOUBLE" || izq.getTipo() == "INT" && der.getTipo() == "DOUBLE" || izq.getTipo() == "DOUBLE" && der.getTipo() == "INT" ){
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
        if (izq.getTipo() == "INT" && der.getTipo() == "INT"){
            object.setTipo("INT"); 
            object.setValor(String.valueOf(Integer.parseInt(izq.getValor())%Integer.parseInt(der.getValor())));
            return object;
        }else if(izq.getTipo() == "DOUBLE" && der.getTipo() == "DOUBLE" || izq.getTipo() == "INT" && der.getTipo() == "DOUBLE" || izq.getTipo() == "DOUBLE" && der.getTipo() == "INT" ){
            object.setTipo("DOUBLE"); 
            object.setValor(String.valueOf(Double.parseDouble(izq.getValor())%Double.parseDouble(der.getValor())));
            return object;
        }else{ 
            object.setTipo("ERROR"); 
            System.err.println("Error Semántico: Error de tipo de Expresion");
            return object;
        }
    }
    
    public static String eliminarComillas(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("[\"']", "");
    }
}