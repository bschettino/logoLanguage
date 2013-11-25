/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.NullCommand;

/**
 *
 * @author SCHETTINO
 */
public class EndFileToken implements Token{
    public static final String RESERVED_WORD = "eof";
    private Command cmd;
    
    public EndFileToken() {
        this.cmd = new NullCommand();
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
