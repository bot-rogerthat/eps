package cli;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SearchAlgorithmTest {

    @Test
    public void testGetGroupFoundIsResult() throws Exception {
        SearchAlgorithm alg = new SearchAlgorithm(new Matrix(1, 1, 1));
        Map<DegreeOfRisk, Integer> result = new HashMap<>();
        result.put(DegreeOfRisk.NONE, 1);
        assertEquals(alg.getGroupFound(), result);
    }

    @Test
    public void testGetGroupFoundIsNotResult() throws Exception {
        SearchAlgorithm alg = new SearchAlgorithm(new Matrix(1, 1, 0));
        Map<DegreeOfRisk, Integer> result = new HashMap<>();
        assertEquals(alg.getGroupFound(), result);
    }
}