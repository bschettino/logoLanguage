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
public interface Command {
    
    public void action();
    public List<Parameter> getParameters();
    public void setParameters(List<Parameter> parameters);
    
}
