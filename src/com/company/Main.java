package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String exp = "1+2+3";
        System.out.println(calculate(exp));
    }


    public static int calculate (String inExp){
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();

        for(int i = 0 ; i < inExp.length() ; i++){
            if(Character.isDigit(inExp.charAt(i))){
                numStack.push(Character.getNumericValue(inExp.charAt(i)));
            }else{
                if(inExp.charAt(i) == '*'){
                    int A = Character.getNumericValue(inExp.charAt(i+1));
                    i+=2;
                    int B = numStack.pop();
                    numStack.push(A*B);
                }else {
                    opStack.push(inExp.charAt(i));
                }
            }
        }
        int sum = 0;
        while(numStack.size() > 1){
            char op = opStack.pop();
            if(op == '+'){
                numStack.push(numStack.pop() + numStack.pop());
            }else if (op == '+'){
                numStack.push(numStack.pop() - numStack.pop());
            }
        }

        return numStack.pop();
    }

}
