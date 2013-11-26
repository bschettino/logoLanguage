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
public class UnknownToken implements Token {

    private String content;
    private Command cmd;

    public UnknownToken() {
        this.cmd = new NullCommand();
    }
    public UnknownToken(String c) {
        this.cmd = new NullCommand();
        this.content = c;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String c) {
        content = c;
    }

    @Override
    public Command getCommand() {
        return cmd;
    }
}
