import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Game_Start Section ������ ���� ���̵��� �����ϴ� Frame�� �����Ѵ�.
 * ��ư Ŭ�� => (event) ���̵� ���� ���� => â ��ȯ(dispose)
 */
public class Game_Start extends JFrame {
	public int Difficult = 0;
	/*
	 * Easy == 0
	 * Normal == 1
	 * Hard == 2
	 */
	
	public Game_Start() {
		setTitle("select Difficulty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		setLocationRelativeTo(null);
		setResizable(false); // frame size fixed

		JPanel diff = new JPanel();
		diff.setLayout(new GridLayout(4, 1, 15, 15));

		JButton Easy = new JButton("Easy");
		JButton Normal = new JButton("Normal");
		JButton Hard = new JButton("Hard");
		JButton prev = new JButton("<< Previous");
		
		/*�̺�Ʈ ������*/
		Easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Difficult = 0;
				dispose();
				new Play();
			}
		});
		
		Normal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Difficult = 1;
				dispose();
				new Play();
			}
		});
		
		Hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Difficult = 2;
				dispose();
				new Play();
			}
		});
		
		prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//goto previous frame ;)
				dispose();
				new Title();
			}
		});
		
		diff.add(Easy);
		diff.add(Normal);
		diff.add(Hard);
		diff.add(prev);
		add(diff);
		setVisible(true);
	}
}
