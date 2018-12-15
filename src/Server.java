import java.io.*;
import java.net.*;
public class Server {
	private ServerSocket sc;
	private Socket client_s;
	private DataInputStream in;
	private DataOutputStream out;
	public void serverSetting() {
		try {
			System.out.println("���� ������...");
			sc = new ServerSocket(8080);
			System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�...");
			client_s = sc.accept();
			System.out.println("Ŭ���̾�Ʈ�� �����߽��ϴ�...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void closeAll() {
		try {
			sc.close();
			client_s.close();
			in.close();
			out.close();
		} catch (Exception e) {
		}
	}
	public void streamSetting() {
		try {
			in = new DataInputStream(client_s.getInputStream());
			out = new DataOutputStream(client_s.getOutputStream());
		} catch (IOException e){
		}
		// ������ ��ǲ, �ƿ�ǲ ��Ʈ���� ���� ��Ʈ���� ����
	}
	public Server(){
		serverSetting();
		streamSetting();
	}
}
