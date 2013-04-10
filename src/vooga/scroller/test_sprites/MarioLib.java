package vooga.scroller.test_sprites;

import java.awt.Dimension;
import java.util.List;
import vooga.scroller.collision_handlers.Coin_CH;
import vooga.scroller.collision_handlers.Koopa_CH;
import vooga.scroller.collision_handlers.Mario_CH;
import vooga.scroller.collision_handlers.Platform_CH;
import vooga.scroller.collision_handlers.Turtle_CH;
import vooga.scroller.design_patterns.State;
import vooga.scroller.sprite_superclasses.NonStaticEntity;
import vooga.scroller.sprite_superclasses.Player;
import vooga.scroller.sprite_superclasses.StaticEntity;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.view.View;

public class MarioLib {
    
    public MarioLib(){
        
    }
    
    public class Mario extends Player {

        private Mario_CH collisionHandler;
        List<State> myStates;    
        State currentState; 
        View myView;
        private Location myOriginalCenter;
        private Dimension mySize;
        private Pixmap myImage;
        
        
        
        public Mario_CH getCollisionHandler () {
            return collisionHandler;
        }

        public void setCollisionHandler (Mario_CH collisionHandler) {
            this.collisionHandler = collisionHandler;
        }
        
        public Mario (Pixmap image, Location center, Dimension size, View view) {
            super(image, center, size, view);
            myView = view;
            myOriginalCenter = center;
            mySize = size;
            myImage = image;
            collisionHandler = new Mario_CH(view);
            // TODO Auto-generated constructor stub
        }

        public void print() {
            System.out.println("Mario");
        }
        
        @Override
        public Type getType() {
            return Type.MARIO;
        }
        

       
        
        
        public void update(double elapsedTime, Dimension bounds) {
//            Commented out for scrolling testing
//            currentState.update();
            // move based on input
//          ONLY FOR TESTING
            int key = myView.getLastKeyPressed();
            if (key == MOVE_LEFT)
            {
                translate(LEFT_VELOCITY);
            }
            if (key == MOVE_RIGHT)
            {
                translate(RIGHT_VELOCITY);
            }
            if (key == MOVE_UP)
            {
                translate(UP_VELOCITY);
            }
            if (key == MOVE_DOWN)
            {
                translate(DOWN_VELOCITY);
            }
//            ONLY FOR TESTING
        }
       
        public void changeState(State newState) {
            currentState = newState;
        }
        
        
    }
    
    public class Koopa extends NonStaticEntity {

        private Koopa_CH collisionHandler = new Koopa_CH();
        
        
        public Koopa_CH getCollisionHandler () {
            return collisionHandler;
        }

        public void setCollisionHandler (Koopa_CH collisionHandler) {
            this.collisionHandler = collisionHandler;
        }
        
        public Koopa (Pixmap image, Location center, Dimension size) {
            super(image, center, size);
        }

        public void print() {
            System.out.println("Koopa");
        }
        
        @Override
        public Type getType() {
            return Type.KOOPA;
        }
        
    }
    
    public class Turtle extends NonStaticEntity {

        
        private Turtle_CH collisionHandler = new Turtle_CH();
        
        
        public Turtle_CH getCollisionHandler () {
            return collisionHandler;
        }

        public void setCollisionHandler (Turtle_CH collisionHandler) {
            this.collisionHandler = collisionHandler;
        }
        
        public Turtle (Pixmap image, Location center, Dimension size) {
            super(image, center, size);
            // TODO Auto-generated constructor stub
        }

        public void print() {
            System.out.println("Turtle");
        }
        
        @Override
        public Type getType() {
            return Type.TURTLE;
        }
    }

    public class Platform extends StaticEntity{

        private Platform_CH collisionHandler = new Platform_CH();
        
        
        public Platform_CH getCollisionHandler () {
            return collisionHandler;
        }

        public void setCollisionHandler (Platform_CH collisionHandler) {
            this.collisionHandler = collisionHandler;
        }
        
        public Platform (Pixmap image, Location center, Dimension size) {
            super(image, center, size);
            // TODO Auto-generated constructor stub
        }

        public void print() {
            System.out.println("Platform");
        }
        
        @Override
        public Type getType() {
            return Type.PLATFORM;
        }
    }

    public class Coin extends StaticEntity {

        
        private Coin_CH collisionHandler = new Coin_CH();
        
        public Coin_CH getCollisionHandler () {
            return collisionHandler;
        }

        public void setCollisionHandler (Coin_CH collisionHandler) {
            this.collisionHandler = collisionHandler;
        }
        
        public Coin (Pixmap image, Location center, Dimension size) {
            super(image, center, size);
            // TODO Auto-generated constructor stub
        }

        
        public void print() {
            System.out.println("Coin");
        }
        
        @Override
        public Type getType() {
            return Type.COIN;
        }



    }
}
