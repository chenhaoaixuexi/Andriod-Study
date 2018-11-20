package study.ch.helloworld;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;


public class chActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ToggleButton tbtn_open;
    private Switch swh_status;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_ch);

        tbtn_open = (ToggleButton)findViewById(R.id.tbtn_open);
        swh_status = (Switch)findViewById(R.id.swh_status);
        tbtn_open.setOnCheckedChangeListener(this);
        swh_status.setOnCheckedChangeListener(this);
    }

    /**
     * Called when the checked state of a compound button has changed.
     *
     * @param compoundButton The compound button view whose state has changed.
     * @param b  The new checked state of buttonView.
     */
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId())
        {
            case R.id.tbtn_open:
                if(compoundButton.isChecked())
                    Toast.makeText(this, "打开声音", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "关闭声音", Toast.LENGTH_SHORT).show();
                break;
            case R.id.swh_status:
                if(compoundButton.isChecked())
                    Toast.makeText(this, "开关:ON", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "开关:OFF", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}

