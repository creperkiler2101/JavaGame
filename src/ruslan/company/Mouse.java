package ruslan.company;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
	public static Vector2 mousePosition;
	
	public MouseEventInfo mousePressInfo;
	public MouseEventInfo mouseReleaseInfo;
	
	@Override
	public void mousePressed(MouseEvent e) {
		mousePressInfo = new MouseEventInfo();
		mousePressInfo.button = e.getButton();
		mousePressInfo.position = new Vector2();
		mousePressInfo.position.x = e.getX();
		mousePressInfo.position.y = e.getY();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		mouseReleaseInfo = new MouseEventInfo();
		mouseReleaseInfo.button = e.getButton();
		mouseReleaseInfo.position = new Vector2();
		mouseReleaseInfo.position.x = e.getX();
		mouseReleaseInfo.position.y = e.getY();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mousePosition = new Vector2();
		mousePosition.x = e.getX();
		mousePosition.y = e.getY();
	}
}
