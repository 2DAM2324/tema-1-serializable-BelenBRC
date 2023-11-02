//Belén Robustillo Carmona

package Modelo;

import java.util.ArrayList;

/**
 * Clase Ruta con atributos:
 * ID_ruta              Código identificador único para cada ruta
 * nombre_ruta          Nombre de la ruta
 * descripcion          Descripción de la ruta
 * distanciaKm          Distancia de la ruta en kilómetros
 * dificultad           Dificultad de la ruta
 * tiempoHoras          Tiempo estimado de la ruta en horas
 * puntuacionMedia      Puntuación media de la ruta en una escala de 0 a 5 estrellas
 * creadorRuta          Usuario que ha creado la ruta
 * listaValoraciones    Lista de valoraciones de la ruta realizadas por los usuarios registrados en la aplicación
 * listaCategorias      Lista de categorías a las que pertenece la ruta
 * @author belen
 */
public class Ruta {
    private String ID_ruta;
    private String nombre_ruta;
    private String descripcion;
    private double distanciaKm;
    private String dificultad;
    private double tiempoHoras;
    private double puntuacionMedia;
    private Usuario creadorRuta;
    private ArrayList<Valoracion> listaValoraciones;
    private ArrayList<Categoria> listaCategorias;
    
    //Constructores
    /**
     * @brief   Constructor de un objeto de la clase Ruta con parámetros
     * @param nombre                Nombre de la ruta
     * @param descripcion           Descripción de la ruta
     * @param distanciaKm           Distancia de la ruta en kilómetros
     * @param dificultad            Dificultad de la ruta
     * @param horas                 Tiempo estimado de la ruta en horas
     * @param creadorRuta           Usuario que ha creado la ruta
     * @post    El ID generado estará asignado en el atributo ID_ruta
     *          La lista de valoraciones estará vacía
     *          La lista de categorías estará vacía
     *          La puntuación media se establecerá a 0
     */
    public Ruta(String nombre, String descripcion, double distanciaKm, String dificultad, double horas, Usuario creadorRuta){
        setNombreRuta(nombre);
        setDescripcion(descripcion);
        setDistanciaKm(distanciaKm);
        setDificultad(dificultad);
        setTiempoHoras(horas);
        setPuntuacionMedia(0);
        setCreadorRuta(creadorRuta);
        asignarID();
        setListaValoraciones(new ArrayList<Valoracion>());
        setListaCategorias(new ArrayList<Categoria>());
    }

    /**
     * @brief   Constructor de un objeto de la clase Ruta con parámetros y lista de categorías
     * @param nombre                Nombre de la ruta
     * @param descripcion           Descripción de la ruta
     * @param distanciaKm           Distancia de la ruta en kilómetros
     * @param dificultad            Dificultad de la ruta
     * @param horas                 Tiempo estimado de la ruta en horas
     * @param creadorRuta           Usuario que ha creado la ruta
     * @param listaCategorias       Lista de categorías a las que pertenece la ruta
     * @post    El ID generado estará asignado en el atributo ID_ruta
     *          La lista de valoraciones estará vacía	
     *          La puntuación media se establecerá a 0
     */
    public Ruta(String nombre, String descripcion, double distanciaKm, String dificultad, double horas, Usuario creadorRuta, ArrayList<Categoria> listaCategorias){
        setNombreRuta(nombre);
        setDescripcion(descripcion);
        setDistanciaKm(distanciaKm);
        setDificultad(dificultad);
        setTiempoHoras(horas);
        setPuntuacionMedia(0);
        setCreadorRuta(creadorRuta);
        asignarID();
        setListaValoraciones(new ArrayList<Valoracion>());
        setListaCategorias(listaCategorias);
    }

    /**
     * @brief   Constructor de un objeto de la clase Ruta con parámetros, lista de valoraciones y lista de categorías
     * @param nombre                Nombre de la ruta
     * @param descripcion           Descripción de la ruta
     * @param distanciaKm           Distancia de la ruta en kilómetros
     * @param dificultad            Dificultad de la ruta
     * @param horas                 Tiempo estimado de la ruta en horas
     * @param creadorRuta           Usuario que ha creado la ruta
     * @param listaValoraciones     Lista de valoraciones de la ruta realizadas por los usuarios registrados en la aplicación
     * @param listaCategorias       Lista de categorías a las que pertenece la ruta
     * @post    El ID generado estará asignado en el atributo ID_ruta
     *          La puntuación media se establecerá a 0
     */
    public Ruta(String nombre, String descripcion, double distanciaKm, String dificultad, double horas, Usuario creadorRuta, ArrayList<Valoracion> listaValoraciones, ArrayList<Categoria> listaCategorias){
        setNombreRuta(nombre);
        setDescripcion(descripcion);
        setDistanciaKm(distanciaKm);
        setDificultad(dificultad);
        setTiempoHoras(horas);
        setPuntuacionMedia(0);
        setCreadorRuta(creadorRuta);
        asignarID();
        setListaValoraciones(listaValoraciones);
        setListaCategorias(listaCategorias);
    }
    
    //Sets y gets
    /**
     * @brief   Método que establece el código identificador único de la ruta
     * @param id    Código identificador único de la ruta
     */
    private void setIdRuta(String id){
        this.ID_ruta = id;
    }
    
    /**
     * @brief   Método que establece el nombre de la ruta
     * @param nombre    Nombre de la ruta
     */
    private void setNombreRuta(String nombre){
        this.nombre_ruta = nombre;
    }
    
    /**
     * @brief   Método que establece la descripción de la ruta
     * @param descripcion   Descripción de la ruta
     */
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    /**
     * @brief   Método que establece la distancia de la ruta en kilómetros
     * @param km    Distancia de la ruta en kilómetros
     */
    private void setDistanciaKm(Double km){
        this.distanciaKm = km;
    }
    
    /**
     * @brief   Método que establece la dificultad de la ruta
     * @param dificultad    Dificultad de la ruta
     */
    public void setDificultad(String dificultad){
        this.dificultad = dificultad;
    }
    
    /**
     * @brief   Método que establece el tiempo estimado de la ruta en horas
     * @param horas     Tiempo estimado de la ruta en horas
     */
    private void setTiempoHoras(double horas){
        this.tiempoHoras = horas;
    }
    
    /**
     * @brief   Método que establece la puntuación media de la ruta en una escala de 0 a 5 estrellas
     * @param puntuacionMedia   Puntuación media de la ruta en una escala de 0 a 5 estrellas
     */
    private void setPuntuacionMedia(double puntuacionMedia){
        this.puntuacionMedia = puntuacionMedia;
    }

    /**
     * @brief   Método que establece el usuario que ha creado la ruta
     * @param creadorRuta   Usuario que ha creado la ruta
     */
    public void setCreadorRuta(Usuario creadorRuta){
        this.creadorRuta = creadorRuta;
    }

    /**
     * @brief   Método que establece la lista de valoraciones de la ruta realizadas por los usuarios registrados en la aplicación
     * @param listaValoraciones     Lista de valoraciones de la ruta realizadas por los usuarios registrados en la aplicación
     * @post    Se calcula la puntuación media de la ruta
     */
    public void setListaValoraciones(ArrayList<Valoracion> listaValoraciones){
        this.listaValoraciones = listaValoraciones;
        calcularPuntuacionMedia();
    }

    /**
     * @brief   Método que añade una valoración a la lista de valoraciones de la ruta realizadas por los usuarios registrados en la aplicación
     * @param valoracion    Valoración de la ruta realizada por un usuario registrado en la aplicación
     * @post    La valoración se añade al final de la lista
     *          Se calcula la puntuación media de la ruta
     */
    public void setValoracionEnLista(Valoracion valoracion){
        getListaValoraciones().add(valoracion);
        //Actualizar la puntuación media de la ruta
        calcularPuntuacionMedia();
    }

    /**
     * @brief   Método que establece la lista de categorías a las que pertenece la ruta
     * @param listaCategorias   Lista de categorías a las que pertenece la ruta
     */
    public void setListaCategorias(ArrayList<Categoria> listaCategorias){
        this.listaCategorias = listaCategorias;
    }

    /**
     * @brief   Método que añade una categoría a la lista de categorías a las que pertenece la ruta
     * @param categoria     Categoría a la que pertenece la ruta
     * @post    La categoría se añade al final de la lista
     */
    public void setCategoriaEnLista(Categoria categoria){
        getListaCategorias().add(categoria);
    }

    /**
     * @brief   Método que devuelve el código identificador único de la ruta
     * @return  ID_ruta     (String)    Código identificador único de la ruta
     */
    public String getIdRuta(){
        return this.ID_ruta;
    }
    
    /**
     * @brief   Método que devuelve el nombre de la ruta
     * @return  nombre_ruta     (String)    Nombre de la ruta
     */
    public String getNombreRuta(){
        return this.nombre_ruta;
    }
    
    /**
     * @brief   Método que devuelve la descripción de la ruta
     * @return  descripcion     (String)    Descripción de la ruta
     */
    public String getDescripcion(){
        return this.descripcion;
    }
    
    /**
     * @brief   Método que devuelve la distancia de la ruta en kilómetros
     * @return  distanciaKm     (Double)    Distancia de la ruta en kilómetros
     */
    public double getDistanciaKm(){
        return this.distanciaKm;
    }
    
    /**
     * @brief   Método que devuelve la dificultad de la ruta
     * @return  dificultad      (String)    Dificultad de la ruta
     */
    public String getDificultad(){
        return this.dificultad;
    }
    
    /**
     * @brief   Método que devuelve el tiempo estimado de la ruta en horas
     * @return  tiempoHoras     (Double)    Tiempo estimado de la ruta en horas
     */
    public double getTiempoHoras(){
        return this.tiempoHoras;
    }
    
    /**
     * @brief   Método que devuelve la puntuación media de la ruta en una escala de 0 a 5 estrellas
     * @return  puntuacionMedia     (Double)    Puntuación media de la ruta en una escala de 0 a 5 estrellas
     */
    public double getPuntuacionMedia(){
        return this.puntuacionMedia;
    }

    /**
     * @brief   Método que devuelve el usuario creador de la ruta
     * @return  creadorRuta     (Usuario)    Usuario que ha creado la ruta
     */
    public Usuario getCreadorRuta(){
        return this.creadorRuta;
    }

    /**
     * @brief   Método que devuelve la lista de valoraciones de la ruta realizadas por los usuarios registrados en la aplicación
     * @return  listaValoraciones   (ArrayList<Valoracion>)     Lista de valoraciones de la ruta realizadas por los usuarios registrados en la aplicación
     */
    public ArrayList<Valoracion> getListaValoraciones(){
        return this.listaValoraciones;
    }

    /**
     * @brief   Método que devuelve una valoración de la lista de valoraciones de la ruta realizadas por los usuarios registrados en la aplicación
     * @param posicion  Posición de la lista en la que se encuentra la valoración
     * @return  valoracion   (Valoracion)    Valoración de la ruta realizada por un usuario registrado en la aplicación
     */
    public Valoracion getValoracionEnListaPorPosicion(Integer posicion){
        return this.listaValoraciones.get(posicion);
    }

    /**
     * @brief   Método que devuelve la lista de categorías a las que pertenece la ruta
     * @return  listaCategorias     (ArrayList<Categoria>)    Lista de categorías a las que pertenece la ruta
     */
    public ArrayList<Categoria> getListaCategorias(){
        return this.listaCategorias;
    }

    /**
     * @brief   Método que devuelve una categoría de la lista de categorías a las que pertenece la ruta
     * @param posicion  Posición de la lista en la que se encuentra la categoría
     * @return  categoria   (Categoria)    Categoría a la que pertenece la ruta
     */
    public Categoria getCategoriaEnListaPorPosicion(Integer posicion){
        return this.listaCategorias.get(posicion);
    }
    
    //Métodos propios internos
    /**
     * @brief   Método que asigna el código identificador único de la ruta
     * @pre     El nombre de la ruta y el creador no pueden estar vacíos
     * @post    El ID generado estará asignado en el atributo ID_ruta
     */
    private void asignarID(){
        String id = getNombreRuta().replaceAll(" ", "") + getCreadorRuta().getIDUsuario();
        setIdRuta(id);
    }

    /**
     * @brief   Método que calcula la puntuación media de la ruta en una escala de 0 a 5 estrellas
     * @pre     La lista de valoraciones no puede estar vacía
     * @post    La puntuación media de la ruta se establece en el atributo puntuacionMedia
     */
    public void calcularPuntuacionMedia(){
        double sumaPuntuaciones = 0, puntuacionMedia = 0;
        for(int i = 0; i < getListaValoraciones().size(); i++){
            sumaPuntuaciones = sumaPuntuaciones + getValoracionEnListaPorPosicion(i).getPuntuacion();
        }
        puntuacionMedia = sumaPuntuaciones/getListaValoraciones().size();
        setPuntuacionMedia(puntuacionMedia);
    }

    //Métodos públicos
    @Override
    /**
     * @brief   Método que permite imprimir el nombre, la descripción, la distancia, la dificultad, el tiempo y la puntuación de una ruta pasando un objeto de la clase
     *              Ruta al método System.out.print o printline.
     * @return  (String)    Información de la ruta
     */
    public String toString(){
        String infoRuta = getNombreRuta() + " - By: " + getCreadorRuta().getDNI();
        
        return infoRuta;
    }
}
