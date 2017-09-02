package pooa20171.iff.br.churrascada.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    }

}
