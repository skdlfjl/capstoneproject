package com.example.test;
//이 페이지는 토큰을 입력했을 때, 토큰에 따른 투표시트템이 등장해야합니다
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    static int find(String[] arr, String s) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].indexOf(s) >= 0)
                return 1;
        }
        return -1;
    }

    private TextView tv_token;
    private EditText et_studentID;
    private Button btn_next;
    private String str2;    // 입력된 학번을 받는 변수입니다, 변수 명을 바꿔주면 좋을듯...
    int where;
    String[] student_id = {"20171478","20181234","20192345","20205532","20213356"};   // 이걸 데이터베이스에서 가져와야 합니다(수정필요!!!)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 매우 중요한 설명이니 꼭 읽으세요!!!!!!!!!!!!!!!!!!!!!!!
        tv_token = findViewById(R.id.tv_token);
        Intent intent = getIntent();  // 어디선가 날라오는 데이터값이 있으면 이쪽에서 그 값을 받겠다 = getIntent()
        String str = intent.getStringExtra("str"); // 메인 액티비티에서 날려보낸 데이터값을 지정한 이름이 "str"이었으니까 여기도 "str"로 받는다
        tv_token.setText(str);
        // 이거는 그냥 텍스트뷰에 토큰을 찍어서 보여주는 코드입니다(토큰이 존재할 경우)
        // 여기서 이 받아온 토큰을 통해 student_id = {"20171478","20181234","20192345","20205532","20213356"} << 이 값을 db에서 받아와야 합니다.


        et_studentID = findViewById(R.id.et_studentID);
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // next 버튼 클릭했을때 실행되는거!!
                str2 = et_studentID.getText().toString();  // 넣은 학번을 string 형태로 가져와서 str(빈 변수)에 저장한다
                where = find(student_id,str2);
                if(where==1) {
                    Intent intent = new Intent(SubActivity.this, SubActivity2.class);
                    intent.putExtra("str2", str2);  // putExtra로 str2(입력한 학번)데이터를 담는다
                    startActivity(intent);  // 실제로 액티비티 이동하는 구문, 담은 데이터를 서브 액티비티로 쏜다!!  >>  서브 액티비티로 가서 코드를 만들어주자
                }else{
                    Toast.makeText(getApplicationContext(),"선거 참여명부에 등록되지 않은 학번입니다.",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

}