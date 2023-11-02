//Belén Robustillo Carmona

package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Categoria con atributos:
 * ID_categoria             Código identificador único para cada categoría
 * nombre_categoria         Nombre de la categoría
 * listaRutas               Lista de rutas que pertenecen a la categoría
 * @author belen
 */
public class Categoria implements Serializable{
    private String ID_categoria;
    private String nombre_categoria;
    private ArrayList<Ruta> listaRutas;

    //Constructor
    /**
     * @brief   Constructor de un objeto de la clase Categoria con parámetros, sin rutas asignadas
     * @param nombre    Nombre de la categoría
     * @post    El ID generado estará asignado en el atributo ID_categoria
     *          La lista de rutas estará vacía
     */
    public Categoria(String nombre){
        setNombreCategoria(nombre);
        asignarID();
        setListaRutas(new ArrayList<Ruta>());
    }

    /**
     * @brief   Constructor de un objeto de la clase Categoria con parámetros y con rutas asignadas
     * @param nombre    Nombre de la categoría
     * @param lista     Lista de rutas que pertenecen a la categoría
     * @post    El ID generado estará asignado en el atributo ID_categoria
     *          La lista de rutas estará inicializada con las rutas pasados por parámetro
     */
    public Categoria(String nombre, ArrayList<Ruta> lista){
        setNombreCategoria(nombre);
        asignarID();
        setListaRutas(lista);
    }

    //Sets y gets
    /**
     * @brief   Método que establece el código identificador único de la categoría
     * @param id    Código identificador único de la categoría
     */
    public void setIDCategoria(String id){
        this.ID_categoria = id;
    }

    /**
     * @brief   Método que establece el nombre de la categoría
     * @param nombre    Nombre de la categoría
     */
    public void setNombreCategoria(String nombre){
        this.nombre_categoria = nombre;
    }

    /**
     * @brief   Método que establece la lista de rutas que pertenecen a la categoría
     * @param lista     Lista de rutas que pertenecen a la categoría
     */
    public void setListaRutas(ArrayList<Ruta> lista){
        this.listaRutas = lista;
    }

    /**
     * @brief   Método que añade una ruta a la lista de rutas que pertenecen a la categoría
     * @param ruta     Ruta que pertenece a la categoría
     */
    public void setRutaEnLista(Ruta ruta){
        getListaRutas().add(ruta);
    }

    /**
     * @brief   Método que devuelve el código identificador único de la categoría
     * @return  ID_categoria    (String)    Código identificador único de la categoría
     */
    public String getIDCategoria(){
        return this.ID_categoria;
    }

    /**
     * @brief   Método que devuelve el nombre de la categoría
     * @return  nombre_categoria    (String)    Nombre de la categoría
     */
    public String getNombreCategoria(){
        return this.nombre_categoria;
    }

    /**
     * @brief   Método que devuelve la lista de rutas que pertenecen a la categoría
     * @return  listaRutas     (ArrayList<Ruta>)    Lista de rutas que pertenecen a la categoría
     */
    public ArrayList<Ruta> getListaRutas(){
        return this.listaRutas;
    }

    /**
     * @brief   Método que devuelve una ruta de la lista de rutas que pertenecen a la categoría
     * @param posicion  Posición de la ruta en la lista de rutas que pertenecen a la categoría
     * @return  ruta   (Ruta)   Ruta de la lista de rutas que pertenecen a la categoría
     */
    public Ruta getRutaEnLista(Integer posicion){
        return getListaRutas().get(posicion);
    }

    //Métodos propios internos
    /**
     * @brief   Método que asigna un código identificador único a la categoría
     * @pre     El nombre de la categoría debe estar asignado
     * @post    El ID generado estará asignado en el atributo ID_categoria
     */
    private void asignarID(){
        setIDCategoria("cat." + getNombreCategoria().replaceAll(" ", ""));
    }

    //Métodos públicos
    /**
     * @brief   Método que permite imprimir por pantalla el nombre de la categoría pasando un objeto de la clase Categoria
     *              al método println() o print().
     * @return  (String)    Nombre de la categoría
     */
    public String toString(){
        return getNombreCategoria();
    }
}