/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validators;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class EmailAgeValidator implements Validator<Usuario>{

   @Override
   public List<String> validate(Usuario info) {
      List<String> errors = new ArrayList();
      String email = info.getEmail();
      int age = info.getAge();
      boolean emailflag = false;
      for (int i = 0; i < email.length(); i++) {
         char emailchar1 = email.charAt(i);
         if(emailchar1=='@'){
            for (int j = i; j < email.length(); j++) {
               char emailchar2 = email.charAt(j);
               if(emailchar2=='.' && j!=email.length()-1){
                  emailflag = true;
               }
            }
         }
      }
      if(age<12){
         errors.add("La edad debe ser >=12");
      }
      if(email.isEmpty()){
         errors.add("E-mail no puede estar vacío");
      }
      else if(!emailflag){
         errors.add("El formato de E-mail es incorrecto");
      }
      return errors;
   }
   
}
