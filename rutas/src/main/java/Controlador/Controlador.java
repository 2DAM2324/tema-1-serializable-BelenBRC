// Belén Robustillo Carmona

package Controlador;

import Modelo.Categoria;
import Modelo.FotoPerfil;
import Modelo.Ruta;
import Modelo.Usuario;
import Modelo.Valoracion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

/**
 * Clase Controlador con atributos:
 * listaCategoriasSistema      Lista de categorías del sistema
 * listaUsuariosSistema        Lista de usuarios del sistema
 * listaFotosPerfilSistema     Lista de fotos de perfil del sistema
 * listaRutasSistema           Lista de rutas del sistema
 * listaValoracionesSistema    Lista de valoraciones del sistema
 * @author belen
 */
public class Controlador {
    private static Controlador      instancia = null;
    private ArrayList<Categoria>    listaCategoriasSistema;
    private ArrayList<Usuario>      listaUsuariosSistema;
    private ArrayList<FotoPerfil>   listaFotosPerfilSistema;
    private ArrayList<Ruta>         listaRutasSistema;
    private ArrayList<Valoracion>   listaValoracionesSistema;
    
    //Constructor
    /**
     * @brief   Constructor de un objeto de la clase Controlador
     * @post    Las listas de categorías, usuarios, fotos de perfil, rutas y valoraciones estarán vacías
     */
    public Controlador(){
        listaCategoriasSistema      = new ArrayList<>();
        listaUsuariosSistema        = new ArrayList<>();
        listaFotosPerfilSistema     = new ArrayList<>();
        listaRutasSistema           = new ArrayList<>();
        listaValoracionesSistema    = new ArrayList<>();
    }

    //Sets y gets

    /**
     * @brief   Método que establece la lista de categorías del sistema
     * @param listaCategoriasSistema    Lista de categorías del sistema
     */
    public void setListaCategoriasSistema(ArrayList<Categoria> listaCategoriasSistema) {
        this.listaCategoriasSistema = listaCategoriasSistema;
    }

    /**
     * @brief   Método que añade una categoría a la lista de categorías del sistema
     * @param categoria    Categoría a añadir a la lista de categorías del sistema
     * @post    La categoría se ha añadido al final de la lista de categorías del sistema
     */
    public void setCategoriaEnLista(Categoria categoria) {
        this.listaCategoriasSistema.add(categoria);
    }

    /**
     * @brief   Método que establece la lista de usuarios del sistema
     * @param listaUsuariosSistema  Lista de usuarios del sistema
     */
    public void setListaUsuariosSistema(ArrayList<Usuario> listaUsuariosSistema) {
        this.listaUsuariosSistema = listaUsuariosSistema;
    }

    /**
     * @brief   Método que añade un usuario a la lista de usuarios del sistema
     * @param usuario   Usuario a añadir a la lista de usuarios del sistema
     * @post    El usuario se ha añadido al final de la lista de usuarios del sistema
     */
    public void setUsuarioEnLista(Usuario usuario) {
        this.listaUsuariosSistema.add(usuario);
    }

    /**
     * @brief   Método que establece la lista de fotos de perfil del sistema
     * @param listaFotosPerfilSistema   Lista de fotos de perfil del sistema
     */
    public void setListaFotosPerfilSistema(ArrayList<FotoPerfil> listaFotosPerfilSistema) {
        this.listaFotosPerfilSistema = listaFotosPerfilSistema;
    }

    /**
     * @brief   Método que añade una foto de perfil a la lista de fotos de perfil del sistema
     * @param fotoPerfil    Foto de perfil a añadir a la lista de fotos de perfil del sistema
     * @post    La foto de perfil se ha añadido al final de la lista de fotos de perfil del sistema
     */
    public void setFotoPerfilEnLista(FotoPerfil fotoPerfil) {
        this.listaFotosPerfilSistema.add(fotoPerfil);
    } 

    /**
     * @brief   Método que establece la lista de rutas del sistema
     * @param listaRutasSistema Lista de rutas del sistema
     */
    public void setListaRutasSistema(ArrayList<Ruta> listaRutasSistema) {
        this.listaRutasSistema = listaRutasSistema;
    }

    /**
     * @brief   Método que añade una ruta a la lista de rutas del sistema
     * @param ruta  Ruta a añadir a la lista de rutas del sistema
     * @post    La ruta se ha añadido al final de la lista de rutas del sistema
     */
    public void setRutaEnLista(Ruta ruta) {
        this.listaRutasSistema.add(ruta);
    }

    /**
     * @brief   Método que establece la lista de valoraciones del sistema
     * @param listaValoracionesSistema  Lista de valoraciones del sistema
     */
    public void setListaValoracionesSistema(ArrayList<Valoracion> listaValoracionesSistema) {
        this.listaValoracionesSistema = listaValoracionesSistema;
    }

    /**
     * @brief   Método que añade una valoración a la lista de valoraciones del sistema
     * @param valoracion    Valoración a añadir a la lista de valoraciones del sistema
     * @post    La valoración se ha añadido al final de la lista de valoraciones del sistema
     */
    public void setValoracionEnLista(Valoracion valoracion) {
        this.listaValoracionesSistema.add(valoracion);
    }

    /**
     * @brief   Método que devuelve la lista de categorías del sistema
     * @return  Lista de categorías del sistema
     */
    public ArrayList<Categoria> getListaCategoriasSistema() {
        return listaCategoriasSistema;
    }

    /**
     * @brief   Método que devuelve la lista de rutas de una categoría del sistema
     * @param IDcategoria   ID de la categoría de la que se quiere obtener la lista de rutas
     * @return  Lista de rutas de la categoría indicada
     */
    public ArrayList<Ruta> getListaRutasCategoria(String IDcategoria){
        ArrayList<Ruta> listaRutasCategoria = new ArrayList<>();

        for(int i=0; i < listaCategoriasSistema.size(); i++){
            if(listaCategoriasSistema.get(i).getIDCategoria().equals(IDcategoria)){
                listaRutasCategoria = listaCategoriasSistema.get(i).getListaRutas();
            }
        }

        return listaRutasCategoria;
    }

    /**
     * @brief   Método que devuelve la lista de usuarios del sistema
     * @return  Lista de usuarios del sistema
     */
    public ArrayList<Usuario> getListaUsuariosSistema() {
        return listaUsuariosSistema;
    }

    public String getIdUsuarioSistema(String dni){
        String IDusuario = "";

        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dni)){
                IDusuario = listaUsuariosSistema.get(i).getIDUsuario();
            }
        }

        return IDusuario;
    }

    /**
     * @brief   Método que devuelve la lista de fotos de perfil del sistema
     * @return  Lista de fotos de perfil del sistema
     */
    public ArrayList<FotoPerfil> getListaFotosPerfilSistema() {
        return listaFotosPerfilSistema;
    }

    /**
     * @brief   Método que devuelve la lista de rutas del sistema
     * @return  Lista de rutas del sistema
     */
    public ArrayList<Ruta> getListaRutasSistema() {
        return listaRutasSistema;
    }

    /**
     * @brief   Método que devuelve el ID de la ruta del sistema
     * @param nombreRuta        Nombre de la ruta de la que se quiere obtener el ID
     * @param IDcreadorRuta     ID del creador de la ruta de la que se quiere obtener el ID
     * @return
     */
    public String getIDrutaSistema(String nombreRuta, String IDcreadorRuta){
        String IDruta = "";

        for(int i=0; i < listaRutasSistema.size(); i++){
            if(listaRutasSistema.get(i).getNombreRuta().equals(nombreRuta) && listaRutasSistema.get(i).getCreadorRuta().getIDUsuario().equals(IDcreadorRuta)){
                IDruta = listaRutasSistema.get(i).getIdRuta();
            }
        }

        return IDruta;
    }

    /**
     * @brief   Método que devuelve la lista de valoraciones del sistema
     * @return  Lista de valoraciones del sistema
     */
    public ArrayList<Valoracion> getListaValoracionesSistema() {
        return listaValoracionesSistema;
    }

    //Métodos
    /**
     * @brief   Método que crea una instancia de la clase Controlador si no existe previamente
     * @return  Instancia de la clase Controlador
     */
    public static Controlador newInstance() {
        if (instancia == null) {
            instancia = new Controlador();
        }
        return instancia;
    }

    /**
     * @brief   Método que comprueba si el formato del DNI es correcto, es decir: tiene 8 números y una letra
     * @param dni   DNI a comprobar
     * @return      True si el formato del DNI es correcto, false en caso contrario
     */
    public boolean comprobarFormatoDNICorrecto(String dni){
        boolean formatoCorrecto = false;
        
        if(dni.length() == 9){
            if(Character.isLetter(dni.charAt(8))){
                if(Character.isDigit(dni.charAt(0)) && Character.isDigit(dni.charAt(1)) && Character.isDigit(dni.charAt(2)) && Character.isDigit(dni.charAt(3)) && Character.isDigit(dni.charAt(4)) && Character.isDigit(dni.charAt(5)) && Character.isDigit(dni.charAt(6)) && Character.isDigit(dni.charAt(7))){
                    formatoCorrecto = true;
                }
            }
        }
        return formatoCorrecto;
    }

    /**
     * @brief   Método que añade una categoría a la lista de categorías del sistema siempre que no exista ya
     * @param nombreCategoria   Nombre de la categoría a añadir a la lista de categorías del sistema
     * @post    Se actualiza el XML
     */
    public void aniadirCategoria(String nombreCategoria){
        boolean existeCategoria = false;
        Categoria categoria = new Categoria(nombreCategoria);

        for(int i=0; i < listaCategoriasSistema.size(); i++){
            if(listaCategoriasSistema.get(i).getIDCategoria().equals(categoria.getIDCategoria())){
                existeCategoria = true;
            }
        }
        
        if(!existeCategoria){
            listaCategoriasSistema.add(categoria);
            escribirXMLCategoria(listaCategoriasSistema);
        }
    }
    
    /**
     * @brief   Método que borra una categoría de la lista de categorías del sistema
     * @param IDcategoriaEliminada  ID de la categoría a eliminar de la lista de categorías del sistema
     * @post    La categoría con el ID indicado se ha eliminado de la lista de categorías del sistema
     * @post    El fichero XML contiene la lista de categorías del sistema actualizada
     * @post    Las rutas que contenían la categoría eliminada ya no la contienen
     *          El fchero XML de rutas contiene la lista de rutas del sistema actualizada
     */
    public void borrarCategoria(String IDcategoriaEliminada){
        for(int i=0; i < listaCategoriasSistema.size(); i++){
            if(listaCategoriasSistema.get(i).getIDCategoria().equals(IDcategoriaEliminada)){
                //Borrar la categoría de las rutas que la contengan
                for(Ruta rutaSistema : listaRutasSistema){
                    for(Categoria cat : rutaSistema.getListaCategorias()){
                        if(cat.getIDCategoria().equals(IDcategoriaEliminada)){
                            //Sobreescribir el array de categorías sin incluir la actual                                                        
                            ArrayList<Categoria> listaCategoriasAux = new ArrayList<>();
                            for(Categoria catAux : rutaSistema.getListaCategorias()){
                                if(!catAux.getIDCategoria().equals(IDcategoriaEliminada)){
                                    listaCategoriasAux.add(catAux);
                                }
                            }
                            rutaSistema.setListaCategorias(listaCategoriasAux);
                        }
                    }
                }

                //Borrar la categoría de la lista de categorías del sistema
                listaCategoriasSistema.remove(i);
            }
        }
        escribirXMLCategoria(listaCategoriasSistema);
        escribirXMLRutas(listaRutasSistema);
    }    

    /**
     * @brief   Método que añade un usuario a la lista de usuarios del sistema siempre que no exista ya
     * @param DNI           DNI del usuario a añadir a la lista de usuarios del sistema
     * @param nombre        Nombre del usuario a añadir a la lista de usuarios del sistema
     * @param apellido1     Primer apellido del usuario a añadir a la lista de usuarios del sistema
     * @param apellido2     Segundo apellido del usuario a añadir a la lista de usuarios del sistema
     * @param correo        Correo electrónico del usuario a añadir a la lista de usuarios del sistema
     * @param contrasenia   Contraseña del usuario a añadir a la lista de usuarios del sistema
     * @post    Se actualiza el XML
     */
    public void aniadirUsuario(String DNI, String nombre, String apellido1, String apellido2, String correo, String contrasenia){
        boolean existeUsuario = false;
        Usuario usuario = new Usuario(nombre, apellido1, apellido2, correo, contrasenia, DNI);

        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getIDUsuario().equals(usuario.getIDUsuario())){
                existeUsuario = true;
            }
        }

        if(!existeUsuario){
            listaUsuariosSistema.add(usuario);
            escribirXMLUsuario(listaUsuariosSistema);
        }
    }

    /**
     * @brief   Método que modifica los datos de un usuario de la lista de usuarios del sistema
     * @param DNI           DNI del usuario a modificar
     * @param apellido1     Primer apellido del usuario a modificar
     * @param apellido2     Segundo apellido del usuario a modificar
     * @param correo        Correo electrónico del usuario a modificar
     * @param contrasenia   Contraseña del usuario a modificar
     * @post    El usuario con el DNI indicado tiene los datos modificados
     * @post    El fichero XML contiene la lista de usuarios del sistema actualizada
     */
    public void modificarUsuario(String DNI, String apellido1, String apellido2, String correo, String contrasenia){
        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(DNI)){
                listaUsuariosSistema.get(i).setApellido1 (apellido1);
                listaUsuariosSistema.get(i).setApellido2(apellido2);
                listaUsuariosSistema.get(i).setCorreoElectronico(correo);
                if(contrasenia.equals("********")){
                    //No se ha modificado, no hacer nada
                }
                else{
                    listaUsuariosSistema.get(i).setContrasenia(contrasenia);
                }
            }
        }
        escribirXMLUsuario(listaUsuariosSistema);
    }

    /**
     * @brief   Método que borra un usuario de la lista de usuarios del sistema
     * @param dni   DNI del usuario a borrar de la lista de usuarios del sistema
     * @post    El usuario con el DNI indicado se ha eliminado de la lista de usuarios del sistema
     * @post    Se han borrado las valoraciones del usuario
     * @post    Se han borrado las rutas del usuario
     * @post    Se ha borrado la foto de perfil del usuario
     * @post    Se modifican todas las listas del sistema afectadas
     * @post    Se actualizan todos los ficheros XML afectados
     */
    public void borrarUsuario(String dni){
        //Borrar la foto de perfil del usuario
        for(int i=0; i < listaFotosPerfilSistema.size(); i++){
            if(listaFotosPerfilSistema.get(i).getUsuario().getDNI().equals(dni)){
                listaFotosPerfilSistema.remove(i);
            }
        }

        //Borrar las valoraciones del usuario
        for(int i=0; i < listaValoracionesSistema.size(); i++){
            if(listaValoracionesSistema.get(i).getUsuario().getDNI().equals(dni)){
                listaValoracionesSistema.remove(i);
                i--;
            }
        }

        //Borrar las rutas del usuario
        for(int i=0; i < listaRutasSistema.size(); i++){
            if(listaRutasSistema.get(i).getCreadorRuta().getDNI().equals(dni)){
                
                //Borrar esa ruta de las listas de ruta de las categorías
                for(int j=0; j < listaCategoriasSistema.size(); j++){
                    for(int k=0; k < listaCategoriasSistema.get(j).getListaRutas().size(); k++){
                        if(listaCategoriasSistema.get(j).getListaRutas().get(k).getIdRuta().equals(listaRutasSistema.get(i).getIdRuta())){
                            listaCategoriasSistema.get(j).getListaRutas().remove(k);
                        }
                    }
                }
                //Borrar las valoraciones de esa ruta
                for(int j=0; j < listaValoracionesSistema.size(); j++){
                    if(listaValoracionesSistema.get(j).getRuta().getIdRuta().equals(listaRutasSistema.get(i).getIdRuta())){
                        listaValoracionesSistema.remove(j);
                        j--;
                        //Borrar esa valoración de la lista de valoraciones de los usuarios
                        for(int k=0; k < listaUsuariosSistema.size(); k++){
                            for(int l=0; l < listaUsuariosSistema.get(k).getListaValoraciones().size(); l++){
                                if(listaUsuariosSistema.get(k).getListaValoraciones().get(l).getIDValoracion().equals(listaValoracionesSistema.get(j).getIDValoracion())){
                                    listaUsuariosSistema.get(k).getListaValoraciones().remove(l);
                                    l--;
                                }
                            }
                        }
                    }
                }

                //Borrar esa ruta de la lista de rutas del sistema
                listaRutasSistema.remove(i);
                i--;
            }
        }

        //Borrar el usuario
        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dni)){
                listaUsuariosSistema.remove(i);
            }
        }
        escribirXMLUsuario(listaUsuariosSistema);
        escribirXMLCategoria(listaCategoriasSistema);
        escribirXMLRutas(listaRutasSistema);
        escribirXMLValoracion(listaValoracionesSistema);
        escribirXMLFotoPerfil(listaFotosPerfilSistema);
    }

    /**
     * @brief   Método que borra una ruta de la lista de rutas del sistema
     * @param nombreRutaEliminada       Nombre de la ruta a borrar de la lista de rutas del sistema
     * @param dniCreadorRutaEliminada   DNI del creador de la ruta a borrar de la lista de rutas del sistema
     * @post    La ruta con el nombre y el dni del creador indicados se ha eliminado de la lista de rutas del sistema
     * @post    Se modifican todas las listas del sistema afectadas
     * @post    Se actualizan todos los ficheros XML afectados
     */
    public void borrarRuta(String nombreRutaEliminada, String dniCreadorRutaEliminada){
        String IDrutaEliminada = "";
        for(int i=0; i < listaRutasSistema.size(); i++){
            if(listaRutasSistema.get(i).getNombreRuta().equals(nombreRutaEliminada) && listaRutasSistema.get(i).getCreadorRuta().getDNI().equals(dniCreadorRutaEliminada)){
                
                IDrutaEliminada = listaRutasSistema.get(i).getIdRuta();

                //Borrar esa ruta de las listas de ruta de las categorías
                for(Categoria cat : listaCategoriasSistema){
                    for(int j=0; j < cat.getListaRutas().size(); j++){
                        if(cat.getListaRutas().get(j).getIdRuta().equals(listaRutasSistema.get(i).getIdRuta())){
                            //Sobreescribir el array de rutas de la categoría ignorando esta ruta
                            ArrayList<Ruta> listaRutasAux = new ArrayList<>();
                            for(int k=0; k < cat.getListaRutas().size(); k++){
                                if(!cat.getListaRutas().get(k).getIdRuta().equals(listaRutasSistema.get(i).getIdRuta())){
                                    listaRutasAux.add(cat.getListaRutas().get(k));
                                }
                            }
                            cat.setListaRutas(listaRutasAux);
                        }
                    }
                }

                //Borrar las valoraciones de esa ruta
                for(Valoracion val : listaValoracionesSistema){
                    if(val.getRuta().getIdRuta().equals(listaRutasSistema.get(i).getIdRuta())){
                        //Borrar esa valoración de la lista de valoraciones de los usuarios
                        for(Usuario usu : listaUsuariosSistema){
                            for(int j=0; j < usu.getListaValoraciones().size(); j++){
                                if(usu.getListaValoraciones().get(j).getIDValoracion().equals(val.getIDValoracion())){
                                    //Sobreescribir el array de valoraciones del usuario ignorando esta valoración
                                    ArrayList<Valoracion> listaValoracionesAux = new ArrayList<>();
                                    for(int k=0; k < usu.getListaValoraciones().size(); k++){
                                        if(!usu.getListaValoraciones().get(k).getIDValoracion().equals(val.getIDValoracion())){
                                            listaValoracionesAux.add(usu.getListaValoraciones().get(k));
                                        }
                                    }
                                    usu.setListaValoraciones(listaValoracionesAux);
                                }
                            }
                        }
                        //Sobreescribir la lista de valoraciones del sistema ingnorando esta valoración
                        ArrayList<Valoracion> listaValoracionesAux = new ArrayList<>();
                        for(int j=0; j < listaValoracionesSistema.size(); j++){
                            if(!listaValoracionesSistema.get(j).getIDValoracion().equals(val.getIDValoracion())){
                                listaValoracionesAux.add(listaValoracionesSistema.get(j));
                            }
                        }
                        listaValoracionesSistema = listaValoracionesAux;
                    }
                }

                //Borrar la ruta del array de rutas de su creador
                for(Usuario creador : listaUsuariosSistema){
                    for(Ruta rutaCreada : creador.getListaRutas()){
                        if(rutaCreada.getIdRuta().equals(IDrutaEliminada)){
                            //Sobreescribir el array de rutas del usuario ignorando esta ruta
                            ArrayList<Ruta> listaRutasAux = new ArrayList<>();
                            for(int j=0; j < creador.getListaRutas().size(); j++){
                                if(!creador.getListaRutas().get(j).getIdRuta().equals(IDrutaEliminada)){
                                    listaRutasAux.add(creador.getListaRutas().get(j));
                                }
                            }
                            creador.setListaRutas(listaRutasAux);
                        }
                    }
                }
                //Borrar la ruta
                listaRutasSistema.remove(i);
            }
        }
        escribirXMLRutas(listaRutasSistema);
        escribirXMLCategoria(listaCategoriasSistema);
        escribirXMLUsuario(listaUsuariosSistema);
        escribirXMLValoracion(listaValoracionesSistema);
    }

    /**
     * @brief   Método que modifica los datos de una ruta de la lista de rutas del sistema
     * @param nombreRuta    Nombre de la ruta a modificar
     * @param descripcion   Descripción de la ruta a modificar
     * @param dificultad    Dificultad de la ruta a modificar
     * @param dniCreador    DNI del creador de la ruta a modificar
     * @post    La ruta con el nombre y el dni del creador indicados tiene los datos modificados
     * @post    El fichero XML contiene la lista de rutas del sistema actualizada
     */
    public void modificarRuta(String nombreRuta, String descripcion, String dificultad, String dniCreador){
        //Buscar ID del usuario creador de la ruta
        String IDcreadorRuta = "";
        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dniCreador)){
                IDcreadorRuta = listaUsuariosSistema.get(i).getIDUsuario();
            }
        }
        //Buscar la ruta en la lista de rutas del sistema por el nombre y el id del creador
        for(int i=0; i < listaRutasSistema.size(); i++){
            if(listaRutasSistema.get(i).getNombreRuta().equals(nombreRuta) && listaRutasSistema.get(i).getCreadorRuta().getIDUsuario().equals(IDcreadorRuta)){
                listaRutasSistema.get(i).setDescripcion(descripcion);
                listaRutasSistema.get(i).setDificultad(dificultad);
            }
        }
        escribirXMLRutas(listaRutasSistema);
    }

    /**
     * @brief   Método que añade una valoración a la lista de valoraciones del sistema siempre que no exista ya
     * @param ruta          Ruta a la que se le añade la valoración
     * @param dniUsuario    DNI del usuario que realiza la valoración
     * @param puntuacion    Puntuación de la valoración
     * @param comentario    Comentario de la valoración
     * @post    Se actualiza el XML
     * @post    Se actualiza la puntuación media de la ruta
     */
    public void aniadirValoracion(Ruta ruta, String dniUsuario, Integer puntuacion, String comentario){
        boolean existeValoracion = false;
        //Buscar usuario con dni
        Usuario usuario = null;
        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dniUsuario)){
                usuario = listaUsuariosSistema.get(i);
            }
        }

        Valoracion valoracion = new Valoracion(ruta, usuario, puntuacion, comentario);

        for(int i=0; i < listaValoracionesSistema.size(); i++){
            if(listaValoracionesSistema.get(i).getIDValoracion().equals(valoracion.getIDValoracion())){
                existeValoracion = true;
            }
        }

        if(!existeValoracion){
            listaValoracionesSistema.add(valoracion);
            usuario.getListaValoraciones().add(valoracion);
            ruta.getListaValoraciones().add(valoracion);
            escribirXMLValoracion(listaValoracionesSistema);
            escribirXMLUsuario(listaUsuariosSistema);
            escribirXMLRutas(listaRutasSistema);
        }
    }
    
    /**
     * @brief   Método que borra una valoración de la lista de valoraciones del sistema
     * @param nombreRuta    Nombre de la ruta a la que se le borra la valoración
     * @param usuario       DNI del usuario que realiza la valoración
     * @post    La valoración con el nombre de la ruta y el dni del usuario indicados se ha eliminado de la lista de valoraciones del sistema
     * @post    El fichero XML contiene la lista de valoraciones del sistema actualizada
     */
    public void borrarValoracion(String nombreRuta, String usuario){
        String IDvaloracionEliminada = "";
        //Buscar la valoración en el sistema
        for(int i=0; i < listaValoracionesSistema.size(); i++){
            if(listaValoracionesSistema.get(i).getRuta().getNombreRuta().equals(nombreRuta) && listaValoracionesSistema.get(i).getUsuario().getDNI().equals(usuario)){
                IDvaloracionEliminada = listaValoracionesSistema.get(i).getIDValoracion();
                //Eliminar la valoración de la lista de valoraciones del usuario
                for(Usuario usu : listaUsuariosSistema){
                    for(Valoracion val : usu.getListaValoraciones()){
                        if(val.getIDValoracion().equals(IDvaloracionEliminada)){
                            //Sobreescribir el array de valoraciones del usuario ignorando esta valoración
                            ArrayList<Valoracion> listaValoracionesAux = new ArrayList<>();
                            for(int j=0; j < usu.getListaValoraciones().size(); j++){
                                if(!usu.getListaValoraciones().get(j).getIDValoracion().equals(IDvaloracionEliminada)){
                                    listaValoracionesAux.add(usu.getListaValoraciones().get(j));
                                }
                            }
                            usu.setListaValoraciones(listaValoracionesAux);
                        }
                    }
                }

                //Eliminar la valoración de la lista de valoraciones de la ruta
                for(Ruta ruta : listaRutasSistema){
                    for(Valoracion val : ruta.getListaValoraciones()){
                        if(val.getIDValoracion().equals(IDvaloracionEliminada)){
                            //Sobreescribir el array de valoraciones de la ruta ignorando esta valoración
                            ArrayList<Valoracion> listaValoracionesAux = new ArrayList<>();
                            for(int j=0; j < ruta.getListaValoraciones().size(); j++){
                                if(!ruta.getListaValoraciones().get(j).getIDValoracion().equals(IDvaloracionEliminada)){
                                    listaValoracionesAux.add(ruta.getListaValoraciones().get(j));
                                }
                            }
                            ruta.setListaValoraciones(listaValoracionesAux);
                        }
                    }
                }

                //Eliminar la valoración de la lista de valoraciones del sistema
                listaValoracionesSistema.remove(i);
            }
        }
        escribirXMLValoracion(listaValoracionesSistema);
        escribirXMLRutas(listaRutasSistema);
        escribirXMLUsuario(listaUsuariosSistema);
    }

    /**
     * @brief   Método que modifica los datos de una valoración de la lista de valoraciones del sistema
     * @param rutaValorada      Ruta a la que se le modifica la valoración
     * @param dniUsuario        DNI del usuario que realiza la valoración
     * @param puntuacion        Puntuación de la valoración
     * @param comentario        Comentario de la valoración
     * @post    La valoración con el nombre de la ruta y el dni del usuario indicados tiene los datos modificados
     * @post    El fichero XML contiene la lista de valoraciones del sistema actualizada
     */
    public void modificarValoracion(Ruta rutaValorada, String dniUsuario, Integer puntuacion, String comentario){
        //Buscar la valoración en la lista de valoraciones del sistema
        for(int i=0; i < listaValoracionesSistema.size(); i++){
            if(listaValoracionesSistema.get(i).getRuta().getIdRuta().equals(rutaValorada.getIdRuta()) && listaValoracionesSistema.get(i).getUsuario().getDNI().equals(dniUsuario)){
                //Sobreescribir el array del usuario sin esta valoracion
                ArrayList<Valoracion> listaValoracionesAux = new ArrayList<>();
                for(int j=0; j < listaValoracionesSistema.get(i).getUsuario().getListaValoraciones().size(); j++){
                    if(!listaValoracionesSistema.get(i).getUsuario().getListaValoraciones().get(j).getIDValoracion().equals(listaValoracionesSistema.get(i).getIDValoracion())){
                        listaValoracionesAux.add(listaValoracionesSistema.get(i).getUsuario().getListaValoraciones().get(j));
                    }
                }
                listaValoracionesSistema.get(i).getUsuario().setListaValoraciones(listaValoracionesAux);

                //Sobreescribir el array de la ruta sin esta valoracion
                listaValoracionesAux = new ArrayList<>();
                for(int j=0; j < listaValoracionesSistema.get(i).getRuta().getListaValoraciones().size(); j++){
                    if(!listaValoracionesSistema.get(i).getRuta().getListaValoraciones().get(j).getIDValoracion().equals(listaValoracionesSistema.get(i).getIDValoracion())){
                        listaValoracionesAux.add(listaValoracionesSistema.get(i).getRuta().getListaValoraciones().get(j));
                    }
                }
                listaValoracionesSistema.get(i).getRuta().setListaValoraciones(listaValoracionesAux);
                listaValoracionesSistema.get(i).setPuntuacion(puntuacion);
                listaValoracionesSistema.get(i).setComentario(comentario);
                
                //Añadir la valoración modificada a la lista de valoraciones del usuario
                listaValoracionesSistema.get(i).getUsuario().setValoracionEnLista(listaValoracionesSistema.get(i));
                //Añadir la valoración modificada a la lista de valoraciones de la ruta
                listaValoracionesSistema.get(i).getRuta().setValoracionEnLista(listaValoracionesSistema.get(i));
            }
        }
        escribirXMLValoracion(listaValoracionesSistema);
        escribirXMLRutas(listaRutasSistema);
    }

    /**
     * @brief   Método que añade una foto de perfil a la lista de fotos de perfil del sistema siempre que no exista ya
     * @param dniUsuario            DNI del usuario al que se le añade la foto de perfil
     * @param nombreImagen          Nombre de la imagen de la foto de perfil
     * @param resolucionImagenMp    Resolución de la imagen de la foto de perfil
     * @param tamanioKb             Tamaño de la imagen de la foto de perfil
     * @post    Se actualiza el XML
     * @post    Se actualiza la lista de fotos de perfil del usuario
     */
    public void aniadirFotoPerfil(String dniUsuario, String nombreImagen, Integer resolucionImagenMp, Integer tamanioKb){
        boolean existeFotoPerfil = false;
        //Buscar usuario con dni
        Usuario usuario = null;
        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dniUsuario)){
                usuario = listaUsuariosSistema.get(i);
            }
        }

        FotoPerfil fotoPerfil = new FotoPerfil(nombreImagen, resolucionImagenMp, tamanioKb, usuario);

        for(int i=0; i < listaFotosPerfilSistema.size(); i++){
            if(listaFotosPerfilSistema.get(i).getIDfoto().equals(fotoPerfil.getIDfoto())){
                existeFotoPerfil = true;
            }
        }

        if(!existeFotoPerfil){
            listaFotosPerfilSistema.add(fotoPerfil);
            usuario.setFotoPerfil(fotoPerfil);
            escribirXMLFotoPerfil(listaFotosPerfilSistema);
            escribirXMLUsuario(listaUsuariosSistema);
        }
    }

    /**
     * @brief   Método que modifica los datos de una foto de perfil de la lista de fotos de perfil del sistema
     * @param dniUsuario            DNI del usuario al que se le modifica la foto de perfil
     * @param nombreImagen          Nombre de la imagen de la foto de perfil
     * @param resolucionImagenMp    Resolución de la imagen de la foto de perfil
     * @param tamanioKb             Tamaño de la imagen de la foto de perfil
     * @post    La foto de perfil del usuario con el dni indicado tiene los datos modificados
     * @post    El fichero XML contiene la lista de fotos de perfil del sistema actualizada
     */
    public void modificarFotoPerfil(String dniUsuario, String nombreImagen, Integer resolucionImagenMp, Integer tamanioKb){
        //Buscar la foto de perfil en la lista de fotos de perfil del sistema
        for(int i=0; i < listaFotosPerfilSistema.size(); i++){
            if(listaFotosPerfilSistema.get(i).getUsuario().getDNI().equals(dniUsuario)){
                listaFotosPerfilSistema.get(i).setNombreImagen(nombreImagen);
                listaFotosPerfilSistema.get(i).setResolucionImagenMp(resolucionImagenMp);
                listaFotosPerfilSistema.get(i).setTamanioKb(tamanioKb);
            }
        }
        escribirXMLFotoPerfil(listaFotosPerfilSistema);
        escribirXMLUsuario(listaUsuariosSistema);
    }

    /**
     * @brief   Método que borra una foto de perfil de la lista de fotos de perfil del sistema
     * @param idFotoEliminada   ID de la foto de perfil a eliminar de la lista de fotos de perfil del sistema
     * @post    La foto de perfil con el ID indicado se ha eliminado de la lista de fotos de perfil del sistema
     * @post    El fichero XML contiene la lista de fotos de perfil del sistema actualizada
     */
    public void borrarFotoPerfil(String idFotoEliminada){
        String dniUsuario = "";
        //Eliminar la foto de perfil del sistema
        for(int i=0; i < listaFotosPerfilSistema.size(); i++){
            if(listaFotosPerfilSistema.get(i).getIDfoto().equals(idFotoEliminada)){
                dniUsuario = listaFotosPerfilSistema.get(i).getUsuario().getDNI();
                listaFotosPerfilSistema.remove(i);
            }
        }
        //Eliminar la foto de perfil del usuario
        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dniUsuario)){
                listaUsuariosSistema.get(i).setFotoPerfil(null);
            }
        }
        escribirXMLFotoPerfil(listaFotosPerfilSistema);
        escribirXMLUsuario(listaUsuariosSistema);
    }
    
    /**
     * @brief   Método que elimina una ruta de una categoría y una categoría de una ruta
     * @param idRuta        ID de la ruta a eliminar de la categoría
     * @param idCategoria   ID de la categoría a eliminar de la ruta
     * @post    La ruta con el ID indicado se ha eliminado de la categoría con el ID indicado
     * @post    La categoría con el ID indicado se ha eliminado de la ruta con el ID indicado
     * @post    Se actualizan los ficheros XML
     * @post    Se actualizan las listas del sistema
     */
    public void eliminarRutaDeCategoria(String idRuta, String idCategoria){
        //Buscar la ruta en la lista de rutas del sistema
        Ruta ruta = null;
        for(int i=0; i < listaRutasSistema.size(); i++){
            if(listaRutasSistema.get(i).getIdRuta().equals(idRuta)){
                ruta = listaRutasSistema.get(i);
            }
        }
        //Buscar la categoría en la lista de categorías del sistema
        Categoria categoria = null;
        for(int i=0; i < listaCategoriasSistema.size(); i++){
            if(listaCategoriasSistema.get(i).getIDCategoria().equals(idCategoria)){
                categoria = listaCategoriasSistema.get(i);
            }
        }
        //Sobreescribir el array de rutas de la categoría ignorando esta ruta
        ArrayList<Ruta> listaRutasAux = new ArrayList<>();
        for(int i=0; i < categoria.getListaRutas().size(); i++){
            if(!categoria.getListaRutas().get(i).getIdRuta().equals(idRuta)){
                listaRutasAux.add(categoria.getListaRutas().get(i));
            }
        }
        categoria.setListaRutas(listaRutasAux);

        //Sobreescibir el array de categorías de la ruta ignorando esta categoría
        ArrayList<Categoria> listaCategoriasAux = new ArrayList<>();
        for(int i=0; i < ruta.getListaCategorias().size(); i++){
            if(!ruta.getListaCategorias().get(i).getIDCategoria().equals(idCategoria)){
                listaCategoriasAux.add(ruta.getListaCategorias().get(i));
            }
        }
        ruta.setListaCategorias(listaCategoriasAux);

        escribirXMLCategoria(listaCategoriasSistema);
        escribirXMLRutas(listaRutasSistema);
    }

    /**
     * @brief   Método que serializa la lista de categorías del sistema
     */
    public void serializarCategoria(){
        ObjectOutputStream serializador = null;
        try{
            serializador = new ObjectOutputStream(new FileOutputStream("Categorias.dat"));
            serializador.writeObject(listaCategoriasSistema);
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al serializar la lista de categorías del sistema");
        }
        finally{
            if(serializador != null){
                try{
                    serializador.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                    System.out.println("Error al cerrar el serializador de la lista de categorías del sistema");
                }
            }
        }
    }

    /**
     * @brief   Método que deserializa la lista de categorías del sistema
     */
    public void deserializarCategoria(){
        ObjectInputStream deserializador = null;
        try{
            deserializador = new ObjectInputStream(new FileInputStream("Categorias.dat"));
            listaCategoriasSistema = (ArrayList<Categoria>) deserializador.readObject();
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
            System.out.println("Error al encontrar el fichero de la lista de categorías del sistema");
        }
        catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            System.out.println("Error al encontrar la clase categorías");
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println("Error al deserializar la lista de categorías del sistema");
        }
        finally{
            if(deserializador != null){
                try{
                    deserializador.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                    System.out.println("Error al cerrar el deserializador de la lista de categorías del sistema");
                }
            }
        }
    }

    /**
     * @brief   Método que serializa la lista de usuarios del sistema
     */
    public void serializarFotoPerfil(){
        ObjectOutputStream serializador = null;
        try{
            serializador = new ObjectOutputStream(new FileOutputStream("FotosPerfil.dat"));
            serializador.writeObject(listaFotosPerfilSistema);
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al serializar la lista de fotos de perfil del sistema");
        }
        finally{
            if(serializador != null){
                try{
                    serializador.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                    System.out.println("Error al cerrar el serializador de la lista de fotos de perfil del sistema");
                }
            }
        }
    }

    /**
     * @brief   Método que deserializa la lista de fotos de perfil del sistema
     */
    public void deserializarFotoPerfil(){
        ObjectInputStream deserializador = null;
        try{
            deserializador = new ObjectInputStream(new FileInputStream("FotosPerfil.dat"));
            listaFotosPerfilSistema = (ArrayList<FotoPerfil>) deserializador.readObject();
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
            System.out.println("Error al encontrar el fichero de la lista de fotos de perfil del sistema");
        }
        catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            System.out.println("Error al encontrar la clase fotos de perfil");
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println("Error al deserializar la lista de fotos de perfil del sistema");
        }
        finally{
            if(deserializador != null){
                try{
                    deserializador.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                    System.out.println("Error al cerrar el deserializador de la lista de fotos de perfil del sistema");
                }
            }
        }
    }
}
