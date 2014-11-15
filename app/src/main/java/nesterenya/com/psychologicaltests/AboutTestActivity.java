package nesterenya.com.psychologicaltests;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class AboutTestActivity extends Activity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_test);

        TextView textView = (TextView)findViewById(R.id.tv_info_about_text);
        String info = "   Личностный опросник Ганса Айзенка (EPI) поможет вам узнать свой темперамент, определить тип темперамента с учетом интроверсии и экстраверсии личности, а так же эмоциональной устойчивости. \n\n   Диагностика самооценки по Г.Айзенку является, пожалуй, классической методикой для определения темперамента и одной из самых значимых в современной психологии. \n\n   Пройдя тест на темперамент Айзенка, вы сможете лучше познать свое собственное Я. Вы поймете, что представляет из себя ваш характер и сможете занять более правильную позицию в жизни. Знание темперамента своих близких и друзей, поможет вам комфортно уживаться в семье и в трудовом коллективе. \n\n   Так, например, в некоторых школах, поступающий должен пройти тест на темперамент. В соответствии с этими тестами в дальнейшем будут формироваться классы. Многие работодатели при приеме на работу так же предлагают пройти тест на темперамент, чтобы выбрать того из соискателей, который удачно впишется в коллектив.";
        textView.setText(info);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.about_test, menu);
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
