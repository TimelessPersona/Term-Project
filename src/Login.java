import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//로그인 화면
public class Login extends JFrame {
   public ArrayList<String> id = new ArrayList<>();
   public ArrayList<String> pw = new ArrayList<>();

   public Login() {
      setTitle("Login");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(300, 150);

      JPanel Loginpanel = new JPanel();
      Loginpanel.setLayout(null);

      JLabel IDLabel = new JLabel("ID:");
      IDLabel.setBounds(10, 10, 80, 25);
      JTextField IDtext = new JTextField(20);
      IDtext.setBounds(100, 10, 160, 25);
      JLabel PWLabel = new JLabel("Password:");
      PWLabel.setBounds(10, 40, 80, 25);
      JTextField PWtext = new JTextField(20);
      PWtext.setBounds(100, 40, 160, 25);
      JButton backButton = new JButton("뒤로가기");
      backButton.setBounds(1, 80, 85, 25);
      JButton LoginButton = new JButton("로그인");
      LoginButton.setBounds(105, 80, 80, 25);
      JButton SignButton = new JButton("회원가입");
      SignButton.setBounds(201, 80, 85, 25);

      backButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
            new Title();
         }
      });

      LoginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            BufferedReader rId = null, rPw = null;
            String str;
            try {
               rId = new BufferedReader(new FileReader("Read_ID.txt"));
            } catch (FileNotFoundException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            try {
               rPw = new BufferedReader(new FileReader("Read_PW.txt"));
            } catch (FileNotFoundException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            try {
               while ((str = rId.readLine()) != null) {
                  id.add(str);
                  pw.add(rPw.readLine());
               }
            } catch (IOException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }

            if (id.contains(IDtext.getText()) && pw.contains(PWtext.getText())) {
               JOptionPane.showMessageDialog(null, "Login success");
               new Title();
               dispose();
            } else
               JOptionPane.showMessageDialog(null, "Login false");
         }
      });

      SignButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
            new SignUp();
         }
      });

      Loginpanel.add(IDLabel);
      Loginpanel.add(IDtext);
      Loginpanel.add(PWLabel);
      Loginpanel.add(PWtext);
      Loginpanel.add(backButton);
      Loginpanel.add(LoginButton);
      Loginpanel.add(SignButton);

      add(Loginpanel);
      setVisible(true);
   }

   public static void main(String args[]) {
      new Login();
   }

}

// 회원가입 화면
class SignUp extends JFrame {
   boolean FLAG = false;
   public SignUp() {

      setTitle("Sign up");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500, 200);

      JPanel Sign_panel = new JPanel();
      Sign_panel.setLayout(new BoxLayout(Sign_panel, BoxLayout.Y_AXIS));

      JPanel IDPanel = new JPanel();
      IDPanel.add(IDText, BorderLayout.WEST);
      IDPanel.add(IDB, BorderLayout.EAST);

      JPanel PWPanel = new JPanel();
      PWPanel.add(PWText, BorderLayout.WEST);
      PWPanel.add(SignButton, BorderLayout.EAST);

      JPanel backPanel = new JPanel();
      JButton backButton = new JButton("취소");
      backPanel.add(backButton);

      backButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
            new Login();
         }
      });

      IDB.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            BufferedReader RID = null;
            String str;
            ArrayList id = new ArrayList();
            try {
               RID = new BufferedReader(new FileReader("Read_ID.txt"));
            } catch (FileNotFoundException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            try {
               while ((str = RID.readLine()) != null) {
                  id.add(str);
               }
            } catch (IOException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            String check = IDText.getText();
            

            for (int i = 0; i < id.size(); i++) {
               if (id.contains(check)) {
                  FLAG = true;
                  JOptionPane.showMessageDialog(null, "OverLap");
                  break;
               }
               if (!id.contains(check)) {
                  JOptionPane.showMessageDialog(null, "Available");
                  break;
               }

            }

         }
      });

      SignButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
               BufferedWriter wid = new BufferedWriter(new FileWriter("Read_ID.txt", true));
               BufferedWriter wpw = new BufferedWriter(new FileWriter("Read_PW.txt", true));
               
               if(FLAG == false) {
               wid.write(IDText.getText() + "\n");
               wpw.write(PWText.getText() + "\n");
               
               JOptionPane.showMessageDialog(null, "Sign up success");
               dispose();
               new Login();
               }
               if(FLAG == true) {
                  JOptionPane.showMessageDialog(null, "Sign up false");
               }

            } catch (Exception e1) {
               JOptionPane.showMessageDialog(null, "Sign up false");
            }
         }
      });

      Sign_panel.add(IDPanel);
      Sign_panel.add(PWPanel);
      Sign_panel.add(backPanel);

      add(Sign_panel);
      setVisible(true);
   }

   JTextField IDText = new JTextField(20);
   JButton IDB = new JButton("중복 확인");

   JTextField PWText = new JTextField(20);
   JButton SignButton = new JButton("회원 등록");

}