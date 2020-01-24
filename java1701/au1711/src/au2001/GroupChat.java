package au2001;


import java.net.*;

public class GroupChat {
	InetAddress group;
	final int port=1234;
	final String address="226.24.30.1";
	MulticastSocket ms;
	boolean canSend = false;
	
	public static void main(String args[]) throws Exception{
		
		GroupChat groupChat = new GroupChat();
		
		groupChat.group = InetAddress.getByName(groupChat.address);
		groupChat.ms = new MulticastSocket(groupChat.port);
		groupChat.ms.joinGroup(groupChat.group);
		System.out.println("Group Chat Application");
		
		new Thread(new Sender(groupChat)).start();
		new Thread(new Receiver(groupChat)).start();
	}
	
	synchronized void changeSender(boolean flag) {
		this.canSend = flag;
		notifyAll();
	}
	
}