import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;



public class FrontMenu {
	private int sliderValue = -10;
	private JFrame Monopoly;

	/**
	 * Launch the application.--
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontMenu window = new FrontMenu();
					window.Monopoly.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 *  
	 * 
	 */
	
	public FrontMenu()   {
		
		initialize();
	}
	
	/**
	 * THEME SONG
	 */
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		
		Monopoly = new JFrame();
		Monopoly.setResizable(false);
		Monopoly.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\flip\\Pictures\\5ecc739de90d76272fce82fd80bd6790.jpg"));
		Monopoly.setTitle("Monopoly");
		Monopoly.setForeground(Color.YELLOW);
		Monopoly.setBackground(new Color(64, 224, 208));
		Monopoly.getContentPane().setBackground(new Color(255, 255, 204));
		Monopoly.setLocationRelativeTo(null);
		ActivateMusic mode1 =new ActivateMusic(1); /* INITIALIZING BACKGROUND MUSIC */
		Monopoly.getContentPane().setLayout(null);
		
		/* *
		 * PLAY BUTTON 
		 * */
		
		JButton PlayButton = new JButton("");
		PlayButton.setBounds(338, 223, 318, 101);
		PlayButton.setForeground(SystemColor.desktop);
		PlayButton.setIcon(new ImageIcon("C:\\Users\\flip\\Pictures\\1vaa.png"));
		PlayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode1.stop();
				InGame ingame1 = new InGame();
				ingame1.Start();
				Monopoly.dispose();
				
				
			}
		});
		
		/* *
		 * SLIDER  
		 * */
		JSlider Slider1 = new JSlider();
		Slider1.setPaintTrack(false);
		Slider1.setBackground(new Color(0, 0, 0));
		Slider1.setSnapToTicks(true);
		Slider1.setToolTipText("");
		Slider1.setMaximum(50);
		Slider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				sliderValue = Slider1.getValue()-65;
				mode1.changeVolume(sliderValue);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Music");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 480, 52, 14);
		Monopoly.getContentPane().add(lblNewLabel_1);
		Slider1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		Slider1.setForeground(new Color(0, 0, 153));
		Slider1.setBounds(52, 467, 40, 39);
		Monopoly.getContentPane().add(Slider1);
		PlayButton.setSelectedIcon(null);
		Monopoly.getContentPane().add(PlayButton);
		
		JLabel BackGroundPic = new JLabel("");
		BackGroundPic.setBounds(2, -12, 2000, 587);
		BackGroundPic.setBackground(new Color(255, 250, 250));
		BackGroundPic.setIcon(new ImageIcon("C:\\Users\\flip\\Pictures\\siam-kempinski-monopoly.jpg"));
		Monopoly.getContentPane().add(BackGroundPic);
		Monopoly.setBounds(100, 100, 1033, 546);
		Monopoly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
