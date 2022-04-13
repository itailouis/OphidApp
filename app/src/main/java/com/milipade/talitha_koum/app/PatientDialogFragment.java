package com.milipade.talitha_koum.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import com.milipade.talitha_koum.app.data.Patient;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PatientDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PatientDialogFragment extends DialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PatientDialogFragment() {
        // Required empty public constructor
    }


    public static PatientDialogFragment newInstance() {
        PatientDialogFragment fragment = new PatientDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_patient_dialog, container, false);
        (rootView.findViewById(R.id.button_close)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            dismiss();
            }

        });
        EditText name = rootView.findViewById(R.id.patient_name);

        RadioButton maleRadioButton = rootView.findViewById(R.id.male_gander);
        RadioButton femaleRadioButton = rootView.findViewById(R.id.female_gander);



        (rootView.findViewById(R.id.button_save)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Patient patient = new Patient();
                patient.setDateOfBirth(new Date());
                patient.setGender(femaleRadioButton.isChecked() ?"Female":"Male");
                patient.setName(name.getText().toString());
                mListener.onFragmentInteraction(patient);
                dismiss();
            }

        });


        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }


    interface OnFragmentInteractionListener {
        void onFragmentInteraction(Patient patient);
    }
}
