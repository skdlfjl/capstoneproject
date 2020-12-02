package com.example.test;
//선거명부 입력 후에 후보 명단과 공약을 입력 받습니다.
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.*;

public class CreatActivity2 extends AppCompatActivity {

    private EditText et_name;
    private EditText et_pledge;
    private TextView tv_display;

    static final String mFILENAME = "myContacts2.txt";

    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat2);

        et_name = (EditText) findViewById(R.id.et_name);
        et_pledge = (EditText) findViewById(R.id.et_pledge);
        tv_display = (TextView) findViewById(R.id.tv_display);

        displayContacts();

        Intent intent = getIntent();  // 어디선가 날라오는 데이터값이 있으면 이쪽에서 그 값을 받겠다 = getIntent()
        ArrayList list1 = (ArrayList) intent.getSerializableExtra("list1");

        btn_next = (Button) findViewById(R.id.btn_next);
        // next 버튼 누르면 생기는 일
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list2.size() > 0) {
                    Intent intent = new Intent(CreatActivity2.this, CreatActivity3.class);
                    intent.putExtra("list1", list1);
                    intent.putExtra("list2", list2);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "후보 이름이 작성되지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void mOnInsertClick(View view) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = null;

        try {
            fos = openFileOutput(mFILENAME, Context.MODE_APPEND);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);

            String name = et_name.getText().toString();
            String pledge = et_pledge.getText().toString();

            dos.writeUTF(name);
            dos.writeUTF(pledge);

            dos.flush();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (dos != null) dos.close();
                if (bos != null) bos.close();
                if (fos != null) fos.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        displayContacts();

        et_name.setText("");
        et_pledge.setText("");
    }

    public void mOnDeleteClick(View view) {
        //지정된 파일 자체를 삭제할 수 있게하는 코드
        if (deleteFile(mFILENAME)) {
            tv_display.setText("delete success");
            list2.clear();
        }else
            tv_display.setText("delete failed");
    }



    ArrayList list2 = new ArrayList();
    private void displayContacts() {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        try {
            fis = openFileInput(mFILENAME);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            String str = "";
            while (dis.available() > 0) {
                String name = dis.readUTF();
                String pledge = dis.readUTF();

                str += name + " | " + pledge + "\n";
            }
            tv_display.setText(str);

            list2.add(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
                if (bis != null) bis.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}