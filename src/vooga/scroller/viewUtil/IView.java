
package vooga.scroller.viewUtil;



public interface IView {

    /**
     * Process a String representing a command.
     * 
     * @param command - unprocessed String.
     */
    public void processCommand(String command);
    
    
    /**
     * Render the Renderable Object based on State.
     * 
     * @param r
     */
    public void render(Renderable r);

}
