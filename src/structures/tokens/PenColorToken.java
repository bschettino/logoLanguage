/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.tokens;

import structures.Command;
import structures.Token;
import structures.commands.PenColorCommand;

/**
 *
 * @author SCHETTINO
 */
public class PenColorToken implements Token{
    public static final String CONTENT = "pencolor";
    private Command cmd;

    public PenColorToken() {
        this.cmd = new PenColorCommand();
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
