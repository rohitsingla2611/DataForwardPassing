package rohitsingla.rdrock.dataforwardpassing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName, editTextPhone;
    Button buttonGoForward;
    String strName, strPhone;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        buttonGoForward = findViewById(R.id.buttonGoForward);
        buttonGoForward.setOnClickListener(this);
        intent = new Intent(MainActivity.this, MainActivity2.class);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonGoForward) {

            strName = editTextName.getText().toString().trim();
            strPhone = editTextPhone.getText().toString().trim();
            if ((TextUtils.isEmpty(strName)) || (TextUtils.isEmpty(strPhone))) {

                if ((TextUtils.isEmpty(strName)) && (TextUtils.isEmpty(strPhone))) {
                    Toast.makeText(this, "Please Enter Your Details", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(strName)) {
                    Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Please Enter Your Phone", Toast.LENGTH_SHORT).show();
                }
            } else {
                intent.putExtra("keyName", strName);
                intent.putExtra("keyPhone", strPhone);
                startActivity(intent);
                editTextName.setText("");
                editTextPhone.setText("");
            }
        }
    }

}
