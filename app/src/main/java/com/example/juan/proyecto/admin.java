/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.juan.proyecto;

import java.util.*;
/**
 *
 * @author juan
 */
public class admin extends User implements UserEvents{
    ArrayList<Integer> events;
    public admin( int id, String user, String name, String password, int age, String email, boolean active ){
        super( id, user, name, password, age, email, active, UserType.ADMINISTRADOR );
        this.events = new ArrayList<>();
    }
    public admin(){
        this.events = new ArrayList<>();
    }

    public admin( String user, String name, String password, int age, String email ){
        super( user, name, password, age, email, true, UserType.ADMINISTRADOR );
        UserType.ADMINISTRADOR.ordinal();
        this.events = new ArrayList<>();
    }

    @Override
    public void addEvent(int id) {
        if( this.eventIdExist(id) )
            this.events.add(id);
    }

    @Override
    public void removeEvent(int id) {
        for (int i = 0; i < this.events.size(); i++) {
            if( this.events.get(i) == id ){
                this.events.remove(i);
                return;
            }
        }
    }

    @Override
    public boolean eventIdExist(int id) {
        Iterator<Integer> eventsIterator = this.events.iterator();
        while( eventsIterator.hasNext() ){
            if(eventsIterator.next() == id ){
                return true;
            }
        }
        return false;
    }
}
