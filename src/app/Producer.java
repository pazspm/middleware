package app;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Random;

import distribution.QueueManagerProxy;
import distribution.message.Operation;

public class Producer {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException{
		
		QueueManagerProxy proxy1 = new QueueManagerProxy();
		QueueManagerProxy proxy2 = new QueueManagerProxy();
		QueueManagerProxy proxy3 = new QueueManagerProxy();
		
		Random rand = new Random();
		
		while(true){
			
			//Fila 1
			proxy1.send("topic1", "T�pico 1, Fila 1" + rand.nextInt(10000), Operation.PUBLISH);
			
			proxy1.send("topic2", "T�pico 2, Fila 1" + rand.nextInt(10000), Operation.PUBLISH);
			proxy1.send("topic3", "T�pico 3, Fila 1" + rand.nextInt(10000), Operation.PUBLISH);
			
			//Fila 2
			proxy2.send("topic11", "T�pico 11, Fila 2" + rand.nextInt(10000), Operation.PUBLISH);
			proxy2.send("topic22", "T�pico 22, Fila 2" + rand.nextInt(10000), Operation.PUBLISH);
			
			//Fila 3
			proxy3.send("topic111", "T�pico 111, Fila 3" + rand.nextInt(10000), Operation.PUBLISH);
			
			
			System.out.println("Producer sent");
			Thread.sleep(500);	
		}
		
	}
	
}
