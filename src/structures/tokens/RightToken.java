/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.RightCommand;

/**
 *
 * @author SCHETTINO
 */
public class RightToken implements Token{
    public static final String RESERVED_WORD = "right";
    private Command cmd;

    public RightToken() {
        this.cmd = new RightCommand();
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
