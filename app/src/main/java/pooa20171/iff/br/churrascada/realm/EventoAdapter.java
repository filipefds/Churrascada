package pooa20171.iff.br.churrascada.realm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import pooa20171.iff.br.churrascada.R;

/**
 * Created by filipefds on 02/09/17.
 */

public class EventoAdapter extends ArrayAdapter<Evento> {


    private Context context;
    private List<Evento> itens;

    public EventoAdapter(Context context, List<Evento> itens) {
        super(context, R.layout.evento, itens);
        this.context = context;
        this.itens = itens;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.evento, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.tvEvento);
        nome.setText(itens.get(position).getNomeEvento());

        return rowView;
    }


}
