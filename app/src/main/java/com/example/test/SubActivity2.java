//투표하는 창입니다
package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity2 extends AppCompatActivity {

    private TextView tv_studentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        // 매우 중요한 설명이니 꼭 읽으세요!!!!!!!!!!!!!!!!!!!!!!!
        tv_studentID = findViewById(R.id.tv_studentID);
        Intent intent = getIntent();  // 어디선가 날라오는 데이터값이 있으면 이쪽에서 그 값을 받겠다 = getIntent()
        String str = intent.getStringExtra("str2"); // 서브액티비티1에서 날려보낸 데이터값을 지정한 이름이 "str2"이었으니까 여기도 "str2"로 받는다
        tv_studentID.setText(str);
        // 이거는 그냥 텍스트뷰에 토큰을 찍어서 보여주는 코드입니다(토큰이 존재할 경우)
        // 여기서 이 받아온 토큰을 통해 student_id = {"20171478","20181234","20192345","20205532","20213356"} << 이 값을 db에서 받아와야 합니다.

    }
}