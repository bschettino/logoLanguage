
import exceptions.TokenNotFoundException;
import java.util.List;
import structures.Token;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SCHETTINO
 */
public interface LexicalAnalyzer {
    public List<Token> lexicalAnalysis(String in) throws TokenNotFoundException;
}
