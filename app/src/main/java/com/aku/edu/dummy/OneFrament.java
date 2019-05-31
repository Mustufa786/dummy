package com.aku.edu.dummy;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aku.edu.dummy.callbacks.Callbacks;
import com.aku.edu.dummy.databinding.FragmentOneFramentBinding;
import com.aku.edu.dummy.validator.validatorClass;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFrament extends Fragment {

    Callbacks callbacks;
    FragmentOneFramentBinding bi;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater,R.layout.fragment_one_frament,container,false);


        return bi.getRoot();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callbacks = (Callbacks) context;
    }

    public boolean formValidation(){

        return validatorClass.EmptyCheckingContainer(getContext(),bi.layout1);
    }
}
