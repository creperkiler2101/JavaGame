package ruslan.company;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.*;

public class GameObject {
	private JPanel mouseTriggerZone;
	
	public Scene scene;
	
    public Vector2 position;
    public Image sprite;
    
    public boolean isActive = true;
    public boolean isVisible = true;
    
    public int getTop() {
    	return (int)position.y;
    }
    public int getBottom() {
    	return (int)position.y + sprite.getHeight(null);
    }
    public int getLeft() {
    	return (int)position.x;
    }
    public int getRight() {
    	return (int)position.x + sprite.getWidth(null);
    }
  
    public GameObject() {
    	position = new Vector2();
    	
    	mouseTriggerZone = new JPanel();
    	mouseTriggerZone.setBackground(new Color(0,0,0,0));
    	mouseTriggerZone.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mousePressed(MouseEvent e) {
    			onMousePress(e);
    		}
    		@Override
    		public void mouseReleased(MouseEvent e) {
    			onMouseRelease(e);
    		}
    		@Override
    		public void mouseMoved(MouseEvent e) {
    			onMouseMove(e);
    		}
    		@Override
    		public void mouseEntered(MouseEvent e) {
    			onMouseEnter(e);
    		}
    		@Override
    		public void mouseExited(MouseEvent e) {
    			onMouseExit(e);
    		}
    		@Override
    		public void mouseWheelMoved(MouseWheelEvent e) {
    			onMouseWheel(e);
    		}
    	});
    	GameWindow.game.add(mouseTriggerZone);
    }
    
    public void start() {
    	mouseTriggerZone.setLocation((int)position.x, (int)position.y);
    	if (sprite != null)
    		mouseTriggerZone.setSize(sprite.getWidth(null), sprite.getHeight(null));
    	else
    		mouseTriggerZone.setSize(1, 1);
    }
    
    public void update() {
    	mouseTriggerZone.setLocation((int)position.x, (int)position.y);
    	if (sprite != null)
    		mouseTriggerZone.setSize(sprite.getWidth(null), sprite.getHeight(null));
    	else
    		mouseTriggerZone.setSize(1, 1);
    }
    
    public void destroy() {
    	isActive = false;
    	isVisible = false;
    	sprite = null;
    	GameWindow.game.remove(mouseTriggerZone);
    }
    
    public void draw() {
    	GameWindow.graphics.drawImage(sprite, (int)position.x, (int)position.y, null);
    }
    
    public void drawText(String text, int x, int y, String font, int fontSize, int style, Color color) {
    	if (font.isEmpty())
    		font = "TimesRoman";
    	if (fontSize == -1)
    		fontSize = 12;
    	if (color == null)
    		color = new Color(0, 0, 0, 255);
    	
    	GameWindow.graphics.setFont(new Font(font, style, fontSize));
    	GameWindow.graphics.setColor(color);
    	GameWindow.graphics.drawString(text, x, y);
    }
    
    public void onMousePress(MouseEvent e) { }
    public void onMouseRelease(MouseEvent e) { }
    public void onMouseMove(MouseEvent e) { }
    public void onMouseWheel(MouseWheelEvent e) { }
    public void onMouseEnter(MouseEvent e) { }
    public void onMouseExit(MouseEvent e) { }
}
