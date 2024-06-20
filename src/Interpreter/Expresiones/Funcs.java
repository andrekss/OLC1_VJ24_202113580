package Interpreter.Expresiones;

import Interpreter.Expresion;
import client.Errors;
import client.TextEditor;

public class Funcs {

    // Aritméticas
     public static Aritmeticas Suma(Expresion izq,Expresion der,Aritmeticas object){
        if(izq.getTipo().equals("INT") && der.getTipo().equals("INT")){
            object.setTipo("INT");
            int IzqValue =  (int) Integer.valueOf(izq.getValor()) ;
            int DerValue = (int) Integer.valueOf(der.getValor()) ;
            String resultado = String.valueOf(IzqValue + DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals( "INT") && der.getTipo().equals("DOUBLE")){
            //System.out.println("holi");
            object.setTipo("DOUBLE");
            
            int IzqValue =  (int) Integer.valueOf(izq.getValor()) ;
            double DerValue = (double) Double.parseDouble(der.getValor()) ;
            String resultado = String.valueOf(IzqValue + DerValue);
            object.setValor(resultado);
            //System.out.println(resultado);
            return object;
        }
        if(izq.getTipo().equals("INT") && der.getTipo().equals("CHAR")){
            object.setTipo("INT");
            int IzqValue =  (int)Integer.valueOf(izq.getValor()) ;
            String DerValue = (String)der.getValor() ;
            char DerValueChar = DerValue.charAt(0);
            
            int DerValueAscii = (int)DerValueChar;
            String resultado = String.valueOf(IzqValue + DerValueAscii);
            object.setValor(resultado);
            return object;                
        }
        if(izq.getTipo().equals("INT") && der.getTipo().equals("STRING")){
            object.setTipo("STRING");
            int IzqValue =  Integer.valueOf(izq.getValor()) ;
            String DerValue = (String) der.getValor() ;
            
            String IzqValueString = String.valueOf(IzqValue);
            String resultado = IzqValueString + DerValue;
            object.setValor(resultado);
            return object;     
        }

        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("INT")){
            object.setTipo("DOUBLE");
            double IzqValue = (double) Double.parseDouble(izq.getValor()) ;
            int DerValue = Integer.valueOf(der.getValor()) ;
            String resultado =String.valueOf( IzqValue + DerValue);
            
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            double IzqValue = (double) Double.parseDouble(izq.getValor()) ;
            double DerValue = (double) Double.parseDouble(der.getValor()) ;
            String resultado = String.valueOf(IzqValue + DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("CHAR")){
            object.setTipo("DOUBLE");
            double IzqValue = (double) Double.parseDouble(izq.getValor()) ;
            String DerValue = (String) der.getValor() ;
            char DerValueChar = DerValue.charAt(0);
            
            double DerValueAscii = (double) DerValueChar;
            String resultado = String.valueOf(IzqValue + DerValueAscii);
            object.setValor(resultado);
            return object;                
        }
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("STRING")){
            object.setTipo("STRING");
            double IzqValue = (double) Double.parseDouble(izq.getValor()) ;
            String DerValue = (String) der.getValor() ;
            String IzqValueString = String.valueOf(IzqValue);
            String resultado = IzqValueString + DerValue;
            object.setValor(resultado);
            return object;     
        }
        


        if(izq.getTipo().equals("BOOL") && der.getTipo().equals("STRING")){
            object.setTipo("STRING");
            boolean IzqValue = (boolean) Boolean.parseBoolean(izq.getValor()) ;
            String DerValue = (String) der.getValor() ;
            String IzqValueString = String.valueOf(IzqValue);
            String resultado = IzqValueString + DerValue;
            object.setValor(resultado);
            return object;
        }
        
        
        

        if(izq.getTipo().equals("CHAR") && der.getTipo().equals("INT")){
            object.setTipo("INT");
            String IzqValue = (String) izq.getValor() ;
            int DerValue = (int) Integer.parseInt(der.getValor()) ;
            char IzqValueChar = IzqValue.charAt(0);
            
            int IzqValueAscii = (int) IzqValueChar;
            String resultado = String.valueOf(IzqValueAscii + DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("CHAR") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            String IzqValue = (String) izq.getValor() ;
            double DerValue = (double) Double.parseDouble(der.getValor()) ;
            char IzqValueChar = IzqValue.charAt(0);
            
            int IzqValueAscii = (int) IzqValueChar;
            String resultado = String.valueOf(IzqValueAscii + DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("CHAR") && der.getTipo().equals("CHAR")){
            object.setTipo("STRING");
            String IzqValue = (String) izq.getValor() ;
            String DerValue = (String) der.getValor() ;
            char IzqValueChar = IzqValue.charAt(0);
            char DerValueChar = DerValue.charAt(0);
            String IzqValueString = String.valueOf(IzqValueChar);
            String DerValueString = String.valueOf(DerValueChar);
            String resultado = IzqValueString + DerValueString;
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("CHAR") && der.getTipo().equals("STRING")){
            object.setTipo("STRING");
            String IzqValue = (String) izq.getValor() ;
            String DerValue = (String) der.getValor() ;
            char IzqValueChar = IzqValue.charAt(0);
            String IzqValueString = String.valueOf(IzqValueChar);
            String resultado = IzqValueString + DerValue;
            object.setValor(resultado);
            return object;
        }
        
        if(izq.getTipo().equals("STRING") && der.getTipo().equals("INT")){
            object.setTipo("STRING");
            String IzqValue = (String) izq.getValor() ;
            int DerValue = (int) Integer.parseInt(der.getValor()) ;
            String DerValueString = String.valueOf(DerValue);
            String resultado = IzqValue + DerValueString;
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("STRING") && der.getTipo().equals("DOUBLE")){
            object.setTipo("STRING");
            String IzqValue = (String) izq.getValor() ;
            double DerValue = (double) Double.parseDouble(der.getValor()) ;
            String DerValueString = String.valueOf(DerValue);
            String resultado = IzqValue + DerValueString;
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("STRING") && der.getTipo().equals("CHAR")){
            object.setTipo("STRING");
            String IzqValue = (String) izq.getValor() ;
            String DerValue = (String) der.getValor() ;
            char DerValueChar = DerValue.charAt(0);
            String DerValueString = String.valueOf(DerValueChar);
            String resultado = IzqValue + DerValueString;
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("STRING") && der.getTipo().equals("STRING")){
            object.setTipo("STRING");
            String IzqValue = (String) izq.getValor() ;
            String DerValue = (String) der.getValor() ;
            String resultado = IzqValue + DerValue;
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("STRING") && der.getTipo().equals("BOOL")){
            object.setTipo("STRING");
            String IzqValue = (String) izq.getValor() ;
            boolean DerValue = (boolean) Boolean.parseBoolean(der.getValor()) ;
            String DerValueString = String.valueOf(DerValue);
            String resultado = IzqValue + DerValueString;
            object.setValor(resultado);
            return object;
        }
            object.setTipo("ERROR"); 
            System.err.println("Error Semántico: Error de tipo de Expresion");
            // Interfaz
            Errors error = new Errors("Semántico","Error de tipo de Expresion",der.getFila() ,der.getColumna());
            TextEditor.Errores.add(error);
            TextEditor.Print+="Error Semántico: Error de tipo de Expresion." + " | Fila:" +der.getFila() + " | Columna: " + der.getColumna()+"\n";

            return object;


     }
     public static Aritmeticas Resta(Expresion izq,Expresion der,Aritmeticas object){
        if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT")){
            object.setTipo("INT");
            //System.out.println("Resta de: "+izq.getValor() + " - " + der.getValor());
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            String resultado = String.valueOf(IzqValue - DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo() .equals( "INT") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            String resultado = String.valueOf(IzqValue - DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("INT") && der.getTipo().equals("CHAR")){
            object.setTipo("INT");
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            String DerValue =  (String) der.getValor()  ;
            char DerValueChar = DerValue.charAt(0);
            int DerValueAscii = (int) DerValueChar;
            String resultado = String.valueOf(IzqValue - DerValueAscii);
            object.setValor(resultado);
            return object;                
        }
        
    
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("INT")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            String resultado = String.valueOf(IzqValue - DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            String resultado = String.valueOf(IzqValue - DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("CHAR")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            String DerValue =  (String) der.getValor()  ;
            char DerValueChar = DerValue.charAt(0);
            //pasar el char a ascii y restar
            int DerValueAscii = (int) DerValueChar;
            String resultado = String.valueOf(IzqValue - DerValueAscii);
            object.setValor(resultado);
            return object;                
        }
        



        if(izq.getTipo().equals("CHAR") && der.getTipo().equals("INT")){
            object.setTipo("INT");
            String IzqValue =  (String) izq.getValor()  ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            char IzqValueChar = IzqValue.charAt(0);
            int IzqValueAscii = (int) IzqValueChar;
            String resultado = String.valueOf(IzqValueAscii - DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("CHAR") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            String IzqValue =  (String) izq.getValor()  ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            char IzqValueChar = IzqValue.charAt(0);
            int IzqValueAscii = (int) IzqValueChar;
            String resultado = String.valueOf(IzqValueAscii - DerValue);
            object.setValor(resultado);
            return object;
        }

        

        object.setTipo("ERROR"); 
        System.err.println("Error Semántico: Error de tipo de Expresion");
        // Interfaz
        Errors error = new Errors("Semántico","Error de tipo de Expresion",der.getFila() ,der.getColumna());
        TextEditor.Errores.add(error);
        TextEditor.Print+="Error Semántico: Error de tipo de Expresion." + " | Fila:" +der.getFila() + " | Columna: " + der.getColumna()+"\n";

        return object;
        
     }

     public static Aritmeticas Multiplicación(Expresion izq,Expresion der,Aritmeticas object){
        if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT")){
            object.setTipo("INT");
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            String resultado = String.valueOf(IzqValue * DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo() .equals( "INT") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            String resultado = String.valueOf(IzqValue * DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("INT") && der.getTipo().equals("CHAR")){
            object.setTipo("INT");
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            String DerValue =  (String) der.getValor()  ;
            char DerValueChar = DerValue.charAt(0);
            int DerValueAscii = (int) DerValueChar;
            String resultado = String.valueOf(IzqValue * DerValueAscii);
            object.setValor(resultado);
            return object;                
        }
        

        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("INT")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            String resultado = String.valueOf(IzqValue * DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            String resultado =String.valueOf( IzqValue * DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("CHAR")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            String DerValue =  (String) der.getValor()  ;
            
            
            char DerValueChar = DerValue.charAt(0);
            int DerValueAscii = (int) DerValueChar;
            String resultado =String.valueOf( IzqValue * DerValueAscii);
            object.setValor(resultado);
            return object;                
        }

        if(izq.getTipo().equals("CHAR") && der.getTipo().equals("INT")){
            object.setTipo("INT");
            String IzqValue =  (String) izq.getValor()  ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            char IzqValueChar = IzqValue.charAt(0);
            int IzqValueAscii = (int) IzqValueChar;
            String resultado = String.valueOf(IzqValueAscii * DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("CHAR") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            String IzqValue =  (String) izq.getValor()  ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            char IzqValueChar = IzqValue.charAt(0);
            int IzqValueAscii = (int) IzqValueChar;
            String resultado = String.valueOf(IzqValueAscii * DerValue);
            object.setValor(resultado);
            return object;
        }        
        object.setTipo("ERROR"); 
        System.err.println("Error Semántico: Error de tipo de Expresion");
        // Interfaz
        Errors error = new Errors("Semántico","Error de tipo de Expresion",der.getFila() ,der.getColumna());
        TextEditor.Errores.add(error);
        TextEditor.Print+="Error Semántico: Error de tipo de Expresion." + " | Fila:" +der.getFila() + " | Columna: " + der.getColumna()+"\n";

        return object;

     }

     public static Aritmeticas Division(Expresion izq,Expresion der,Aritmeticas object){

        if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor());
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            
            String resultado = String.valueOf(IzqValue / DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo() .equals( "INT") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            
            String resultado = String.valueOf(IzqValue / DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("INT") && der.getTipo().equals("CHAR")){
            object.setTipo("DOUBLE");
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            String DerValue =  (String) der.getValor() ;
            char DerValueChar = DerValue.charAt(0);

            int DerValueAscii = (int) DerValueChar;
            String resultado = String.valueOf(IzqValue / DerValueAscii);
            object.setValor(resultado);
            return object;                
        }
        
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("INT")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            
            String resultado = String.valueOf(IzqValue / DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            
            String resultado = String.valueOf(IzqValue / DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("CHAR")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            String DerValue =  (String) der.getValor() ;
            char DerValueChar = DerValue.charAt(0);
            int DerValueAscii = (int) DerValueChar;
            
            String resultado = String.valueOf(IzqValue / DerValueAscii);
            object.setValor(resultado);
            return object;                
        }
        
        if(izq.getTipo().equals("CHAR") && der.getTipo().equals("INT")){
            object.setTipo("DOUBLE");
            String IzqValue =  (String) izq.getValor() ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            char IzqValueChar = IzqValue.charAt(0);
            int IzqValueAscii = (int) IzqValueChar;

            String resultado = String.valueOf(IzqValueAscii / DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("CHAR") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            String IzqValue =  (String) izq.getValor() ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            char IzqValueChar = IzqValue.charAt(0);
            int IzqValueAscii = (int) IzqValueChar;

            String resultado = String.valueOf(IzqValueAscii / DerValue);
            object.setValor(resultado);
            return object;
        }
        object.setTipo("ERROR"); 
        System.err.println("Error Semántico: Error de tipo de Expresion");
        // Interfaz
        Errors error = new Errors("Semántico","Error de tipo de Expresion",der.getFila() ,der.getColumna());
        TextEditor.Errores.add(error);
        TextEditor.Print+="Error Semántico: Error de tipo de Expresion." + " | Fila:" +der.getFila() + " | Columna: " + der.getColumna()+"\n";

        return object;

     }

     public static Aritmeticas Potencia(Expresion izq,Expresion der,Aritmeticas object){

        if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT")){
            object.setTipo("INT");
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            String resultado = String.valueOf((int) Math.pow(IzqValue, DerValue));
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo() .equals( "INT") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            String resultado = String.valueOf(Math.pow(IzqValue, DerValue));
            object.setValor(resultado);
            return object;
        }
        
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("INT")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            String resultado = String.valueOf(Math.pow(IzqValue, DerValue));
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            String resultado = String.valueOf(Math.pow(IzqValue, DerValue));
            object.setValor(resultado);
            return object;
        }

        object.setTipo("ERROR"); 
        System.err.println("Error Semántico: Error de tipo de Expresion");
        // Interfaz
        Errors error = new Errors("Semántico","Error de tipo de Expresion",der.getFila() ,der.getColumna());
        TextEditor.Errores.add(error);
        TextEditor.Print+="Error Semántico: Error de tipo de Expresion." + " | Fila:" +der.getFila() + " | Columna: " + der.getColumna()+"\n";

        return object;


     }

     public static Aritmeticas Modulo(Expresion izq,Expresion der,Aritmeticas object){

        if(izq.getTipo() .equals( "INT") && der.getTipo() .equals( "INT")){
            object.setTipo("INT");
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            String resultado = String.valueOf(IzqValue % DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo() .equals( "INT" )&& der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            int IzqValue =  (int) Integer.parseInt(izq.getValor()) ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            String resultado =String.valueOf( IzqValue % DerValue);
            object.setValor(resultado);
            return object;
        }
        
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("INT")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            int DerValue =  (int) Integer.parseInt(der.getValor()) ;
            String resultado = String.valueOf(IzqValue % DerValue);
            object.setValor(resultado);
            return object;
        }
        if(izq.getTipo().equals("DOUBLE") && der.getTipo().equals("DOUBLE")){
            object.setTipo("DOUBLE");
            double IzqValue =  (double) Double.parseDouble(izq.getValor()) ;
            double DerValue =  (double) Double.parseDouble(der.getValor()) ;
            String resultado = String.valueOf(IzqValue % DerValue);
            object.setValor(resultado);
            return object;
        }

        object.setTipo("ERROR"); 
        System.err.println("Error Semántico: Error de tipo de Expresion");
        // Interfaz
        Errors error = new Errors("Semántico","Error de tipo de Expresion",der.getFila() ,der.getColumna());
        TextEditor.Errores.add(error);
        TextEditor.Print+="Error Semántico: Error de tipo de Expresion." + " | Fila:" +der.getFila() + " | Columna: " + der.getColumna()+"\n";

        return object;

     }

     // LOGICAS
     public static Logicas Or(Expresion izq,Expresion der,Logicas object){

        if (izq.getTipo() .equals( "BOOL") && der.getTipo() .equals( "BOOL")) {
            object.setTipo("BOOL");

            object.setValor(String.valueOf(Boolean.parseBoolean(izq.getValor().toString()) || Boolean.parseBoolean(der.getValor().toString())));
            return object;
        }

        object.setTipo("ERROR"); 
        System.err.println("Error Semántico: Error de tipo de Expresion");
        // Interfaz
        Errors error = new Errors("Semántico","Error de tipo de Expresion",der.getFila() ,der.getColumna());
        TextEditor.Errores.add(error);
        TextEditor.Print+="Error Semántico: Error de tipo de Expresion." + " | Fila:" +der.getFila() + " | Columna: " + der.getColumna()+"\n";

        return object;
     }

     public static Logicas And(Expresion izq,Expresion der,Logicas object){

     if (izq.getTipo() .equals( "BOOL") && der.getTipo() .equals( "BOOL")) {
        object.setValor(String.valueOf(Boolean.parseBoolean(izq.getValor().toString()) && Boolean.parseBoolean(der.getValor().toString())));
        object.setTipo("BOOL");
        return object;
     }
     object.setTipo("ERROR"); 
     System.err.println("Error Semántico: Error de tipo de Expresion");
     // Interfaz
     Errors error = new Errors("Semántico","Error de tipo de Expresion",der.getFila() ,der.getColumna());
     TextEditor.Errores.add(error);
     TextEditor.Print+="Error Semántico: Error de tipo de Expresion." + " | Fila:" +der.getFila() + " | Columna: " + der.getColumna()+"\n";

     return object;

    } 

    public static Logicas XOR(Expresion izq,Expresion der,Logicas object){

        if (izq.getTipo() .equals( "BOOL") && der.getTipo() .equals( "BOOL")) {
            object.setValor(String.valueOf(Boolean.parseBoolean(izq.getValor().toString()) ^ Boolean.parseBoolean(der.getValor().toString())));
            object.setTipo("BOOL");

            return object;
        }

        object.setTipo("ERROR"); 
        System.err.println("Error Semántico: Error de tipo de Expresion");
        // Interfaz
        Errors error = new Errors("Semántico","Error de tipo de Expresion",der.getFila() ,der.getColumna());
        TextEditor.Errores.add(error);
        TextEditor.Print+="Error Semántico: Error de tipo de Expresion." + " | Fila:" +der.getFila() + " | Columna: " + der.getColumna()+"\n";
   
        return object;



    }

    // RELACIONALES
}
