package com.lybeat.multiselector;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Author: lybeat
 * Date: 2016/7/28
 */
public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.OptionHolder> {

    public interface OnOptionListener {
        void onOption();
    }

    private Context context;
    private BaseOption options;
    private OnOptionListener listener;
    private Drawable background;

    public OptionAdapter(Context context, BaseOption options) {
        this.context = context;
        this.options = options;
    }

    @Override
    public OptionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_option, parent, false);
        return new OptionHolder(view);
    }

    @Override
    public void onBindViewHolder(final OptionHolder holder, final int position) {
        holder.optionTxt.setText(options.getOptions().get(position));
        if (position == options.getIndex()) {
            if (background != null) {
                holder.optionTxt.setBackground(background);
            } else {
                holder.optionTxt.setBackgroundResource(R.drawable.bg_item_option_pressed);
            }
        } else {
            holder.optionTxt.setBackground(null);
        }

        holder.optionTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                options.select(position);
                if (listener != null) {
                    listener.onOption();
                }

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return options.getOptions().size();
    }

    public void setOnSelectListener(OnOptionListener listener) {
        this.listener = listener;
    }
    public void setBackground(Drawable background) {
        this.background = background;
    }

    public class OptionHolder extends RecyclerView.ViewHolder {

        TextView optionTxt;

        public OptionHolder(View itemView) {
            super(itemView);
            optionTxt = (TextView) itemView.findViewById(R.id.option_txt);
        }
    }
}
