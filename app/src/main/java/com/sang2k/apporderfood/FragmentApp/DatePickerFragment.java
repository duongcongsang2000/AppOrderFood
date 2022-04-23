package com.sang2k.apporderfood.FragmentApp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


import com.sang2k.apporderfood.R;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendar=Calendar.getInstance();
        int nam=calendar.get(Calendar.YEAR);
        int thangg=calendar.get(Calendar.MONTH);
        int ngayy=calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,ngayy,thangg,nam);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayy) {
        EditText edNgay=getActivity().findViewById(R.id.ngaysinhdk);
        String NgaySinh  =dayy+"/"+(month+1)+"/"+year;
        edNgay.setText(NgaySinh);
    }

}
