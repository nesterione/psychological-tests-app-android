package nesterenya.com.psychologicaltests;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import nesterenya.com.psychologicaltests.views.CustomImageView;


public class ResultActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        int extra = getIntent().getIntExtra("extra",-1);
        int emotion = getIntent().getIntExtra("emotion",-1);
        int lie = getIntent().getIntExtra("lie",-1);

        if(extra>=0&&emotion>=0&&lie>=0) {
            String youAre = "";

            if(extra>12) {
                if(emotion>12) {
                    youAre = "Холерик";
                } else {
                    youAre = "Сангвиник";
                }
            } else {
                if(emotion>12) {
                    youAre = "Меланхолик";
                } else {
                    youAre = "Флегматик";
                }
            }

            TextView tvYouAre = (TextView) findViewById(R.id.tv_result_you);
            tvYouAre.setText(tvYouAre.getText()+youAre);

            TextView tvExtra = (TextView) findViewById(R.id.tv_result_extra);
            tvExtra.setText(tvExtra.getText()+ Integer.toString(extra));

            TextView tvEmotion = (TextView) findViewById(R.id.tv_result_emotion);
            tvEmotion.setText(tvEmotion.getText()+Integer.toString(emotion));

            TextView tvLie = (TextView) findViewById(R.id.tv_result_lie);
            tvLie.setText(tvLie.getText()+Integer.toString(lie));

            final CustomImageView customImageView = (CustomImageView)findViewById(R.id.iv_result_scale);
            customImageView.showResult(extra,emotion);
        }

        Button btnMoreInfo = (Button)findViewById(R.id.btn_more_info);
        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, TempersActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.result, menu);
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
