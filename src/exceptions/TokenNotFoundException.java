/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author SCHETTINO
 */
public class TokenNotFoundException extends Exception {

    public TokenNotFoundException() {
    }

    public TokenNotFoundException(String msg) {
        super(msg);
    }
}
