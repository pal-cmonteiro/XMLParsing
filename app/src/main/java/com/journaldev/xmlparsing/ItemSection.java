package com.journaldev.xmlparsing;

import android.support.annotation.IntDef;
import android.widget.LinearLayout;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class ItemSection<T> extends Section {

    private int mLayout;

    @IntDef({LinearLayout.HORIZONTAL, LinearLayout.VERTICAL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SectionLayout {}

    private List<T> mItems;

    ItemSection(String title, String subtitle, int layout, List<T> items) {
        super(title, subtitle);
        mLayout = layout;
        mItems = items;
    }

    public int getLayout() {
        return mLayout;
    }

    public String getLayoutString() {
        return mLayout == 1 ? "Vertical" : "Horizontal";
    }

    public void setLayout(@SectionLayout int layout) {
        mLayout = layout;
    }

    public List<T> getItems() {
        return mItems;
    }

    public void setItems(List<T> items) {
        mItems = items;
    }
}
