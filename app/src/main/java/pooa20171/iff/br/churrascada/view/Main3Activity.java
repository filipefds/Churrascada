package pooa20171.iff.br.churrascada.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import pooa20171.iff.br.churrascada.R;
import pooa20171.iff.br.churrascada.controller.Evento;
import pooa20171.iff.br.churrascada.controller.HTTPDataHandler;

public class Main3Activity extends AppCompatActivity {

    String cepEntrada = "";
    String urlapi = "";
    ProgressDialog progressDialog;
    String mulher = "";
    String nomeEvento;
    String homem = "";
    String crianca = "";
    String valor_total = "";
    String rateio_homem = "";
    String rateio_misto = "";
    String cep = "";
    String logradouro = "";
    String complemento = "";
    String bairro = "";
    String localidade = "";
    String uf = "";
    String ibge = "";
    String numero = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        mulher = (String) intent.getSerializableExtra("mulher");
        homem = (String) intent.getSerializableExtra("homem");
        crianca = (String) intent.getSerializableExtra("crianca");
        valor_total = (String) intent.getSerializableExtra("valor_total");
        rateio_homem = (String) intent.getSerializableExtra("rateioHomem");
        rateio_misto = (String) intent.getSerializableExtra("rateioMisto");

        NumberFormat formatarFloat = new DecimalFormat("##.##");

        TextView cont_mulher = (TextView) findViewById(R.id.cont_mulher);
        cont_mulher.setText("Total de mulheres: "+mulher);
        TextView cont_homem = (TextView) findViewById(R.id.cont_homem);
        cont_homem.setText("Total de homens: "+homem);
        TextView cont_crianca = (TextView) findViewById(R.id.cont_crianca);
        cont_crianca.setText("Total de crianças: "+crianca);
        TextView valorTotal = (TextView) findViewById(R.id.total_consumo);
        valorTotal.setText("Total gasto: R$"+formatarFloat.format(Float.parseFloat(valor_total)));
        TextView rateioHomem = (TextView) findViewById(R.id.rateio_homens);
        rateioHomem.setText("Rateio entre homens: R$"+formatarFloat.format(Float.parseFloat(rateio_homem)));
        TextView rateioMisto = (TextView) findViewById(R.id.rateio_misto);
        rateioMisto.setText("Rateio misto: R$"+formatarFloat.format(Float.parseFloat(rateio_misto)));

        final Button btnBuscarCEP = (Button) findViewById(R.id.btnChamaBuscaCEP);
        final Button btnSalvar = (Button) findViewById(R.id.salvar);
        final EditText editTextCep = (EditText) findViewById(R.id.edtCep);

        btnBuscarCEP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Evento evento = new Evento();
                cepEntrada = editTextCep.getText().toString();
                editTextCep.setText("");
                urlapi = "https://viacep.com.br/ws/" + cepEntrada + "/json/";
                if(cepEntrada.length() == 8){
                    progressDialog =ProgressDialog.show(Main3Activity.this, "Caregando . . . ","", true);
                    progressDialog.setCancelable(true);
                    new ProcessJSON().execute(urlapi);
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor informe um CEP válido.", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nomeEv = (EditText) findViewById(R.id.nomeEvento);
                nomeEvento = nomeEv.getText().toString();
                EditText numeroEv = (EditText) findViewById(R.id.txtBC_numero);
                numero = numeroEv.getText().toString();

                Intent i = new Intent(Main3Activity.this, Main4Activity.class);
                startActivity(i);
            }
        });


    }

    public void toast (String msg){
        Toast.makeText (getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private class ProcessJSON extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String stream = null;
            String urlString = strings[0];
            HTTPDataHandler hh = new HTTPDataHandler();
            stream = hh.GetHTTPData(urlString);
            return stream;
        }

        protected void onPostExecute(String stream){

            if(stream !=null){
                try{
                    JSONObject reader= new JSONObject(stream);
                    cep = reader.getString("cep");
                    logradouro = reader.getString("logradouro");
                    complemento = reader.getString("complemento");
                    bairro = reader.getString("bairro");
                    localidade = reader.getString("localidade");
                    uf = reader.getString("uf");
                    ibge = reader.getString("ibge");

                    progressDialog.dismiss();

                    EditText edtCep = (EditText) findViewById(R.id.edtCep);
                    final EditText txtLogradouro = (EditText) findViewById(R.id.txtBC_logradouro);
                    final EditText txtComplemento = (EditText) findViewById(R.id.txtBC_complemento);
                    final EditText txtBairro = (EditText) findViewById(R.id.txtBC_bairro);
                    final EditText txtLocalidade = (EditText) findViewById(R.id.txtBC_localidade);
                    final EditText txtUf = (EditText) findViewById(R.id.txtBC_uf);

                    edtCep.setText(""+cep);
                    if(logradouro != ""){
                        txtLogradouro.setText(""+logradouro);
                    }else{
                        txtLogradouro.setText("SEM LOGRADOURO");
                    }
                    if(complemento != ""){
                        txtComplemento.setText(""+complemento);
                    }else{
                        txtComplemento.setText("SEM COMPLEMENTO");
                    }
                    if(bairro != ""){
                        txtBairro.setText(""+bairro);
                    }else{
                        txtBairro.setText("SEM BAIRRO");
                    }
                    if (localidade != ""){
                        txtLocalidade.setText(""+localidade);
                        txtUf.setText(""+uf);
                    }

                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
