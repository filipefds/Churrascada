package pooa20171.iff.br.churrascada.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import io.realm.Realm;
import pooa20171.iff.br.churrascada.R;
import pooa20171.iff.br.churrascada.controller.Lista;
import pooa20171.iff.br.churrascada.controller.ListaAdapter;
import pooa20171.iff.br.churrascada.realm.Evento;
import pooa20171.iff.br.churrascada.realm.EventoAdapter;

public class Main4Activity extends AppCompatActivity {

    private List<Evento> eventos;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        realm = Realm.getDefaultInstance();

        ListView lvLista = (ListView) findViewById(R.id.listView);
        eventos = realm.where(Evento.class).findAll();
        EventoAdapter adapter = new EventoAdapter(this, eventos);
        lvLista.setAdapter(adapter);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(Main4Activity.this, Main5Activity.class);
                intent.putExtra("ID", eventos.get(position).getId());
                startActivity(intent);
            }
        });



    }

}
