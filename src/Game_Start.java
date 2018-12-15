import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Game_Start Section ������ ���� ���̵��� �����ϴ� Frame�� �����Ѵ�.
 * ��ư Ŭ�� => (event) ���̵� ���� ���� => â ��ȯ(dispose)
 */
public class Game_Start extends JFrame {
	public int Difficult = 0;
	public static int timerLength;
	
	public static int getTime() {
		int time = timerLength;
		return time;
	}
	/*
	 * Easy == 0
	 * Normal == 1
	 * Hard == 2
	 */
// Ÿ�̸� ������, 1�ʸ��� �ð� ���
	class Countdown extends JFrame {
		private JLabel timelabel;
		class timerThread extends Thread {
			public void run() {
				if (timerLength < 0) {
					
				}
				for (int i = timerLength; i<0; i--) {
					timelabel = new JLabel("���� �ð� : "+i);
					try {
						Thread.sleep(1000);
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		public Countdown() {
			setTitle("Ÿ�̸�");
			setSize(250,250);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel timerpanel = new JPanel();
			timelabel = new JLabel("Start");
			timelabel.setFont(new Font("serif", Font.BOLD, 100));
			timerpanel.add(timelabel);
			add(timerpanel);
			new timerThread().start();
			setVisible(true);
		}
	}
	
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
				timerLength = 40;
				dispose();
				new Play();
				new Countdown();

			}
		});
		
		Normal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Difficult = 1;
				timerLength = 30;
				dispose();
				new Play();
				new Countdown();
			}
		});
		
		Hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Difficult = 2;
				timerLength = 20;
				dispose();
				new Play();
				new Countdown();
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
