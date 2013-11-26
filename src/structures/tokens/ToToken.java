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
    public static final String CONTENT = "to";
    private Command cmd;
    
    public ToToken() {
        this.cmd = new ToCommand();
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
