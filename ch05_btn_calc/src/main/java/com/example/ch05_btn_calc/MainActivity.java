package com.example.ch05_btn_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main_table);


        //1.java 객체를 만든다
        EditText edt1 = findViewById(R.id.Edit1);;
        EditText edt2;

        Button btn1;
        Button btn2;
        Button btn3;
        Button btn4;
        Button btn5;//나머지 버튼 추가

        TextView tv1;

        //2.xml객체를 java객체에 연결한다(바인딩)
//        edt1 = findViewById(R.id.Edit1);
        edt2 = findViewById(R.id.Edit2);

        btn1 = findViewById(R.id.BtnAdd);
        btn2 = findViewById(R.id.BtnSub);
        btn3 = findViewById(R.id.BtnMul);
        btn4 = findViewById(R.id.BtnDiv);

        btn5 = findViewById(R.id.BtnMod);//나머지

        tv1 = findViewById(R.id.TextResult);

        //3.java객체에 효과(메소드나 멤버변수 사용)를 준다

        //4.java객체에 이벤트 처리를 한다.
        //4-1.이벤트 리스너 객체를 만든다.
        class MyListener implements View.OnClickListener {

            @Override
            public void onClick(View v) {
                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                int n1 = Integer.parseInt(str1);
                int n2 = Integer.parseInt(str2);

                int result = n1 + n2;

//                tv1.setText(String.valueOf(result));
                tv1.setText("계산결과:"+result);
            }
        }

        MyListener lis1 = new MyListener();

        //4-2.java객체에 리스너 객체를 등록한다.(리스너 객체 사용)
//        btn1.setOnClickListener(리스너객체);
        btn1.setOnClickListener(lis1);


        //2번째 빼기 리스너
        class MyListener2 implements View.OnClickListener {

            @Override
            public void onClick(View v) {
                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                int n1 = Integer.parseInt(str1);
                int n2 = Integer.parseInt(str2);

                int result = n1 - n2;

//                tv1.setText(String.valueOf(result));
                tv1.setText("계산결과:"+result);
            }
        }

//        MyListener2 lis2 = new MyListener2();
        btn2.setOnClickListener(new MyListener2());

        //3번째 곱하기
        //2번째 빼기 리스너
//        class MyListener3 implements View.OnClickListener {
//
//            @Override
//            public void onClick(View v) {
//                String str1 = edt1.getText().toString();
//                String str2 = edt2.getText().toString();
//
//                int n1 = Integer.parseInt(str1);
//                int n2 = Integer.parseInt(str2);
//
//                int result = n1 * n2;
//
////                tv1.setText(String.valueOf(result));
//                tv1.setText("계산결과:"+result);
//            }
//        }

//        MyListener2 lis2 = new MyListener2();
//        btn3.setOnClickListener(new MyListener3());
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                if(str1.equals("") || str2.equals(""))
                {

                }
                else
                {
                    int n1 = Integer.parseInt(str1);
                    int n2 = Integer.parseInt(str2);

                    int result = n1 * n2;

//                tv1.setText(String.valueOf(result));
                    tv1.setText("계산결과:"+result);
                }

            }
        });

//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        btn4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                if(str1.equals("") || str2.equals(""))
                {
                    Toast.makeText(MainActivity.this,
                            "값을 입력해주세요",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(str2.equals("0"))
                    {
                        Toast.makeText(MainActivity.this,
                                "0으로 나눌수 없어요!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else//정상
                    {
                        double n1 = Double.parseDouble(str1);
                        double n2 = Double.parseDouble(str2);
                        double result = n1 /n2;
                        result = (int)(result*100)/100.0;

//                tv1.setText(String.valueOf(result));
                        tv1.setText("계산결과:"+result);
                    }
                }
                return false;
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                //editText에 값이 없을때, 토스트 띄우기
                if(str1.equals("") || str2.equals(""))
                {
                    Toast.makeText(MainActivity.this,
                            "값을 입력해주세요",
                            Toast.LENGTH_SHORT).show();
                }
                else//정상일때
                {
                    double n1 = Double.parseDouble(str1);
                    double n2 = Double.parseDouble(str2);

                    double result = n1 % n2;

//                tv1.setText(String.valueOf(result));
                    tv1.setText("계산결과:"+result);
                }
            }
        });

        //숫자버튼 추가
//        Button btn00 = findViewById(R.id.BtnNum0);
//        Button btn01 = findViewById(R.id.BtnNum1);
//        Button btn02 = findViewById(R.id.BtnNum2);
//        Button btn03 = findViewById(R.id.BtnNum3);
//        Button btn04 = findViewById(R.id.BtnNum4);
//        Button btn05 = findViewById(R.id.BtnNum5);
//        Button btn06 = findViewById(R.id.BtnNum6);
//        Button btn07 = findViewById(R.id.BtnNum7);
//        Button btn08 = findViewById(R.id.BtnNum8);
//        Button btn09 = findViewById(R.id.BtnNum9);



//        int btnIdArr[] = new int[9];
        int btnIdArr[] = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
                          R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5,
                          R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8,
                          R.id.BtnNum9};

        Button btnArr[] = new Button[btnIdArr.length];//객체배열
        for(int i=0; i<btnIdArr.length;++i)
        {
//            btnArr[i] = findViewById(R.id.BtnNum0);
//            btnArr[i] = findViewById(R.id.BtnNum+i);
            btnArr[i] = findViewById(btnIdArr[i]);
        }


        for(int i=0; i<btnArr.length;++i)
        {
            int final_i = i;
    //        btn01.setOnClickListener(new View.OnClickListener() {
            btnArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edt1.isFocused())//포커스가 edt1에 있을때
                    {
                        edt1.setText(edt1.getText().toString() + final_i);
                    } else if (edt2.isFocused())//포커스가 edt2에 있을때
                    {
                        edt2.setText(edt2.getText().toString() + final_i);
                    }

                }
            });
        }

//        btn00.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())//포커스가 edt1에 있을때
//                {
//                    edt1.setText(edt1.getText().toString()+"0");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"0");
//                }
//
//            }
//        });

//    btn01 = findViewById(R.id.BtnNum3);



//        btn01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())//포커스가 edt1에 있을때
//                {
//                    edt1.setText(edt1.getText().toString()+"1");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"1");
//                }
//
//            }
//        });

//        btn02.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())//포커스가 edt1에 있을때
//                {
//                    edt1.setText(edt1.getText().toString()+"2");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"2");
//                }
//
//            }
//        });
//
//        btn03.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())//포커스가 edt1에 있을때
//                {
//                    edt1.setText(edt1.getText().toString()+"3");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"3");
//                }
//
//            }
//        });
//
//        btn04.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())//포커스가 edt1에 있을때
//                {
//                    edt1.setText(edt1.getText().toString()+"4");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"4");
//                }
//
//            }
//        });
//
//        btn05.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())//포커스가 edt1에 있을때
//                {
//                    edt1.setText(edt1.getText().toString()+"5");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"5");
//                }
//
//            }
//        });
//
//        btn06.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())//포커스가 edt1에 있을때
//                {
//                    edt1.setText(edt1.getText().toString()+"6");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"6");
//                }
//
//            }
//        });
//
//        btn07.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())//포커스가 edt1에 있을때
//                {
//                    edt1.setText(edt1.getText().toString()+"7");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"7");
//                }
//
//            }
//        });
//
//        btn08.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())//포커스가 edt1에 있을때
//                {
//                    edt1.setText(edt1.getText().toString()+"8");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"8");
//                }
//
//            }
//        });
//
//        btn09.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edt1.isFocused())//포커스가 edt1에 있을때
//                {
//                    edt1.setText(edt1.getText().toString()+"9");
//                }
//                else if(edt2.isFocused())//포커스가 edt2에 있을때
//                {
//                    edt2.setText(edt2.getText().toString()+"9");
//                }
//
//            }
//        });



    }
}