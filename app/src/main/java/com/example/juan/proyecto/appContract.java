package com.example.juan.proyecto;
import android.provider.BaseColumns;

/**
 * Created by juan on 5/28/17.
 */

public final class appContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private appContract() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME_USER = "user";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_AGE = "age";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_ACTIVE = "active";
        public static final String COLUMN_NAME_ROLL = "roll";
    }

}


