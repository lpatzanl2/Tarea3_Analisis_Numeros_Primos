import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**Clase para crear, sobreescribir y leer archivos
 * @authors L. Patzan, B. Recinos, K. Salazar
 * Version 1.0, 27/03/2023
 */

class Leer_Fichero {
    /**
     * Leemos el archivo, traemos la variable del usuario, desde el main
     * y con esa buscamos el archivo para leerlo, se mostrar tanto en consola como en JOptionPane
     * @param userReader
     */
    public void leeArchivoConBuffer(String userReader) { //Metodo para leer el archivo
        try { //reader para leer la info del fichero
            FileReader entrada = new FileReader(userReader + ".txt");
            BufferedReader miBuffer = new BufferedReader(entrada);//Almacenamos en un buffer ENTRADA que es fichero de texto
            //int c=entrada.read(); //Read devuelve -1 cuando llega al final
            String linea = "",lina2="";

            while (linea != null) { //leeremos la linea, el string y validamos que no este null, la linea de texto termina cuando encuentra
                //\n un salto de linea
                linea = miBuffer.readLine(); //Almacenamos cada linea del TXT
                 //Para que imprima de una vez la cadena en el JOptionPane y no por linea
                if (linea != null) //para que no imprima el ultimo null
                {
                    //Leeremos linea a linea, NO CARACTER A CARACTER
                    lina2+=linea+"\n";
                    System.out.println(linea); //Con salto de linea despues de cada linea
                }

            }
            JOptionPane.showMessageDialog(null,lina2+"\n");
            entrada.close();
        } catch (
                IOException e) { //FileNotFoundException solo para el file, pero la IO es la super clase que abarca read y reader
            JOptionPane.showMessageDialog(null,"No se ha encontrado el archivo, o no a de existir aun");
            //System.out.println("No se ha encontrado el archivo, o no a de existir aun");
        }
    }

    /**
     * Metodo para extraer fecha y hora de la computadora
     * @return es retornado en una variable String para imprimirla donde la llamemos
     */
    public String fecha() { //Metodo para fecha y hora
        String date;
        date = (new SimpleDateFormat("yyy//MM/dd HH:mm:ss")).format(Calendar.getInstance().getTime());
        return date;
    }
    /**
     * Metodo para escribir en el archivo, traemos una variable con el usuario ingresado, y creamos con ese
     * nombre del usuario el archivo txt.
     * @return
     */
    public void Sobreescribir(String frase, String usuaaario, int numIngresado) { //Con este metodo SOBREESCRIBIMOS
        try { //File writer sino existe el documento lo crea, si existe sobreescribe
            FileWriter escritura = new FileWriter(usuaaario + ".txt", true);
            escritura.write("\n\nNumero Ingresado:" + numIngresado + "\nUsuario: " + usuaaario + "\n");

            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));//Nos permite meter un String
            }
            escritura.write("Fecha y hora: " + fecha());
            escritura.close(); //cerramos la cosa
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
