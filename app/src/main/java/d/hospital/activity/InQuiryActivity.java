package d.hospital.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import d.hospital.R;
import d.hospital.adapter.GridAdapter;
import d.hospital.adapter.InQuiry_GridView1_item_Adapter;
import d.hospital.imageUtils.AlbumActivity;
import d.hospital.imageUtils.BaseActivity;
import d.hospital.imageUtils.Bimp;
import d.hospital.imageUtils.FileUtils;
import d.hospital.imageUtils.GalleryActivity;
import d.hospital.imageUtils.ImageItem;

public class InQuiryActivity extends Activity {

    @Bind(R.id.finish_fanhui)
    ImageView finishFanhui;
    @Bind(R.id.finish_title)
    TextView finishTitle;
    @Bind(R.id.grid_view1)
    GridView gridView1;
    @Bind(R.id.et_describe)
    EditText etDescribe;
    @Bind(R.id.astrict_nummber)
    TextView astrictNummber;
    @Bind(R.id.grid_view)
    GridView gridView;
    @Bind(R.id.textView26)
    TextView textView26;
    @Bind(R.id.textView27)
    TextView textView27;
    @Bind(R.id.rl_grid_view)
    LinearLayout rlGridView;
    @Bind(R.id.rl_start)
    RelativeLayout rlStart;
    private PopupWindow pop = null;
    private LinearLayout ll_popup;
    private List<String> lists = new ArrayList<String>(Arrays.asList("糖尿病", "糖尿病", "糖尿病"
            , "糖尿病", "糖尿病", "糖尿病", "糖尿病", "糖尿病", "糖尿病", "糖尿病", "糖尿病", "糖尿病"));
    // 限制字数为300
    private int num = 300;
    public static Bitmap bimap;
    private static final int TAKE_PICTURE = 0;
    GridAdapter adapter1;
    InQuiry_GridView1_item_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);
        ButterKnife.bind(this);
        finishTitle.setText("快速问诊");
        if (Bimp.tempSelectBitmap.size() != 0) {
            textView27.setVisibility(View.GONE);
            textView26.setVisibility(View.GONE);
        }
        setView();
        initView();
    }

    private void setView() {
        adapter = new InQuiry_GridView1_item_Adapter(this, lists);
        gridView1.setAdapter(adapter);
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setSeclection(position);
                adapter.notifyDataSetChanged();
            }
        });
        etDescribe.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;
            private int selectionStart;
            private int selectionEnd;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int number = s.length();
                astrictNummber.setText("" + number + "/" + num);
                selectionStart = etDescribe.getSelectionStart();
                selectionEnd = etDescribe.getSelectionEnd();
//                if (temp.length() > number) {
//                    s.delete(selectionStart + 1, selectionEnd);
//                    int tempSelection = selectionEnd;
//                    etDescribe.setText(s);
//                    etDescribe.setSelection(tempSelection);//设置光标在最后
//                }
            }
        });

    }

    private void initView() {
        initPopu();
        // 点击GridView时出现背景色设置为透明
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        adapter1 = new GridAdapter(this);
        gridView.setAdapter(adapter1);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == Bimp.tempSelectBitmap.size()) {
                    ll_popup.startAnimation(AnimationUtils.loadAnimation(
                            InQuiryActivity.this, R.anim.activity_translate_in));
                    pop.showAtLocation(rlGridView, Gravity.BOTTOM, 0, 0);
                } else {
                    Intent intent = new Intent(InQuiryActivity.this,
                            GalleryActivity.class);
                    intent.putExtra("ID", position);
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * PopupWindow
     */
    private void initPopu() {
        pop = new PopupWindow(InQuiryActivity.this);
        View view = getLayoutInflater().inflate(R.layout.item_popupwindows, null);
        ll_popup = (LinearLayout) view.findViewById(R.id.ll_popup);

        pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        pop.setContentView(view);

        RelativeLayout parent = (RelativeLayout) view.findViewById(R.id.parent);
        Button bt1 = (Button) view.findViewById(R.id.item_popupwindows_camera);
        Button bt2 = (Button) view.findViewById(R.id.item_popupwindows_Photo);
        Button bt3 = (Button) view.findViewById(R.id.item_popupwindows_cancel);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                ll_popup.clearAnimation();
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                photo();
                pop.dismiss();
                ll_popup.clearAnimation();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(InQuiryActivity.this,
                        AlbumActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_translate_in,//activity显示的动画
                        R.anim.activity_translate_out);
                pop.dismiss();
                ll_popup.clearAnimation();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pop.dismiss();
                ll_popup.clearAnimation();
            }
        });
    }

    protected void photo() {
        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(openCameraIntent, TAKE_PICTURE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter1.notifyDataSetChanged();
        gridView.setAdapter(adapter1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PICTURE:
                if (Bimp.tempSelectBitmap.size() < 9 && resultCode == RESULT_OK) {

                    String fileName = String.valueOf(System.currentTimeMillis());
                    Bitmap bm = (Bitmap) data.getExtras().get("data");
                    FileUtils.saveBitmap(bm, fileName);

                    ImageItem takePhoto = new ImageItem();
                    takePhoto.setBitmap(bm);
                    Bimp.tempSelectBitmap.add(takePhoto);
                    textView27.setVisibility(View.GONE);
                    textView26.setVisibility(View.GONE);

                }
                break;
        }
    }

    @OnClick({R.id.rl_start, R.id.finish_fanhui})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.finish_fanhui:
                finish();
                break;

            case R.id.rl_start://提交
                for (int i = 0; i < Bimp.tempSelectBitmap.size(); i++) {
                    BaseActivity.fileList.add(new File(Bimp.tempSelectBitmap.get(i).getImagePath()));
                }
                doAn();

//                present();
                break;

        }
    }

    private void doAn() {
        List<File> a = BaseActivity.fileList;
        for (int i = 0; i < a.size(); i++) {
            File b = a.get(i);
            System.out.println("b=" + b);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (Bimp.tempSelectBitmap.size() != 0) {
            textView27.setVisibility(View.GONE);
            textView26.setVisibility(View.GONE);
        } else {
            textView27.setVisibility(View.VISIBLE);
            textView26.setVisibility(View.VISIBLE);
        }

    }
}
