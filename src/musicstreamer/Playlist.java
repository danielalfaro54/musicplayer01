/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicstreamer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lighthouse
 */
public class Playlist implements Serializable{
   
   private List<Song> songs;
   private char id;

   public Playlist() {
      songs = new ArrayList();
   }
   

   public List<Song> getSongs() {
      return songs;
   }

   public void setSongs(List<Song> songs) {
      this.songs = songs;
   }

   public char getId() {
      return id;
   }

   public void setId(char id) {
      this.id = id;
   }
   
   
   
}
