package com.jck.sorteadorpararpgs;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Sorteador_Activity extends AppCompatActivity {

    //SharedPreferences.Editor preferencesEditor;
    TextView historico[];
    ArrayList<int[]> historicoNum;
    Dialog popup;
    int numero;
    TextView numPers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteador);
        atualizarBarra();

        popup = new Dialog(this);
        historico = new TextView[10];
        numero = getSharedPreferences("numero", MODE_PRIVATE).getInt("sorteador", 2);
        historicoNum = new ArrayList<>();

        historico[0] = findViewById(R.id.historico10);
        historico[1] = findViewById(R.id.historico9);
        historico[2] = findViewById(R.id.historico8);
        historico[3] = findViewById(R.id.historico7);
        historico[4] = findViewById(R.id.historico6);
        historico[5] = findViewById(R.id.historico5);
        historico[6] = findViewById(R.id.historico4);
        historico[7] = findViewById(R.id.historico3);
        historico[8] = findViewById(R.id.historico2);
        historico[9] = findViewById(R.id.historico1);

        numPers = findViewById(R.id.numPers);
        numPers.setText("" + numero);
        int tmp[] = {-1,-1};
        for (int i = 0  ; i <10 ; i++){
            historicoNum.add(tmp);
            historico[i].setVisibility(View.INVISIBLE);
        }


        atualizarHistorico();

    }
    public void atualizarBarra(){
        TextView t = findViewById(R.id.atributo_barra_superior_experiencia);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("experiencia", 0));
        t = findViewById(R.id.atributo_barra_superior_dinheiro);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("dinheiro", 0));
        t = findViewById(R.id.atributo_barra_superior_mana_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_atual", 0));
        t = findViewById(R.id.atributo_barra_superior_vida_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0));
    }

    public void atualizarHistorico(){
        for (int i = historico.length - 1; i >= 0 ; i -- ){
            if(historicoNum.get(i)[0] <= 0){
                historico[i].setText("");
            }else{
                historico[i].setVisibility(View.VISIBLE);
                historico[i].setText("" + historicoNum.get(i)[0] + " - D" + historicoNum.get(i)[1]);
            }

        }
    }

    public void novo(View view){
        int numero2 = 2;
        try {
            EditText e = findViewById(R.id.editTextNumber);
            numero2 = Integer.parseInt(e.getText() + "");

        } catch (NumberFormatException e ){
        }
        if(numero != numero2){
            numero = numero2;
            View view2 = this.getCurrentFocus();
            if (view2 != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view2.getWindowToken(), 0);
            }
            numPers.setText(""+ numero);
            SharedPreferences.Editor preferencesEditor = getSharedPreferences("numero", MODE_PRIVATE).edit();
            preferencesEditor.putInt("sorteador",numero);
            preferencesEditor.commit();
        }
    }

    public void popUpDice(int valorReferencia){

        int numero = (new Random().nextInt(valorReferencia) + 1);
        popup.setContentView(R.layout.popup_dice);

        TextView sorteado = popup.findViewById(R.id.numeroSorteado);
        TextView dado = popup.findViewById(R.id.numerodado);

        sorteado.setText(numero + "");
        dado.setText("D" + valorReferencia);

        int tmp[] = {numero, valorReferencia};
        historicoNum.add(tmp);
        historicoNum.remove(0);
        atualizarHistorico();

        Button b = popup.findViewById(R.id.botaofechar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });
        popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popup.show();
    }


    //public void op2(View view){ popUpDice(2);}
    public void op3(View view){ popUpDice(3);}
    public void op4(View view){ popUpDice(4);}
    public void op6(View view){ popUpDice(6);}
    public void op8(View view){ popUpDice(8);}
    public void op10(View view){ popUpDice(10);}
    public void op12(View view){ popUpDice(12);}
    public void op20(View view){ popUpDice(20);}
    public void op30(View view){ popUpDice(30);}
    public void op100(View view){ popUpDice(100);}
    public void opPers(View view){ popUpDice(numero);}
}
