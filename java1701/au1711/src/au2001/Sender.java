package au2001;

import java.net.DatagramPacket;
import java.util.Scanner;

class Sender implements Runnable{
	static DatagramPacket sentPacket;
	GroupChat groupChat;
	
	Sender(GroupChat syncChat){
		this.groupChat = syncChat;
	}
	
	synchronized static void setPacket(DatagramPacket packet) {
		Sender.sentPacket = packet;
	}
	

	Scanner sc = new Scanner(System.in);
	public void run(){
		while(true){
			synchronized(groupChat) {
				try{
//					System.out.println("Sender");
					while(this.groupChat.canSend) {
//						System.out.println("S waiting");
						this.groupChat.wait();
//						System.out.println("Stopped Waiting @s ");
					}
					System.out.println("Enter Msg to Chat");
					String message = sc.next();
//					System.out.println(message);
					DatagramPacket packet = new DatagramPacket(message.getBytes(),message.length(),groupChat.group,groupChat.port);
					groupChat.ms.send(packet);
					setPacket(packet);
					System.out.println("Msg Sent"+message);
					this.groupChat.changeSender(true);
				}
				catch(Exception e){
					this.groupChat.changeSender(true);
					e.printStackTrace();
				}
			}
		}
	}
}