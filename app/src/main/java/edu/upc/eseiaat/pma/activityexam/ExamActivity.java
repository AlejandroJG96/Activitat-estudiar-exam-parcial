package edu.upc.eseiaat.pma.activityexam;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ExamActivity extends AppCompatActivity {

    private ArrayList<String> country_list;
    private ArrayAdapter<String> Adaptador;
    private Button btn_next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        String[] countrie =getResources().getStringArray(R.array.countries);
        country_list = new ArrayList<>(Arrays.asList(countrie));
        Adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, country_list);
        ListView lista  = (ListView) findViewById(R.id.listapaises);
        btn_next = (Button) findViewById(R.id.btn_next);

        lista.setAdapter(Adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ExamActivity.this, String.format("Ha escogido '%s'",country_list.get(position)), Toast.LENGTH_SHORT).show();

            }
        });
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ExamActivity.this);
                builder.setTitle(R.string.titulo);
                String msg = getResources().getString(R.string.confirmmessage);
                String acabado = String.format(msg, country_list.get(position));
                builder.setMessage(acabado + " de la llista?");
                builder.setPositiveButton(R.string.erase, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        country_list.remove(position);
                        Adaptador.notifyDataSetChanged();

                    }
                });
                builder.setNegativeButton(android.R.string.cancel, null);
                builder.create().show();
                return true;
            }
        });
    }

    public void pasarpantalla(View view) {
        Intent intent = new Intent(this, secondscreen.class); //Per crear una activitat s'utilitzen objectes de la clase intent
        intent.putStringArrayListExtra(secondscreen.KEY_NOM, country_list);
        startActivity(intent);


    }
}
