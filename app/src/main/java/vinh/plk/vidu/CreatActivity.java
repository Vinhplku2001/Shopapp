package vinh.plk.vidu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatActivity extends AppCompatActivity {
    Button finish;
    Button singup;
    EditText email;
    EditText pass;
    EditText konPass;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creat_activity);

        //ánh xạ
        finish = (Button) findViewById(R.id.finish);
        singup = (Button) findViewById(R.id.sign_up);
        email = (EditText) findViewById(R.id.rectangle_1);
        pass = (EditText) findViewById(R.id.rectangle_2);
        konPass = (EditText) findViewById(R.id.rectangle_3);
        onClickButton();
        sharedPreferences = getSharedPreferences("logup_data", MODE_PRIVATE);

        if (sharedPreferences != null) {
            email.setText(sharedPreferences.getString("Email", ""));
            pass.setText(sharedPreferences.getString("Pass", ""));
            konPass.setText(sharedPreferences.getString("KonPass", ""));

        }

    }

    void onClickButton() {

        Intent intent = new Intent(this, SinginActivity.class);
        finish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String message = finish.getText().toString();

                intent.putExtra("EXTRA_MESSAGE", message);
                startActivity(intent);
            }

        });
        singup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String Emaill = email.getText().toString();
                String Pass = pass.getText().toString();
                String KonPass = konPass.getText().toString();

                if (Emaill.equals("admin@gmail.com") && (Pass.equals("123456")) && (KonPass.equals(Pass))) {
                    Toast.makeText(CreatActivity.this, "login success", Toast.LENGTH_LONG).show();
                    if (singup.isClickable()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Email", Emaill);
                        editor.putString("Pass", Pass);
                        editor.putString("KonPass", KonPass);
                        editor.commit();
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("Email");
                        editor.remove("pass");
                        editor.remove("checked");
                        editor.commit();
                    }
                }else {
                    Toast.makeText(CreatActivity.this, "logup Failure", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}






