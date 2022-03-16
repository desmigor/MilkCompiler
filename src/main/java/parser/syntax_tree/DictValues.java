package parser.syntax_tree;

import java.util.HashMap;
import java.util.Map;

public class DictValues {

    private HashMap<Object, Object> values = new HashMap<>();

    public HashMap<Object, Object> getValues() {
        return values;
    }

    public void setValues(HashMap<Object, Object> values) {
        this.values = values;
    }

    public void add(Assignment assignment) {
        values.put(assignment.getName(), assignment.getValue());
    }

    public DictValues(Object values, Object assignment) {
        this.values = ((DictValues)values).values;
        add((Assignment) assignment);
    }

    public DictValues() {  }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        boolean isFirst = true;
        for (Map.Entry<Object, Object> entry : values.entrySet()) {
            if (!isFirst) {
                res.append(", ");
            }
            res.append(entry.getKey().toString());
            res.append("=");
            res.append(entry.getValue().toString());
            isFirst = false;
        }
        return res.toString();
    }
}
