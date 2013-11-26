package analizers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import structures.tokens.UnknownToken;

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

    @Override
    public List<Token> lexicalAnalysis(String input) {
        List<Token> result = new ArrayList<>();
        for (int i = 0; i < input.length();) {
            switch (input.charAt(i)) {
                case ';':
                    result.add(new EndCommandToken());
                    i++;
                    break;
                case '{':
                    result.add(new OpenBracesToken());
                    i++;
                    break;
                case '}':
                    result.add(new CloseBracesToken());
                    i++;
                    break;
                default:
                    if (Character.isWhitespace(input.charAt(i))) {
                        i++;
                    } else {
                        String atom = getAtom(input, i);
                        i += atom.length();
                        boolean foundToken = false;
                        for (Token token : TOKENS) {
                            if (token.getContent().equals(atom.trim())) {
                                foundToken = true;
                                result.add(token);
                                break;
                            }
                        }
                        if (!foundToken) {
                            result.add(new UnknownToken(atom));
                        }

                    }
                    break;
            }
        }
        result.add(new EndFileToken());
        return result;
    }

    public static String getAtom(String s, int i) {
        int j = i;
        if (Character.isLetter(s.charAt(j))) {
            for (; j < s.length();) {
                if (Character.isLetter(s.charAt(j))) {
                    j++;
                } else {
                    return s.substring(i, j);
                }
            }
        }else{
            for (; j < s.length();) {
                char c = s.charAt(j);
                if (Character.isLetter(c) || (c == ';') || (c == '{') || (c == '}') || Character.isWhitespace(c)) {
                    return s.substring(i, j);
                } else {
                    j++;
                }
            }  
        }
        return s.substring(i, j);
    }
}
