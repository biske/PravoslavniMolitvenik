package com.molitvenik;

import com.molitvenik.R;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MolitvenikActivity extends ListActivity {
	/**
	 * Позива се када се активност први пут позове. Наслеђујемо методу onCreate.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String[] naziviMolitvi = getResources().getStringArray(R.array.nazivi_molitvi);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, naziviMolitvi));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(getApplicationContext(), Molitva.class);
				Bundle bundle = new Bundle();
				bundle.putInt("pozicija", position);
				intent.putExtras(bundle);
				startActivity(intent);
				
				// When clicked, show a toast with the TextView text
//				Toast.makeText(getApplicationContext(),
//						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}