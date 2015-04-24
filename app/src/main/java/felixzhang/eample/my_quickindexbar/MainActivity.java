package felixzhang.eample.my_quickindexbar;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";
    private QuickIndexBar mQuickIndexBar;
    private ListView mListView;
    private static final int DEFAULT_DELAY = 1200;

    private TextView mLabel;    //在屏幕中间显示的字母放大版标签

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuickIndexBar = (QuickIndexBar) findViewById(R.id.quickbar);
        mListView = (ListView) findViewById(R.id.listview);
        mLabel = (TextView) findViewById(R.id.showLabel);

        mQuickIndexBar.setIndexChangedListener(new QuickIndexBar.IndexChangedListener() {
            @Override
            public void indexChanged(String word) {
                Log.i(TAG, word);
//                Toast.makeText(MainActivity.this, word, Toast.LENGTH_SHORT).show();
                showIndexLabel(word);

            }
        });
    }

    private Handler mHandler = new Handler();

    private void showIndexLabel(String word) {
        mLabel.setVisibility(View.VISIBLE);
        mLabel.setText(word);

        mHandler.removeCallbacksAndMessages(null); //移除所有消息队列
        mHandler.postDelayed(new Runnable() {      //发送延时消息
            @Override
            public void run() {
                mLabel.setVisibility(View.GONE);
            }
        }, DEFAULT_DELAY);
    }


    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }


}
