package study.ch.helloworld;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class chActivity extends Activity {
    private Button btnOne;
    private Button btnTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch);

//        btnOne = (Button) findViewById(R.id.submit1);
//        btnTwo = (Button) findViewById(R.id.submit2);
//        btnTwo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(btnTwo.getText().toString().equals("按钮不可用")){
//                    btnOne.setEnabled(false);
//                    btnTwo.setText("按钮可用");
//                }else{
//                    btnOne.setEnabled(true);
//                    btnTwo.setText("按钮不可用");
//                }
//            }
//        });

//        btn_add = (Button) findViewById(R.id.submit);
//        edit_one = (EditText) findViewById(R.id.edit);
//
//        btn_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SpannableString spanStr = new SpannableString("imge");
//                Drawable drawable = chActivity.this.getResources().getDrawable(R.drawable.ptr);
//                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
//                ImageSpan span = new ImageSpan(drawable,ImageSpan.ALIGN_BASELINE);
//                spanStr.setSpan(span,0,4,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                int cursor = edit_one.getSelectionStart();
//                edit_one.getText().insert(cursor, spanStr);
//            }
//        });
    }
}

