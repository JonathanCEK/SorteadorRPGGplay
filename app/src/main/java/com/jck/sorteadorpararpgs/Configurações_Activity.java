package com.jck.sorteadorpararpgs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class Configurações_Activity extends AppCompatActivity {

    SharedPreferences.Editor preferencesEditor;
    EditText t[];
    String atributo[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_bar);


        preferencesEditor = getSharedPreferences("atributos", MODE_PRIVATE).edit();
        instaciar();
        atualizarBarra();
        atualizarInterface();

    }
    public void instaciar(){
        atributo = new String[21];
        atributo[0] = "experiencia";
        atributo[1] = "dinheiro";
        atributo[2] = "mana_atual";
        atributo[3] = "vida_atual";
        atributo[4] = "mana_maxima";
        atributo[5] = "vida_maxima";
        atributo[6] = "carisma";
        atributo[7] = "inteligencia";
        atributo[8] = "destreza";
        atributo[9] = "força";
        atributo[10] = "skill1";
        atributo[11] = "skill2";
        atributo[12] = "skill3";
        atributo[13] = "skill1_dado";
        atributo[14] = "skill2_dado";
        atributo[15] = "skill3_dado";
        atributo[16] = "constituição";
        atributo[17] = "sorte";
        atributo[18] = "sanidade_atual";
        atributo[19] = "sanidade_maxima";
        atributo[20] = "sanidade_minima";

        t = new EditText[24];
        t[0] = findViewById(R.id.atributo_experiencia);

        t[1] = findViewById(R.id.atributo_dinheiro);

        t[2] = findViewById(R.id.atributo_mana_atual);

        t[3] = findViewById(R.id.atributo_vida_atual);

        t[4] = findViewById(R.id.atributo_mana_maxima);

        t[5] = findViewById(R.id.atributo_vida_maxima);

        t[6] = findViewById(R.id.atributo_carisma);

        t[7] = findViewById(R.id.atributo_inteligencia);

        t[8] = findViewById(R.id.atributo_destreza);

        t[9] = findViewById(R.id.atributo_força);

        t[10] = findViewById(R.id.atributo_skill1);

        t[11] = findViewById(R.id.atributo_skill2);

        t[12] = findViewById(R.id.atributo_skill3);

        t[13] = findViewById(R.id.atributo_skill1_dado);

        t[14] = findViewById(R.id.atributo_skill2_dado);

        t[15] = findViewById(R.id.atributo_skill3_dado);

        t[16] = findViewById(R.id.atributo_constituição);

        t[17] = findViewById(R.id.atributo_sorte);

        t[18] = findViewById(R.id.atributo_sanidade_atual);

        t[19] = findViewById(R.id.atributo_sanidade_maxima);

        t[20] = findViewById(R.id.atributo_sanidade_minima);

        t[21] = findViewById(R.id.atributo_skill1_nome);

        t[22] = findViewById(R.id.atributo_skill2_nome);

        t[23] = findViewById(R.id.atributo_skill3_nome);


    }

    public void atualizarMemoria(){
        for (int i = 0 ; i < atributo.length; i++){
            int tmp = 0;
            try{
                tmp = Integer.parseInt(t[i].getText()+"");
            }catch (NumberFormatException e){
                System.out.println(i);
            }
            preferencesEditor.putInt(atributo[i], tmp);
        }

        /*int tmp = 0;
        try{
            tmp = Integer.parseInt(t[19].getText()+"");
        }catch (NumberFormatException e){
        }
        preferencesEditor.putInt("constituição", tmp);*/

        preferencesEditor.putString("skill1_nome", t[21].getText()+"");
        preferencesEditor.putString("skill2_nome", t[22].getText()+"");
        preferencesEditor.putString("skill3_nome", t[23].getText()+"");


        preferencesEditor.commit();
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
    }

    public void atualizarInterface(){

        t[0].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("experiencia", 0));
        t[1].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("dinheiro", 0));
        t[2].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_atual", 0));
        t[3].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0));
        t[4].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("mana_maxima", 0));
        t[5].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_maxima", 0));
        t[6].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("carisma", 0));
        t[7].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("inteligencia", 0));
        t[8].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("destreza", 0));
        t[9].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("força", 0));
        t[10].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1", 0));
        t[11].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill2", 0));
        t[12].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill3", 0));
        t[13].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1_dado", 1));
        t[14].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill2_dado", 1));
        t[15].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill3_dado", 1));
        t[16].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("constituição", 0));
        t[17].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sorte", 0));
        t[18].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_atual", 30));
        t[19].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_maxima", 0));
        t[20].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_minima", 30));
        t[21].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getString("skill1_nome", "Skill 1"));
        t[22].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getString("skill2_nome", "Skill 2"));
        t[23].setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getString("skill3_nome", "Skill 3"));

    }

    public void submit(View view){
        atualizarMemoria();
    }


}
