package app.appnutrientes.com.appnutrientes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class tela3 extends AppCompatActivity {

    private TextView nome;
    private TextView txt_GET;
    private TextView pt_kcal;
    private TextView pt_gramas;
    DecimalFormat df = new DecimalFormat("#####.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        final Intent intent = getIntent();

        nome = findViewById(R.id.username);
        txt_GET = findViewById(R.id.GET_final);

        String nome_usuario = intent.getStringExtra(Main2Activity.USUARIO);
        double GET_final = intent.getDoubleExtra(Main2Activity.GET, 0.0);

        nome.setText(nome_usuario);
        txt_GET.setText("GET = " + df.format(GET_final) + " kcal");

        //calculando proteinas, carboidratos e gorduras
        double quant_prot_kcal = GET_final * 0.15;
        pt_kcal = findViewById(R.id.prot_kcal);
        pt_kcal.setText(df.format(quant_prot_kcal));
        pt_gramas = findViewById(R.id.prot_gramas);
        pt_gramas.setText(df.format(quant_prot_kcal / 4));

        double quant_carb_kcal = GET_final * 0.6;
        pt_kcal = findViewById(R.id.carb_kcal);
        pt_kcal.setText(df.format(quant_carb_kcal));
        pt_gramas = findViewById(R.id.carb_gramas);
        pt_gramas.setText(df.format(quant_carb_kcal / 4));

        double quant_gord_kcal = GET_final * 0.25;
        pt_kcal = findViewById(R.id.gord_kcal);
        pt_kcal.setText(df.format(quant_gord_kcal));
        pt_gramas = findViewById(R.id.gord_gramas);
        pt_gramas.setText(df.format(quant_gord_kcal / 9));
    }
}
