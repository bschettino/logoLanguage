/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.HideTurtleCommand;

/**
 *
 * @author SCHETTINO
 */
public class HideTurtleToken implements Token{
    public static final String CONTENT = "hideturtle";
    private Command cmd;

    public HideTurtleToken() {
        this.cmd = new HideTurtleCommand();
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
