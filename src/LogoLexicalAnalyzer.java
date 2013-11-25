
import exceptions.TokenNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import structures.Token;
import structures.tokens.BackToken;
import structures.tokens.ClearScreenToken;
import structures.tokens.CloseBracesToken;
import structures.tokens.EndCommandToken;
import structures.tokens.EndFileToken;
import structures.tokens.ForwardToken;
import structures.tokens.HideTurtleToken;
import structures.tokens.LeftToken;
import structures.tokens.OpenBracesToken;
import structures.tokens.PenColorToken;
import structures.tokens.PenDownToken;
import structures.tokens.PenUpToken;
import structures.tokens.RepeatToken;
import structures.tokens.RightToken;
import structures.tokens.ShowTurtleToken;
import structures.tokens.ToToken;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SCHETTINO
 */
public class LogoLexicalAnalyzer implements LexicalAnalyzer {

    private final static List<Token> TOKENS = Arrays.asList(new BackToken(), new ForwardToken(),
            new LeftToken(), new RightToken(), new PenUpToken(), new PenDownToken(),
            new HideTurtleToken(), new ShowTurtleToken(), new PenColorToken(),
            new ClearScreenToken(), new RepeatToken(), new ToToken(),
            new OpenBracesToken(), new CloseBracesToken(), new EndCommandToken(),
            new EndFileToken());
    private int lastCharPos;

    @Override
    public List<Token> lexicalAnalysis(String in) throws TokenNotFoundException {
        lastCharPos = next(in);
        List<Token> foundTokens = new ArrayList<>();
        while ((lastCharPos <= in.length()) && (lastCharPos != -1)) {
            System.out.println("lastCharPos: " + lastCharPos);
            boolean tokenFound = false;
            System.out.println("in " + in);
            String string = in.substring(0, lastCharPos).trim();
            System.out.println("String: " + string);
            for (Token token : TOKENS) {
                System.out.println("Token: " + token);
                if (token.getReservedWord().equals(string) || token.getReservedWord().concat(new EndCommandToken().getReservedWord()).equals(string)) {
                    try {
                        tokenFound = true;
                        foundTokens.add(token.getClass().newInstance());
                        if (lastCharPos <= in.length()) {
                            in = in.substring(lastCharPos, in.length());
                        }
                        lastCharPos = next(in);
                        break;
                    } catch (InstantiationException | IllegalAccessException ex) {
                        Logger.getLogger(LogoLexicalAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
            if (!tokenFound) {
                throw new TokenNotFoundException("Vish");
            }

        }
        foundTokens.add(new EndFileToken());
        return foundTokens;
    }

    private int next(String in) {
        int result = in.indexOf(";") + 1;
        if (result == 0) {
            result = in.indexOf(" ") + 1;
            if (result == 0 && in.length() > 0) {
                result = in.length();
            } else {
                result = -1;
            }
        }

        return result;
    }
//        stack.push(in);
//        a = nextToken();
//        do {
//            x = stack.pop();
//            if (IS_TERMINAL(x)) {
//                if (x == a) {
//                    a = nextToken();
//                } else {
//                    syntaxError();
//                    break;
//                }
//            } else {
//                a = subst[x][a];
//                if (IS_NULL(a)) {
//                    syntaxError();
//                    break;
//                } else {
//                    push(a);
//                }
//            }
//        } while (x != 
//        ‘eof
//    
//
//’ );
}
