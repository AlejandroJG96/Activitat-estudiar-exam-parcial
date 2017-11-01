package edu.upc.eseiaat.pma.activityexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Usuari on 01/11/2017.
 */

public class secondscreen extends AppCompatActivity {
    public static String KEY_NOM;
    private ArrayAdapter<String> adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondscreen);
        ArrayList<String> nom = getIntent().getExtras().getStringArrayList(KEY_NOM);
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nom);
        ListView list = (ListView) findViewById(R.id.listViewbueno);
        list.setAdapter(adaptador);








    }
}
