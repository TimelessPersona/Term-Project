import java.io.*;
import java.net.*;
public class Server {
	private ServerSocket sc;
	private Socket client_s;
	private DataInputStream in;
	private DataOutputStream out;
	public void serverSetting() {
		try {
			System.out.println("서버 생성중...");
			sc = new ServerSocket(8080);
			System.out.println("클라이언트의 접속을 기다립니다...");
			client_s = sc.accept();
			System.out.println("클라이언트가 접속했습니다...");
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
		// 데이터 인풋, 아웃풋 스트림을 소켓 스트림과 연결
	}
	public Server(){
		serverSetting();
		streamSetting();
	}
}
