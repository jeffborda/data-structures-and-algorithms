package leftjoin;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JoinTest {

    @Test
    public void testLeftJoin() {
        HashMap<String, String> synonym = new HashMap<>();
        HashMap<String, String> antonym = new HashMap<>();
        // ::: Test Data from Code Challenge 33 :::
        // ~ LEFT TABLE ~
        synonym.put("fond", "enamored");
        synonym.put("wrath", "anger");
        synonym.put("diligent", "employed");
        synonym.put("outfit", "garb");
        synonym.put("guide", "usher");
        // ~ RIGHT TABLE ~
        antonym.put("fond", "averse");
        antonym.put("wrath", "delight");
        antonym.put("diligent", "idle");
        antonym.put("guide", "follow");
        antonym.put("flow", "jam");

        Map<String, List<String>> result1 = Join.leftJoin(synonym, antonym);
        assertEquals("The result of the join must be equal to the size of the left table.", synonym.size(), result1.size());
        assertTrue("All key value pairs from the left table must appear in the result.", result1.get("fond").contains("enamored"));
        assertTrue("The result must also contain the value from the right table if it had the same key.", result1.get("fond").contains("averse"));
        assertTrue("If the right table did not have a key that appeared in the left table, a 'null' should be inserted in the list for that key.", result1.get("outfit").contains(null));
        assertTrue("Confirm that it stored the value from the left table when a 'null' was inserted.", result1.get("outfit").contains("garb"));
        assertEquals("The list of values should always be size '2'.", 2, result1.get("wrath").size());


        HashMap<String, String> leftTable = new HashMap<>();
        HashMap<String, String> rightTable = new HashMap<>();
        Map<String, List<String>> result2 = Join.leftJoin(leftTable, rightTable);
        assertEquals("If given an empty HashMap, it should return an empty HashSet without errors.", 0, result2.size());

        leftTable.put("1", "one");
        leftTable.put("2", "two");
        leftTable.put("3", "three");
        rightTable.put("4", "four");
        rightTable.put("5", "five");
        rightTable.put("6", "size");

        Map<String, List<String>> result3 = Join.leftJoin(leftTable, rightTable);
        assertEquals("The size of the result HashMap should always be the size of the left table.", leftTable.size(), result3.size());
        String[] strs = new String[]{"one", "two", "three"};
        for(int i = 1; i <= leftTable.size(); i++) {
            assertTrue("If the right table shares no keys with the left table, the every list of values should contain 'null'.", result3.get(Integer.toString(i)).contains(null));
            assertTrue("If the right table shares no keys with the left table, the list of values should contain the values from the left table.", result3.get(Integer.toString(i)).contains(strs[i-1]));
            assertEquals("The values list should always be size '2'.", 2, result3.get(Integer.toString(i)).size());
        }

        leftTable.put("4", "Java");
        result3 = Join.leftJoin(leftTable, rightTable);
        assertEquals("Result should still be size of the left table.", leftTable.size(), result3.size());
        assertTrue("Left and Right tables share the key of '4', so values from left table and right table should appear in the list.", result3.get("4").contains("four"));
        assertTrue("Left and Right tables share the key of '4', so values from left table and right table should appear in the list.", result3.get("4").contains("Java"));
        assertEquals("There should only be two elements in the list of values.", 2, result3.get("4").size());
    }
}