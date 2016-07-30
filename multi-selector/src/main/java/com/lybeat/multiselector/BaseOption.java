package com.lybeat.multiselector;

import java.util.List;

/**
 * Author: lybeat
 * Date: 2016/7/28
 */
public class BaseOption {

    private List<String> options;
    private int index;

    public BaseOption options(List<String> options) {
        this.options = options;
        return this;
    }

    public BaseOption select(int index) {
        if (options == null || options.isEmpty()) {
            throw new ExceptionInInitializerError("The \"options is empty\"");
        }
        if (index < 0 || index > options.size()) {
            this.index = 0;
        } else {
            this.index = index;
        }
        return this;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getIndex() {
        return index;
    }
}
