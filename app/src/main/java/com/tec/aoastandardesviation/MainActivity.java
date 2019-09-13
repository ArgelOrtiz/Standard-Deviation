package com.tec.aoastandardesviation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    protected void initComponents(){
        final EditText firstEditText      = findViewById(R.id.firstMainEditText);
        final EditText secondEditText     = findViewById(R.id.secondMainEditText);
        final EditText thirdEditText      = findViewById(R.id.thirdMainEditText);
        final EditText fourthEditText     = findViewById(R.id.fourthMainEditText);
        final EditText fifthEditText      = findViewById(R.id.fifthMainEditText);
        final EditText sixthEditText      = findViewById(R.id.sixthMainEditText);
        final EditText seventhEditText    = findViewById(R.id.seventhMainEditText);
        final EditText eighthEditText     = findViewById(R.id.eighthMainEditText);
        final EditText ninthEditText      = findViewById(R.id.ninthMainEditText);
        final EditText tenthEditText      = findViewById(R.id.tenthMainEditText);
        Button calculateButton      = findViewById(R.id.calculateMainButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double [] numbers   = new double[10];

                String first    = firstEditText.getText().toString();
                String second   = secondEditText.getText().toString();
                String third    = thirdEditText.getText().toString();
                String fourth   = fourthEditText.getText().toString();
                String fifth    = fifthEditText.getText().toString();
                String sixth    = sixthEditText.getText().toString();
                String seventh  = seventhEditText.getText().toString();
                String eighth   = eighthEditText.getText().toString();
                String ninth    = ninthEditText.getText().toString();
                String tenth    = tenthEditText.getText().toString();

                if (first.isEmpty()){
                    Snackbar.make(v,"Ingrese el primer numero",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (second.isEmpty()){
                    Snackbar.make(v,"Ingrese el segundo numero",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (third.isEmpty()){
                    Snackbar.make(v,"Ingrese el tercero numero",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (fourth.isEmpty()){
                    Snackbar.make(v,"Ingrese el cuarto numero",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (fifth.isEmpty()){
                    Snackbar.make(v,"Ingrese el quinto numero",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (sixth.isEmpty()){
                    Snackbar.make(v,"Ingrese el sexto numero",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (seventh.isEmpty()){
                    Snackbar.make(v,"Ingrese el septimo numero",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (eighth.isEmpty()){
                    Snackbar.make(v,"Ingrese el octavo numero",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (ninth.isEmpty()){
                    Snackbar.make(v,"Ingrese el noveno numero",Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (tenth.isEmpty()){
                    Snackbar.make(v,"Ingrese el decimo numero",Snackbar.LENGTH_LONG).show();
                    return;
                }

                try {

                    numbers[0]  = Double.parseDouble(first);
                    numbers[1]  = Double.parseDouble(second);
                    numbers[2]  = Double.parseDouble(third);
                    numbers[3]  = Double.parseDouble(fourth);
                    numbers[4]  = Double.parseDouble(fifth);
                    numbers[5]  = Double.parseDouble(sixth);
                    numbers[6]  = Double.parseDouble(seventh);
                    numbers[7]  = Double.parseDouble(eighth);
                    numbers[8]  = Double.parseDouble(ninth);
                    numbers[9]  = Double.parseDouble(tenth);

                    standarDesviation(numbers, v);

                }catch (NumberFormatException numberFormatException){
                    Log.e("MainActivity",numberFormatException.getMessage());
                    Snackbar.make(v,"Ocurrio un error al calcular la desviacion",Snackbar.LENGTH_LONG).show();
                }

            }
        });
    }

    protected void standarDesviation(double [] numbers, View view) throws NumberFormatException{
        double x_;
        double ds;

        double x_aux    = 0;
        for (double currentNumber:numbers) {
            x_aux = x_aux+currentNumber;
        }

        x_ = (0.1)*(x_aux);

        double sum  = 0;
        for (int i=0; i<numbers.length; i++){
            sum = sum + Math.pow((numbers[i]- x_),2);
        }

        ds = 0.1111*sum;

        ds = Math.sqrt(ds);

        Snackbar.make(view,"La SD es: "+ds,Snackbar.LENGTH_LONG).show();
    }
}
