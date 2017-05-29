/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.juan.proyecto;


/**
 *
 * @author juan
 */
public class Limitado extends User{
    public Limitado(){
    }
    public Limitado( int id, String user, String name, String password, int age, String email, boolean active ){
        super( id, user, name, password, age, email, active, UserType.LIMITADO );
    }
    public Limitado( String user, String name, String password, int age, String email ){
        super( user, name, password, age, email, false, UserType.LIMITADO );
    }
}
