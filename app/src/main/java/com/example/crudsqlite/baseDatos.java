package com.example.crudsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class baseDatos extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "bdProyecto";
    private static final int VERSION_BD = 1;
    private static final String TABLA_ESTUDIANTES="CREATE TABLE estudiantes (codigo text primary key, nombre text, carrera text );";

    public baseDatos(Context context){
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_ESTUDIANTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLA_ESTUDIANTES);
        db.execSQL(TABLA_ESTUDIANTES);
    }

    public void agregarEstdiante(String codigo, String nombre, String carrera){
        SQLiteDatabase db = getReadableDatabase();
        if (db!=null){
            db.execSQL("INSERT INTO estudiantes VALUES ('"+codigo+","+nombre+","+carrera+"')");
            db.close();
        }
    }

}
