import java.io.*;
import java.net.*;
public class Client {
	private Socket client;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	
	public void connect() {
		try {
			System.out.println("접속 시도중...");
			client = new Socket("127.0.0.1",8080);
			System.out.println("접속 성공");
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
		// 데이터 인풋, 아웃풋 스트림을 소켓 스트림과 연결
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
