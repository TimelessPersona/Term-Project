import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/* Term Project ���� - ������ ���
 * Scene ���� - Title, ���̵� ����, ����ȭ��, ���ӹ��, ��ŷ 
 * 
 * TODO ����� - Thread�� �̿��� �ǽð� ���� �߻�, ��ư�� ���� �� ��ư ������ �� �׼� ����
 * TODO ������ - Game_Start Frame(Class)���� Login��� ���� �� ����, ��ü���� �̹��� ������ �۾�
 * TODO �ڹ� - GUI ����, ����/��Ʈ��ũ �ܿ��� ���� ����, �����ͺ��̽� ����(���� ����, ��ŷ�� �ǽð� ����ȭ)
 */

/*	Main Section ������ ���α׷��� �������� ���� �ʱ�ȭ��� ��ü���� ȯ���� ����
 *   ��ư�� ������ �� ȭ�� ��ȯ�� ���⼭ ����
 */
class Title extends JFrame {
	public Title() {
		/* Title Frame ȯ�漳�� */
		setTitle("Title");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		setLocationRelativeTo(null);
		setResizable(false); // frame size fixed

		/* Title�� ������Ʈ */
		JPanel Title_Panel = new JPanel();
		Title_Panel.setLayout(new GridLayout(4, 1, 15, 15)); // array to vertical

		JButton Game_Start = new JButton("Game Start");
		JButton How_To_Play = new JButton("How To Play?");
		JButton Ranking = new JButton("Ranking");
		JButton Game_EXIT = new JButton("Game EXIT");
		
		/*�̺�Ʈ ������ */
		Game_Start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Game_Start Frame pop
				dispose();
				new Game_Start();
			}
		});
		
		How_To_Play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//How_To_Play Frame pop
				dispose();
				new How_To_Play();
			}
		});
		
		Ranking.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Ranking Frame pop
				dispose();
				new Ranking();
			}
		});
		
		Game_EXIT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); //Program dispose
			}
		});
		
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
