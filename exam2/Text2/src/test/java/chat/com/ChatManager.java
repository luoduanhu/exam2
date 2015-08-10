package chat.com;
import java.util.Vector;
//����Ŀ��Ҫ�ǽ��½����̹߳�������������ʵ������֮���ͨ�ţ��ͺñ�һ��������
public class ChatManager {
	//��ChatManger��������ÿ���ͻ��˻���֮���Ƕ�����
	private ChatManager(){}
	private static final ChatManager cm = new ChatManager();
	public static ChatManager getChatManager(){
		return cm;
	}
	//�ü��ϱ���ͻ��˶�����ӵ����ϵ���
	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	public void add(ChatSocket cs){
		vector.add(cs);
	}
	//�˷�������Ϊ������Ϣ
	public void publish(ChatSocket cs,String out){
		for(int i=0;i<vector.size();i++){
	    //ͨ�����ϣ�����������пͻ��˷��͵���Ϣ����������
		ChatSocket csChatSocket = vector.get(i);
		if(!cs.equals(csChatSocket)){
			//�ص��ͻ��˵�out����������Ϣ
			csChatSocket.out(out+"\n");
			
		}
		}
	}

}
