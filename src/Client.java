import java.io.*;
import java.net.*;
public class Client {
	private Socket client;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	
	public void connect() {
		try {
			System.out.println("���� �õ���...");
			client = new Socket("127.0.0.1",8080);
			System.out.println("���� ����");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void streamSetting() {
		try {
			dataInputStream = new DataInputStream(client.getInputStream());
			dataOutputStream = new DataOutputStream(client.getOutputStream());
		} catch (IOException e){
		}
		// ������ ��ǲ, �ƿ�ǲ ��Ʈ���� ���� ��Ʈ���� ����
	}
	public void sendScore() {
		new Thread(new Runnable() {
			public void run() {
			}
		});
	}
	
	/*public void idpwSend() {
		new Thread(new Runnable() {
			public void run() {
				try {
					readID = new BufferedRead(new FileReader(""));
				}
			}
		}
	}*/
	public Client() {
		connect();
		streamSetting();
	}
	public static void main(String[] args) {
		new Client();
	}
}
