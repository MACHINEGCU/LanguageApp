package com.example.mhairistewart.honours_proj;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> mDataset;
    private Context context;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public RelativeLayout parentLayout;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.title);
            parentLayout = v.findViewById(R.id.parent_layout);
        }
    }

    public MyAdapter(List<String> myDataset, Context context) {
        this.mDataset = myDataset;
        this.context = context;

    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View answerView = layoutInflater.inflate(R.layout.row_layout, parent, false);

        MyViewHolder viewHolders = new MyViewHolder(answerView);

        return viewHolders;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String s = mDataset.get(position);
        TextView textView = holder.textView;
        textView.setText(s);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}