package nesterenya.com.psychologicaltests;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class StartActivity extends Activity {

    private void showDialog(Context context, DialogInterface.OnClickListener yesListener, DialogInterface.OnClickListener noListener, DialogInterface.OnCancelListener cancelListener ) {
        AlertDialog.Builder ad;
        ad = new AlertDialog.Builder(StartActivity.this);
        ad.setTitle("Выход");
        ad.setMessage("Вы хотите выйти?");
        ad.setPositiveButton("Да", yesListener);
        ad.setNegativeButton("Нет", noListener);
        ad.setCancelable(true);
        ad.setOnCancelListener(cancelListener);
        ad.show();
    }

    private View.OnClickListener exitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

             DialogInterface.OnClickListener yesL = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    finish();
                }
             };

            DialogInterface.OnClickListener noL = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                }
            };

            DialogInterface.OnCancelListener cancelL = new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                }
            };
           showDialog(StartActivity.this,yesL,noL,cancelL);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button bbb = (Button)findViewById(R.id.btn_more_info);
        bbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, ResultActivity.class);

                intent.putExtra("extra", 2);
                intent.putExtra("emotion",20);
                intent.putExtra("lie",2);

                startActivity(intent);
            }
        });


        Button btnExit = (Button)findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(exitListener);

        Button btnAboutTest = (Button)findViewById(R.id.btn_about_test);

        btnAboutTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,AboutTestActivity.class));
            }
        });

        Button btnBeginTest = (Button)findViewById(R.id.btn_begin_test);
        btnBeginTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, PreTestActivity.class));
            }
        });

        Button btnShowInfo = (Button) findViewById(R.id.btn_show_info);
        btnShowInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, TempersActivity.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
