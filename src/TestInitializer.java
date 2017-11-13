/**
 * Written by Jinghan Liang
 * This class is for creating 10 test examples randomly. 
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestInitializer {
	
	public void initialize() {
	try {
		Operation oper = new Operation();
		int testNum = 10;
		while(testNum > 0){
			FileWriter writer = new FileWriter("test"+testNum+".txt",true);
			Random random = new Random();
			String[] command = {"MOVE","LEFT","RIGHT"};
			writer.write("PLACE "+ random.nextInt(5) + "," +random.nextInt(5)+","
					+ oper.direction[random.nextInt(3)]+"\n");
			for(int i = 0; i< 5;i++){
				writer.write(command[random.nextInt(2)]+"\n");
			}
			writer.write("REPORT"+"\n");
			writer.close();
			testNum--;
		}
	}catch (IOException e) {
			e.printStackTrace();
	}
	}
	
	public static void main(String[] args){
		TestInitializer testSets = new TestInitializer();
		testSets.initialize();
	}

}
