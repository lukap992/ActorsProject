package com.example.actorsproject.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

public class AboutDialog extends AlertDialog.Builder {

    public AboutDialog(Context context) {
        super(context);

        setTitle("About Application");
        setMessage("Here we store informations about most popular ACTORS. Do You like the application?");
        setCancelable(false);

        setPositiveButton("Yes i do", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(getContext(), "Thank you", Toast.LENGTH_LONG).show();
            }
        });
        setNegativeButton("No i don't.", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(getContext(), "Fuck you", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public AlertDialog prepareDialog(){

        AlertDialog alertDialog = create();
        alertDialog.setCanceledOnTouchOutside(false);
        return alertDialog;
    }
}
