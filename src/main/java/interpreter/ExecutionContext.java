package interpreter;

import java.util.HashMap;
import java.util.Map;

public class ExecutionContext {

    private final Map<String, Object> names = new HashMap<>();

    public ExecutionContext() { }

    public Object getByName(String name) {
        if (!names.containsKey(name)) {
            throw new RuntimeException("Name " + name + " is not defined");
        }
        return names.get(name);
    }

    public void setName(String name, Object value) {
        names.put(name, value);
    }

}
