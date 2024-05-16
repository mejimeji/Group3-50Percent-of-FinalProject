/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagementSystem;

import java.util.HashMap;

/**
 *
 * @author User
 */
public class UsernameAndPassword {
    
    HashMap<String,String> login = new HashMap<String,String>();
    
    UsernameAndPassword(){
        login.put("Joyce","joyce123");
    }
    
    protected HashMap getLogin(){
        return login;
    }
    
}
