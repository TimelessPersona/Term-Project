import javax.swing.*;
import java.awt.*;

/* Term Project ���� - ������ ���
 * Scene ���� - Title, ���̵� ����, ����ȭ��, ���ӹ��, ��ŷ 
 */
class Title extends JFrame {
	public Title() {
		/* Title Frame ȯ�漳�� */
		setTitle("Title");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		setResizable(false); // frame size fixed

		/* Title�� ������Ʈ */
		JPanel Title_Panel = new JPanel();
		Title_Panel.setLayout(new GridLayout(4, 1, 15, 15)); // array to vertical

		JButton Game_Start = new JButton("Game Start");
		JButton How_To_Play = new JButton("How To Play?");
		JButton Ranking = new JButton("Ranking");
		JButton Game_EXIT = new JButton("Game EXIT");
		
		

		Title_Panel.add(Game_Start);
		Title_Panel.add(How_To_Play);
		Title_Panel.add(Ranking);
		Title_Panel.add(Game_EXIT);

		this.add(Title_Panel);

		setVisible(true);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Title();
	}

}
