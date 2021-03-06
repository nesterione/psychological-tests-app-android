package nesterenya.com.psychologicaltests;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import nesterenya.com.psychologicaltests.views.AizenText;

public class TestActivity extends Activity {

    private TextView questionTV;

    //TODO сделать возможность поделиться вконтакте
    private void putAnswer(int answer) {
        test.answer(answer);

        if(!test.isFinish()) {
            questionTV.setText(test.getActiveQuestion());
        } else {
            sendResult();
            finish();
        }
    }

    private void sendResult() {
        AizenText.TestResult result = test.getResult();

        if(result!=null) {
            Intent intent = new Intent(TestActivity.this, ResultActivity.class);
            intent.putExtra("extra", result.getExtra());
            intent.putExtra("emotion", result.getEmotion());
            intent.putExtra("lie", result.getLie());
            startActivity(intent);
        }
    }

    private AizenText test;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // Has previous state been saved?
        if (savedInstanceState != null) {
            test = (AizenText) savedInstanceState.getSerializable("test");
        } else {
            test = new AizenText();
        }

        questionTV = (TextView)findViewById(R.id.tv_question);
        questionTV.setText(test.getActiveQuestion());

        Button btnPositive = (Button)findViewById(R.id.btn_positive);
        Button btnNegative = (Button)findViewById(R.id.btn_negative);

        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putAnswer(1);
            }
        });

        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putAnswer(0);
            }
        });




        // Создание экземпляра adView.
        adView = new AdView(this);
        adView.setAdUnitId(getResources().getString(R.string.banner_ad_unit_id));
        adView.setAdSize(AdSize.BANNER);

        // Поиск разметки LinearLayout (предполагается, что ей был присвоен
        // атрибут android:id="@+id/mainLayout").
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout_banner);

        // Добавление в разметку экземпляра adView.
        layout.addView(adView);

        // Инициирование общего запроса.
        AdRequest adRequest = new AdRequest.Builder().build();

        // Загрузка adView с объявлением.
        adView.loadAd(adRequest);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putSerializable("test", test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test, menu);
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
