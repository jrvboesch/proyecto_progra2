package com.example.juan.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class profileActivity extends AppCompatActivity {
    API api = new API();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        api.fillUserList( this );

        String username = getIntent().getStringExtra( "username" );

        TextView nombre = (TextView) findViewById( R.id.txtName);
        TextView email = (TextView) findViewById( R.id.txtEmail);

        User u = api.info( username );

        if( u != null ) {
            nombre.setText(u.getName());
            email.setText(u.getEmail());
        }
    }

    @Override
    public void onBackPressed() {
        return;
    }

    public void logout( View view ) {

        Intent newView =  new Intent( this, LoginActivity.class );

        startActivity( newView );
    }
}
