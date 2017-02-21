package d.hospital.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import d.hospital.R;

public class WebActivity extends AppCompatActivity {

    private String raw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Intent i=getIntent();

        raw=i.getStringExtra("raw");
        TextView tv= (TextView) findViewById(R.id.textView27);
        tv.setText(raw);
    }
}
