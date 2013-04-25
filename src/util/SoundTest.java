package util;

public class SoundTest {
    public static void main(String[] args) {
        Sound boing = new Sound("boing.wav");
        for (int i = 0; i < 10; i++) {
            boing.play();
        }
    }
}
