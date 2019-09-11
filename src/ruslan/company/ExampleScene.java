package ruslan.company;

public class ExampleScene extends Scene {
	
	GameObject gm;
	GameObject bg;
	GameObject gg;
	GameObject restart;
	
	public boolean isEnd;
	
	public ExampleScene() {

	}
	
	@Override
	public void start() {
		bg = new GameObject();
		bg.isActive = false;
		bg.sprite = Resources.getSprite("background");
		bg.position = new Vector2(0,0);
		this.addGameObject(bg);

		gg = new GameObject();
		gg.isVisible = false;
		gg.isActive = false;
		gg.position = new Vector2(0, 150);
		gg.sprite = Resources.getSprite("gg");
		this.addGameObject(gg);

		gm = new DropObject();
		this.addGameObject(gm);
		//
		
		super.start();
	}
	
	@Override
	public void update() 
	{
		if (isEnd) {	
			gg.isVisible = true;
			
			if (restart == null) {
				restart = new RestartButtonObject();
				this.addGameObject(restart);
			}
		}
		
		super.update();
	}
	
	public void restartGame() {
		gg.isVisible = false;
		isEnd = false;
		restart = null;
		gm = new DropObject();
		this.addGameObject(gm);
	}
}
