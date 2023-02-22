package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Funciones {
    
    /**
     * A method that receives an int from the user and returns it
     * 
     * @return int
     */
    public static int getUserIntegerInput() {
        
    	System.out.print("How many students are in this class? : ");
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String inputString = null;
        
        try {
            inputString = br.readLine();
        } catch (IOException e) {
            System.out.println("The input value is incorrect. Closed");      
            e.printStackTrace();
        }
        
        return Integer.parseInt( inputString );
    }
    
    /**
     * A method that receives and returns a double from the user.
     * 
     * @return double
     */
    public static double getUserDoubleInput(String id, String nom) {

    	System.out.print(id + " Studen's " + nom + " Score : ");
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String inputString = null;
        double valor = 0.0;
        
        try {
            inputString = br.readLine();
        } catch (IOException e) {
   
            e.printStackTrace();
        }
        try {
            valor = Double.parseDouble( inputString );
    } catch (IllegalArgumentException e) {
        System.out.println("The input value is incorrect. Closed");      
    	System.out.print(id + " Studen's " + nom + " Score : ");
    	
        try {
            inputString = br.readLine();
            valor = Double.parseDouble( inputString );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        return valor ;
    
    }
    
    /**
     * A method that receives String input from the user and returns it
     * 
     * @return String
     */
    public static String getCodeInput() {
        
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String inputString = null;
        
        try {
            inputString = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return inputString;
    }
}