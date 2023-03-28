import javax.swing.*;
import java.util.ArrayList;

/**Metodos con calculos con el objeto usuarios y calculos matematicos
 * @authors L. Patzan, B. Recinos, K. Salazar
 * Version 1.0, 27/03/2023
 */
public class Metodos_Usuario {
    /**
     * ArrayList que almacenara lo numeros primos generados por la cadena
     */
    ArrayList<Usuario> users = new ArrayList<>(); //Creamor el array

    /**
     * metodo para mostrar JOptionPane y retornar el valor tipo String ingresado
     * @param text
     * @return valor ingresado en el cuadro de dialogo
     */
    public String Input(String text) {
        return JOptionPane.showInputDialog(text);
    }

    /**
     * Metodo para agregar un usuario, validando que no exista ya
     */
    public void addUser() {
        Usuario objUsuario = new Usuario(); //Instanceamos
        String user = Input("Ingrese su usuario: "); //Creamos variable y se la mandamos como parametro al metodo INPUT
        String pass = Input("Ingrese su contrasena: "); //El input nos pedira el valor, el textos solo es para el showmessage
        objUsuario.setUsuario(user);
        objUsuario.setContra(pass);

        if (users.isEmpty()) {
            users.add(objUsuario);
        } else {
            int contador = 0;
            for (Usuario usuario : users) {

                if (usuario.getUsuario().equals(user)) {
                    JOptionPane.showMessageDialog(null, "Usuario ya existe");
                    contador++;
                }
            }
            if (contador == 0)
                users.add(objUsuario);
        }
    }

    /**
     * Metodo para validar que el usuario y la contraseña ingresada, despues de crear usuario, coincidan para tener acceso al programa
     * @param us usuario
     * @param pas = contraseña
     * @return verdadero o falso
     */
    public boolean Existe(String us, String pas) {

        boolean validacion = false;
        if (users.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Hay Usuarios En La Base De Datos");
        } else {
            int contador = 0;
            for (Usuario user : users) {
                if (user.getUsuario().equals(us) && user.getContra().equals(pas)) {
                    contador++;
                }
            }
            validacion = contador == 1;
        }
        return validacion;
    }

    /**
     * Metodo para mostrar el ArrayList, con todos sus valores
     * esto es unicamente para el programador, es obvio que a un usuario final
     * no se le pueden mostrar los otros usuario
     */
    public void getUsuarios() { //ciclo for para recorred la lista y extraer los valores
        StringBuilder stringUsuarios = new StringBuilder();
        for (Usuario user : users) {//.append es igual a +=
            stringUsuarios.append("Usuario: ").append(user.getUsuario()).append("\nContrasena: ").append(user.getContra()).append("\n");
        }
        JOptionPane.showMessageDialog(null, stringUsuarios.toString());
    }
}
