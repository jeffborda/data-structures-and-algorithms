package leftjoin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Join {

    public static Map<String, List<String>> leftJoin(Map<String, String> leftTable, Map<String, String> rightTable) {

        // Create the HashMap to contain the result of the left join
        Map<String, List<String>> leftJoined = new HashMap<>();
        for (Map.Entry<String, String> entryLeft : leftTable.entrySet()) {
            // Create a list of values on each iteration.
            List<String> current = new ArrayList<>();
            // Always add the value of the left table to the list
            current.add(entryLeft.getValue());
            // If the right table has a key which also occurs in the left table, add the right table's value to the list also
            if(rightTable.containsKey(entryLeft.getKey())) {
                current.add(rightTable.get(entryLeft.getKey()));
            }
            else {
                // If the right table does NOT have that key, add a 'null' to the list
                current.add(null);
            }
            // Put the key/value pair into the join table: <left key, list of values>
            leftJoined.put(entryLeft.getKey(), current);
        }
        return leftJoined;
    }
}
