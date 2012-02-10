package com.molitvenik;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.molitvenik.R;


/**
 * Класа молитва служи за приказ текста молитве, када се кликне на назив молитве у листи (ListView)
 */
public class Molitva extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Подешавање излгеда активности. Изглед активности се чува у R.layout.molitva тј. у фајлу res/layout/molitva.xml
		setContentView(R.layout.molitva);
		//Ова класа се позива из класе MolitvenikActivity и том приликом се стављају додатни подаци у класи Bundle.
		//Такав један податак је позиција наслова молитве у листи.
		Bundle bundle = this.getIntent().getExtras();
		int pozicija = bundle.getInt("pozicija");
		
		//Преузимамо референцу на текстуалну компоненту на коју хоћемо да испишемо текст (тј. текст молитве)
		TextView tv = (TextView) this.findViewById(R.id.textView1);
		//Подешавамо текст молитве.
		tv.setText(getPrayerText(pozicija));
		
	}
	
	/**
	 * Даје текстове молитви на основу позиције наслова молитве у листи
	 * Текстви молитви се чувају у низу чији је назив tekstovi_molitvi (налази се у res/values/strings.xml фалју)
	 * Текстви молитви морају да буду у истом редоследу као и наслови молитви.
	 * @param pozicija Позиција наслова молитве у лист
	 * @return Текст молитве
	 */
	private String getPrayerText(int pozicija) {
		String[] tekstovi_molitvi = getResources().getStringArray(R.array.tekstovi_molitvi);
		return tekstovi_molitvi[pozicija];
	}
}
