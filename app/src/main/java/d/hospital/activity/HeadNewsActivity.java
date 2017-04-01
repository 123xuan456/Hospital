package d.hospital.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import d.hospital.R;
import d.hospital.view.FlowLayout;

/**
 * 健康头条
 */
public class HeadNewsActivity extends AppCompatActivity {

    @Bind(R.id.finish_fanhui)
    ImageView finishFanhui;
    @Bind(R.id.finish_title)
    TextView finishTitle;
    @Bind(R.id.iv_titlenews)
    ImageView ivTitlenews;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_titleImage)
    ImageView ivTitleImage;
    @Bind(R.id.tv_titleActiclor)
    TextView tvTitleActiclor;
    @Bind(R.id.tv_articleTime)
    TextView tvArticleTime;
    @Bind(R.id.rv_articleContent)
    RecyclerView rvArticleContent;
    @Bind(R.id.type)
    FlowLayout type;
    @Bind(R.id.iv_share)




    ImageView ivShare;
    @Bind(R.id.view1)
    View view1;
    @Bind(R.id.tv_share)
    TextView tvShare;
    @Bind(R.id.view2)
    View view2;
    @Bind(R.id.rv_recommand)
    RecyclerView rvRecommand;
    @Bind(R.id.activity_head_news)
    LinearLayout activityHeadNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_news);
        ButterKnife.bind(this);
    }
}
