import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JLabel;


public class MessageListener implements ActionListener {
	
	// Setting object "filepath" got from UserInterface.
	String filepath;
	public MessageListener(String filepath) {
		this.filepath = filepath;
	}
	
	// Handle click events on the buttons.
	@Override
	public void actionPerformed(ActionEvent evt) {
		// Getting source button.
		Object source = evt.getSource();
		if (source instanceof JButton) {
			JButton button = (JButton) source;
			// If clicked button is button "Play"...
			if (button == buttonPlay) {
				// Go to method for button "Play".
				buttonPlayActionPerformed(evt, filepath);
			}
			// If clicked button is button "Pause"...
			else if (button == buttonPause) {
				// Go to method for button "Pause".
				buttonPauseActionPerformed(evt);
			}
			// If clicked button is button "Resume"...
			else if (button == buttonResume) {
				// Go to method for button "Resume".
				buttonResumeActionPerformed(evt);
			}
			// If clicked button is button "Stop"...
			else if (button == buttonStop) {
				// Go to method for button "Stop".
				buttonStopActionPerformed(evt);
			}
		}
	}
	
	// Variables declaration.
	static Clip clip;
	static long clipTimePosition;
	// Getting variables from UserInterface.
	static JLabel labelAuthor = UserInterface.getLabelAuthor();
	JButton buttonPlay = UserInterface.getButtonPlay();
	JButton buttonPause = UserInterface.getButtonPause();
	JButton buttonResume = UserInterface.getButtonResume();
	JButton buttonStop = UserInterface.getButtonStop();
	
	// Creating boolean isPlaying - if the clip is playing isPlaying = true.
	public static boolean isPlaying = false;
	// Creating boolean isPause - if the clip is paused isPause = true.
	public static boolean isPause = false;

	// Method for start playing the sound when the "Play" button is clicked.
	public static void buttonPlayActionPerformed(ActionEvent evt, String musicLocation) { 
		// Information for console that button "Play" is working.
        System.out.println("Button Play is working!");
        // Try-catch for checking if the file to play exists.
        try {
        	// Creating file object with file path.
			File musicPath = new File(musicLocation);
			// Checking if the file exists.
			if(musicPath.exists()) {
				// Checking if sound clip is not playing...
				if (!isPlaying) {
					// If clip is not playing:
					// Setting text on labelAuthor from "MARGARETA" to "Merry Christmas!".
					labelAuthor.setText("Merry Christmas!");
					// Creating an object audioInput responsible for bringing sound file to player program.
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
					// Clip object gets audio stream from audioInput object.
					clip = AudioSystem.getClip();
					clip.open(audioInput);
					// Setting boolean isPlaying to true / clip is playing.
					isPlaying = true;
					// Starting the clip.
					clip.start();
					// Setting clip to play continuously.
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					// Information for console that clip is playing.
					System.out.println("Clip is playing!");
				}
			}
			else {
				// Print error message if can't find file.
				System.out.println("Can't find file");
			}
		}
		catch(Exception ex) {
			// Print error message.
			ex.printStackTrace();
		}
        
    }                                          

	// Method for pause playing the sound when the "Pause" button is clicked.
    public static void buttonPauseActionPerformed(ActionEvent evt) {   
    	// Information for console that button "Pause" is working.
    	System.out.println("Button Pause is working!");
    	// Checking if sound clip is playing...
    	if (isPlaying) {
    		// If clip is playing:
    		// Setting boolean isPlaying to false / clip is not playing, it is paused.
	    	isPlaying = false;
	    	// Setting boolean isPause to true / clip is paused.
	    	isPause = true;
	    	// Getting position in playing file.
	    	clipTimePosition = clip.getMicrosecondPosition();
	    	// Stopping the clip.
			clip.stop();
			// Information for console that clip is paused.
			System.out.println("Clip is paused!");
    	}
    }                                           

    // Method for resume playing the sound when the "Resume" button is clicked.
    public static void buttonResumeActionPerformed(ActionEvent evt) { 
    	// Information for console that button "Resume" is working.
    	System.out.println("Button Resume is working!");
    	// Checking if sound clip is not playing and if it is paused...
    	if (!isPlaying && isPause) {
    		// If the conditions are met:
    		// Setting boolean isPlaying to true / clip is playing.
	    	isPlaying = true;
	    	// Setting boolean isPause to false / clip is not paused.
	    	isPause = false;
	    	// Setting position in file to play sound from the paused position.
			clip.setMicrosecondPosition(clipTimePosition);
			// Starting the clip.
			clip.start();
			// Information for console that clip is resumed.
			System.out.println("Clip is resumed!");
    	}
    }
    
    // Method for stop playing the sound when the "Stop" button is clicked.
    public static void buttonStopActionPerformed(ActionEvent evt) { 
    	// Information for console that button "Stop" is working.
    	System.out.println("Button Stop is working!");
    	// Checking if sound clip is playing or if it is paused...
    	if (isPlaying || isPause) {
    		// If the conditions are met:
	    	labelAuthor.setText("MARGARETA");
	    	// Setting boolean isPlaying to false / clip is not playing, it is stopped.
	    	isPlaying = false;
	    	// Setting boolean isPause to false / clip is not paused, it is stopped.
	    	isPause = false;
	    	// Stopping the clip.
	    	clip.stop();
	    	// Closing the clip.
	    	clip.close();
	    	// Information for console that clip is stopped.
	    	System.out.println("Clip is stopped!");
    	}
    }                                            
	
}