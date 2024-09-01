package vinh.plk.vidu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import vinh.plk.vidu.recycleview.ListActivityDuct;

public class SinginActivity extends AppCompatActivity {
    TextView sign;
    EditText email;
    EditText pass;
    TextView forgot;
    Button signin;
    Button singmenu;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singin_activity);

        //Ánh xạ
        sign = (TextView) findViewById(R.id.sign);
        email = (EditText) findViewById(R.id.rectangle_1);
        pass = (EditText) findViewById(R.id.rectangle_2);
        forgot = (TextView) findViewById(R.id.forgot_pass);
        signin = (Button) findViewById(R.id.sign_in);
        singmenu = (Button) findViewById(R.id.sign_in_men);
        cbRemember = (CheckBox) findViewById((R.id.checkbox));
        onClickButton();
        //getSupportActionBar().hide();
        Log.d("123", "hello");

        sharedPreferences = getSharedPreferences("login_data", MODE_PRIVATE);
        if (sharedPreferences != null) {
            email.setText(sharedPreferences.getString("Email", ""));
            pass.setText(sharedPreferences.getString("Passs", ""));
            cbRemember.setChecked(sharedPreferences.getBoolean("Checked", false));
        }

    }

    void onClickButton() {
        Intent intent = new Intent(this, CreatActivity.class);
        singmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = singmenu.getText().toString();

                intent.putExtra("EXTRA_MESSAGE", message);
                startActivity(intent);
            }
        });
        Intent intent1=new Intent(this, ListActivityDuct.class);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = signin.getText().toString();
                intent1.putExtra("EXTRA_MESSAGE",message);
                startActivity(intent1);


                String Emaill = email.getText().toString();
                String Passs = pass.getText().toString();

                if (Emaill.equals("admin@gmail.com") && (Passs.equals("123456"))) {
                    Toast.makeText(SinginActivity.this, "login success", Toast.LENGTH_LONG).show();
                    if (cbRemember.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Email", Emaill);
                        editor.putString("pass", Passs);
                        editor.putBoolean("checked", true);
                        editor.commit();

                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("Email");
                        editor.remove("pass");
                        editor.remove("checked");
                        editor.commit();

                    }
                } else {
                    Toast.makeText(SinginActivity.this, "login Failure", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}

//        private void showAlertDialog() {
//       AlertDialog dialog = new AlertDialog.Builder(SinginActivity.this)
//                .setTitle("Alert Title")
//                .setMessage("")
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                }).create();
//       dialog.show();
//    }
//}