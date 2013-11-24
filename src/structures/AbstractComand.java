/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.util.List;

/**
 *
 * @author SCHETTINO
 */
public abstract class AbstractComand implements Comand {

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
