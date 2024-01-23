package com.jck.sorteadorpararpgs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Atributos_Activity extends AppCompatActivity {

SharedPreferences.Editor preferencesEditor;
EditText textoReferencia;
int valor_referencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atributos);

        preferencesEditor = getSharedPreferences("atributos", MODE_PRIVATE).edit();
        textoReferencia = findViewById(R.id.textoReferencia);
        valor_referencia = 1;

        atualizarBarra();
        //atualizarInterface();
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
        t = findViewById(R.id.atributo_experiencia);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("experiencia", 0));
        t = findViewById(R.id.atributo_vida_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0));
        t = findViewById(R.id.atributo_dinheiro);
        t.setText("$ " + getSharedPreferences("atributos", MODE_PRIVATE).getInt("dinheiro", 0));
        t = findViewById(R.id.atributo_mana_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_atual", 0));
        t = findViewById(R.id.atributo_sanidade_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_atual", 0));
    }


    @Override
    protected void onResume() {
        super.onResume();
        atualizarBarra();
    }

    public void alterarValorReferencia(View view){
        int valor_referencia2 = 0;
        try{
            valor_referencia2 = Integer.parseInt(textoReferencia.getText() + "");
        }catch (NumberFormatException e){
            valor_referencia2 = 0;
        }
        if(valor_referencia2 != valor_referencia){
            View view2 = this.getCurrentFocus();
            if (view2 != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view2.getWindowToken(), 0);
            }
            valor_referencia = valor_referencia2;
        }
    }

    public void incrementar_experiencia(View view){ editar_experiencia(true);}
    public void incrementar_dinheiro(View view){ editar_dinheiro(true);}
    public void incrementar_mana_atual(View view){ editar_mana_atual(true);}
    public void incrementar_vida_atual(View view){ editar_vida_atual(true);}
    public void incrementar_sanidade_atual(View view){ editar_sanidade_atual(true);}



    public void decrementar_experiencia(View view){ editar_experiencia(false);}
    public void decrementar_dinheiro(View view){ editar_dinheiro(false);}
    public void decrementar_mana_atual(View view){ editar_mana_atual(false);}
    public void decrementar_vida_atual(View view){ editar_vida_atual(false);}
    public void decrementar_sanidade_atual(View view){ editar_sanidade_atual(false);}

    public void editar_sanidade_atual(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_atual", 0);
        if(incrementar) {
            numero += valor_referencia;
        }else{
            numero -= valor_referencia;
        }
        if(numero < getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_minima", 0)){
            numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_minima", 0);
        }else if(numero > getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_maxima", 0)){
            numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_maxima", 0);
        }
        preferencesEditor.putInt("sanidade_atual", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_sanidade_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_atual", 0));
    }

    public void editar_experiencia(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("experiencia", 0);
        if(incrementar) {
            numero += valor_referencia;
        }else{
            numero -= valor_referencia;
        }
        if(numero < 0){
            numero = 0;
        }
        preferencesEditor.putInt("experiencia", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_experiencia);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("experiencia", 0));
        t = findViewById(R.id.atributo_barra_superior_experiencia);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("experiencia", 0));
    }
    public void editar_dinheiro(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("dinheiro", 0);
        if(incrementar) {
            numero += valor_referencia;
        }else{
            numero -= valor_referencia;
        }
        preferencesEditor.putInt("dinheiro", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_dinheiro);
        t.setText("$ " + getSharedPreferences("atributos", MODE_PRIVATE).getInt("dinheiro", 0));
        t = findViewById(R.id.atributo_barra_superior_dinheiro);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("dinheiro", 0));
    }
    public void editar_mana_atual(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_atual", 0);
        if(incrementar) {
            numero += valor_referencia;
        }else{
            numero -= valor_referencia;
        }
        if(numero < 0){
            numero = 0;
        }if(numero > getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_maxima", 0)){
            numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_maxima", 0);
        }
        preferencesEditor.putInt("mana_atual", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_mana_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_atual", 0));
        t = findViewById(R.id.atributo_barra_superior_mana_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_atual", 0));
    }
    public void editar_vida_atual(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0);
        if(incrementar) {
            numero += valor_referencia;
        }else{
            numero -= valor_referencia;
        }
        if(numero < 0){
            numero = 0;
        }
        if(numero > getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_maxima", 0)){
            numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_maxima", 0);
        }
        preferencesEditor.putInt("vida_atual", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_vida_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0));
        t = findViewById(R.id.atributo_barra_superior_vida_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0));
    }

    public void trocarRef(int valor){
        valor_referencia = valor;
        textoReferencia.setText("" + valor_referencia);
    }
    public void ref1(View view){
        trocarRef(1);
    }
    public void ref10(View view){
        trocarRef(10);
    }
    public void ref50(View view){
        trocarRef(50);
    }
    public void ref100(View view){
        trocarRef(100);
    }
    public void ref1000(View view){
        trocarRef(1000);
    }


}
