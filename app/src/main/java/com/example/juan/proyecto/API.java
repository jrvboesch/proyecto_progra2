/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.juan.proyecto;

import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.*;
import android.content.*;

/**
 *
 * @author juan
 */
public class API {
public ArrayList<User> usuarios = new ArrayList<>();

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

        if( temp != null )
            temp.setPassword("");

        return temp;
    }

    public void addUserToDB( User u , Context context){

        appDbHelper mDbHelper;
        mDbHelper = new appDbHelper(context);

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(appContract.Users.COLUMN_NAME_USER, u.getUser() );
        values.put(appContract.Users.COLUMN_NAME_NAME, u.getName() );
        values.put(appContract.Users.COLUMN_NAME_PASSWORD, u.getPassword() );
        values.put(appContract.Users.COLUMN_NAME_AGE, u.getAge() );
        values.put(appContract.Users.COLUMN_NAME_EMAIL, u.getEmail() );
        values.put(appContract.Users.COLUMN_NAME_ACTIVE, u.isActive() );
        values.put(appContract.Users.COLUMN_NAME_ROLL, u.getRoll().ordinal() );

        // Insert the new row, returning the primary key value of the new row
        db.insert(appContract.Users.TABLE_NAME, null, values);
    }

    public void fillUserList( Context context ){

        appDbHelper mDbHelper;
        mDbHelper = new appDbHelper(context);

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        Cursor cur = db.rawQuery( "select * from " + appContract.Users.TABLE_NAME, null );

        while( cur.moveToNext() ){

            int id = cur.getInt( 0 );
            String username = cur.getString( 1 );
            String name = cur.getString( 2 );
            String password = cur.getString( 3 );
            int age = cur.getInt( 4 );
            String email = cur.getString( 5 );
            int active = cur.getInt( 6 );
            int roll = cur.getInt( 7 );
            User u;

            if( roll == UserType.ADMINISTRADOR.ordinal() ){
                u = new admin( id, username, name, password, age, email, active == 1 );
            }else if( roll == UserType.CONTENIDO.ordinal() ){
                u = new Contenido( id, username, name, password, age, email, active == 1 );
            }else{
                u = new Limitado( id, username, name, password, age, email, active == 1 );
            }

            this.usuarios.add( u );
        }
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
            
            return this.getUserp( username, next + 1 );
        }
        return null;
    }


}
