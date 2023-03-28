/**Esta clase contiene el objeto usuario, el cual cuenta con 2 atributos
 * @authors L. Patzan, B. Recinos, K. Salazar
 * Version 1.0, 27/03/2023
 */
public class Usuario {
    /**
     * Variables que contendran los atributos
     */
    private String usuario, contra;

    /**
     * Constructor, seteando los valores de los atributos
     */
    public Usuario() {
        usuario = contra = "";
    }

    /**
     *
     * @return valor del usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * Configura el valor de usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return el valor la contraseña
     */
    public String getContra() {
        return contra;
    }

    /**
     * almacena la contrasena
     * @param contra
     */
    public void setContra(String contra) {
        this.contra = contra;
    }
}
