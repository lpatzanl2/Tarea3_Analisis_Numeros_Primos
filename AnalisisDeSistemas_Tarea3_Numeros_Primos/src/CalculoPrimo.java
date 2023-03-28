import java.util.ArrayList;
/**Clase que almacena el numero ingresado, crea la cadena
 * @authors L. Patzan, B. Recinos, K. Salazar
 * Version 1.0, 27/03/2023
 */
public class CalculoPrimo {
    /**
     * ArrayList para almacenar la cadena
     */
    ArrayList<Integer> prim = new ArrayList<>(); //Creamor el array
    int max;
    int sumatotal = 0;

    /**
     * Constructor para traer el numero ingresado en el main, y setearlo en la base local de la clase
     * @param max
     */
    public CalculoPrimo(int max) {
        this.max = max;
    }

    /**
     * Metodo para calcular los numeros primos
     */
    public void calculo() { //Metodo para calcular

        for (int i = 1; i <= max; i++) {
            int contador = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0)
                    contador++;
            }
            if (contador == 2) {
                //Es primo
                prim.add(i);
                sumatotal = sumatotal + i;
            }
        }

    }

    /**
     * Metodo para imprimir la cadena de numeros + el totol
     * @return todo lo almacenamos en la variable a retornar, para imprimirlo en cualquier JOptino Pane
     * Sino retorna, tendriamos que llamar el Joption pane desde aqui
     */
    public String mostrarResultado() { //Imprimimos el resultado en un String
        String showTotal = "";

        for (Integer integer : prim) {

            if (integer != 0) {
                showTotal += " [" + integer + "] ";
            }
        }
        showTotal += "\nLa sumatoria total es: " + sumatotal + "\n";
        return showTotal;
    }


}
