package app.appnutrientes.com.appnutrientes;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1001;
    public static final String GET = "get";
    public static final String USUARIO = "usuario";
    private String nome_do_usuario;
    private TextView nome;
    private TextView altura_do_usuario;
    private TextView txt_altura;
    private TextView peso_do_usuario;
    private TextView txt_peso;
    private TextView TMB_resultado;
    private TextView GET_resultado;
    private TextView selecione_tipo;
    private RadioGroup botoes;
    private double atual_TMB = 0.0;
    public double resultado;
    private Button detalhar;
    DecimalFormat df = new DecimalFormat("#####.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Intent intent = getIntent();

        nome_do_usuario = intent.getStringExtra(MainActivity.USUARIO);

        nome = findViewById(R.id.usuario);

        nome.setText(nome_do_usuario);

        altura_do_usuario = findViewById(R.id.altura);
        peso_do_usuario = findViewById(R.id.peso);
        txt_altura = findViewById(R.id.txt_altura);
        txt_peso = findViewById(R.id.txt_peso);
        TMB_resultado = findViewById(R.id.TMB_resultado);
        GET_resultado = findViewById(R.id.GET_resultado);
        selecione_tipo = findViewById(R.id.selecione_tipo);
        botoes = findViewById(R.id.botoes);
        detalhar = findViewById(R.id.detalhar);
    }

    public void abrirTela2(View view) {
        final Intent intent = new Intent(this, tela2.class);
        intent.putExtra(USUARIO, nome_do_usuario);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void onRadioButtonClicked (View view){
        boolean checked = ((RadioButton) view).isChecked();
        double tipo = 0.0;

        switch (view.getId()) {
            case R.id.btn_sedentario:
                if (checked)
                    tipo = 1.00;
                break;

            case R.id.btn_leve_ativo:
                if (checked)
                    tipo = 1.11;
                break;

            case R.id.btn_moder_ativo:
                if (checked)
                    tipo = 1.25;
                break;

            case R.id.btn_muito_ativo:
                if (checked)
                    tipo = 1.48;
                break;
        }

        resultado = atual_TMB * tipo;
        GET_resultado.setText("GET = " + df.format(resultado) + " kcal");
        GET_resultado.setVisibility(View.VISIBLE);
        detalhar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                if (data != null) {
                    double altura = data.getDoubleExtra(tela2.ALTURA, 0.0);
                    altura_do_usuario.setText(altura + " m");
                    altura_do_usuario.setVisibility(View.VISIBLE);
                    txt_altura.setVisibility(View.VISIBLE);

                    double peso = data.getDoubleExtra(tela2.PESO, 0.0);
                    peso_do_usuario.setText(peso + " kg");
                    peso_do_usuario.setVisibility(View.VISIBLE);
                    txt_peso.setVisibility(View.VISIBLE);

                    double TMB = data.getDoubleExtra(tela2.TMB, 0.0);
                    atual_TMB = TMB;
                    TMB_resultado.setText("TMB = " + df.format(TMB) + " kcal");
                    TMB_resultado.setVisibility(View.VISIBLE);

                    selecione_tipo.setVisibility(View.VISIBLE);
                    botoes.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void abrirTela3(View view) {
        final Intent intent = new Intent(this, tela3.class);
        intent.putExtra(USUARIO, nome_do_usuario);
        intent.putExtra(GET, resultado);
        startActivity(intent);
    }
}
