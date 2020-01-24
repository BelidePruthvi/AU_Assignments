package au2001;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

class Receiver implements Runnable{
	
	GroupChat groupChat;
	
	Receiver(GroupChat groupChat){
		this.groupChat = groupChat;
	}
	public void run(){
		while(true){
				try{
//					System.out.println("Receiver");
					byte[] data = new byte[1024];
					DatagramPacket packet = new DatagramPacket(data,1024);
					groupChat.ms.receive(packet);
					String message = new String(packet.getData()).trim();
					if(!(Sender.sentPacket!=null && message.equals((new String(Sender.sentPacket.getData())).trim()))) {
						System.out.println(message);
						Sender.setPacket(null);
						this.groupChat.changeSender(false);
					}
					else {
						Sender.setPacket(null);
					}
				}
				catch(Exception e){
					e.printStackTrace();
					this.groupChat.changeSender(false);
				}
		}
	}
}