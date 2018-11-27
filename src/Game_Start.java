import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Game_Start Section 에서는 게임 난이도를 설정하는 Frame을 포함한다.
 * 버튼 클릭 => (event) 난이도 변수 설정 => 창 전환(dispose)
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
		
		/*이벤트 구현부*/
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
