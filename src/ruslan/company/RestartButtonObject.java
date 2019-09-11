package ruslan.company;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Random;

public class RestartButtonObject extends GameObject {
	
	@Override
	public void start() { 
		super.start();
		position = new Vector2(400, 400);
		sprite = Resources.getSprite("restart");
	}
	
	@Override
	public void update() {
		super.update();
	}
	
	@Override
	public void onMousePress(MouseEvent e) {
		scene.destroyGameObject(this);
		((ExampleScene)scene).restartGame();
	}
	
	@Override
    public void onMouseRelease(MouseEvent e) { 
		
	}
	
	@Override
    public void onMouseEnter(MouseEvent e) { 
		sprite = Resources.getSprite("restartHover");
	}
	
	@Override
    public void onMouseExit(MouseEvent e) { 
		sprite = Resources.getSprite("restart");
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