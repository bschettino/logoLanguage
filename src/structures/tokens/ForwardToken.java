/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.ForwardCommand;

/**
 *
 * @author SCHETTINO
 */
public class ForwardToken implements Token{
    public static final String RESERVED_WORD = "forward";
    private Command cmd;

    public ForwardToken() {
        this.cmd = new ForwardCommand();
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
