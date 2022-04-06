/*
 * This file is for testing purposes only.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Test {
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Scanner scanner = new Scanner(System.in);
		
		File file = new File("CuteSound.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		String response = "";
		while(!response.equals("Q")) {
			
			System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
			System.out.print("Enter your choice: ");
			
			response = scanner.next().toUpperCase();
					
			switch(response) {
				
				// play
				case "P":
					clip.start();
					break;
					
				// stop
				case "S":
					clip.stop();
					break;
				
				// reset
				case "R":
					clip.setMicrosecondPosition(0);
					break;
				
				// quite
				case "Q":
					clip.close();
					break;
					
				default:
					System.out.println("Not a valid response.");
					
			}
			
		}
		
		System.out.println("Byeee!");
		
	}
	
}
