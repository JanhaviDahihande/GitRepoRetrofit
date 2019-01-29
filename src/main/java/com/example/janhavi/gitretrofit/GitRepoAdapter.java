package com.example.janhavi.gitretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class GitRepoAdapter extends ArrayAdapter<GitRepo> {

    private Context context;
    private List<GitRepo> values;

    public GitRepoAdapter(Context context, List<GitRepo> values) {
        super(context, R.layout.list_item, values);

        this.context = context;
        this.values = values;
    }


    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.list_item, parent, false);
        }

        TextView textView = row.findViewById(R.id.textView);

        GitRepo gitRepo = values.get(position);
        String message = gitRepo.getName();

        textView.setText(message);

        return row;
    }
}
