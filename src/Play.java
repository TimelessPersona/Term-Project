import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;
/*
 * MEMO - 박민
 * 
 * 일정 딜레이(Thread) 마다 난수 발생 => 그 난수 %9 => 해당 버튼 1로 변경
 * 
 * Event 처리 => 버튼 눌렀을 때 버튼의 (getName() == 1)이면 score++
 * 
 * -전부 내부클래스로 작성해야함 (접근성)
 */
public class Play extends JFrame {
	Random rand = new Random();
	JButton[] Digda = new JButton[9]; // 두더지가 될 버튼들, Thread에서 접근하기 위해 멤버로 선언
	int Popup = 0;
	int score = 0;
	public void score_Save(int score) throws IOException{
		FileWriter scoreSave = new FileWriter("score.txt");
		scoreSave.write(score);
	}
	
	
	class Game_Controller_Thread implements Runnable { // 딜레이 마다 두더지 뿅
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

		setLayout(new GridLayout(3, 3, 30, 30)); // 두더지 잡기 테이블 == 3*3

		for (int i = 0; i < 9; i++) {
			Digda[i] = new JButton("0"); // 두더지 들어간 상태 == 0, 나온 상태 == 1
			add(Digda[i]);
		}
		//버튼 클릭시 Hit이면 점수++, 아니면 점수--
		//이벤트 한 번에 구현 못해서 일단 하드코딩으로 9개 구현함, 수정방법 있으면 수정 예정
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
				System.out.println("결과가 정상적으로 저장되었습니다.");
			}catch(InterruptedException e) {
				e.printStackTrace();
			}catch(IOException e) {
				System.out.println("결과가 정상적으로 저장되지 않았습니다.");
			}
			
		}
		
		
	}
	public int getScore() {
		return score;
	}
}
