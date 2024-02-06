package com.example.findtoeat;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment {
    private EditText editTextName;
    private EditText editTextCompanyName;
    private EditText editTextCarbohydrates;
    private EditText editTextFats;
    private EditText editTextKiloCalories;
    private EditText editTextProteins;
    private DialogListener listener;
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog, null);

        builder.setView(view)
                .setTitle("Czego szukasz?")
                .setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Szukaj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name = editTextName.getText().toString();
                        String companyName = editTextCompanyName.getText().toString();
                        int kiloCalories = Integer.parseInt(editTextKiloCalories.getText().toString());
                        int carbohydrates = Integer.parseInt(editTextCarbohydrates.getText().toString());
                        int fats = Integer.parseInt(editTextFats.getText().toString());
                        int proteins = Integer.parseInt(editTextProteins.getText().toString());
                        listener.applySearch(name,companyName, kiloCalories, carbohydrates, fats, proteins);

                    }
                });
        editTextName = view.findViewById(R.id.editName);
        editTextCompanyName = view.findViewById(R.id.editCompanyName);
        editTextCarbohydrates = view.findViewById(R.id.editCarbohydrates);
        editTextFats = view.findViewById(R.id.editFats);
        editTextProteins = view.findViewById(R.id.editProteins);
        editTextKiloCalories = view.findViewById(R.id.editKiloCalories);

        return builder.create();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (DialogListener) context;

        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "implement listener");
        }
    }

    public interface DialogListener{
        void applySearch(String name, String companyName, int kiloCalories, int carbohydrates, int fats, int proteins);
    }
}
