import javax.swing.SwingUtilities;

/**
 * A Swing-based "audio player" program with message from Santa Claus to play.
 * Audio file is WAVE (*.wav) file.
 * @author Malgorzata Pick
 *
 */

// Main class.
public class Main {
	
	// Main method.
	public static void main (String [] args) {
		
		// Creating user interface "ui".
		UserInterface ui = new UserInterface();
		// Invoking Swing Utilities library for user interface.
        SwingUtilities.invokeLater(ui);
				
	}
}
