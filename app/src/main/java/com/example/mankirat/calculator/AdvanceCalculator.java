package com.example.mankirat.calculator;

import java.util.Scanner;


import java.util.ArrayList;

import java.util.Scanner;

import java.util.Stack;

import java.util.regex.Matcher;

import java.util.regex.Pattern;


public class AdvanceCalculator //this calculator will calculate all the expressions with operator precedence like

        //expressions people put on facebook :P

{

    ArrayList<Character> operators;

    public AdvanceCalculator()

    {

        operators = new ArrayList<>();

        operators.add('^');

        operators.add('/');

        operators.add('*');

        operators.add('+');

        operators.add('-');

    }


    public String findPostfix(String inputP)//this will return the postfix expression of given input

    {

        if (!validateInput(inputP))

            return "Invalid expression";

        String temp = "";

        ArrayList<Character> al = new ArrayList<>();

        al.add('(');

        char ch;

        inputP = inputP + ")";

        for (int i = 0; i < inputP.length(); i++)

        {

            ch = inputP.charAt(i);

            if (ch == '(')

                al.add('(');

            else if (operators.contains(ch))

            {

                al.add(ch);

                temp = temp + pop(al, ch);

            } else if (ch == ')')

                temp = temp + pop(al);

            else

            {

                while (ch != '(' && ch != ')' && !operators.contains(ch))

                {

                    temp = temp + ch;

                    i = i + 1;

                    ch = inputP.charAt(i);

                }

                temp = temp + " ";

                i = i - 1;

            }


        }

        return temp;

    }


//    boolean isOperator(char ch)//to check whether character is a operator

//    {

//        if(operators.contains(ch))

//            return true;

//        return false;

//    }


    String pop(ArrayList<Character> al, char ch)// pop all the operators of higher precedence than ch and add them to

    //temp

    {

        String temp = "";

        for (int i = al.size() - 1; al.get(i) != '(' && i >= 0; i--)

        {

            if (operators.indexOf(al.get(i)) < operators.indexOf(ch))

            {

                temp = temp + al.get(i);

                al.remove(i);

            }

        }

        return temp;

    }


    public boolean validateInput(String input) {

        if ((input.replaceAll("[^(]", "").length() != input.replaceAll("[^)]", "").length()) || input.split("[^\\d]").length == 0 || input.length() == 0)

            return false;


//                [\d|-][(|)]   [\d|)][(|\d]|[^\d|(][)|^\d]

//        [\d][(]|[)][\d]|[^\d][)]|[(][^\d]


//        String ope = "*\\/+^-";

        //to check input like 9(, )9, *),(*..

        Pattern pattern = Pattern.compile("(\\d\\()|(\\)\\d)|(\\([*\\/+^-])|([*\\/+^-]\\))");

        Matcher matcher = pattern.matcher(input);

        if (matcher.find())

            return false;


        //

        pattern = pattern.compile("[^\\d|+*^()\\/-]");

        matcher = pattern.matcher(input);

        if (matcher.find())

            return false;


        //to check if 2 consecutive operators are there...

        pattern = pattern.compile("[*-+^\\/]{2}");

        matcher = pattern.matcher(input);

        if (matcher.find())

            return false;


        return true;

    }


    String pop(ArrayList<Character> al)// pop all operators until '(' reached and add them to temp

    {

        String temp = "";

        for (int i = al.size() - 1; al.get(i) != '(' && i >= 0; i--)

        {

            temp = temp + al.get(i);

            al.remove(i);

        }

        al.remove(al.size() - 1);

        return temp;

    }


    public float evaluatePostfix(String inputP)//this will return the final result after evaluating postfix expression

    {

        Stack<Float> stack = new Stack<>();

        char ch;

        float inputA;

        float inputB;

        for (int i = 0; i < inputP.length(); i++)

        {

            ch = inputP.charAt(i);


            if (operators.contains(ch))

            {

                inputB = stack.pop();

                inputA = stack.pop();

                switch (ch)

                {

                    case '^':

                        stack.push((float) Math.pow(inputA, inputB));

                        break;

                    case '/':

                        stack.push(inputA / inputB);

                        break;

                    case '*':

                        stack.push(inputA * inputB);

                        break;

                    case '+':

                        stack.push(inputA + inputB);

                        break;

                    case '-':

                        stack.push(inputA - inputB);

                        break;

                }

            } else

            {

                String temp = "";

                while (!operators.contains(ch) && i < inputP.length() && ch != ' ')

                {

                    temp = temp + ch;

                    i = i + 1;

                    ch = inputP.charAt(i);

                }

                stack.push((Float.parseFloat(temp)));

            }


        }

        return stack.pop();

    }


    public static void main(String[] args)

    {

        System.out.println("write the expression to calculate");

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        AdvanceCalculator obj = new AdvanceCalculator();

        String postfix = obj.findPostfix(input);

        System.out.println("Postfix expression is :" + postfix);

        float result = obj.evaluatePostfix(postfix);

        System.out.println("result of " + input + " is : " + result);

    }

}

