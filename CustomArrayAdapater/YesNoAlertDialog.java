        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Confirm?");
        b.setMessage("Are you sure?");
        b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(), "Clicked yes!", Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });
        b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(), "Clicked no!", Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });

        AlertDialog alert = b.create();
        alert.show();