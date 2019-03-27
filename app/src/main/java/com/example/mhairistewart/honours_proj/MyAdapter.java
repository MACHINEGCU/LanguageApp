package com.example.mhairistewart.honours_proj;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

import model.Answer;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Answer> myDataset;
    private Context context;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public TextView subTextView;
        public RelativeLayout parentLayout;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.title);
            subTextView = v.findViewById(R.id.subtitle);

            parentLayout = v.findViewById(R.id.parent_layout);
        }
    }

    public MyAdapter(List<Answer> myDataset, Context context) {
        this.myDataset = myDataset;
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

        Answer answerPosition = myDataset.get(position);

        holder.subTextView.setText(answerPosition.getSubTitle());
        holder.textView.setText(answerPosition.getAnswerDescription());
        
    }

    @Override
    public int getItemCount() {
        return myDataset.size();
    }
}