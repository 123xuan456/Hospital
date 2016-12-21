package d.hospital.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import d.hospital.R;

public class KeShiActivity extends Activity implements View.OnClickListener{
    private ListView listView;
    private TextView finish_title;
    private ImageView finish_fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_shi);
        listView = (ListView) findViewById(R.id.listview);
        finish_title=(TextView)findViewById(R.id.finish_title);
        finish_title.setText("科室");
        finish_fanhui=(ImageView)findViewById(R.id.finish_fanhui);
        finish_fanhui.setOnClickListener(this);
        getdate();
    }
    public void getdate() {



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finish_fanhui:
                finish();
                break;
        }
    }


}
