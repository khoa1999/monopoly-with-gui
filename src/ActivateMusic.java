import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;


public class  ActivateMusic {
	private FloatControl gainControl;
	private File yourFile;
	private AudioInputStream stream;
	private AudioFormat format;
	private DataLine.Info info;
	private Clip clip;
  
	
		public ActivateMusic(int mode) {
			try {	
//		

				yourFile = new File("C:\\Users\\flip\\eclipse-workspace\\Monopoly_GUI\\src\\Monopoly (2008).wav");
				
			    if (mode == 1) {
			    stream = AudioSystem.getAudioInputStream(yourFile);
			    
			    } else {
		    	yourFile = new File("C:\\Users\\flip\\eclipse-workspace\\Monopoly_GUI\\src\\Ingame.wav");
			    stream = AudioSystem.getAudioInputStream(yourFile);
			    }
			    format = stream.getFormat();
			    info = new DataLine.Info(Clip.class, format); 
			    clip = (Clip) AudioSystem.getLine(info);
			    clip.open(stream);
			    gainControl = 
			    	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			    	gainControl.setValue(-10);
			    clip.start(); 
			    
			}
			catch(Exception e){	
			}
			
		}
	
		public void changeVolume(int value) {
		    	gainControl.setValue(value);	
		}
		
		public void stop() {
			clip.stop();
		}
		
	
}



