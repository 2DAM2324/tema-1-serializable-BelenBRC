//Belén Robustillo Carmona

package Modelo;

/**
 * Clase Valoracion con atributos:
 * ID_valoracion           Código identificador único para cada valoración
 * ruta                    Ruta valorada
 * usuario                 Usuario que realiza la valoración
 * puntuacion              Puntuación de la ruta valorada
 * comentario              Comentario del usuario sobre la ruta valorada
 * @author BelenBRC
 */
public class Valoracion {
    private String ID_valoracion;
    private Ruta ruta;
    private Usuario usuario;
    private Integer puntuacion;
    private String comentario;

    //Constructor
    /**
     * @brief   Constructor de un objeto de la clase Valoracion con parámetros
     * @param ruta          Ruta valorada
     * @param usuario       Usuario que realiza la valoración
     * @param puntuacion    Puntuación de la ruta valorada
     * @param comentario    Comentario del usuario sobre la ruta valorada
     * @post    El ID generado estará asignado en el atributo ID_valoracion
     */
    public Valoracion(Ruta ruta, Usuario usuario, Integer puntuacion, String comentario){
        setRuta(ruta);
        setUsuario(usuario);
        setPuntuacion(puntuacion);
        setComentario(comentario);
        asignarIDValoracion();
    }

    //Sets y gets
    /**
     * @brief   Método que establece el código identificador único de la valoración
     * @param id    Código identificador único de la valoración
     */
    private void setIDValoracion(String id){
        this.ID_valoracion = id;
    }

    /**
     * @brief   Método que establece la ruta valorada
     * @param ruta    Ruta valorada
     */
    private void setRuta(Ruta ruta){
        this.ruta = ruta;
    }

    /**
     * @brief   Método que establece el usuario que realiza la valoración
     * @param usuario    Usuario que realiza la valoración
     */
    private void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    /**
     * @brief   Método que establece la puntuación de la ruta valorada
     * @param puntuacion    Puntuación de la ruta valorada
     */
    public void setPuntuacion(Integer puntuacion){
        this.puntuacion = puntuacion;
    }

    /**
     * @brief   Método que establece el comentario del usuario sobre la ruta valorada
     * @param comentario    Comentario del usuario sobre la ruta valorada
     */
    public void setComentario(String comentario){
        this.comentario = comentario;
    }

    /**
     * @brief   Método que devuelve el código identificador único de la valoración
     * @return  ID_valoracion    (String)    Código identificador único de la valoración
     */
    public String getIDValoracion(){
        return this.ID_valoracion;
    }

    /**
     * @brief   Método que devuelve la ruta valorada
     * @return  ruta    (Ruta)    Ruta valorada
     */
    public Ruta getRuta(){
        return this.ruta;
    }

    /**
     * @brief   Método que devuelve el usuario que realiza la valoración
     * @return  usuario    (Usuario)    Usuario que realiza la valoración
     */
    public Usuario getUsuario(){
        return this.usuario;
    }

    /**
     * @brief   Método que devuelve la puntuación de la ruta valorada
     * @return  puntuacion    (Integer)    Puntuación de la ruta valorada
     */
    public Integer getPuntuacion(){
        return this.puntuacion;
    }

    /**
     * @brief   Método que devuelve el comentario del usuario sobre la ruta valorada
     * @return  comentario    (String)    Comentario del usuario sobre la ruta valorada
     */
    public String getComentario(){
        return this.comentario;
    }

    //Métodos propios internos
    /**
     * @brief   Método que asigna un código identificador único a la valoración
     * @pre     El ID de la ruta valorada y el ID del usuario que realiza la valoración deben estar asignados
     * @post    El ID generado estará asignado en el atributo ID_valoracion
     */
    private void asignarIDValoracion(){
        setIDValoracion(getRuta().getIdRuta() + getUsuario().getIDUsuario());
    }

    //Métodos públicos
    @Override
    /**
     * @brief   Método que permite imprimir la puntuación y el comentario de una valoración pasando un objeto de la clase Valoracion al método println() o print().
     * @return  (String)    Puntuación y comentario de la valoración
     */
    public String toString(){
        return "Puntuación: " + getPuntuacion().toString() + "\nComentario: " + getComentario();
    }
}