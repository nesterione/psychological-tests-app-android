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

        // TODO вынести в отдельные файлы
        final String[] discrTempers = {
                "Быстрый, порывистый, однако совершенно неуравновешенный, с резкоменяющимся настроением с эмоциональными вспышками, быстро истощаемый. У него нет равновесия нервных процессов, это его резко отличает от сангвиника. Холерик облодает огромной работоспособностью, однако, увлекаясь, безалаберно растрачивает свои силы и быстро истощается.",
                "Склонный к постоянному переживанию различных событий, он остро реагирует на внешние факторы. Свои астенические переживания он зачастую не может сдерживать усилием воли, он повышено впечатлителен, эмоционально раним.",
                "Неспешен, невозмутим, имеет устойчивые стремления и настроение, внешне скуп на проявление эмоций и чувств. Он проявляет упорство и настойчивость в работе, оставаясь спокойным и уравновешенным. В работе он производителен, компенсируя свою неспешность прилежанием.",
                "Живой, горячий, подвижный человек, с частой сменой впечатлений, с быстрой реакцией на все события, происходящие вокруг него, довольно легко примиряющийся со своими неудачами и неприятностями. Обычно сангвиник обладает выразительной мимикой. Он очень продуктивен в работе, когда ему интересно, если работа неинтересна, онотносится к ней безразлично, ему становится скучно.",
        };

        //TODO тоже вынести в отдельные файлы
        final ArrayList<String> list = new ArrayList<String>();
        list.add("Холерик");
        list.add("Меланхолик");
        list.add("Флегматик");
        list.add("Сангвиник");

        final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

                Intent intent = new Intent(TempersActivity.this, InfoActivity.class);
                intent.putExtra("header",(String)parent.getItemAtPosition(position));
                intent.putExtra("text", discrTempers[position]);

                final String item                =(String)parent.getItemAtPosition(position) ;

                view.animate().setDuration(1500).alpha(0).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        list.remove(item);
                        adapter.notifyDataSetChanged();
                        view.setAlpha(1);
                    }
                });
                //Toast.makeText(getApplicationContext(),"Click "+position, Toast.LENGTH_LONG).show();
            }
        });
       //setListAdapter(new ArrayAdapter<String>(getActivity(), layout, FRIENDS));
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
