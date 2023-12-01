package com.example.jucseroutinery;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentFragment extends Fragment {
    private String selectedOption = "";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StudentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentFragment newInstance(String param1, String param2) {
        StudentFragment fragment = new StudentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        View view = inflater.inflate(R.layout.fragment_student, container, false);

        Spinner spinnerYear = view.findViewById(R.id.spinnerYear);
        Button btnInfo= view.findViewById(R.id.btnInfo);
        view.findViewById(R.id.txtViewRoutine).setOnClickListener(this::openTargetActivity);


        String[] yearSemesterOptions = {"1st Year 1st Semester", "2nd Year 1st Semester", "3rd Year 1st Semester", "4th Year 1st Semester", "MSc 1st Semester"};

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(getActivity(), R.layout.custom_spinner_item, yearSemesterOptions);
        // Set the adapter for the Spinner
        spinnerYear.setAdapter(adapter);



        // Attach an OnItemSelectedListener to the Spinner
        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Get the selected item from the Spinner
                selectedOption = (String) parentView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case when nothing is selected
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
        return view;
    }

    void checkDataEntered() {


        if(selectedOption.toString().equals("1st Year 1st Semester") ){

            Intent intent = new Intent(getActivity(), WholeRoutine_1_1_Activity.class);
            startActivity(intent);
        }
        else if(selectedOption.toString().equals("2nd Year 1st Semester") ){

            Intent intent = new Intent(getActivity(), WholeRoutine_2_1_Activity.class);
            startActivity(intent);
        }

        else if(selectedOption.toString().equals("3rd Year 1st Semester") ){

            Intent intent = new Intent(getActivity(), WholeRoutine_3_1_Activity.class);
            startActivity(intent);
        }
        else if(selectedOption.toString().equals("4th Year 1st Semester") ){

            Intent intent = new Intent(getActivity(), BatchRoutineActivity2.class);
            startActivity(intent);
        }


    }


    public void openTargetActivity(View view) {
        Intent intent = new Intent(getActivity(), WholeRoutine.class);
        startActivity(intent);
    }

}