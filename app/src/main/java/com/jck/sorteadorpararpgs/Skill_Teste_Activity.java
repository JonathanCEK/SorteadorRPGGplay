package com.jck.sorteadorpararpgs;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Skill_Teste_Activity extends AppCompatActivity {

    //SharedPreferences.Editor preferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testes_skills);
        popup = new Dialog(this);
        //preferencesEditor = getSharedPreferences("atributos", MODE_PRIVATE).edit();
        atualizarBarra();
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
        t = findViewById(R.id.atributo_carisma);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("carisma", 0));
        t = findViewById(R.id.atributo_inteligencia);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("inteligencia", 0));
        t = findViewById(R.id.atributo_destreza);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("destreza", 0));
        t = findViewById(R.id.atributo_força);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("força", 0));
        t = findViewById(R.id.atributo_constituição);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("constituição", 0));
        t = findViewById(R.id.atributo_sorte);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sorte", 0));
        t = findViewById(R.id.atributo_sanidade_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_atual", 0));
        t = findViewById(R.id.atributo_skill1);
        t.setText("D" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1_dado", 1) + " + " + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1", 0));
        t = findViewById(R.id.atributo_skill2);
        t.setText("D" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill2_dado", 1) + " + " + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill2", 0));
        t = findViewById(R.id.atributo_skill3);
        t.setText("D" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill2_dado", 1) + " + " + getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill3", 0));
        t = findViewById(R.id.atributo_skill1_nome);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getString("skill1_nome", "Skill 1"));
        t = findViewById(R.id.atributo_skill2_nome);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getString("skill2_nome", "Skill 2"));
        t = findViewById(R.id.atributo_skill3_nome);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getString("skill3_nome", "Skill 3"));
    }




    Dialog popup;

    public void popUpTesteSkill(int valorReferencia, int endereçoImagem){

        int numero = (new Random().nextInt(100) + 1);
        popup.setContentView(R.layout.popup);
        TextView sorteado = popup.findViewById(R.id.numeroSorteado);
        TextView objetivo = popup.findViewById(R.id.numeroObjetivo);
        sorteado.setText(numero + "");
        objetivo.setText(valorReferencia + "");
        ImageView fundo = popup.findViewById(R.id.fundoPop);
        ImageView icone = popup.findViewById(R.id.imagemSkill);
        icone.setImageResource(endereçoImagem);
        if(numero <= 5 || numero == valorReferencia){   /// CRITICAL
        fundo.setImageResource(R.drawable.skill_critical);
        }else if(numero >= 95){ /// FAIL
        fundo.setImageResource(R.drawable.skill_fail);
        }else if (numero < valorReferencia){ /// ACERTO
        fundo.setImageResource(R.drawable.skill_acerto);
        }else{ //// ERRO
        fundo.setImageResource(R.drawable.skill_erro);
        }

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

    public void fecharPopUp(View view){
        popup.dismiss();
    }

    public void testarCarisma(View view){
        popUpTesteSkill(getSharedPreferences("atributos", MODE_PRIVATE).getInt("carisma", 0), R.drawable.charisma);
    }
    public void testardestreza(View view){
        popUpTesteSkill(getSharedPreferences("atributos", MODE_PRIVATE).getInt("destreza", 0), R.drawable.coordination);
    }
    public void testarforça(View view){
        popUpTesteSkill(getSharedPreferences("atributos", MODE_PRIVATE).getInt("força", 0), R.drawable.strong);
    }
    public void testarinteligencia(View view){
        popUpTesteSkill(getSharedPreferences("atributos", MODE_PRIVATE).getInt("inteligencia", 0), R.drawable.brain);
    }

    public void testarconstituição(View view){
        popUpTesteSkill(getSharedPreferences("atributos", MODE_PRIVATE).getInt("constituição", 0), R.drawable.history);
    }
    public void testarsorte(View view){
        popUpTesteSkill(getSharedPreferences("atributos", MODE_PRIVATE).getInt("sorte", 0), R.drawable.lucky);
    }
    public void testarsanidade(View view){
        popUpTesteSkill(getSharedPreferences("atributos", MODE_PRIVATE).getInt("sanidade_atual", 0), R.drawable.palhaco);
    }


    public void testarSkill1(View view){
        popUpTesteAtaque(getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1_dado", 1),getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1", 0), R.drawable.explosion);
    }
    public void testarSkill2(View view){
        popUpTesteAtaque(getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill2_dado", 1),getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1", 0), R.drawable.espadas);
    }
    public void testarSkill3(View view){
        popUpTesteAtaque(getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill3_dado", 1),getSharedPreferences("atributos", MODE_PRIVATE).getInt("skill1", 0), R.drawable.cuidado);
    }


    public void testarVida(View view){

        int numero = (new Random().nextInt(10) + 1);
        popup.setContentView(R.layout.popup);
        TextView sorteado = popup.findViewById(R.id.numeroSorteado);
        TextView objetivo = popup.findViewById(R.id.numeroObjetivo);
        sorteado.setText((numero) + "");
        objetivo.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0) + " + "  + numero + " = " + (getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0) + numero));
        editar_vida_atual(numero);
        ImageView fundo = popup.findViewById(R.id.fundoPop);
        ImageView icone = popup.findViewById(R.id.imagemSkill);
        icone.setImageResource(R.drawable.heart);
        fundo.setImageResource(R.drawable.skill_skill);



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


    public void popUpTesteAtaque(int valorReferencia, int valorBase, int endereçoImagem){
        int numero = 0;
        if(valorReferencia > 0){
            numero = (new Random().nextInt(valorReferencia) + 1);
        }
        popup.setContentView(R.layout.popup);
        TextView sorteado = popup.findViewById(R.id.numeroSorteado);
        TextView objetivo = popup.findViewById(R.id.numeroObjetivo);
        sorteado.setText((numero + valorBase) + "");
        objetivo.setText("(D" + valorReferencia + ") "  + numero + " + " + valorBase);
        ImageView fundo = popup.findViewById(R.id.fundoPop);
        ImageView icone = popup.findViewById(R.id.imagemSkill);
        icone.setImageResource(endereçoImagem);
        fundo.setImageResource(R.drawable.skill_skill);

        Button b = popup.findViewById(R.id.botaofechar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
                TextView t = findViewById(R.id.atributo_barra_superior_vida_atual);
                t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0));
            }
        });
        popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popup.show();
    }

    public void editar_vida_atual(int valor_referencia){
        int numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0);
        numero += valor_referencia;
        if(numero > getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_maxima", 0)){
            numero = getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_maxima", 0);
        }
        SharedPreferences.Editor preferencesEditor = getSharedPreferences("atributos", MODE_PRIVATE).edit();
        preferencesEditor.putInt("vida_atual", numero);
        preferencesEditor.commit();
        TextView t = findViewById(R.id.atributo_barra_superior_vida_atual);
        t.setText("" + getSharedPreferences("atributos", MODE_PRIVATE).getInt("vida_atual", 0));
    }


}
