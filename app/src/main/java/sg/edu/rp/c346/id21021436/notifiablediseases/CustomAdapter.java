package sg.edu.rp.c346.id21021436.notifiablediseases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Disease> diseaseArrayList;

    public CustomAdapter(Context context, int resource, ArrayList<Disease> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        diseaseArrayList = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvDiseaseName = rowView.findViewById(R.id.textViewDiseaseName);
        TextView tvNumber = rowView.findViewById(R.id.textViewNumber);

        Disease currentDisease = diseaseArrayList.get(position);
        tvDiseaseName.setText(currentDisease.getDiseaseName());
        tvNumber.setText("Number: " + String.valueOf(currentDisease.getNumber()));

        return rowView;

    }

}
