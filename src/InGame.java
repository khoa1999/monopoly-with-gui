import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.xml.stream.events.StartDocument;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.DropMode;

public class InGame {
	int jslider;
	private JFrame frame;
	private JTextField nameField;
	

	/**
	 * Launch the application.
	 * 
	 */
	public void Start() {
//	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		ActivateMusic mode2 = new ActivateMusic(2);
			public void run() {
				try {
					InGame window = new InGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1070);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel playerName = new JLabel("");
		playerName.setIcon(new ImageIcon("C:\\Users\\flip\\Pictures\\Your name.png"));
		playerName.setBounds(1219, 252, 180, 50);
		frame.getContentPane().add(playerName);
		
		jslider = 1;
		JSlider Num_slider = new JSlider();
		Num_slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int slidernum = Num_slider.getValue();
				System.out.println(slidernum);
			}
		});
		Num_slider.setPaintTicks(true);
		Num_slider.setFont(new Font("Tahoma", Font.BOLD, 12));
		Num_slider.setSnapToTicks(true);
		Num_slider.setPaintTrack(false);
		Num_slider.setForeground(new Color(0, 0, 0));
		Num_slider.setBackground(new Color(0, 204, 255));
		Num_slider.setMajorTickSpacing(1);
		Num_slider.setMaximum(4);
		Num_slider.setMinimum(1);
		Num_slider.setValue(1);
		Num_slider.setBounds(1418, 212, 119, 24);
		frame.getContentPane().add(Num_slider);
		
		nameField = new JTextField();
		nameField.setForeground(new Color(255, 255, 255));
		nameField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameField.setBackground(new Color(0, 0, 0));
		nameField.setBounds(1418, 262, 119, 29);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		
		
		JLabel playersbox = new JLabel("");
		playersbox.setIcon(new ImageIcon("C:\\Users\\flip\\Pictures\\Players.png"));
		playersbox.setForeground(new Color(102, 255, 0));
		playersbox.setFont(new Font("Tahoma", Font.BOLD, 15));
		playersbox.setBackground(new Color(0, 204, 153));
		playersbox.setHorizontalAlignment(SwingConstants.CENTER);
		playersbox.setBounds(1502, 133, 268, 169);
		frame.getContentPane().add(playersbox);
		
		JLabel TheGuy = new JLabel("");
		TheGuy.setIcon(new ImageIcon("C:\\Users\\flip\\Pictures\\the-property-strategist.gif"));
		TheGuy.setBounds(182, 156, 842, 735);
		frame.getContentPane().add(TheGuy);
		
		JLabel board = new JLabel("");
		board.setIcon(new ImageIcon("C:\\Users\\flip\\Pictures\\monopoly-board.png"));
		board.setBounds(0, 11, 1024, 1007);
		frame.getContentPane().add(board);
		
		JLabel City = new JLabel("");
		City.setIcon(new ImageIcon("C:\\Users\\flip\\Pictures\\cityt.gif"));
		City.setBounds(101, 133, 797, 759);
		frame.getContentPane().add(City);
		
		JLabel PressStart = new JLabel("New label");
		PressStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.out.println("Test");
				Num_slider.setVisible(false);
				playersbox.setVisible(false);
				PressStart.setVisible(false);
				playerName.setVisible(false);
				nameField.setVisible(false);
				TheGuy.setVisible(false);
				City.setVisible(false);
				
				
			}
		});
		PressStart.setIcon(new ImageIcon("C:\\Users\\flip\\Pictures\\ExhaustedMeanComet-size_restricted.gif"));
		PressStart.setBounds(1219, 344, 501, 60);
		frame.getContentPane().add(PressStart);
		
		JLabel tron_theme = new JLabel("");
		tron_theme.setBackground(new Color(102, 102, 102));
		tron_theme.setForeground(new Color(51, 51, 51));
		tron_theme.setIcon(new ImageIcon("C:\\Users\\flip\\Pictures\\tron-lightcycle-hex-black-wallpaper.png"));
		tron_theme.setBounds(979, -341, 987, 2000);
		frame.getContentPane().add(tron_theme);
		
		JLabel black_theme = new JLabel("");
		black_theme.setIcon(new ImageIcon("C:\\Users\\flip\\Pictures\\blacktheme.jpg"));
		black_theme.setBounds(0, 11, 1000, 1500);
		frame.getContentPane().add(black_theme);
		
	}
}
