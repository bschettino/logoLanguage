/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import analizers.LogoLexicalAnalyzer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import structures.Token;
import structures.tokens.BackToken;
import structures.tokens.CloseBracesToken;
import structures.tokens.EndCommandToken;
import structures.tokens.EndFileToken;
import structures.tokens.ForwardToken;
import structures.tokens.LeftToken;
import structures.tokens.OpenBracesToken;
import structures.tokens.RepeatToken;
import structures.tokens.ToToken;
import structures.tokens.UnknownToken;

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
    public void emptyString()  {
        String in = "";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(1, result.size());
        int i = 0;
        assertEquals(EndFileToken.CONTENT, result.get(i++).getContent());
    }
    
   @Test
    public void oneToken(){
        String in = "back";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(2, result.size());
        int i = 0;
        assertEquals(BackToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndFileToken.CONTENT, result.get(i++).getContent());
    }
    
   @Test
    public void oneTokenWithEndCommand() {
        String in = "back;";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(3, result.size());
        int i = 0;
        assertEquals(BackToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndCommandToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndFileToken.CONTENT, result.get(i++).getContent());
    }
   
    @Test
    public void twoTokens()  {
        String in = "back ;forward;";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(5, result.size());
        int i =0;
        assertEquals(BackToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndCommandToken.CONTENT, result.get(i++).getContent());
        assertEquals(ForwardToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndCommandToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndFileToken.CONTENT, result.get(i++).getContent());
    }
    
    @Test
    public void twoTokensWithSpace() {
        String in = "back; forward;";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(5, result.size());
        int i =0;
        assertEquals(BackToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndCommandToken.CONTENT, result.get(i++).getContent());
        assertEquals(ForwardToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndCommandToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndFileToken.CONTENT, result.get(i++).getContent());
    }
    
    @Test
    public void function() {
        String in = "left 50;";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(4, result.size());
        int i = 0;
        assertEquals(LeftToken.CONTENT, result.get(i++).getContent());
        assertEquals("50", result.get(i).getContent());
        assertEquals(new UnknownToken().getClass().getName(), result.get(i++).getClass().getName());
        assertEquals(EndCommandToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndFileToken.CONTENT, result.get(i++).getContent());
    }
    
    @Test
    public void functionTo() {
        String in = "to square{ back};";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(7, result.size());
        int i = 0;
        assertEquals(ToToken.CONTENT, result.get(i++).getContent());
        assertEquals("square", result.get(i).getContent());
        assertEquals(new UnknownToken().getClass().getName(), result.get(i++).getClass().getName());
        assertEquals(OpenBracesToken.CONTENT, result.get(i++).getContent());
        assertEquals(BackToken.CONTENT, result.get(i++).getContent());
        assertEquals(CloseBracesToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndCommandToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndFileToken.CONTENT, result.get(i++).getContent());
    }
    
    @Test
    public void functionInception() {
        String in = "to square{ repeat 4 {back};};";
        LogoLexicalAnalyzer instance = new LogoLexicalAnalyzer();
        List<Token> result = instance.lexicalAnalysis(in);
        assertEquals(12, result.size());
        int i = 0;
        assertEquals(ToToken.CONTENT, result.get(i++).getContent());
        assertEquals("square", result.get(i).getContent());
        assertEquals(new UnknownToken().getClass().getName(), result.get(i++).getClass().getName());
        assertEquals(OpenBracesToken.CONTENT, result.get(i++).getContent());
        assertEquals(RepeatToken.CONTENT, result.get(i++).getContent());
        assertEquals("4", result.get(i).getContent());
        assertEquals(new UnknownToken().getClass().getName(), result.get(i++).getClass().getName());
        assertEquals(OpenBracesToken.CONTENT, result.get(i++).getContent());
        assertEquals(BackToken.CONTENT, result.get(i++).getContent());
        assertEquals(CloseBracesToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndCommandToken.CONTENT, result.get(i++).getContent());
        assertEquals(CloseBracesToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndCommandToken.CONTENT, result.get(i++).getContent());
        assertEquals(EndFileToken.CONTENT, result.get(i++).getContent());
    }
}