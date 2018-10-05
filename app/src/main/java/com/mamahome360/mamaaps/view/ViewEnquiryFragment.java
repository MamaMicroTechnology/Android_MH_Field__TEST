package com.mamahome360.mamaaps.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mamahome360.mamaaps.R;
public class ViewEnquiryFragment extends Fragment {
    View enquiryView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       enquiryView = inflater.inflate(R.layout.view_enquiry_fragment,container,false);
       return enquiryView;

        }
}
