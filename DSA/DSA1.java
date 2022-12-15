package DSA;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class DSA1 {
    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static StringBuilder infixToPreFix(String expression){

        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        Stack<Character> stack = new Stack<>();

        char [] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {

            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            }
            else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (int i = 0; i <charsExp.length ; i++) {
            char c = charsExp[i];

            //check if char is operator or operand
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    result.append(stack.pop());
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result.append(x);
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{

                result.append(c);
            }
        }

        for (int i = 0; i <=stack.size() ; i++) {
            result.append(stack.pop());
        }
        return result.reverse();
    }
    public String infixToPostfix(String s) {
        String postfix = "";
        Stack<Character> st = new Stack<Character>();
        char ch[] = s.toCharArray();
        for (char c : ch) {
            if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
                postfix = postfix + c;
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty()) {
                    char t = st.pop();
                    if (t != '(') {
                        postfix = postfix + t;
                    } else {
                        break;
                    }

                }

            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (st.isEmpty()) {
                    st.push(c);
                }
                else {
                    while (!st.isEmpty()) {
                        char t = st.pop();
                        if (t == '(') {
                            st.push(t);
                            break;
                        }
                        else if (c == '+' || c == '-' || c == '*' || c == '/') {
                            if (getPriority(t) < getPriority(c)){
                                st.push(t);
                                break;
                            }
                            else{
                                postfix = postfix+ t;
                            }
                        }
                    }
                    st.push(c);
                }
             }

         }
        while (!st.isEmpty()){
            postfix = postfix+ st.pop();
        }
        return (postfix);
    }


    public int getPriority(char c){
        if (c=='+' || c=='-'){
            return 1;
        }
        else {
            return 2;
        }
    }
    public static void main(String[] args) {
        A obj1= new A();
        DSA1 o = new DSA1();
        String s1 ="a+b*(a*b-c)";
        System.out.println(o.infixToPostfix(s1));
        System.out.println(obj1.infixToPrefix(s1));

        Frame f = new Frame("INFIX TO PREFIX & POSTFIX");
        f.setBounds(0,0,500,500);
        f.setSize(500,500);

        f.setBackground(Color.black);
        f.setVisible(true);
        f.setLayout(null);
        JPanel p = new JPanel();
        ImageIcon background=new ImageIcon("");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(500,500,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,500,500);
        p.setBounds(0,0,500,500);
        p.add(back);
        f.add(p);

        Label l1 = new Label("CONVERT INFIX TO PREFIX & POSTFIX");
        l1.setAlignment(Label.CENTER);
        l1.setBounds(100,100,300,30);
        l1.setBackground(Color.pink);
        p.add(l1);

        Label l2 = new Label("Enter the expression");
        l2.setBounds(60,180,160,30);
        l2.setBackground(Color.pink);
        l2.setAlignment(Label.CENTER);
        p.add(l2);

        TextField t1 = new TextField();
        t1.setBounds(270,180,160,30);
        t1.setBackground(Color.pink);
        p.add(t1);

        Label l3= new Label();
        l3.setBounds(140,340,220,30);
        l3.setBackground(Color.pink);
        p.add(l3);

        Button b1 = new Button("convert to postfix");
        b1.setBackground(Color.pink);
        b1.setBounds(280,260,130,30);
        p.add(b1);

        Button b2 = new Button("convert to prefix");
        b2.setBackground(Color.pink);
        b2.setBounds(90,260,130,30);
        p.add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l3.setText(o.infixToPostfix(t1.getText()));
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String st = t1.getText();
                l3.setText(String.valueOf(infixToPreFix(st.toString())));
            }
        });

        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
            f.dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
    }

