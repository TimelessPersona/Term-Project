import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * MEMO - �ڹ�
 * 
 * ���� ������(Thread) ���� ���� �߻� => �� ���� %9 => �ش� ��ư 1�� ����
 * 
 * Event ó�� => ��ư ������ �� ��ư�� (getName() == 1)�̸� score++
 * 
 * -���� ����Ŭ������ �ۼ��ؾ��� (���ټ�)
 */
public class Play extends JFrame {
	Random rand = new Random();
	JButton[] Digda = new JButton[9]; // �δ����� �� ��ư��, Thread���� �����ϱ� ���� ����� ����
	int Popup = 0;
	int score = 0;

	class Game_Controller_Thread implements Runnable { // ������ ���� �δ��� ��
		public void run() {
			while (true) {
				Digda[Popup].setText(Integer.toString(0));

				Popup = rand.nextInt(10) % 9;
				Digda[Popup].setText("HIT !!!!!!!!!");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}

			}
		}
	}

	public Play() {
		setTitle("Play");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false); // frame size fixed

		setLayout(new GridLayout(3, 3, 30, 30)); // �δ��� ��� ���̺� == 3*3

		for (int i = 0; i < 9; i++) {
			Digda[i] = new JButton("0"); // �δ��� �� ���� == 0, ���� ���� == 1
			add(Digda[i]);
		}
		Digda[Popup].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = Digda[Popup].getText();
				if(temp.equals("HIT !!!!!!!!!")){
					score++;
				}
				else {
					score--;
				}
				
			}
		});

		Thread GCT = new Thread(new Game_Controller_Thread());

		GCT.start();
		setVisible(true);
	}
}
