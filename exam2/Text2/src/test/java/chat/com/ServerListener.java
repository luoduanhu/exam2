package chat.com;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
//����Ŀ��������������
class ServerListener extends Thread{
	@SuppressWarnings("resource")
	public void run() {
		try {	
	      //�󶨼������˿�
			ServerSocket serverSocket = new ServerSocket(333);
			while(true){
				//ʹ�̴߳�������״̬
				Socket socket = serverSocket.accept();
				//���ͻ�����������˿�ʱ�����ã���������
				JOptionPane.showConfirmDialog(null,"�пͻ����ӵ��˷�����");
				//���ͻ���������֮����ã�ͨ���µ��߳̽���һ���ͻ���
				ChatSocket cs =new ChatSocket(socket);
				cs.start();
				//���ù����̵߳�ChatManager�࣬ʵ�ֿͻ���֮���ͨ��
				ChatManager.getChatManager().add(cs);
			}
			
		} catch (IOException e) {
			e.printStackTrace();}
	}
}
