package ruslan.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;

public class GameWindow extends JFrame {

    public static GameWindow current;
    public static GameField game;
    public static Graphics graphics;
    
    private boolean ready;

    private Scene currentScene;
    public Scene getScene() {
        return currentScene;
    }
    public void setScene(Scene scene) {
        ready = false;
        currentScene = scene;
        
        start();
    }

    private void start() {
        currentScene.start();
        ready = true;
    }

    public void update(Graphics _g) {
    	graphics = _g;
    	Time.updateDelta();
    	if (!ready || currentScene == null)
    		return;
    	
        currentScene.update();
    }
    
    public GameWindow() {
    	current = this;
    	
        current.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        current.setLocation(200, 100);
        current.setSize(960, 639);
        current.setResizable(false);

        current.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
            }
        });

        game = new GameField();
        current.add(game);

        current.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
    	Resources.load("Resources/");
    	new GameWindow();
    	
    	//SET DEFAULT SCENE HERE
    	//----------------------
    	GameWindow.current.setScene(new ExampleScene());
    }

    public static class GameField extends JPanel {

        @Override
        protected void paintComponent(Graphics _g) {
            super.paintComponent(_g);
            GameWindow.current.update(_g);
            repaint();
        }
    }
}
