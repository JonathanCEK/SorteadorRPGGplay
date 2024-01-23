package com.jck.sorteadorpararpgs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main_Menu_Activity extends AppCompatActivity {

    //SharedPreferences.Editor preferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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
    }
    @Override
    protected void onResume() {
        super.onResume();
        atualizarBarra();
    }

    public void skills(View view){
        startActivity(new Intent(getBaseContext(), Skills_Change_Activity.class));
    }
    public void Testeskills(View view){
        startActivity(new Intent(getBaseContext(), Skill_Teste_Activity.class));
    }
    public void Sorteador(View view){
        startActivity(new Intent(getBaseContext(), Sorteador_Activity.class));
    }
    public void Atributos(View view){
        startActivity(new Intent(getBaseContext(), Atributos_Activity.class));
    }

    public void Configurações(View view){
        startActivity(new Intent(getBaseContext(), Configurações_Activity.class));
    }

}
