package rohitsingla.rdrock.dataforwardpassing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {


    TextView textViewName, textViewPhone;
    Button buttonGoBack;
    Intent getData;
    String getDataName, getDataPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
    }

    void initViews() {
        textViewName = findViewById(R.id.textViewName);
        textViewPhone = findViewById(R.id.textViewPhone);
        buttonGoBack = findViewById(R.id.buttonGoBack);
        getData = getIntent();
        getDataName = getData.getStringExtra("keyName");
        getDataPhone = getData.getStringExtra("keyPhone");
        textViewName.setText(getDataName);
        textViewPhone.setText(getDataPhone);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

}
