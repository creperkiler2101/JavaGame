package ruslan.company;

public class Time {
    public static float deltaTime;
    public static float lastTime = System.nanoTime();

    public static void updateDelta() {
        long current = System.nanoTime();
        deltaTime = (current - lastTime) * 0.000000001f;
        lastTime = current;
    }
}
