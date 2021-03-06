/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.BackCommand;

/**
 *
 * @author SCHETTINO
 */
public class BackToken implements Token{
    public static final String CONTENT = "back";
    private Command cmd;
    public BackToken() {
        this.cmd = new BackCommand();
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
