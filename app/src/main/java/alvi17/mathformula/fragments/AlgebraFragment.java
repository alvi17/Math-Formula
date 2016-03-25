package alvi17.mathformula.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alvi17.mathformula.R;

/**
 * Created by Alvi17 on 6/26/2015.
 */
public class AlgebraFragment extends Fragment{
    public AlgebraFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.algebra_set_fragment, container, false);

        return rootView;
    }
}
