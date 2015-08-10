package hand.com;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
//��������Ҫ����������socket
public class ChatManager1 {
	
	
	private ChatManager1(){}
	public static final ChatManager1 instance = new ChatManager1();
	public static ChatManager1 getCM(){
		return instance;
	}
	
	MainWindow window;
	String IP;
	Socket socket;
	BufferedReader reader;
	PrintWriter writer;
	
	public void setWindow(MainWindow window) {
		this.window = window;
		window.appendTxt("�ı���ChatWindow���ˡ�");
	}
	//����һ�����ӷ������ķ���
	public void connect(String ip){
		this.IP=ip;
		new Thread(){
			public void run() {
				try {
					//ͨ��IP�Ͷ˿ڽ�������
					socket = new Socket(IP, 333);
					writer = new PrintWriter(
							     new OutputStreamWriter(
									socket.getOutputStream()));
					reader = new BufferedReader(
							    new InputStreamReader(
									socket.getInputStream()));
					String line;
					//ѭ�������ȡ��������
					while((line=reader.readLine())!=null){
						window.appendTxt("�յ���"+line);
					}
					//�ر���Ӧ������������
					writer.close();
					reader.close();
					writer = null;
					reader = null;
					
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	//����һ���������ݵķ���
	public void send(String out){
		
		if(writer!=null){
			writer.write(out+"\n");
			writer.flush();
		}else{
			window.appendTxt("���Ѿ��Ͽ�����");
		}
			
		}

}
