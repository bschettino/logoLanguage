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
public class OpenBracesToken implements Token{
    public static final String CONTENT = "{";
    private Command cmd;

    public OpenBracesToken() {
        this.cmd = new NullCommand();
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
