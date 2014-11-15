package nesterenya.com.psychologicaltests;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends Activity {

    private TextView questionTV;

    private String[] questions = {
            "1. Часто ли Вы испытываете тягу к новым впечатлениям, к тому чтобы отвлечься, испытать сильные ощущения?",
            "2. Часто ли вы чувствуете, что нуждаетесь в друзьях, которые могут вас понять, одобрить или посочувствовать?",
            "3. Считаете ли вы себя беззаботным человеком?",
            "4. Очень ли трудно вам отказываться от своих намерений?",
            "5. Обдумываете ли вы свои дела не спеша и предпочитаете подождать, прежде чем действовать?",
            "6. Всегда ли вы сдерживаете свои обещания, даже если вам это невыгодно?",
            "7. Часто ли у вас бывают спады и подъемы настроения?",
            "8. Быстро ли вы обычно действуете и говорите, не затрачиваете ли много времени на обдумывание?",
            "9. Возникало ли у вас когда-нибудь чувство, что вы несчастны, хотя никакой серьезной причины на это не было?",
            "10. Верно ли, что \"на спор\" вы способны решиться на все?",
            "11. Смущаетесь ли вы, когда хотите познакомиться с человеком противоположного пола, который вам симпатичен?",
            "12. Бывает ли когда-нибудь, что, разозлившись, вы выходите из себя?",
            "13. Часто ли действуете необдуманно, под влиянием момента?",
            "14. Часто ли вас беспокоят мысли о том, что вам не следовало чего-либо делать или говорить?",
            "15. Предпочитаете ли вы чтение книг встречам с людьми?",
            "16. Верно ли, что вас легко задеть?",
            "17. Любите ли вы часто бывать в компании?",
            "18. Бывают ли у вас такие мысли, которыми вам не хотелось делиться с другими людьми?",
            "19. Верно ли, что иногда вы настолько полны энергии, что все горит в руках, а иногда вы чувствуете сильную вялость?",
            "20. Стараетесь ли вы ограничить круг своих знакомств небольшим числом самых близких людей?",
            "21. Много ли вы мечтаете?",
            "22. Когда на вас кричат, отвечаете ли тем же?",
            "23. Считаете ли вы свои привычки хорошими?",
            "24. Часто ли у вас появляется чувство, что вы чем-то виноваты?",
            "25. Способны ли вы иногда дать волю своим чувств и беззаботно развлечься с веселой компанией?",
            "26. Можно ли сказать, что часто у вас нервы бывают натянуты до предела?",
            "27. Слывете ли вы за человека веселого и живого?",
            "28. После того, как дело сделано, часто ли вы мысленно возвращаетесь к нему и думаете, что могли бы сделать лучше?",
            "29. Чувствуете ли вы себя неспокойно, находясь в большой компании?",
            "30. Бывает ли, что вы передаете слухи?",
            "31. Бывает ли, что вам не спится из-за того, что в голову лезут разные мысли?",
            "32. Что вы предпочитаете, если хотите что-либо узнать: найти это в книге или спросить у друзей?",
            "33. Бывают ли у вас сильные сердцебиения?",
            "34.Нравится ли вам работа, требующая сосредоточения?",
            "35. Бывают ли у вас приступы дрожи?",
            "36. Всегда ли вы говорите только правду?",
            "37. Бывает ли вам неприятно находиться в компании, где все подшучивают друг над другом?",
            "38. Раздражительны ли вы?",
            "39. Нравится ли вам работа, требующая быстрого действия?",
            "40. Верно ли, что вам часто не дают покоя мысли о разных неприятностях и \"ужасах\", которые могли бы произойти, хотя все кончилось благополучно?",
            "41. Верно ли, что вы неторопливы в движениях и несколько медлительны?",
            "42. Опаздывали ли вы когда-нибудь на работу или встречу с кем-то?",
            "43. Часто ли вам снятся кошмары?",
            "44. Верно ли что вы так любите поговорить, что не упускаете любого удобного случая побеседовать с новым человеком?",
            "45. Беспокоят ли вас какие-либо боли?",
            "46. Огорчились бы вы, если бы не смогли долго видеться с друзьями?",
            "47. Можете ли вы назвать себя нервным человеком?",
            "48. Есть ли среди ваших знакомых такие, которые вам явно не нравятся?",
            "49. Могли бы вы сказать, что вы уверенный в себе человек?",
            "50. Легко ли вас задевает критика ваших недостатков, или вашей работы?",
            "51. Трудно ли вам получить настоящее удовольствие от мероприятий, в которых участвует много народу?",
            "52. Беспокоит ли вас чувство, что вы чем-то хуже других?",
            "53. Сумели бы вы внести оживление в скучную компанию?",
            "54. Бывает ли, что вы говорите о вещах, в которых совсем не разбираетесь?",
            "55. Беспокоитесь ли вы о своем здоровье?",
            "56. Любите ли вы подшутить над другими?",
            "57. Страдаете ли вы бессонницей?",
    };

    private String[] questionsB = {
            "1. Нравится ли вам оживление и суета вокруг вас?",
            "2. Часто ли у вас бывает беспокойное чувство, что вам что-либо хочется, а вы не знаете что?",
            "3. Вы из тех людей, которые не лезут за словом в карман?",
            "4. Чувствуете ли вы себя иногда счастливым, а иногда печальным без какой-либо причины?",
            "5. Держитесь ли вы обычно в \"тени\" на вечеринках или в компании?",
            "6. Всегда ли в детстве вы делали немедленно и безропотно то, что вам приказывали?",
            "7. Бывает ли у вас иногда дурное настроение?",
            "8. Когда вас втягивают в ссору, предпочитаете ли вы отмолчаться, надеясь, что все обойдется?",
            "9. Легко ли вы поддаетесь переменам настроения?",
            "10. Нравится ли вам находиться среди людей?",
            "11. Часто ли вы теряли сон из-за своих тревог?",
            "12. Упрямитесь ли вы иногда?",
            "13. Могли бы вы назвать себя бесчестным?",
            "14. Часто ли вам приходят хорошие мысли слишком поздно?",
            "15. Предпочитаете ли вы работать в одиночестве?",
            "16. Часто ли вы чувствуете себя апатичным и усталым без серьезной причины?",
            "17. Вы по натуре живой человек?",
            "18. Смеетесь ли вы иногда неприличным шуткам?",
            "19. Часто ли вам что-то так надоедает, что вы чувствуете себя \"сытным по горло\"?",
            "20. Чувствуете ли вы себя неловко в какой-либо иной одежде, кроме повседневной?",
            "21. Часто ли ваши мысли отвлекаются, когда вы пытаетесь сосредоточить на чем-то свое внимание?",
            "22. Можете ли вы быстро выразить ваши мысли словами?",
            "23. Часто ли вы бываете погружены в свои мысли?",
            "24. Полностью ли вы свободны от всяких предрассудков?",
            "25. Нравятся ли вам первоапрельские шутки?",
            "26. Часто ли вы думаете о своей работе?",
            "27. Очень ли вы любите вкусно поесть?",
            "28. Нуждаетесь ли вы в дружески расположенном человеке, чтобы выговориться, когда вы раздражены?",
            "29. Очень ли вам неприятно брать взаймы или продавать что-нибудь, когда вы нуждаетесь в деньгах?",
            "30. Хвастаетесь ли вы иногда?",
            "31. Очень ли вы чувствительны к некоторым вещам?",
            "32. Предпочли бы вы остаться в одиночестве дома, чем пойти на скучную вечеринку?",
            "33. Бываете ли вы иногда так беспокойны, что не можете долго усидеть на месте?",
            "34. Склонны ли вы планировать свои дела тщательно и раньше, чем следовало бы?",
            "35. Бывают ли у вас головокружения?",
            "36. Всегда ли вы отвечаете на письма сразу после прочтения?",
            "37. Справляетесь ли вы с делом лучше, обдумав его самостоятельно, а не обсуждая с другими?",
            "38. Бывает ли у вас когда-либо отдышка, даже если вы не делали никакой тяжелой работы?",
            "39. Можно ли сказать, что вы человек, которого не волнует, чтобы все было именно так, как нужно?",
            "40. Беспокоят ли вас ваши нервы?",
            "41. Предпочитаете ли вы больше строить планы, чем действовать?",
            "42. Откладываете ли вы иногда на завтра то, что должны сделать сегодня?",
            "43. Нервничаете ли вы в местах, подобных лифту, метро, туннелю?",
            "44. При знакомстве вы обычно первым проявляете инициативу?",
            "45. Бывают ли у вас сильные головные боли?",
            "46. Считаете ли вы обычно, что все само собой уладится и придет в норму?",
            "47. Трудно ли вам заснуть ночью?",
            "48. Лгали ли вы когда-нибудь в своей жизни?",
            "49. Говорите ли вы иногда первое, что придет в голову?",
            "50. Долго ли вы переживаете после случившегося конфуза?",
            "51. 3амкнуты ли вы обычно со всеми, кроме близких друзей?",
            "52. Часто ли с вами случаются неприятности?",
            "53. Любите ли вы рассказывать забавные истории друзьям?",
            "54. Предпочитаете ли вы больше выигрывать, чем проигрывать?",
            "55. Часто ли вы чувствуете себя неловко в обществе людей выше вас по положению?",
            "56. Когда обстоятельства против вас, обычно вы думаете, тем не менее, что стоит еще что-либо предпринять?",
            "57. Часто ли у вас \"сосет под ложечкой\" перед важным делом?"
    };

    private int activeQuestion = 0;
    //TODO сделать возможность поделиться вконтакте
    private void putAnswer(int answer) {

        //TODO обработка ответа
        activeQuestion++;
        if(activeQuestion<questions.length) {
            questionTV.setText(questions[activeQuestion]);
        } else {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questionTV = (TextView)findViewById(R.id.tv_question);
        questionTV.setText(questions[activeQuestion]);

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