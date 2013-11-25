/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.PenUpCommand;

/**
 *
 * @author SCHETTINO
 */
public class PenUpToken implements Token{
    public static final String RESERVED_WORD = "penup";
    private Command cmd;

    public PenUpToken() {
        this.cmd = new PenUpCommand();
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
