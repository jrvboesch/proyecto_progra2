/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author juan
 */
public interface UserEvents {
    
    void addEvent( int id );
    void removeEvent( int id );
    boolean eventIdExist( int id );
}
