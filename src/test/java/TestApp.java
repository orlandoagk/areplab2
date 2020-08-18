import junit.framework.TestCase;
import edu.escuelaing.arep.components.*;


public class TestApp extends TestCase {

    public void testMean() throws Exception {
        LinkedList lista = new LinkedList();
        lista.addNode(3.4);
        lista.addNode(5.8);
        lista.addNode(10.9);
        lista.addNode(4.3);
        lista.addNode(2.1);
        lista.addNode(9);
        lista.addNode(20);
        lista.restartView();
        assertEquals(Calculator.mean(lista),7.93);
        lista = new LinkedList();
        lista.addNode(15.0);
        lista.addNode(69.9);
        lista.addNode(6.5);
        lista.addNode(22.4);
        lista.addNode(28.4);
        lista.addNode(65.9);
        lista.addNode(19.4);
        lista.addNode(198.7);
        lista.addNode(38.8);
        lista.addNode(138.2);
        assertEquals(Calculator.mean(lista),60.32);
    }

    public void testDeviation() throws Exception {
        LinkedList lista = new LinkedList();
        lista.addNode(3.4);
        lista.addNode(5.8);
        lista.addNode(10.9);
        lista.addNode(4.3);
        lista.addNode(2.1);
        lista.addNode(9);
        lista.addNode(20);
        lista.restartView();
        assertEquals(Calculator.deviation(lista,Calculator.mean(lista)),6.16);
        lista = new LinkedList();
        lista.addNode(15.0);
        lista.addNode(69.9);
        lista.addNode(6.5);
        lista.addNode(22.4);
        lista.addNode(28.4);
        lista.addNode(65.9);
        lista.addNode(19.4);
        lista.addNode(198.7);
        lista.addNode(38.8);
        lista.addNode(138.2);
        assertEquals(Calculator.deviation(lista,Calculator.mean(lista)),62.26);
    }

}
