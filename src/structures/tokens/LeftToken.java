/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.LeftCommand;

/**
 *
 * @author SCHETTINO
 */
public class LeftToken implements Token{
    public static final String CONTENT = "left";
    private Command cmd;
    

    public LeftToken() {
        this.cmd = new LeftCommand();
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
