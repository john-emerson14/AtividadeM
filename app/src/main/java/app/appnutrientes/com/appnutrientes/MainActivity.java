package app.appnutrientes.com.appnutrientes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String USUARIO = "usuario";
    private EditText nomeUsuario;
    String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeUsuario = findViewById(R.id.nome_do_usuario);
    }

    public void abrirTela1(View view) {
        nome = nomeUsuario.getText().toString();

        final Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(USUARIO, nome);

        startActivity(intent);
    }
}
