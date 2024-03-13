package com.example.find_yourself;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<String> strings;
    TextAdapter(Context context, ArrayList<String> strings)
    {
        this.inflater = LayoutInflater.from(context);
        this.strings = strings;
    }

    @Override
    public TextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.about_app_text, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(TextAdapter.ViewHolder holder, int position) {
        String str = strings.get(position);
        holder.textView.setText(str);
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        public ViewHolder(View itemView)
        {
            super(itemView);
            textView = itemView.findViewById(R.id.about_tv_id);
        }
    }
}
