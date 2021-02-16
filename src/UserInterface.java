import java.awt.Container;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

// Class for User Interface.
public class UserInterface implements Runnable {
	
	// Frame declaration.
	private JFrame frame;
	// Variables declaration.
	private static JButton buttonPlay; 
    private static JButton buttonPause;
    private static JButton buttonResume;
    private static JButton buttonStop;
    private static JLabel LabelChristmas;
    private static JLabel labelAuthor;
    
    // Create and display the frame-form.
	@Override
	public void run() {
		// Creating new frame with title "Message From Santa Claus".
		frame = new JFrame("Message From Santa Claus");
		// Setting size for frame.
		frame.setPreferredSize(new Dimension(500, 350));
		// Setting "resizable" to false / can't resize frame.
		frame.setResizable(false);
		// Setting options for windows (close, minimize, etc.).
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// Go to createComponents method.
		createComponents(frame.getContentPane());
		// Packing frame components.
		frame.pack();
		// Setting frame to "visible".
		frame.setVisible(true);
	}
	
	// Method creating components - design of interface.
	private void createComponents(Container container) {
		
		// Creating buttons: "Play", "Pause", "Resume", "Stop".
		buttonPlay = new JButton();
        buttonPause = new JButton();
        buttonResume = new JButton();
        buttonStop = new JButton();
        
        // Creating label for Santa Clause "picture".
        LabelChristmas = new JLabel();
        // Setting png-picture on labelChristmas.
        LabelChristmas.setIcon(new ImageIcon("images/Santa1small.png"));
        
        // Creating label for text: author / wishes.
        labelAuthor = new JLabel();
        // Setting text on labelAuthor.
        labelAuthor.setText("MARGARETA");
        // Setting font on labelAuthor:
        labelAuthor.setFont(new Font("Tahoma", 0, 16));
        // Setting font colour on labelAuthor.
        labelAuthor.setForeground(new Color(0, 204, 204));
        
        // Creating path to sound file.
        String filepath = "MessageFromSantaClaus.wav";
        
        // Setting object for MessageListener.
        MessageListener musicObject = new MessageListener(filepath);
        
        // Setting font, text and size to button "Play".
        buttonPlay.setFont(new java.awt.Font("Tahoma", 1, 12));
        buttonPlay.setText("►  Play");
        buttonPlay.setPreferredSize(new Dimension(90, 25));
        buttonPlay.setMaximumSize(new Dimension(100, 40));
        // Adding action listener to button "Play".
        buttonPlay.addActionListener(musicObject);
        
        // Setting font, text and size to button "Pause".
        buttonPause.setFont(new java.awt.Font("Tahoma", 1, 12));
        buttonPause.setText("║║ Pause");
        buttonPause.setPreferredSize(new Dimension(90, 25));
        buttonPause.setMaximumSize(new Dimension(100, 40));
        // Adding action listener to button "Pause".
        buttonPause.addActionListener(musicObject);
        
        // Setting font, text and size to button "Resume".
        buttonResume.setFont(new java.awt.Font("Tahoma", 1, 12));
        buttonResume.setText("► Resume");
        buttonResume.setPreferredSize(new Dimension(90, 25));
        buttonResume.setMaximumSize(new Dimension(100, 40));
        // Adding action listener to button "Resume".
        buttonResume.addActionListener(musicObject);
        
        // Setting font, text and size to button "Stop".
        buttonStop.setFont(new java.awt.Font("Tahoma", 1, 12));
        buttonStop.setText("█  Stop");
        buttonStop.setPreferredSize(new Dimension(90, 25));
        buttonStop.setMaximumSize(new Dimension(100, 40));
        // Adding action listener to button "Stop":
        buttonStop.addActionListener(musicObject);
        
        // Creating layout and its components, style, size, etc.
        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(labelAuthor))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(buttonPlay, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonPause, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonResume, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonStop, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                    .addGap(30, 30, 30))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelChristmas)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelAuthor)
                    .addGap(23, 23, 23)
                    .addComponent(LabelChristmas)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonPlay, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonPause, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonResume, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonStop, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24))
            );    			       
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public static JButton getButtonPlay() {
		return buttonPlay;
	}
	public static JButton getButtonPause() {
		return buttonPause;
	}
	public static JButton getButtonResume() {
		return buttonResume;
	}
	public static JButton getButtonStop() {
		return buttonStop;
	}
	
	public static JLabel getLabelAuthor() {
		return labelAuthor;
	}

}