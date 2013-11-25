/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.ToCommand;

/**
 *
 * @author SCHETTINO
 */
public class ToToken implements Token{
    public static final String RESERVED_WORD = "to";
    private Command cmd;
    
    public ToToken() {
        this.cmd = new ToCommand();
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
