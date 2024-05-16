/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagementSystem;

/**
 *
 * @author User
 */
public class Main {
    public static void main (String[]args){
        
        UsernameAndPassword userPass = new UsernameAndPassword();
        
        Login loginInfo = new Login(userPass.getLogin());
        
    }
}