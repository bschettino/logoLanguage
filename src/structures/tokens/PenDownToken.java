/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.PenDownCommand;

/**
 *
 * @author SCHETTINO
 */
public class PenDownToken implements Token{
    public static final String RESERVED_WORD = "pendown";
    private Command cmd;

    public PenDownToken() {
        this.cmd = new PenDownCommand();
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
