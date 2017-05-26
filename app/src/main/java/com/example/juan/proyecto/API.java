/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author juan
 */
public class API {
    ArrayList<User> usuarios = new ArrayList<>();
    public API() {
       User temp = new admin("admin", "El Big Boss", "supersecreto", 100, "el@mejor.com" );
       this.usuarios.add(temp);
    }
    
    public User login( String username, String password ){
        User temp = this.getUser( username );
        
        if( temp != null && temp.getPassword().equals(password) ){
            temp.setPassword("");
            return temp;
        }
        return null;
    }
    
    public User register( String user, String name, String password, int age, String email ){
        User temp = this.getUser(user);
        
        if( temp != null)
            return null;
        
        temp = new Limitado( user, name, password, age, email );
        
        this.usuarios.add( temp );
        
        return temp;
    }
    
    public User info( String name ){
        User temp = this.getUser( name );
        
        temp.setPassword("");
        return temp;
    }
    
    /*************************** Private Methods *************************************/
    
    private User getUser( String username ){
        return getUserp( username, 0 );
    }
    
    private User getUserp( String username, int next){
        if( next < this.usuarios.size() ){
            User temp = this.usuarios.get( next );
            
            if( temp.getUser().equals(username) )
                return temp;
            
            return this.getUserp( username, next+1 );
        }
        return null;
    }
}
