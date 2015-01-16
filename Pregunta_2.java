/**
*Utilizando el diccionario SOWPODS de Scrabble (https://scrabblehelper.googlecode.com/
*svn-history/r20/trunk/ScrabbleHelper/src/dictionaries/sowpods.txt) escriba un programa (en
*su lenguaje de preferencia) que determine cuáles letras nunca aparecen repetidas de forma
*consecutiva (AA, BB, CC, etc). Por ejemplo, la letra “D” aparece repetida pues la palabra
*“ADD” contiene la sub-secuencia “DD”.
**/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Pregunta_2 {
 
    public static void CargarArchivo(String dirArchivo)
    throws IOException,ArrayIndexOutOfBoundsException,IndexOutOfBoundsException {
        BufferedReader in = new BufferedReader(new FileReader(dirArchivo));	
        String s;
        String[] tok;
        FileWriter fichero=null;
        PrintWriter pw=null;
        try {
		fichero = new FileWriter("sowpods_salida.txt");
		pw = new PrintWriter(fichero);
        	while ((s = in.readLine()) != null ){
			char[] tokens = s.toCharArray();
			for (int i=0; i<tokens.length;i++){
				if (i!= tokens.length -1){
					if (tokens[i] != tokens[i +1]) {
						if (i==0){
						pw.print(tokens[i] + " ");
						}else{
							if (tokens[i] != tokens[i -1]){
								pw.print(tokens[i] + " ");	
							}
						
						}
					}
				}else{
					if(tokens[i]!=tokens[i-1]){
						pw.print(tokens[i]);	
					}
				}
			}
			pw.println();
            	}
		fichero.close();


        }catch (IOException e){
        System.out.println("Error: no se encuentra el archivo de lectura.");
        } catch (ArrayIndexOutOfBoundsException e1) {
        System.out.println("Error: formato incorrecto del archivo.");
        } catch (IndexOutOfBoundsException e2) {
        System.out.println("Error: formato incorrecto del archivo.");
        }
    }

    public static void main(String[] args) {
        if (args.length !=1) {
            System.out.println("Error en la entrada: java Pregunta_2 sowpods.txt");
            System.exit(1);
        }
        try {	
            CargarArchivo(args[0]);
    
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
