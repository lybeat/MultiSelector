package com.lybeat.multiselector;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lybeat
 * Date: 2016/7/28
 */
public class SelectorAdapter extends RecyclerView.Adapter<SelectorAdapter.SelectorHolder> implements
        OptionAdapter.OnOptionListener {

    public interface OnSelectListener {
        void onSelect(List<String> choices);
    }

    private Context context;
    private List<BaseOption> multiOptions;
    private OnSelectListener listener;
    private Drawable optionBackground;

    public SelectorAdapter(Context context) {
        this.context = context;
        multiOptions = new ArrayList<>();
    }

    @Override
    public SelectorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_selector, parent, false);
        return new SelectorHolder(view);
    }

    @Override
    public void onBindViewHolder(SelectorHolder holder, int position) {
        OptionAdapter adapter = new OptionAdapter(context, multiOptions.get(position));
        adapter.setOnSelectListener(this);
        adapter.setBackground(optionBackground);
        holder.optionRecycler.setLayoutManager(new LinearLayoutManager(
                context, LinearLayoutManager.HORIZONTAL, false));
        holder.optionRecycler.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return multiOptions.size();
    }

    public void addBaseOption(BaseOption baseOption) {
        multiOptions.add(baseOption);
        notifyDataSetChanged();
    }

    public void addBaseOptions(List<BaseOption> baseOptions) {
        multiOptions.addAll(baseOptions);
        notifyDataSetChanged();
    }

    public BaseOption getOptions(int position) {
        return multiOptions.get(position);
    }

    public void setOnSelectListener(OnSelectListener listener) {
        this.listener = listener;
    }

    public void setOptionBackground(Drawable drawable) {
        this.optionBackground = drawable;
    }

    @Override
    public void onOption() {
        if (listener != null) {
            listener.onSelect(getChoices());
        }
    }

    public List<String> getChoices() {
        List<String> choices = new ArrayList<>();
        for (int i = 0; i < multiOptions.size(); i++) {
            choices.add(multiOptions.get(i).getOptions().get(multiOptions.get(i).getIndex()));
        }
        return choices;
    }

    public class SelectorHolder extends RecyclerView.ViewHolder {

        RecyclerView optionRecycler;

        public SelectorHolder(View itemView) {
            super(itemView);
            optionRecycler = (RecyclerView) itemView.findViewById(R.id.option_recycler);
        }
    }
}
