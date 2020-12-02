package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CreatActivity3 extends AppCompatActivity {

    private Button btn_revert;

    private TextView tv_list1;
    private TextView tv_list2;
    private int list1_size;
    private int list2_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat3);

        tv_list1 = findViewById(R.id.tv_list1);
        tv_list2 = findViewById(R.id.tv_list2);

        Intent intent = getIntent();  // 어디선가 날라오는 데이터값이 있으면 이쪽에서 그 값을 받겠다 = getIntent()
        ArrayList list1 = (ArrayList) intent.getSerializableExtra("list1");
        ArrayList list2 = (ArrayList) intent.getSerializableExtra("list2");

        list1_size = list1.size();
        for(int i=0; i<list1_size; i++){
            tv_list1.setText((String) list1.get(i));
        }

        list2_size = list2.size();
        for(int i=0; i<list2_size; i++){
            tv_list2.setText((String) list2.get(i));
        }


        //이건 버튼 눌렀을 때 맨 처음화면으로 돌아가는거
        btn_revert = findViewById(R.id.btn_revert);
        btn_revert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}