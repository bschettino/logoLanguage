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
    public static final String RESERVED_WORD = "showturtle";
    private Command cmd;
    
    public ShowTurtleToken() {
        this.cmd = new ShowTurtleCommand();
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
