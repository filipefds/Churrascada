package pooa20171.iff.br.churrascada.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import pooa20171.iff.br.churrascada.R;
import pooa20171.iff.br.churrascada.realm.Evento;
import pooa20171.iff.br.churrascada.view.Main4Activity;

/**
 * Created by filipefds on 22/07/17.
 */

public class ListaAdapter extends ArrayAdapter<Lista> {

    private Context context;
    private ArrayList<Lista> itens;

    public ListaAdapter(Context context, ArrayList<Lista> itens) {
        super(context, R.layout.linha, itens);
        this.context = context;
        this.itens = itens;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView titulo = (TextView) rowView.findViewById(R.id.titulo);
        TextView subTitulo = (TextView) rowView.findViewById(R.id.subTitulo);
        TextView preco = (TextView) rowView.findViewById(R.id.preco);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);

        titulo.setText(itens.get(position).getTitulo());
        subTitulo.setText(itens.get(position).getSubTitulo());
        preco.setText(itens.get(position).getPreco());
        imagem.setImageResource(itens.get(position).getImagem());

        return rowView;
    }

}
