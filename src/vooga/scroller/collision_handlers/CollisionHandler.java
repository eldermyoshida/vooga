package vooga.scroller.collision_handlers;

import vooga.scroller.test_sprites.Coin;
import vooga.scroller.test_sprites.Koopa;
import vooga.scroller.test_sprites.Mario;
import vooga.scroller.test_sprites.Platform;
import vooga.scroller.test_sprites.Turtle;
import vooga.scroller.test_sprites.Type;
import vooga.scroller.util.Sprite;


public class CollisionHandler {

    public void visit (Sprite sprite) {
        System.err.println("Going into visit method of CollisionHandler. Should never happen.");

    }

    public void handleCollision (Type type, CollisionHandler ch, Sprite obj2) {

        switch (type) {
            case COIN:
                Coin_CH coin_ch = (Coin_CH) ch;
                visitCollision(coin_ch, obj2);
                break;

            case KOOPA:
                Koopa_CH koopa_ch = (Koopa_CH) ch;
                visitCollision(koopa_ch, obj2);
                break;

            case MARIO:
                Mario_CH mario_ch = (Mario_CH) ch;
                visitCollision(mario_ch, obj2);
                break;

            case PLATFORM:
                Platform_CH platform_ch = (Platform_CH) ch;
                visitCollision(platform_ch, obj2);
                break;

            case TURTLE:
                Turtle_CH turtle_ch = (Turtle_CH) ch;
                visitCollision(turtle_ch, obj2);
                break;
        }
    }

    public void visitCollision (Coin_CH ch, Sprite obj2) {

        switch (obj2.getType()) {
            case COIN:
                Coin object1 = (Coin) obj2;
                ch.visit(object1);
                break;

            case KOOPA:
                Koopa object2 = (Koopa) obj2;
                ch.visit(object2);
                break;

            case MARIO:
                Mario object3 = (Mario) obj2;
                ch.visit(object3);
                break;

            case PLATFORM:
                Platform object4 = (Platform) obj2;
                ch.visit(object4);
                break;

            case TURTLE:
                Turtle object5 = (Turtle) obj2;
                ch.visit(object5);
                break;
        }
    }

    public void visitCollision (Koopa_CH ch, Sprite obj2) {

        switch (obj2.getType()) {
            case COIN:
                Coin object1 = (Coin) obj2;
                ch.visit(object1);
                break;

            case KOOPA:
                Koopa object2 = (Koopa) obj2;
                ch.visit(object2);
                break;

            case MARIO:
                Mario object3 = (Mario) obj2;
                ch.visit(object3);
                break;

            case PLATFORM:
                Platform object4 = (Platform) obj2;
                ch.visit(object4);
                break;

            case TURTLE:
                Turtle object5 = (Turtle) obj2;
                ch.visit(object5);
                break;
        }
    }

    public void visitCollision (Mario_CH ch, Sprite obj2) {

        switch (obj2.getType()) {
            case COIN:
                Coin object1 = (Coin) obj2;
                ch.visit(object1);
                break;

            case KOOPA:
                Koopa object2 = (Koopa) obj2;
                ch.visit(object2);
                break;

            case MARIO:
                Mario object3 = (Mario) obj2;
                ch.visit(object3);
                break;

            case PLATFORM:
                Platform object4 = (Platform) obj2;
                ch.visit(object4);
                break;

            case TURTLE:
                Turtle object5 = (Turtle) obj2;
                ch.visit(object5);
                break;
        }
    }

    public void visitCollision (Platform_CH ch, Sprite obj2) {

        switch (obj2.getType()) {
            case COIN:
                Coin object1 = (Coin) obj2;
                ch.visit(object1);
                break;

            case KOOPA:
                Koopa object2 = (Koopa) obj2;
                ch.visit(object2);
                break;

            case MARIO:
                Mario object3 = (Mario) obj2;
                ch.visit(object3);
                break;

            case PLATFORM:
                Platform object4 = (Platform) obj2;
                ch.visit(object4);
                break;

            case TURTLE:
                Turtle object5 = (Turtle) obj2;
                ch.visit(object5);
                break;
        }
    }

    public void visitCollision (Turtle_CH ch, Sprite obj2) {

        switch (obj2.getType()) {
            case COIN:
                Coin object1 = (Coin) obj2;
                ch.visit(object1);
                break;

            case KOOPA:
                Koopa object2 = (Koopa) obj2;
                ch.visit(object2);
                break;

            case MARIO:
                Mario object3 = (Mario) obj2;
                ch.visit(object3);
                break;

            case PLATFORM:
                Platform object4 = (Platform) obj2;
                ch.visit(object4);
                break;

            case TURTLE:
                Turtle object5 = (Turtle) obj2;
                ch.visit(object5);
                break;
        }
    }
}
