package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Button joao = (Button) findViewById(R.id.button2);

        //btn.setOnClickListener(this::abreSegundaActivity);

        joao.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Intent intent = new Intent(v.getContext(),SegundaActivity.class);
                //startActivity(intent);
                abreSegundaActivity(v);

            }

        });
    }

    public void abreSegundaActivity(View view) {
        Intent intent = new Intent(this,SegundaActivity.class);

        // adicional para incluir dados para a proxima activity
        intent.putExtra("valorTexto", "Nossa 4ª aula");
        Pessoa jean  = new Pessoa("Jean Paul", 666);
        intent.putExtra("objPessoa", jean);

        EditText editNome = (EditText)findViewById(R.id.editTextTextPersonName);
        intent.putExtra("nome",editNome.getText().toString());
        EditText editID = (EditText) findViewById(R.id.editTextTextPassword);
        intent.putExtra("id",editID.getText().toString());

        // lança intent para o SO chamar a activity
         if (intent.getStringExtra("nome").equals(intent.getStringExtra("id")))
            startActivity(intent);
         else
             Toast.makeText(this,"Senha incorreta",Toast.LENGTH_LONG).show();

    }
}