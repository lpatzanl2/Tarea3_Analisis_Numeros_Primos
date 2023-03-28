import javax.swing.*;
import java.io.IOException;
/**Clase main, para llamar los metodos de las otras clases y mandarle sus parametros
 *
 * @authors L. Patzan, B. Recinos, K. Salazar
 * Version 1.0, 27/03/2023
 */


public class Main {
    public static void main(String[] args) throws IOException {
        Metodos_Usuario obj = new Metodos_Usuario();
        byte opcion = 0;
        String user, contras ;
        do {
            /**
             * Validamos que no se ingrese letra o algun numero mayor a la cantidad de opcioes
             */
            try{  //Validamos que se ingrese un numero unicamente
            opcion = Byte.parseByte(JOptionPane.showInputDialog(null, "1. Agregar un usuario\n"
                    + "2.Ver Base De Datos Usuarios\n3.Ya Tengo Usuario\n4.Salir", "MENU", JOptionPane.QUESTION_MESSAGE));
            switch (opcion) {
                /**Llmamamos metodo para agregar usuario */
                case 1:
                    obj.addUser();
                    break;
                /**Mostramos base de datos de usuarios y contra en un arraylist */
                case 2:
                    obj.getUsuarios();
                    break;
                /**Ingreso de usuario con contraseña al sistema para calcular numeros, escribir y leer */
                case 3:
                    Leer_Fichero leer = new Leer_Fichero();
                    int numeroIngresadoAcalcular;

                    user = JOptionPane.showInputDialog(null, //String solo empieza con JOptionPane
                            "Ingrese Su Usuario: ", "User", JOptionPane.QUESTION_MESSAGE);
                    contras = JOptionPane.showInputDialog(null, //String solo empieza con JOptionPane
                            "Ingrese Su Contrasena: ", "Password", JOptionPane.QUESTION_MESSAGE);
                    if (obj.Existe(user, contras) == true) {
                        JOptionPane.showMessageDialog(null, "Bienvenido " + user);
                        int opc, opc2 = 0;
                        while (opc2 != 3) {
                            try{ /**
                                * Validamos que no se ingrese letra o algun numero mayor a la cantidad de opcioes
                                */
                            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Calcular Primos De Un Numero\n2.Ver Historial De Intentos\n" + "3. Salir", "Ingreso Numero...", JOptionPane.QUESTION_MESSAGE));
                            switch (opc) {
                                case 1:
                                    numeroIngresadoAcalcular = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Numero A Calcular", "Ingreso Numero...", JOptionPane.QUESTION_MESSAGE));
                                    CalculoPrimo obj2 = new CalculoPrimo(numeroIngresadoAcalcular);
                                    obj2.calculo();
                                    leer.Sobreescribir(obj2.mostrarResultado(), user, numeroIngresadoAcalcular);
                                    JOptionPane.showMessageDialog(null, obj2.mostrarResultado(), "SALIDA", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                case 2:
                                    leer.leeArchivoConBuffer(user);
                                    break;
                                case 3:
                                    opc2 = 3;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Solo existen 3 opciones", "Error!!!!", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                            }
                                /**Si el usuario mete una letra o numero no valido, o espacio en blanco no se cerrara el programa*/
                        }catch (NumberFormatException n){ //Para validar que el usuario ingrese numero unicamnete
                            JOptionPane.showMessageDialog(null,"Introduzca un numero");
                        }

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos no coinsiden");
                    }
                    break; //Break Caso 3
                case 4:/**Usuario decidio salir, mostramos mensaje de salida en JOption Pane*/
                    JOptionPane.showMessageDialog(null, "Gracias, vuelva pronto", "SALIDA", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcino no existe", "Error", JOptionPane.QUESTION_MESSAGE);
                    break;
            }/**Si el usuario mete una letra o numero no valido, o espacio en blanco no se cerrara el programa*/
            }catch (NumberFormatException n){ //Para validar que el usuario ingrese numero unicamnete
                JOptionPane.showMessageDialog(null,"Introduzca un numero");
            }
            /**Fin Cilo */
        } while (opcion != 4);

    }

}