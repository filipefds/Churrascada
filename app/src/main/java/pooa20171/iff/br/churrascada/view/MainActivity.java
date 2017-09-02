package pooa20171.iff.br.churrascada.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pooa20171.iff.br.churrascada.R;

public class MainActivity extends AppCompatActivity {

    private TextView tvMulher, tvHomem, tvCrianca;
    private int mulher = 0;
    private int homem = 0;
    private int crianca = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMulher = (TextView) findViewById(R.id.tvMulherCont);
        tvHomem = (TextView) findViewById(R.id.tvHomemCont);
        tvCrianca = (TextView) findViewById(R.id.tvCriancaCont);

        Button mulherMenos = (Button) findViewById(R.id.btMulherMenos);
        mulherMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mulher > 0){
                    mulher--;
                    tvMulher.setText(String.valueOf(mulher));
                } else {
                    mulher = 0;
                    tvMulher.setText(String.valueOf(mulher));
                }
            }
        });

        Button mulherMais = (Button) findViewById(R.id.btMulherMais);
        mulherMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mulher++;
                tvMulher.setText(String.valueOf(mulher));
            }
        });

        Button homemMenos = (Button) findViewById(R.id.btHomemMenos);
        homemMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homem > 0){
                    homem--;
                    tvHomem.setText(String.valueOf(homem));
                } else {
                    homem = 0;
                    tvHomem.setText(String.valueOf(homem));
                }
            }
        });

        Button homemMais = (Button) findViewById(R.id.btHomemMais);
        homemMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homem++;
                tvHomem.setText(String.valueOf(homem));
            }
        });

        Button criancaMenos = (Button) findViewById(R.id.btCriancaMenos);
        criancaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crianca > 0) {
                    crianca--;
                    tvCrianca.setText(String.valueOf(crianca));
                } else {
                    crianca = 0;
                    tvCrianca.setText(String.valueOf(crianca));
                }
            }
        });

        Button criancaMais = (Button) findViewById(R.id.btCriancaMais);
        criancaMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crianca++;
                tvCrianca.setText(String.valueOf(crianca));
            }
        });

        Button listaCompras = (Button) findViewById(R.id.button01);
        listaCompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("mulher",tvMulher.getText().toString());
                intent.putExtra("homem", tvHomem.getText().toString());
                intent.putExtra("crianca", tvCrianca.getText().toString());
                startActivityForResult(intent, 0);

            }
        });

        Button desenvolvedor = (Button) findViewById(R.id.button02);
        desenvolvedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/filipefds");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        Button btnHistorico = (Button) findViewById(R.id.button04);
        btnHistorico.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main4Activity.class );
                startActivity(intent);
            }
        });

    }

}
