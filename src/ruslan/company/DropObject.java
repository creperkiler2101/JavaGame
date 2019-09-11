package ruslan.company;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Random;

public class DropObject extends GameObject {
	
	@Override
	public void start() { 
		Random r = new Random();
		
		position = new Vector2(r.nextInt(850), -200);
		isActive = true;
		sprite = Resources.getSprite("drop");
	}
	
	@Override
	public void update() {
		super.update();
		
		position.y += 0.3f;
		if (position.y >= 650) {			
			((ExampleScene)scene).isEnd = true;
			scene.destroyGameObject(this);
		}
		
		//drawText("" + Float.toString(position.x), 200, 190, "TimesRoman", 24, Font.BOLD | Font.ITALIC, new Color(255, 0, 0, 255));
	}
	
	@Override
	public void onMousePress(MouseEvent e) {
		//System.out.println("Press");
		scene.destroyGameObject(this);
		scene.addGameObject(new DropObject());
	}
	
	@Override
    public void onMouseRelease(MouseEvent e) { 
		//System.out.println("Release");
	}
	
	@Override
    public void onMouseEnter(MouseEvent e) { 
		//System.out.println("Enter");
	}
	
	@Override
    public void onMouseExit(MouseEvent e) { 
		//System.out.println("Exit");
	}
	
	//Õ≈ –¿¡Œ“¿≈“
	@Override
    public void onMouseMove(MouseEvent e) { 
		System.out.println("Move");
	}
	//Õ≈ –¿¡Œ“¿≈“
	@Override
    public void onMouseWheel(MouseWheelEvent e) { 
		System.out.println("Wheel");
	}
}
