package d.hospital.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import d.hospital.MainActivity;
import d.hospital.R;

public class WelcomeActivity extends Activity {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private boolean time;
    private View img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        img=findViewById(R.id.textView21);
        sp = getSharedPreferences("time", MODE_PRIVATE);

        editor = sp.edit();
        time = sp.getBoolean("time", false);
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 1.0f);
        alpha.setDuration(2000);
        img.setAnimation(alpha);
        alpha.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
                if (time) {
                    //第二次打开时
                    Intent intent_main = new Intent(WelcomeActivity.this,
                            MainActivity.class);
                    startActivity(intent_main);
                    finish();
                } else {
                    //第一次安装打开
                    editor.putBoolean("time", true);
                    editor.commit();
                    Intent intent_guide = new Intent(WelcomeActivity.this,
                            MineActivity.class);
                    startActivity(intent_guide);
                    finish();
                }
            }
        });

    }
}
