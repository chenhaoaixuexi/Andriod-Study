package study.ch.service;

import android.content.Context;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileService {
    private Context context;
    public FileService(Context context){
        this.context = context;
    }

    public void saveSDcard(String filename, String filecontent) throws IOException {
        File file = new File(Environment.getExternalStorageDirectory(),filename);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(filecontent.getBytes());
        fileOutputStream.close();
    }

    /**
     * @param filename
     * @param content
     * @throws IOException
     */
    public void save(String filename,String content) throws IOException {
        FileOutputStream outputStream = context.openFileOutput(filename, context.MODE_PRIVATE);
        outputStream.write(content.getBytes());
        outputStream.close();
    }
    public void saveAppend(String filename,String content) throws IOException {
        FileOutputStream outputStream = context.openFileOutput(filename, context.MODE_APPEND);
        outputStream.write(content.getBytes());
        outputStream.close();
    }
    public void saveWriteable(String filename,String content) throws IOException {
        FileOutputStream outputStream = context.openFileOutput(filename, context.MODE_APPEND);
        outputStream.write(content.getBytes());
        outputStream.close();
    }
    public void saveRW(String filename,String content) throws IOException {
        FileOutputStream outputStream = context.openFileOutput(filename, context.MODE_APPEND);
        outputStream.write(content.getBytes());
        outputStream.close();
    }
    public String read(String filename) throws IOException {
        FileInputStream inputStream = context.openFileInput(filename);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffBytes = new byte[1024];
        int len = 0;
        while (-1 != (len = inputStream.read(buffBytes))){
            outputStream.write(buffBytes, 0, len);
        }
        byte[] data = outputStream.toByteArray();
        return new String(data);
    }
}
