/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.RepeatCommand;

/**
 *
 * @author SCHETTINO
 */
public class RepeatToken implements Token{
    public static final String RESERVED_WORD = "repeat";
    private Command cmd;
    
    public RepeatToken() {
        this.cmd = new RepeatCommand();
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
