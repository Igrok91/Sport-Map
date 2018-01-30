package com.map.sport.sportmap.view.controller.create.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.map.sport.sportmap.R;
import com.map.sport.sportmap.view.controller.create.CreateActivity;

/**
 * Created by igrok on 29.01.18.
 */

public class CreateDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите место события")
                .setItems(R.array.playground_subscribe, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        Intent intent = new Intent(getActivity(), CreateActivity.class);
                        startActivity(intent);

                    }
                });
        return builder.create();
    }
}
