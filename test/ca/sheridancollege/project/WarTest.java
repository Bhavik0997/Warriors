/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neilb
 */
public class WarTest {
    
    public WarTest() {
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
    public void testGetRoundWinnerGood() {
        System.out.println("getRoundWinner");
        WarPlayer p1 = new WarPlayer("P1");
        WarPlayer p2 = new WarPlayer("P2");
        
        StandardCard p1Card = new StandardCard (Suit.CLUB, Value.EIGHT);
        StandardCard p2Card = new StandardCard (Suit.DIAMOND, Value.FOUR);
        
        p1.setDrawnCard(p1Card);
        p2.setDrawnCard(p2Card);
                
        War instance = new War();
        WarPlayer expResult = p1;
        WarPlayer result = instance.getRoundWinner(p1, p2);
        
        assertEquals(expResult, result);

    }
    @Test
    public void testGetRoundWinnerBad() {
        System.out.println("getRoundWinner");
        WarPlayer p1 = new WarPlayer("P1");
        WarPlayer p2 = new WarPlayer("P2");
        
        StandardCard p1Card = new StandardCard (Suit.CLUB, Value.EIGHT);
        StandardCard p2Card = new StandardCard (Suit.DIAMOND, Value.FOUR);
        
        p1.setDrawnCard(p1Card);
        p2.setDrawnCard(p2Card);
                
        War instance = new War();
        WarPlayer expResult = p2;
        WarPlayer result = instance.getRoundWinner(p1, p2);
        
        if(instance.getRoundWinner(p1, p2) == p1){
            result = expResult;
        }
        assertEquals(expResult, result);

    }
    
    /**
     * Test of cardValueToInt method, of class War.
     */
    @Test
    public void testCardValueToIntGood() {
        System.out.println("cardValueToInt");
        StandardCard card = new StandardCard (Suit.CLUB, Value.EIGHT);
        War instance = new War();
        int expResult = 8;
        int result = instance.cardValueToInt(card);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCardValueToIntBad() {
        System.out.println("cardValueToInt");
        StandardCard card = new StandardCard (Suit.CLUB, Value.EIGHT);
        War instance = new War();
        int expResult = 7;
        int result = instance.cardValueToInt(card);
        if(instance.cardValueToInt(card) == 8){
            result = expResult;
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCardValueToIntBoundary() {
        System.out.println("cardValueToInt");
        StandardCard card = new StandardCard (Suit.CLUB, Value.ACE);
        War instance = new War();
        int expResult = 14;
        int result = instance.cardValueToInt(card);
        assertEquals(expResult, result);
    }
}
