// Belén Robustillo Carmona

package Modelo;

import java.util.ArrayList;

/**
 * Clase Usuario con atributos:
 * ID_usuario               Código identificador único para cada usuario
 * nombre_usuario           Nombre propio del usuario, sin apellidos
 * apellido_1               Primer apellido del usuario
 * apellido_2               Segundo apellido del usuario
 * correo_electronico       Dirección del correo electrónico del usuario
 * contrasenia              Hash de la contraseña del usuario
 * DNI                      Documento Nacional de Identidad del usuario
 * fotoPerfil               Foto de perfil del usuario
 * listaValoraciones        Lista de valoraciones realizadas por el usuario
 * listaRutas               Lista de rutas creadas por el usuario
 * @author belen
 */
public class Usuario {
    private String ID_usuario;
    private String nombre_usuario;
    private String apellido_1;
    private String apellido_2;
    private String correo_electronico;
    private String contrasenia;
    private String DNI;
    private FotoPerfil fotoPerfil;
    private ArrayList<Valoracion> listaValoraciones;
    private ArrayList<Ruta> listaRutas;
    
    //Constructor
    /**
     * @brief    Constructor de un objeto de la clase Usuario con parámetros
     * @param nombre                    Nombre propio del usuario, sin apellidos
     * @param apellido1                 Primer apellido del usuario
     * @param apellido2                 Segundo apellido del usuario
     * @param correoElectronico         Dirección del correo electrónico del usuario
     * @param contrasenia               Hash de la contraseña del usuario
     * @param dni                       Números y letra del documento nacional de identidad
     * @post    El ID generado estará asignado en el atributo ID_usuario
     *          La lista de valoraciones estará vacía
     *          La lista de rutas estará vacía
     *          La foto de perfil estará vacía
     */
    public Usuario(String nombre, String apellido1, String apellido2, String correoElectronico, String contrasenia, String dni){
        setNombreUsuario(nombre);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setCorreoElectronico(correoElectronico);
        setContrasenia(contrasenia);
        setDNI(dni);
        asignarID();
        setFotoPerfil(null);
        setListaValoraciones(new ArrayList<Valoracion>());
        setListaRutas(new ArrayList<Ruta>());
    }

    /**
     * @brief    Constructor de un objeto de la clase Usuario con parámetros y lista de valoraciones
     * @param nombre                    Nombre propio del usuario, sin apellidos
     * @param apellido1                 Primer apellido del usuario
     * @param apellido2                 Segundo apellido del usuario
     * @param correoElectronico         Dirección del correo electrónico del usuario
     * @param contrasenia               Hash de la contraseña del usuario
     * @param dni                       Números y letra del documento nacional de identidad
     * @param listaValoraciones         Lista de valoraciones de rutas realizadas por el usuario
     * @post    El ID generado estará asignado en el atributo ID_usuario
     *          La lista de rutas estará vacía
     *          La foto de perfil estará vacía
     */
    public Usuario(String nombre, String apellido1, String apellido2, String correoElectronico, String contrasenia, String dni, ArrayList<Valoracion> listaValoraciones){
        setNombreUsuario(nombre);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setCorreoElectronico(correoElectronico);
        setContrasenia(contrasenia);
        setDNI(dni);
        asignarID();
        setFotoPerfil(null);
        setListaValoraciones(listaValoraciones);
        setListaRutas(new ArrayList<Ruta>());
    }

    /**
     * @brief    Constructor de un objeto de la clase Usuario con parámetros y lista de valoraciones y lista de rutas creadas
     * @param nombre                    Nombre propio del usuario, sin apellidos
     * @param apellido1                 Primer apellido del usuario
     * @param apellido2                 Segundo apellido del usuario
     * @param correoElectronico         Dirección del correo electrónico del usuario
     * @param contrasenia               Hash de la contraseña del usuario
     * @param dni                       Números y letra del documento nacional de identidad
     * @param listaValoraciones         Lista de valoraciones de rutas realizadas por el usuario
     * @param listaRutas         Lista de rutas creadas por el usuario
     * @post    El ID generado estará asignado en el atributo ID_usuario
     *          La foto de perfil estará vacía
     */
    public Usuario(String nombre, String apellido1, String apellido2, String correoElectronico, String contrasenia, String dni, ArrayList<Valoracion> listaValoraciones, ArrayList<Ruta> listaRutas){
        setNombreUsuario(nombre);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setCorreoElectronico(correoElectronico);
        setContrasenia(contrasenia);
        setDNI(dni);
        asignarID();
        setFotoPerfil(null);
        setListaValoraciones(listaValoraciones);
        setListaRutas(listaRutas);
    }
    
    //Sets y gets
    /**
     * @brief    Método que establece el código identificador único del usuario
     * @param id    Código identificador único del usuario
     */
    private void setIDUsuario(String id){
        this.ID_usuario = id;
    }
    
    /**
     * @brief    Método que establece el nombre del usuario, sin apellidos
     * @param nombre    Nombre propio del usuario, sin apellidos
     */
    private void setNombreUsuario(String nombre){
        this.nombre_usuario = nombre;
    }
    
    /**
     * @brief    Método que establece el primer apellido del usuario
     * @param apellido1     Primer apellido del usuario
     */
    public void setApellido1(String apellido1){
        this.apellido_1 = apellido1;
    }
    
    /**
     * @brief    Método que establece el segundo apellido del usuario
     * @param apellido2     Segundo apellido del usuario
     */
    public void setApellido2(String apellido2){
        this.apellido_2 = apellido2;
    }
    
    /**
     * @brief    Método que establece el correo electrónico del usuario
     * @param correo    Dirección del correo electrónico del usuario
     */
    public void setCorreoElectronico(String correo){
        this.correo_electronico = correo;
    }
    
    /**
     * @brief    Método que establece el Hash de la contraseña del usuario
     * @param contrasenia   Hash de la contraseña del usuario
     */
    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }
    
    /**
     * @brief    Método que establece los números y letra del Documento Nacional de Identidad del usuario
     * @param dni   Números y letra del Documento Nacional de Identidad del usuario
     */
    private void setDNI(String dni){
        this.DNI = dni;
    }

    /**
     * @brief    Método que establece la foto de perfil del usuario
     * @param fotoPerfil    Foto de perfil del usuario
     */
    public void setFotoPerfil(FotoPerfil fotoPerfil){
        this.fotoPerfil = fotoPerfil;
    }

    /**
     * @brief    Método que establece la lista de valoraciones realizadas por el usuario
     * @param listaValoraciones     Lista de valoraciones realizadas por el usuario
     */
    public void setListaValoraciones(ArrayList<Valoracion> listaValoraciones){
        this.listaValoraciones = listaValoraciones;
    }

    /**
     * @brief    Método que añade una valoración a la lista de valoraciones realizadas por el usuario
     * @param valoracion    Valoración realizada por el usuario
     * @post     La valoración se añade al final de la lista
     */
    public void setValoracionEnLista(Valoracion valoracion){
        getListaValoraciones().add(valoracion);
    }

    /**
     * @brief    Método que establece la lista de rutas creadas por el usuario
     * @param listaRutas    Lista de rutas creadas por el usuario
     */
    public void setListaRutas(ArrayList<Ruta> listaRutas){
        this.listaRutas = listaRutas;
    }

    /**
     * @brief    Método que añade una ruta a la lista de rutas creadas por el usuario
     * @param ruta    Ruta creada por el usuario
     * @post     La ruta se añade al final de la lista
     */
    public void setRutaEnLista(Ruta ruta){
        getListaRutas().add(ruta);
    }
    
    /**
     * @brief    Método que devuelve el código identificador único del usuario
     * @return   ID_usuario     (String)     Código identificador único del usuario
     */
    public String getIDUsuario(){
        return this.ID_usuario;
    }
    
    /**
     * @brief    Método que devuelve el nombre propio del usuario, sin apellidos
     * @return   Nombre_usuario     (String)     Nombre propio del usuario, sin apellidos
     */
    public String getNombreUsuario(){
        return this.nombre_usuario;
    }
    
    /**
     * @brief    Método que devuelve el primer apellido del usuario
     * @return   apellido_1     (String)     Primer apellido del usuario
     */
    public String getApellido1(){
        return this.apellido_1;
    }
    
    /**
     * @brief    Método que devuelve el segundo apellido del usuario
     * @return   apellido_2     (String)     Segundo apellido del usuario
     */
    public String getApellido2(){
        return this.apellido_2;
    }
    
    /**
     * @brief    Método que devuelve la dirección del correo electrónico del usuario
     * @return   correo_electronico     (String)     Dirección de correo electrónico del usuario
     */
    public String getCorreoElectronico(){
        return this.correo_electronico;
    }
    
    /**
     * @brief    Método que devuelve el Hash de la contraseña del usuario
     * @return   contrasenia     (String)     Hash de la contraseña del usuario
     */
    public String getContrasenia(){
        return this.contrasenia;
    }
    
    /**
     * @brief   Método que devuelve los números y letra del Documento Nacional de Identidad del usuario
     * @return  DNI     (String)     Números y letra del Documento Nacional de Identidad del usuario
     */
    public String getDNI(){
        return this.DNI;
    }

    /**
     * @brief   Método que devuelve la foto de perfil del usuario
     * @return  fotoPerfil  (FotoPerfil)    Foto de perfil del usuario
     */
    public FotoPerfil getFotoPerfil(){
        if(this.fotoPerfil != null)
            return this.fotoPerfil;
        else
            return null;
    }

    /**
     * @brief   Método que devuelve la lista de valoraciones realizadas por el usuario
     * @return  listaValoraciones   (ArrayList<Valoracion>)    Lista de valoraciones realizadas por el usuario
     */
    public ArrayList<Valoracion> getListaValoraciones(){
        return this.listaValoraciones;
    }

    /**
     * @brief   Método que devuelve una valoración de la lista de valoraciones realizadas por el usuario
     * @param posicion  Posición de la lista en la que se encuentra la valoración
     * @return  valoracion  (Valoracion)    Valoración realizada por el usuario
     */
    public Valoracion getValoracionEnListaPorPosicion(Integer posicion){
        return getListaValoraciones().get(posicion);
    }

    /**
     * @brief   Método que devuelve la lista de rutas creadas por el usuario
     * @return  listaRutas  (ArrayList<Ruta>)    Lista de rutas creadas por el usuario
     */
    public ArrayList<Ruta> getListaRutas(){
        return this.listaRutas;
    }

    /**
     * @brief   Método que devuelve una ruta de la lista de rutas creadas por el usuario
     * @param posicion  Posición de la lista en la que se encuentra la ruta
     * @return  ruta (Ruta)   Ruta creado por el usuario
     */
    public Ruta getRutaEnListaPorPosicion(Integer posicion){
        return getListaRutas().get(posicion);
    }
    
    //Métodos propios internos
    /**
     * @brief    Método que genera y asigna un ID a un usuario
     * @pre      Los atributos nombre y DNI no pueden estar vacíos 
     * @post     El ID generado estará asignado en el atributo ID_usuario
     */
    private void asignarID(){
        setIDUsuario(this.getNombreUsuario().charAt(0) + this.getDNI());
    }
    
    //Métodos públicos
    @Override
    /**
     * @brief   Método que permite imprimir el nombre y apellidos de un usuario pasando un objeto de la clase
     *                  Usuario al método System.out.print o println.
     * @return  (String)    Nombre y apellidos del usuario
     */
    public String toString(){
        String infoUsuario = getNombreUsuario() + " " + getApellido1() + " " + getApellido2();
        return infoUsuario;
    }
    
}
