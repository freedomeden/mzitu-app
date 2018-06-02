package com.din.mzitudemo.utills;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

import java.util.List;

public class FragmentUtil {

    private Activity activity;
    private List<Fragment> list;
    private int layoutID;

    public FragmentUtil(Activity activity, int layoutID, List<Fragment> list) {
        this.activity = activity;
        this.layoutID = layoutID;
        this.list = list;
    }

    public FragmentUtil addFragment() {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        for (int i = 0; i < list.size(); i++) {
            transaction.add(layoutID, list.get(i));
        }
        transaction.commit();
        return this;
    }

    public FragmentUtil hideFragment() {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isVisible()) {
                transaction.hide(list.get(i));
            }
        }
        transaction.commit();
        return this;
    }

    public FragmentUtil showFragment(Fragment fragment) {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        if (!fragment.isVisible()) {
            transaction.show(fragment);
        }
        transaction.commit();
        return this;
    }
}