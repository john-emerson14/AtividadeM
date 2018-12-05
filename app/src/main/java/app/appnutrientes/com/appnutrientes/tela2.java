package app.appnutrientes.com.appnutrientes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class tela2 extends AppCompatActivity {

    public static final String PESO = "peso";
    public static final String ALTURA = "altura";
    public static final String TMB = "tmb";
    private TextView nome;
    private EditText altura_editText;
    private EditText peso_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        final Intent intent = getIntent();

        String nome_do_usuario = intent.getStringExtra(Main2Activity.USUARIO);

        nome = findViewById(R.id.usuario2);

        nome.setText(nome_do_usuario);

        altura_editText = findViewById(R.id.edit_altura);
        peso_editText = findViewById(R.id.edit_peso);
    }

    public double calcularTMB (double peso, double altura){
        return ((11.3 * peso) + (16 * altura) + 901);
    }

    public void pronto(View view) {
        double altura = Double.parseDouble(altura_editText.getText().toString());
        double peso = Double.parseDouble(peso_editText.getText().toString());
        double tmb = calcularTMB(peso, altura);

        Intent intent = new Intent();

        intent.putExtra(PESO, peso);
        intent.putExtra(ALTURA, altura);
        intent.putExtra(TMB, tmb);

        setResult(RESULT_OK, intent);

        finish();
    }
}
