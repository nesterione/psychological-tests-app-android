package nesterenya.com.psychologicaltests;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.widget.AdapterView.*;


class StableArrayAdapter extends ArrayAdapter<String> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public StableArrayAdapter(Context context, int textViewResourceId, List<String> objects) {
        super(context, textViewResourceId, objects);
        for(int i = 0; i < objects.size(); i++) {
            mIdMap.put(objects.get(i), i);
        }
    }

    public long getItemId(int position) {
        String item = getItem(position);
        return mIdMap.get(item);
    }

    public boolean hasStableIds() {
        return true;
    }
}

public class TempersActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempers);

        ListView listView = (ListView)findViewById(R.id.listView);

        //TODO тоже вынести в отдельные файлы
        final ArrayList<String> list = new ArrayList<String>();
        list.add("Холерик");
        list.add("Меланхолик");
        list.add("Флегматик");
        list.add("Сангвиник");
        // TODO вынести в отдельные файлы
        String t1 = "(высокая экстраверсия и высокий нейротизм) отличается повышенной возбудимостью, действия прерывисты. Ему свойственны резкость и стремительность движений, сила, импульсивность, яркая выраженность эмоциональных переживаний. Вследствие неуравновешенности, увлекшись делом, склонен действовать изо всех сил, истощаться больше, чем следует. Имея общественные интересы, темперамент проявляет в инициативности, энергичности, принципиальности. При отсутствии духовной жизни холерический темперамент часто проявляется в раздражительности, эффективности, несдержанности, вспыльчивости, неспособности к самоконтролю при эмоциональных обстоятельствах.";
        String t2 = "(высокая интроверсия и высокий нейротизм). У него реакция часто не соответствует силе раздражителя, присутствует глубина и устойчивость чувств при слабом их выражении. Ему трудно долго на чем-то сосредоточиться. Сильные воздействия часто вызывают у меланхолика продолжительную тормозную реакцию (опускаются руки). Ему свойственны сдержанность и приглушенность моторики и речи, застенчивость, робость, нерешительность. В нормальных условиях меланхолик ­ человек глубокий, содержательный, может быть хорошим тружеником, успешно справляться с жизненными задачами. При неблагоприятных условиях может превратиться в замкнутого, боязливого, тревожного, ранимого человека, склонного к тяжелым внутренним переживаниям таких жизненных обстоятельств, которые вовсе этого не заслуживают.";
        String t3 = "(высокая интровесия и высокий нейротизм) характеризуется сравнительно низким уровнем активности поведения, новые формы которого вырабатываются медленно, но являются стойкими. Обладает медлительностью и спокойствием в действиях, мимике и речи, ровностью, постоянством, глубиной чувств и настроений. Настойчивый и упорный «труженик жизни», он редко выходит из себя, не склонен к аффектам, рассчитав свои силы, доводит дело до конца, ровен в отношениях, в меру общителен, не любит попусту болтать. Экономит силы, попусту их не тратит. В зависимости от условий в одних случаях флегматик может характеризоваться «положительными» чертами ­ выдержкой, глубиной мыслей, постоянством, основательностью и т. д., в других ­ вялостью, безучастностью к окружающему, ленью и безволием, бедностью и слабостью эмоций, склонностью к выполнению одних лишь привычных действий.";
        String t4 = "(высокая экстраверсия и низкий нейротизм) быстро приспосабливается к новым условиям, быстро сходится с людьми, общителен. Чувства легко возникают и сменяются, эмоциональные переживания, как правило, неглубоки. Мимика богатая, подвижная, выразительная. Несколько непоседлив, нуждается в новых впечатлениях, недостаточно регулирует свои импульсы, не умеет строго придерживаться выработанного распорядка, жизни, системы в работе. В связи с этим не может успешно выполнять дело, требующее равной затраты сил, длительного и методичного напряжения, усидчивости, устойчивости внимания, терпения. При отсутствии серьезных целей, глубоких мыслей, творческой деятельности вырабатываются поверхностность и непостоянство.";
        final String[] discrTempers = {t1,t2,t3,t4 };

        final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

                Intent intent = new Intent(TempersActivity.this, InfoActivity.class);
                intent.putExtra("header",(String)parent.getItemAtPosition(position));
                intent.putExtra("text", discrTempers[position]);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tempers, menu);
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
