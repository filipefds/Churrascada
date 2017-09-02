package pooa20171.iff.br.churrascada.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import pooa20171.iff.br.churrascada.R;
import pooa20171.iff.br.churrascada.controller.Lista;
import pooa20171.iff.br.churrascada.controller.ListaAdapter;

public class Main2Activity extends AppCompatActivity {

    private int contMulher = 0;
    private int contHomem = 0;
    private int contCrianca = 0;
    private int contTotal = 0;
    private float totalCompras = 0;
    private TextView tvTotal;
    private float rateioHomem = 0;
    private float rateioMisto = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String mulher = (String) intent.getSerializableExtra("mulher");
        String homem = (String) intent.getSerializableExtra("homem");
        String crianca = (String) intent.getSerializableExtra("crianca");

        contMulher = Integer.parseInt(mulher);
        contHomem = Integer.parseInt(homem);
        contCrianca = Integer.parseInt(crianca);
        contTotal = (contMulher + contHomem + contCrianca);


        ListView lista = (ListView) findViewById(R.id.lista);
        ArrayList<Lista> itens = adicionarItem();
        ArrayAdapter adapter = new ListaAdapter(this, itens);
        lista.setAdapter(adapter);

        if (contTotal == 0) {
            totalCompras = 0;
        }

        NumberFormat formatarFloat = new DecimalFormat("##.##");
        tvTotal = (TextView) findViewById(R.id.tvTotal);
        tvTotal.setText("R$"+formatarFloat.format(totalCompras));

        rateioHomem = rateioHomem();
        rateioMisto = rateioMisto();


        Button cadastroEvento = (Button) findViewById(R.id.button03);
        cadastroEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("mulher", String.valueOf(contMulher));
                intent.putExtra("homem", String.valueOf(contHomem));
                intent.putExtra("crianca", String.valueOf(contCrianca));
                intent.putExtra("valor_total", String.valueOf(totalCompras));
                intent.putExtra("rateioHomem", String.valueOf(rateioHomem));
                intent.putExtra("rateioMisto", String.valueOf(rateioMisto));
                startActivityForResult(intent, 1);
            }
        });

    }

    private float rateioMisto() {
        if (contTotal == 0) {
            return 0;
        } else {
            return (totalCompras / (contHomem + contMulher));
        }
    }

    private float rateioHomem() {
        if (contTotal == 0) {
            return 0;
        } else {
            return (totalCompras / contHomem);
        }
    }

    private ArrayList<Lista> adicionarItem() {

        ArrayList<Lista> itens = new ArrayList<Lista>();

        NumberFormat formatarFloat = new DecimalFormat("##.##");

        Lista l = new Lista("Carne Bovina", formatarFloat.format(qtdCarne())+"Kg de carne bovina.", "R$"+formatarFloat.format(precoCarne()), R.drawable.carne);
        itens.add(l);
        l = new Lista("Frango", formatarFloat.format(qtdFrango())+"Kg de frango.", "R$"+formatarFloat.format(precoFrango()),R.drawable.frango);
        itens.add(l);
        l = new Lista("Linguiça", formatarFloat.format(qtdLinguica()) + "Kg de linguiça.", "R$"+formatarFloat.format(precoLinguica()), R.drawable.linguica);
        itens.add(l);
        l = new Lista("Pão de Alho", formatarFloat.format(qtdPao()) + " Pães.", "R$"+formatarFloat.format(precoPao()),R.drawable.pao);
        itens.add(l);
        l = new Lista("Arroz", formatarFloat.format(qtdArroz()) + "Kg de arroz.", "R$"+formatarFloat.format(precoArroz()), R.drawable.arroz);
        itens.add(l);
        l = new Lista("Molho", formatarFloat.format(qtdMolho()) + "Kg de molho.", "R$"+formatarFloat.format(precoMolho()), R.drawable.vinagrete);
        itens.add(l);
        l = new Lista("Farofa", formatarFloat.format(qtdFarofa()) + " Embalagem de 500G de farofa.", "R$"+formatarFloat.format(precoFarofa()),R.drawable.farofa);
        itens.add(l);
        l = new Lista("Cerveja", formatarFloat.format(qtdCerveja())+" Garrafas de cerveja", "R$"+formatarFloat.format(precoCerveja()), R.drawable.cerveja);
        itens.add(l);
        l = new Lista("Refrigerante", formatarFloat.format(qtdRefrigerante())+" Litros de refrigerante", "R$"+formatarFloat.format(precoRefrigerante()), R.drawable.refrigerante);
        itens.add(l);
        l = new Lista("Suco", formatarFloat.format(qtdSuco())+" Listros de suco", "R$"+formatarFloat.format(precoSuco()), R.drawable.suco);
        itens.add(l);
        l = new Lista("Carvao", qtdCarvao()+" Saco de 5kg de carvão.", "R$"+formatarFloat.format(precoCarvao()), R.drawable.carvao);
        itens.add(l);
        l = new Lista("Copos Descartáveis", qtdCopos() + " Copos descartáveis", "R$"+formatarFloat.format(precoCopo()), R.drawable.copo);
        itens.add(l);
        l = new Lista("Talheres", qtdTalher() + " Garfos e Facas", "R$"+formatarFloat.format(precoTalher()), R.drawable.talher);
        itens.add(l);
        l = new Lista("Pratos", qtdPrato()+" Pratos descartáveis", "R$"+formatarFloat.format(precoPrato()), R.drawable.prato);
        itens.add(l);

        return itens;
    }

    private float precoPrato() {
        float qtd = qtdPrato();
        float prc = (float) 0.4;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoTalher() {
        float qtd = qtdTalher();
        float prc = (float) 0.5;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoCopo() {
        float qtd = qtdCopos();
        float prc = (float) 0.45;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoCarvao() {
        float qtd = qtdCarvao();
        float prc = (float) 9.8;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoSuco() {
        float qtd = qtdSuco();
        float prc = (float) 5.5;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoRefrigerante() {
        float qtd = qtdRefrigerante();
        float prc = (float) 6.5;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoCerveja() {
        float qtd = qtdCerveja();
        float prc = (float) 7.5;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoFarofa() {
        float qtd = qtdFarofa();
        float prc = (float) 4.2;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoMolho() {
        float qtd = qtdMolho();
        float prc = (float) 3.8;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoArroz() {
        float qtd = qtdArroz();
        float prc = (float) 3.5;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoPao() {
        float qtd = qtdPao();
        float prc = (float) 0.6;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoLinguica() {
        float qtd = qtdLinguica();
        float prc = (float) 9.5;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoFrango() {
        float qtd = qtdFrango();
        float prc = (float) 4.3;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private float precoCarne() {
        float qtd = qtdCarne();
        float prc = (float) 20.5;
        float total = qtd * prc;
        totalCompras = totalCompras + total;
        return total;
    }

    private int qtdPrato() {
        return (int) (contTotal * 1.5);
    }

    private int qtdTalher() {

        return (int) (contTotal * 1.5);
    }

    private int qtdCopos() {

        return (int) (contTotal * 1.5);
    }

    private float qtdFarofa() {

        return ((contTotal / 5) + 1);
    }

    private float qtdMolho() {
        float h = (float) (contHomem * 0.3);
        float m = (float) (contMulher * 0.2);
        float c = (float) (contCrianca * 0.1);
        return (h + m + c);
    }

    private float qtdArroz() {
        float h = (float) (contHomem * 1.0);
        float m = (float) (contMulher * 0.5);
        float c = (float) (contCrianca * 0.3);
        return (h + m + c);
    }

    private int qtdPao() {

        return (int) (contTotal * 1);
    }

    private float qtdLinguica() {

        float h = (float) (contHomem * 0.1);
        float m = (float) (contMulher * 0.1);
        float c = (float) (contCrianca * 0.1);
        return (h + m + c);

    }

    private float qtdCarne() {
        float h = (float) (contHomem * 0.3);
        float m = (float) (contMulher * 0.2);
        float c = (float) (contCrianca * 0.1);
        return (h + m + c);
    }

    private float qtdFrango() {
        float h = (float) (contHomem * 0.2);
        float m = (float) (contMulher * 0.1);
        float c = (float) (contCrianca * 0.1);
        return (h + m + c);
    }

    private float qtdCerveja() {
        float h = (float) (contHomem * 3);
        float m = (float) (contMulher * 2);
        return (h + m);
    }

    private float qtdRefrigerante() {
        float h = (float) (contHomem * 0.2);
        float m = (float) (contMulher * 0.3);
        float c = (float) (contCrianca * 0.3);
        return (h + m + c);
    }

    private float qtdSuco() {
        float m = (float) (contMulher * 0.3);
        float c = (float) (contCrianca * 0.3);
        return (m + c);
    }

    private float qtdCarvao() {

        return ((contTotal / 10) + 1);
    }

    public void finish() {
        NumberFormat formatarFloat = new DecimalFormat("##.##");
        Intent dados = new Intent();
        dados.putExtra("total", tvTotal.getText().toString());
        dados.putExtra("rateioHomem", String.valueOf(formatarFloat.format(rateioHomem())));
        dados.putExtra("rateioMisto", String.valueOf(formatarFloat.format(rateioMisto())));
        setResult(RESULT_OK, dados);
        super.finish();

    }

}
