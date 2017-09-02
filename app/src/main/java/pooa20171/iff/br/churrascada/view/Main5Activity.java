package pooa20171.iff.br.churrascada.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import pooa20171.iff.br.churrascada.R;
import pooa20171.iff.br.churrascada.realm.Evento;

public class Main5Activity extends AppCompatActivity {

    private EditText etNome, etQtdMulher, etQtdHomem, etQtdCrianca, etValorTotal;
    private Button btnEditar, btnExcluir;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        realm = Realm.getDefaultInstance();
        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0);
        final Evento evento = realm.where(Evento.class).equalTo("id", id).findFirst();

        etNome = (EditText) findViewById(R.id.etNome);
        etQtdMulher = (EditText) findViewById(R.id.etQtdMulher);
        etQtdHomem = (EditText) findViewById(R.id.etQtdHomem);
        etQtdCrianca = (EditText) findViewById(R.id.etQtdCrianca);
        etValorTotal = (EditText) findViewById(R.id.etValorTotal);

        etNome.setText(evento.getNomeEvento());
        etQtdMulher.setText(evento.getMulher());
        etQtdHomem.setText(evento.getHomem());
        etQtdCrianca.setText(evento.getCrianca());
        etValorTotal.setText(evento.getTotalGasto());

        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                evento.setNomeEvento(etNome.getText().toString());
                evento.setMulher(etQtdMulher.getText().toString());
                evento.setHomem(etQtdHomem.getText().toString());
                evento.setCrianca(etQtdCrianca.getText().toString());
                evento.setTotalGasto(etValorTotal.getText().toString());
                realm.copyToRealm(evento);
                realm.commitTransaction();

                Toast.makeText(Main5Activity.this, "Registro alterado!", Toast.LENGTH_SHORT).show();

            }
        });

        btnExcluir = (Button) findViewById(R.id.btnExcluir);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                evento.deleteFromRealm();
                realm.commitTransaction();

                Toast.makeText(Main5Activity.this, "Registro removido!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}


