/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.ClearScreenCommand;

/**
 *
 * @author SCHETTINO
 */
public class ClearScreenToken implements Token{
    public static final String CONTENT = "clearscreen";
    private Command cmd;
    
    public ClearScreenToken() {
        this.cmd = new ClearScreenCommand();
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
