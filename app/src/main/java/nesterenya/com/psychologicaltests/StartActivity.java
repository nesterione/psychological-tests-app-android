package nesterenya.com.psychologicaltests;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


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
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);




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



        // Создание экземпляра adView.
        adView = new AdView(this);
        adView.setAdUnitId(getResources().getString(R.string.banner_ad_unit_id));
        adView.setAdSize(AdSize.BANNER);

        // Поиск разметки LinearLayout (предполагается, что ей был присвоен
        // атрибут android:id="@+id/mainLayout").
        LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout);

        // Добавление в разметку экземпляра adView.
        layout.addView(adView);

        // Инициирование общего запроса.
        AdRequest adRequest = new AdRequest.Builder().build();

        // Загрузка adView с объявлением.
        adView.loadAd(adRequest);
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
