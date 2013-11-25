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
    public static final String RESERVED_WORD = "hideturtle";
    private Command cmd;

    public HideTurtleToken() {
        this.cmd = new HideTurtleCommand();
    }
        @Override
    public String getReservedWord() {
       return RESERVED_WORD;
    }

    @Override
    public Command getCommand() {
        return cmd;
    }
}
