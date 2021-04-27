/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicstreamer;

import java.io.Serializable;

/**
 *
 * @author Lighthouse
 */
public class Song implements Serializable{
   private String nombre;
   private String artista;
   private String album;
   private int year;
   private String genero;
   private String urlname;

   public Song(String nombre, String artista, String album, int year, String genero, String urlname) {
      this.nombre = nombre;
      this.artista = artista;
      this.album = album;
      this.year = year;
      this.genero = genero;
      this.urlname = urlname;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getArtista() {
      return artista;
   }

   public void setArtista(String artista) {
      this.artista = artista;
   }

   public String getAlbum() {
      return album;
   }

   public void setAlbum(String album) {
      this.album = album;
   }

   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year = year;
   }

   public String getGenero() {
      return genero;
   }

   public void setGenero(String genero) {
      this.genero = genero;
   }

   public String getUrlname() {
      return urlname;
   }

   public void setUrlname(String urlname) {
      this.urlname = urlname;
   }
   
   
   
}
