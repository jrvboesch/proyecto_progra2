package com.example.juan.proyecto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    API api = new API();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        api.fillUserList( this );

    }
    @Override
    public void onBackPressed() {
        return;
    }

    public void register(View view){
        Intent newView =  new Intent( this, RegisterActivity.class );
        startActivity( newView );
    }

    public void login(View view){
        EditText username = (EditText) findViewById( R.id.txtEmail);
        EditText pass = (EditText) findViewById( R.id.txtPassword );
        User u = api.login( username.getText().toString(), pass.getText().toString() );

        if( u !=  null ){
            Intent newView =  new Intent( this, profileActivity.class );
            newView.putExtra( "username", u.getUser() );

            startActivity( newView );
        }
    }

}
