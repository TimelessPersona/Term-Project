import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class How_To_Play extends JFrame{
	public How_To_Play() {
		setTitle("How To Play?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
		setLocationRelativeTo(null);
		setResizable(false); // frame size fixed
		
		JPanel How_To_Play = new JPanel();
		
		JLabel explain = new JLabel();
		JButton prev = new JButton("<< Previous");
		
		explain.setText("<html>== ���� ��� == "
				+ "<br>1. ���� Ű�� qwe/asd/zxc �̰� ���� 1, 2, 3/4, 5, 6/7, 8, 9 ��° �δ�����  �����ȴ�.\n"
				+ "<br>2. ���̵��� ���̸� �־����� �ð�, �δ����� ����� �� ������ ��������."
				+ "<br>3. ��ſ� ���� �÷��� �Ǽ���!</html>");
		
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//goto previous frame ;)
				dispose();
				new Title();
			}
		});
		
		How_To_Play.add(explain);
		How_To_Play.add(prev);
		this.add(How_To_Play);
		
		setVisible(true);
	}
}
