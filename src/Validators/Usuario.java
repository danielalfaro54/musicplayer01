/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validators;



/**
 *
 * @author Lighthouse
 */
public class Usuario {
   private String name;
   private String surname;
   private String email;
   private String username;
   private String password;
   private int age;

   public Usuario(String name, String surname, String email, String username, String password, int age) {
      this.name = name;
      this.surname = surname;
      this.email = email;
      this.username = username;
      this.password = password;
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getSurname() {
      return surname;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }
   
   
   
}
