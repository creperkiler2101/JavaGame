package ruslan.company;

import java.util.ArrayList;

public class Scene {
	
	public ArrayList<GameObject> gameObjects;
	public ArrayList<GameObject> destroyed;
	
	public boolean isActive;
	
	public Scene() {
		gameObjects = new ArrayList<GameObject>();
		destroyed = new ArrayList<GameObject>();
	}
	
	public void addGameObject(GameObject gm) {
		gm.scene = this;
		gameObjects.add(gm);
		if (isActive)
			gm.start();
	}
	
	public void destroyGameObject(GameObject gm) {
		gm.destroy();
		destroyed.add(gm);
	}
	
	public void destroy() {
		for (GameObject gm : gameObjects) {
			gm.destroy();
		}
		
		gameObjects.clear();
		gameObjects = null;
	}
	
    public void start() {
        isActive = true;
        for (GameObject gm : gameObjects) {
        	gm.start();
        }
    }

    public void update() {
    	for (int i = 0; i < destroyed.size(); i++) {
    		gameObjects.remove(destroyed.get(i));
    	}
    	destroyed.clear();
    	
        for (GameObject gm : gameObjects) {
        	if (gm.isActive)
        		gm.update();
        	if (gm.isVisible)
        		gm.draw();
        }
    }
}
