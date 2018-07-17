package com.example.mydata;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
    String name1 = "jone01";
    String name2 = "jane02";
    String name3 = "david03";
    String name4 = "connan04";
    String name5 = "james05";
    */

    // String[] names = new String[5];

    String[] names = { "da01","da02","da03","da04","da05"};

    int count = 0;
    //Person person;
    // 각각의 데이타를 배열의 구조 속에서 자동으로 집어 넣기 위해....
    //Person[] persons = new  Person[5];
    // 오류 난다. 쩝..
    //Person[][] phonebook = new Person[2][5];
    //String[][] phonebook = new String[2][5];

    // ArrayList 사용
    ArrayList<Person> persons = new ArrayList<Person>();

    //
    ArrayList<ArrayList<String>> phonebook =new ArrayList<ArrayList<String>>();

    TextView textView ;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        container = (LinearLayout) findViewById(R.id.container);

        ArrayList<String> friends = new ArrayList<String>();
/*

        //2차원 배열..데이타 담기
        String[] friends = {"철수","영희","민희","수지","지민"};
        phonebook[0] = friends;

        String[] family = {"할아버지","할머니","아버지","엄마","동생"};
        phonebook[1] = family;




        // 2차원 배열의 값 뿌리기...
        for (int i=0 , i < phonebook.length; i++){
            for (int j=0, j < phonebook[i].length; j++ ){

                System.out.println("2차원 배열의 값(" + i "," + j+ "):" + phonebook[i][j] );

            }
        }

*/
        /*
        names[0]= "da01";
        names[1]= "da02";
        names[2]= "da03";
        names[3]= "da04";
        names[4]= "da05";
        */

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 5개 보다 더 많은 데이타가 생겨서 그걸 복사해서 크기를 크게 만들어 넣는다.
                // 따라서 중간에 데이타를 담아 둘..tempPersons 라는 배열에 기존 배열 데이타를 잠시 넣고
                // 기존 배열의 크기를 증가한 후 복사 다시 사용한다.
/*                if (count >= persons.length ){
                    Person[] tempPersons = new Person[persons.length + 5];
                    System.arraycopy(persons,0,tempPersons,0,persons.length);
                    persons = tempPersons;
                }
*/

                int nameIndex = count % 5;
                //persons[count] = new Person(names[nameIndex]);
                // ArrayList 타입의
                Person aPerson = new Person(names[nameIndex]);
                persons.add(aPerson);



                Toast.makeText(getApplicationContext(), names[nameIndex] + "No man", Toast.LENGTH_LONG).show();




                if (count< names.length){
                    //person = new Person(names[count]);
                    persons[count] = new Person(names[count]);
                } else {
                    Toast.makeText(getApplicationContext(), names[nameIndex] + "No man", Toast.LENGTH_LONG).show();
                }

                count++;
                textView.setText(count+"명생성");

                TextView nameTextView = new TextView(getApplicationContext());
                nameTextView.setText(names[nameIndex]);
                nameTextView.setTextSize(50.0f);
                nameTextView.setTextColor(Color.BLUE);

                container.addView(nameTextView);

                for( int i=0 ; i <names.length; i++){

                    //Logcat.. 윽.. 않됨
                    System.out.println("Name"+i+";"+ names[i]);
                    Toast.makeText(getApplicationContext(),"Name"+i+";"+ names[i],Toast.LENGTH_LONG).show();
                }


                /*
                String name = "";
                if (count == 0) {
                    name = name1;
                    person = new Person(name);
                } else if (count == 1 ) {
                    name = name2;
                    person = new Person(name);
                } else if (count == 2 ) {
                    name = name3;
                    person = new Person(name);
                } else if (count == 3 ) {
                    name = name4;
                    person = new Person(name);
                } else if (count == 4 ) {
                    name = name5;
                    person = new Person(name);
                }
                */



            }
        });

    }
}
