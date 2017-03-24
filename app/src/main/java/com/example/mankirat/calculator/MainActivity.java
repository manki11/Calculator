package com.example.mankirat.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private float firstnum,secondnum;
    private boolean madd,msub,mmultiply,mdivide,mpower;
    AdvanceCalculator advanceCalculator;


    TextView text,wholeText;
    String text1;

    Button button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button add,multiply,minus,divide,clear,enter,point,openB,closeB,power,del;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstnum=0;
        secondnum=0;
        madd=false;
        msub=false;
        mmultiply=false;
        mdivide=false;
        mpower=false;

        text = (TextView) findViewById(R.id.textView);
        wholeText = (TextView) findViewById(R.id.textViewHistory);
        button1 = (Button) findViewById(R.id.one);
        button2 = (Button) findViewById(R.id.two);
        button3 = (Button) findViewById(R.id.three);
        button4 = (Button) findViewById(R.id.four);
        button5 = (Button) findViewById(R.id.five);
        button6 = (Button) findViewById(R.id.six);
        button7 = (Button) findViewById(R.id.seven);
        button8 = (Button) findViewById(R.id.eight);
        button9 = (Button) findViewById(R.id.nine);
        add = (Button) findViewById(R.id.add);
        minus = (Button) findViewById(R.id.minus);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        clear = (Button) findViewById(R.id.clear);
        enter = (Button) findViewById(R.id.enter);
        openB = (Button) findViewById(R.id.openB);
        closeB = (Button) findViewById(R.id.closeB);
        power = (Button) findViewById(R.id.power);
        del = (Button) findViewById(R.id.del);
        point=(Button) findViewById(R.id.point);


        text.setText(" ");
    }


    public void zero(View view){
        text.setText(text.getText()+"0");
        wholeText.setText(wholeText.getText()+"0");}


    public void one(View view){
        text.setText(text.getText()+"1");
        wholeText.setText(wholeText.getText()+"1");}

    public void two(View view){
        text.setText(text.getText()+"2");
        wholeText.setText(wholeText.getText()+"2");}

    public void three(View view){
        text.setText(text.getText()+"3");
        wholeText.setText(wholeText.getText()+"3");}

    public void four(View view){
        text.setText(text.getText()+"4");
        wholeText.setText(wholeText.getText()+"4");}

    public void five(View view){
        text.setText(text.getText()+"5");
        wholeText.setText(wholeText.getText()+"5");}

    public void six(View view){
        text.setText(text.getText()+"6");
        wholeText.setText(wholeText.getText()+"6");}

    public void seven(View view){
        text.setText(text.getText()+"7");
        wholeText.setText(wholeText.getText()+"7");}

    public void eight(View view){
        text.setText(text.getText()+"8");
        wholeText.setText(wholeText.getText()+"8");}

    public void nine(View view){
        text.setText(text.getText()+"9");
        wholeText.setText(wholeText.getText()+"9");}

    public void point(View view){
        text.setText(text.getText()+".");
        wholeText.setText(wholeText.getText()+".");}

    public void clear(View view){
        text.setText("");
        wholeText.setText("");
        firstnum=0;
        secondnum=0;
        madd=false;
        msub=false;
        mmultiply=false;
        mdivide=false;
    }

    public void add(View view){
        if(text==null){
            text.setText("");
        }else {
            firstnum = Float.parseFloat(text.getText() + " ");
            madd=true;
            text.setText(null);
            wholeText.setText(wholeText.getText()+"+");
        }
    }

    public void minus(View view) {
        if (text == null) {
            text.setText("");
        } else {
            firstnum = Float.parseFloat(text.getText() + " ");
            msub = true;
            text.setText(null);
            wholeText.setText(wholeText.getText()+"-");
        }
    }

    public void multiply(View view) {
        if (text == null) {
            text.setText("");
        } else {
            firstnum = Float.parseFloat(text.getText() + " ");
            mmultiply = true;
            text.setText(null);
            wholeText.setText(wholeText.getText()+"*");
        }
    }

    public void divide(View view) {
        if (text == null) {
            text.setText("");
        } else {
            firstnum = Float.parseFloat(text.getText() + " ");
            mdivide = true;
            text.setText(null);
            wholeText.setText(wholeText.getText()+"/");
        }
    }

    public void del(View view) {
        String s = text.getText().toString();
        if(s.length()>0){
        text.setText(s.substring(0, text.length() - 1));}
        else{
            text.setText("");
        }

        String e = wholeText.getText().toString();
        if(e.length()>0){
        wholeText.setText(e.substring(0, wholeText.length() - 1));}
        else{
            wholeText.setText("");
            text.setText("");
        }
    }


    public void enter(View view) {



//        advanceCalculator = new AdvanceCalculator();
//
//        text1 = wholeText.getText().toString();
//
//
//        String postfixExpression = advanceCalculator.findPostfix(text1);
//
//
//        if (postfixExpression.equals("Invalid expression")) {
//
//            wholeText.setVisibility(View.VISIBLE);
//
//            text.setText("");
//            wholeText.setText("");
//
//            return;
//
//        }
//
//
//        float result = advanceCalculator.evaluatePostfix(postfixExpression);
//
////        TODO You can make it like 2+4=6.0*2=12.0..so that further you can take actions..however i don't want it that messy;)
//
//        text.setText("" + result);

        OrderOfOperations Operations=new OrderOfOperations();
        String s=wholeText.getText().toString();

        String check=Operations.brackets(s);

        if(check.equalsIgnoreCase("Error")){
            wholeText.setText("");
            text.setText("ERROR");
        }

        String result=Operations.recognize(check);

        text.setText(""+result);


    }

    public void openB(View view){

        wholeText.setText(wholeText.getText()+"(");}

    public void closeB(View view){

        wholeText.setText(wholeText.getText()+")");}

    public void power(View view){
        firstnum = Float.parseFloat(text.getText() + " ");
        mpower=true;
        text.setText(null);
        wholeText.setText(wholeText.getText()+"^");;}

}
