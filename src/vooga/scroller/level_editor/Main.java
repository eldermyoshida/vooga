
package vooga.scroller.level_editor;

import vooga.scroller.util.Sprite;


public class Main {

    /**
     * @param args
     */
    public static void main (String[] args) {
        // TODO Auto-generated method stub
        SpriteLibrary testLib = new SpriteLibrary();
        for (Class<?> c:testLib.getStuff()) {
            Sprite s;
            try {
                s = (Sprite) c.newInstance();
                System.out.println(s.getType());
            }
            catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                
        }
//        LEController con = new LEController(new SpriteLibrary());
//        con.start(); 
    }
}
