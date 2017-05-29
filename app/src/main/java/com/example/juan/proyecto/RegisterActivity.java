package com.example.juan.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    API api = new API();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        api.fillUserList( this );
    }

    public void register(View view){
        EditText username = (EditText) findViewById( R.id.txtUsername);
        EditText name = (EditText) findViewById( R.id.txtName );
        EditText password = (EditText) findViewById( R.id.txtPassword );
        EditText age = (EditText) findViewById( R.id.txtAge );
        EditText email = (EditText) findViewById( R.id.txtEmail );

        User u = api.register( username.getText().toString(),
                                name.getText().toString(),
                                password.getText().toString(),
                                Integer.parseInt( age.getText().toString() ),
                                email.getText().toString() );

        if( u !=  null ){
            api.addUserToDB( u, this );

            Intent newView =  new Intent( this, LoginActivity.class );

            startActivity( newView );
        }
    }

}

