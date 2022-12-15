package DSA;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
class Main {
    public static void main(String[] args) {
        ImagePanel panel = new ImagePanel(
                new ImageIcon("C:\\Users\\Satbharai\\IdeaProjects\\Semester_project_DSA\\src\\DSA\\ppp.jpg").getImage());

        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setBounds(50,50,500,500);
        frame.setVisible(true);

        DSA1 obj1= new DSA1();
        A o= new A();


        Label l1 = new Label("INFIX TO PREFIX AND INFIX TO POSTFIX CONVERSION");
        l1.setAlignment(Label.CENTER);
        Font font = new Font("Courier", Font.BOLD,13);
        l1.setForeground(Color.black);
        l1.setFont(font);
        l1.setBounds(40,100,420,30);
        l1.setBackground(Color.white);

        panel.add(l1);

        Label l2 = new Label("Enter the infix expression");
        l2.setBounds(40,180,200,30);
        l2.setBackground(Color.green);
        l2.setAlignment(Label.CENTER);
        Font font2 = new Font("Courier", Font.BOLD,14);
        l2.setForeground(Color.black);
        l2.setFont(font2);
        panel.add(l2);

        TextField t1 = new TextField();
        t1.setBounds(270,180,160,30);
        t1.setBackground(Color.white);
        Font font3 = new Font("Courier", Font.BOLD,15);
        t1.setForeground(Color.black);
        t1.setFont(font3);
        panel.add(t1);

        Label l3= new Label();
        l3.setBounds(140,340,220,30);
        l3.setBackground(Color.green);
        Font font4 = new Font("Courier", Font.BOLD,15);
        l3.setForeground(Color.black);
        l3.setFont(font4);
        panel.add(l3);

        Button b1 = new Button("convert to postfix");
        b1.setBackground(Color.green);
        b1.setBounds(280,260,130,30);
        Font font5 = new Font("Courier", Font.BOLD,13);
        b1.setForeground(Color.black);
        b1.setFont(font5);
        panel.add(b1);

        Button b2 = new Button("convert to prefix");
        b2.setBackground(Color.white);
        b2.setBounds(90,260,130,30);
        Font font6 = new Font("Courier", Font.BOLD,13);
        b2.setForeground(Color.black);
        b2.setFont(font6);
        panel.add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l3.setText(String.valueOf(obj1.infixToPostfix(t1.getText())));
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String st = t1.getText();
                l3.setText(String.valueOf(obj1.infixToPreFix(st.toString())));
            }
        });
    }
}
class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0,500,500,null);
    }
}

