package uk.ac.leedsbeckett.mullier.sesc;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AwardTest {
    private CycleLeague league;
    private Competitor c;

    @BeforeAll
    static void initialise()
    {
        System.out.println("initialising tests");
    }
    @AfterAll
    static void finished()
    {
        System.out.println("finished tests");
    }

    @BeforeEach
    void setUp() throws Exception
    {
        System.out.println("allocating resources");
        league = new CycleLeague("Time Trial League",18);
        c = new Competitor(league,"Test Person","Nova","Vet");
    }


    @AfterEach
    void tearDown() throws Exception
    {
        System.out.println("deallocating resources");
        //release resources
        league = null;
        c = null;
    }

    @Test
    /**
     * tests getPointsEvent(int event)
     * sets the points using setResult(int event, int points)
     * uses getPointsEvent(int event) to read the set value back
     */
    void testResult()
    {

        c.setResult(5,50);
        assertEquals(c.getPointsEvent(5),5);
    }

    @Test
    /**tests GetPoints()
     * sets five sequential events to 10 points each using setResult()
     * reads the total points back using getPoints()
     */
    void testGetPoints()
    {
        c.setResult(10);
        c.setResult(10);
        c.setResult(10);
        c.setResult(10);
        c.setResult(10);
        assertEquals(c.getPoints(),50);
    }


}