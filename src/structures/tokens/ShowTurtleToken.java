/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.ShowTurtleCommand;

/**
 *
 * @author SCHETTINO
 */
public class ShowTurtleToken implements Token{
    public static final String CONTENT = "showturtle";
    private Command cmd;
    
    public ShowTurtleToken() {
        this.cmd = new ShowTurtleCommand();
    }
        @Override
    public String getContent() {
       return CONTENT;
    }

    @Override
    public Command getCommand() {
        return cmd;
    }
}
