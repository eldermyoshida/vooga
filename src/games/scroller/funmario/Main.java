package games.scroller.funmario;

public class Main {
    
    public static void main(String[] args){
        String[] filenames = new String[]
                {"backgroundhills.png","backgroundhillsbig.png"};
        FunMario.runLevelEditor(new SpriteLib(), filenames );
    }

}
