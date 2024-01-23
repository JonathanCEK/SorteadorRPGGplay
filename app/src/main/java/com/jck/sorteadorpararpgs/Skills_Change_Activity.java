package com.jck.sorteadorpararpgs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


    /*
    ATRIBUTOS
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("experiencia", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("dinheiro", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_maxima", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_atual", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_maxima", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("destreza", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("inteligencia", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("força", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("carisma", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill2", 0)
    getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill3", 0)
     */
    //botoes[] = viewFrag.findViewById(R.id.op3);

public class Skills_Change_Activity extends AppCompatActivity {

    SharedPreferences.Editor preferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);


        preferencesEditor = getSharedPreferences("atributos", MODE_PRIVATE).edit();

        atualizarBarra();
        atualizarInterface();

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
        t = findViewById(R.id.atributo_skill1_nome);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getString("skill1_nome", "Skill 1"));
        t = findViewById(R.id.atributo_skill2_nome);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getString("skill2_nome", "Skill 2"));
        t = findViewById(R.id.atributo_skill3_nome);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getString("skill3_nome", "Skill 3"));
    }

    public void atualizarInterface(){
        TextView t = findViewById(R.id.atributo_mana_maxima);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_maxima", 0));
        t = findViewById(R.id.atributo_vida_maxima);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_maxima", 0));
        t = findViewById(R.id.atributo_carisma);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("carisma", 0));
        t = findViewById(R.id.atributo_inteligencia);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("inteligencia", 0));
        t = findViewById(R.id.atributo_constituição);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("constituição", 0));
        t = findViewById(R.id.atributo_destreza);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("destreza", 0));
        t = findViewById(R.id.atributo_força);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("força", 0));
        t = findViewById(R.id.atributo_skill1);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1", 0));
        t = findViewById(R.id.atributo_skill2);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill2", 0));
        t = findViewById(R.id.atributo_skill3);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill3", 0));
        t = findViewById(R.id.atributo_sorte);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sorte", 0));
        t = findViewById(R.id.atributo_sanidade_maxima);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_maxima", 0));
    }

    public void incrementar_mana_maxima(View view){ editar_mana_maxima(true);}
    public void incrementar_vida_maxima(View view){ editar_vida_maxima(true);}
    public void incrementar_carisma(View view){ editar_carisma(true);}
    public void incrementar_inteligencia(View view){ editar_inteligencia(true);}
    public void incrementar_destreza(View view){ editar_destreza(true);}
    public void incrementar_força(View view){ editar_força(true);}
    public void incrementar_constituição(View view){ editar_constituição(true);}
    public void incrementar_skill1(View view){ editar_skill1(true);}
    public void incrementar_skill2(View view){ editar_skill2(true);}
    public void incrementar_skill3(View view){ editar_skill3(true);}
    public void incrementar_sorte(View view){ editar_sorte(true);}
    public void incrementar_sanidade_maxima(View view){ editar_sanidade_maxima(true);}

    public void decrementar_mana_maxima(View view){ editar_mana_maxima(false);}
    public void decrementar_vida_maxima(View view){ editar_vida_maxima(false);}
    public void decrementar_carisma(View view){ editar_carisma(false);}
    public void decrementar_inteligencia(View view){ editar_inteligencia(false);}
    public void decrementar_destreza(View view){ editar_destreza(false);}
    public void decrementar_força(View view){ editar_força(false);}
    public void decrementar_constituição(View view){ editar_constituição(false);}
    public void decrementar_skill1(View view){ editar_skill1(false);}
    public void decrementar_skill2(View view){ editar_skill2(false);}
    public void decrementar_skill3(View view){ editar_skill3(false);}
    public void decrementar_sorte(View view){ editar_sorte(false);}
    public void decrementar_sanidade_maxima(View view){ editar_sanidade_maxima(false);}



    public void editar_sanidade_maxima(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_maxima", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }if(numero < getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_minima", 30)){
            numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_minima", 30);
        }
        preferencesEditor.putInt("sanidade_maxima", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_sanidade_maxima);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_maxima", 0));
    }

    public void editar_sorte(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("sorte", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }if(numero < 0){
            numero = 0;
        }
        preferencesEditor.putInt("sorte", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_sorte);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sorte", 0));
    }

    public void editar_constituição(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("constituição", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }
        preferencesEditor.putInt("constituição", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_constituição);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("constituição", 0));
    }

    public void editar_mana_maxima(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_maxima", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }if(numero < 0){
            numero = 0;
        }
        preferencesEditor.putInt("mana_maxima", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_mana_maxima);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_maxima", 0));
    }
    public void editar_vida_maxima(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_maxima", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }if(numero < 0){
            numero = 0;
        }
        preferencesEditor.putInt("vida_maxima", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_vida_maxima);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_maxima", 0));
    }
    public void editar_carisma(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("carisma", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }if(numero < 0){
            numero = 0;
        }
        preferencesEditor.putInt("carisma", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_carisma);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("carisma", 0));
    }
    public void editar_inteligencia(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("inteligencia", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }if(numero < 0){
            numero = 0;
        }
        preferencesEditor.putInt("inteligencia", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_inteligencia);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("inteligencia", 0));
    }
    public void editar_destreza(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("destreza", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }if(numero < 0){
            numero = 0;
        }
        preferencesEditor.putInt("destreza", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_destreza);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("destreza", 0));
    }
    public void editar_força(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("força", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }if(numero < 0){
            numero = 0;
        }
        preferencesEditor.putInt("força", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_força);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("força", 0));
    }
    public void editar_skill1(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }if(numero < 0){
            numero = 0;
        }
        preferencesEditor.putInt("skill1", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_skill1);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1", 0));
    }
    public void editar_skill2(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill2", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }if(numero < 0){
            numero = 0;
        }
        preferencesEditor.putInt("skill2", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_skill2);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill2", 0));
    }
    public void editar_skill3(boolean incrementar){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill3", 0);
        if(incrementar) {
            numero++;
        }else{
            numero--;
        }if(numero < 0){
            numero = 0;
        }
        preferencesEditor.putInt("skill3", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_skill3);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill3", 0));
    }

}
