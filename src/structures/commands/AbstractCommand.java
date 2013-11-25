/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.commands;

import java.util.List;
import structures.Command;
import structures.Parameter;

/**
 *
 * @author SCHETTINO
 */
public abstract class AbstractCommand implements Command {

    private List<Parameter> parameters;

    @Override
    public List<Parameter> getParameters() {
        return this.parameters;
    }
    
    @Override
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}
