/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import exceptions.TokenNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.Soundbank;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import structures.Token;
import structures.tokens.BackToken;
import structures.tokens.EndFileToken;
import structures.tokens.ForwardToken;

/**
 *
 * @author SCHETTINO
 */
public class LogoLexicalAnalyzerTest {
    
    public LogoLexicalAnalyzerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void emptyString() throws TokenNotFoundException {
        String in = "";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(1, result.size());
        assertEquals(EndFileToken.RESERVED_WORD, result.get(0).getReservedWord());
    }
    
   @Test
    public void oneToken() throws TokenNotFoundException {
        String in = "back";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(2, result.size());
        assertEquals(BackToken.RESERVED_WORD, result.get(0).getReservedWord());
        assertEquals(EndFileToken.RESERVED_WORD, result.get(1).getReservedWord());
    }
    
   @Test
    public void oneTokenWithEndCommand() throws TokenNotFoundException {
        String in = "back;";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(2, result.size());
        BackToken backToken = new BackToken();
        assertEquals(backToken.getReservedWord(), result.get(0).getReservedWord());
        EndFileToken endToken = new EndFileToken();
        assertEquals(endToken.getReservedWord(), result.get(1).getReservedWord());
    }
   
    @Test
    public void twoTokens() throws TokenNotFoundException {
        String in = "back ;forward;";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(3, result.size());
        assertEquals(BackToken.RESERVED_WORD, result.get(0).getReservedWord());
        assertEquals(ForwardToken.RESERVED_WORD, result.get(1).getReservedWord());
        assertEquals(EndFileToken.RESERVED_WORD, result.get(2).getReservedWord());
    }
    
    @Test
    public void twoTokensWithSpace() throws TokenNotFoundException {
        String in = "back; forward;";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(3, result.size());
        assertEquals(BackToken.RESERVED_WORD, result.get(0).getReservedWord());
        assertEquals(ForwardToken.RESERVED_WORD, result.get(1).getReservedWord());
        assertEquals(EndFileToken.RESERVED_WORD, result.get(2).getReservedWord());
    }
}