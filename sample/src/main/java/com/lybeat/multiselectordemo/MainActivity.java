package com.lybeat.multiselectordemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lybeat.multiselector.BaseOption;
import com.lybeat.multiselector.MultiSelector;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MultiSelector.OnSelectListener {

    private static final String TAG = "MainActivity";

    private TextView choicesTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<BaseOption> baseOptions = initData();

        MultiSelector multiSelector = (MultiSelector) findViewById(R.id.multi_selector);
        multiSelector.addBaseOptions(baseOptions);
        multiSelector.setOnSelectListener(this);

        choicesTxt = (TextView) findViewById(R.id.choices_txt);
        onSelect(multiSelector.getChoices());
    }

    @NonNull
    private List<BaseOption> initData() {
        List<String> options1 = new ArrayList<>();
        options1.add("全部");
        options1.add("TV版");
        options1.add("OVA.OAD");
        options1.add("剧场版");
        BaseOption baseOption1 = new BaseOption();
        baseOption1.options(options1).select(0);

        List<String> options2 = new ArrayList<>();
        options2.add("全部");
        options2.add("日本");
        options2.add("大陆");
        options2.add("其他");
        BaseOption baseOption2 = new BaseOption();
        baseOption2.options(options2).select(0);

        List<String> options3 = new ArrayList<>();
        options3.add("全部");
        options3.add("热血");
        options3.add("科幻");
        options3.add("神魔");
        options3.add("机战");
        options3.add("轻改");
        options3.add("后宫");
        options3.add("推理");
        options3.add("日常");
        options3.add("神OP");
        options3.add("神ED");
        options3.add("萌萌哒");
        options3.add("百合");
        options3.add("伪娘");
        options3.add("催泪");
        options3.add("治愈");
        options3.add("爱抖露");
        options3.add("马猴烧酒");
        options3.add("萝莉");
        BaseOption baseOption3 = new BaseOption();
        baseOption3.options(options3).select(0);

        List<String> options4 = new ArrayList<>();
        options4.add("全部");
        options4.add("完结");
        options4.add("连载");
        BaseOption baseOption4 = new BaseOption();
        baseOption4.options(options4).select(0);

        List<String> options5 = new ArrayList<>();
        options5.add("全部");
        options5.add("1月");
        options5.add("4月");
        options5.add("7月");
        options5.add("10月");
        BaseOption baseOption5 = new BaseOption();
        baseOption5.options(options5).select(0);

        List<String> options6 = new ArrayList<>();
        options6.add("全部");
        options6.add("2016");
        options6.add("2015");
        options6.add("2014");
        options6.add("2013");
        options6.add("2012");
        options6.add("2011");
        options6.add("2010");
        options6.add("2009");
        options6.add("2008");
        options6.add("2007");
        options6.add("2006");
        options6.add("2005");
        options6.add("2004");
        options6.add("2003");
        options6.add("2002");
        options6.add("2001");
        options6.add("2000");
        options6.add("更早之前");
        BaseOption baseOption6 = new BaseOption();
        baseOption6.options(options6).select(0);

        List<BaseOption> baseOptions = new ArrayList<>();
        baseOptions.add(baseOption1);
        baseOptions.add(baseOption2);
        baseOptions.add(baseOption3);
        baseOptions.add(baseOption4);
        baseOptions.add(baseOption5);
        baseOptions.add(baseOption6);
        return baseOptions;
    }

    @Override
    public void onSelect(List<String> choices) {
        StringBuilder sb = new StringBuilder();
        for (String choice : choices) {
            sb.append(choice);
            sb.append(", ");
        }
        choicesTxt.setText(sb.toString());
    }
}
