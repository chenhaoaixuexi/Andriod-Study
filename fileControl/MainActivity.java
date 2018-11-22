package study.ch.filecontrol;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import study.ch.service.FileService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = this.findViewById(R.id.button);
        button.setOnClickListener(new buttonListener());
    }
    private  final  class buttonListener implements View.OnClickListener{
        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            EditText filenameText = (EditText)findViewById(R.id.filename);
            EditText fileContentText = (EditText)findViewById(R.id.filecontent);
            String filename = filenameText.getText().toString();
            String fileContent = fileContentText.getText().toString();

//        file control
            FileService  service = new FileService(getApplicationContext());
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                try {
                    service.saveSDcard(filename,fileContent);
                    Toast.makeText(getApplicationContext(), R.string.success, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),R.string.failSDCard,Toast.LENGTH_LONG);
                }
            }else {
                Toast.makeText(getApplicationContext(),R.string.failSDCard,Toast.LENGTH_LONG);
            }

        }
    }
}
