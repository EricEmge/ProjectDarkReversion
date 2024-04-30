package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Audio.JukeBox;
import Entity.PlayerSave;
import Handlers.Keys;
import Main.GamePanel;

public class DevState extends GameState {
private BufferedImage head;
	
	private int currentChoice = 0;
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	private Font font2;
	
	public DevState(GameStateManager gsm) {
		
		super(gsm);
		
		try {
			
			// load floating head
			head = ImageIO.read(
				getClass().getResourceAsStream("/HUD/EEGSLogo.gif")
			).getSubimage(0, 0, 100, 90);
			
			// titles and fonts
			titleColor = Color.WHITE;
			titleFont = new Font("Times New Roman", Font.PLAIN, 28);
			font = new Font("Arial", Font.PLAIN, 14);
			font2 = new Font("Arial", Font.PLAIN, 10);
			
			// load sound fx
			JukeBox.load("/SFX/menuoption.mp3", "menuoption");
			JukeBox.load("/SFX/menuselect.mp3", "menuselect");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void init() {}
	
	public void update() {	
		// check keys
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Evil Eric Game Studio", 50, 90);
		g.drawImage(head, 105, 95, null);
		
		// draw menu options
		g.setFont(font);
		g.setColor(Color.WHITE);
		
		// other
		g.setFont(font2);
		g.drawString("2024 Evil Eric Game Studio", 10, 232);
		g.drawString("Press Enter", 130, 195);
		
	}
	
	private void select(){
		gsm.setState(GameStateManager.MENUSTATE);
	}
	
	public void handleInput() {	
		if(Keys.isPressed(Keys.ENTER)) select();
	}
}
