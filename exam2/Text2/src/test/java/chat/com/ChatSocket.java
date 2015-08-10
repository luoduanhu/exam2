package chat.com;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
//����ĿΪ��������
class ChatSocket extends Thread{
	
	Socket socket;
	//��ȡ���ݹ�����socket
	public ChatSocket(Socket s){
		this.socket=s;
	}
	//�˷���Ϊ��ȡ�ͻ��˷�������Ϣ�������������ͻ���
	public void out(String out){		
		try {
			//����socket�е�write��������ͻ��˷�����Ϣ
			socket.getOutputStream().write(out.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {	
		try {
			//��ȡ������
			BufferedReader br = new BufferedReader(
					               new InputStreamReader(
							           socket.getInputStream(), "UTF-8"));
			String line;
			while((line=br.readLine())!=null){
				//����ChatManager�ཫ��ȡ���Ŀͻ��˶���ͱ�д����Ϣ���͵���������
				ChatManager.getChatManager().publish(this, line);
		    }
			//�ر�������
			br.close();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	        
	}
	
}

