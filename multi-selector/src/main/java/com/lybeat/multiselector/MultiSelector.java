package com.lybeat.multiselector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import java.util.List;

/**
 * Author: lybeat
 * Date: 2016/7/28
 */
public class MultiSelector extends FrameLayout implements SelectorAdapter.OnSelectListener {

    public interface OnSelectListener {
        void onSelect(List<String> choices);
    }

    private RecyclerView recyclerView;

    private SelectorAdapter selectorAdapter;
    private MultiSelector.OnSelectListener listener;

    public MultiSelector(Context context) {
        this(context, null);
    }

    public MultiSelector(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiSelector(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.multi_selector, this, true);

        selectorAdapter = new SelectorAdapter(context);
        selectorAdapter.setOnSelectListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.selector_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MultiSelector);
        Drawable selectorBackground = a.getDrawable(R.styleable.MultiSelector_selectorBackground);
        Drawable optionBackground = a.getDrawable(R.styleable.MultiSelector_optionBackground);
        a.recycle();

        recyclerView.setBackground(selectorBackground);
        selectorAdapter.setOptionBackground(optionBackground);
    }

    public void addBaseOptions(List<BaseOption> baseOptions) {
        selectorAdapter.addBaseOptions(baseOptions);
        notifyDataSetChanged();
    }

    public void addBaseOption(BaseOption baseOption) {
        selectorAdapter.addBaseOption(baseOption);
    }

    // If you use addBaseOption, you must use notifyDataSetChanged for recyclerView set adapter.
    public void notifyDataSetChanged() {
        recyclerView.setAdapter(selectorAdapter);
    }

    public void setOnSelectListener(OnSelectListener listener) {
        this.listener = listener;
    }

    public List<String> getChoices() {
        return selectorAdapter.getChoices();
    }

    @Override
    public void onSelect(List<String> choices) {
        if (listener != null) {
            listener.onSelect(choices);
        }
    }
}
