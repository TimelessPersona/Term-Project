import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;
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
	public void score_Save(int score) throws IOException{
		FileWriter scoreSave = new FileWriter("score.txt");
		scoreSave.write(score);
	}
	
	
	class Game_Controller_Thread implements Runnable { // ������ ���� �δ��� ��
		public void run(){
			while (true) {
				Digda[Popup].setText(Integer.toString(0));

				Popup = rand.nextInt(10) % 9;
				Digda[Popup].setText("HIT !!!!!!!!!");
				System.out.println(score);

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
		//��ư Ŭ���� Hit�̸� ����++, �ƴϸ� ����--
		//�̺�Ʈ �� ���� ���� ���ؼ� �ϴ� �ϵ��ڵ����� 9�� ������, ������� ������ ���� ����
		Digda[0].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = Digda[0].getText();
				if(temp.equals("HIT !!!!!!!!!")){
					score++;
				}
				else {
					score--;
				}
				
			}
		});
		Digda[1].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = Digda[1].getText();
				if(temp.equals("HIT !!!!!!!!!")){
					score++;
				}
				else {
					score--;
				}
				
			}
		});
		Digda[2].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = Digda[2].getText();
				if(temp.equals("HIT !!!!!!!!!")){
					score++;
				}
				else {
					score--;
				}
				
			}
		});
		Digda[3].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = Digda[3].getText();
				if(temp.equals("HIT !!!!!!!!!")){
					score++;
				}
				else {
					score--;
				}
				
			}
		});
		Digda[4].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = Digda[4].getText();
				if(temp.equals("HIT !!!!!!!!!")){
					score++;
				}
				else {
					score--;
				}
				
			}
		});
		Digda[5].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = Digda[5].getText();
				if(temp.equals("HIT !!!!!!!!!")){
					score++;
				}
				else {
					score--;
				}
				
			}
		});
		Digda[6].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = Digda[6].getText();
				if(temp.equals("HIT !!!!!!!!!")){
					score++;
				}
				else {
					score--;
				}
				
			}
		});
		Digda[7].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = Digda[7].getText();
				if(temp.equals("HIT !!!!!!!!!")){
					score++;
				}
				else {
					score--;
				}
				
			}
		});
		Digda[8].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = Digda[8].getText();
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
		if (score==10) {
			try {
				GCT.wait();
				score_Save(score);
				System.out.println("����� ���������� ����Ǿ����ϴ�.");
			}catch(InterruptedException e) {
				e.printStackTrace();
			}catch(IOException e) {
				System.out.println("����� ���������� ������� �ʾҽ��ϴ�.");
			}
			
		}
		
		
	}
	public int getScore() {
		return score;
	}
}
