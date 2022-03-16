package parser.syntax_tree;

import interpreter.ExecutionContext;

public class StringValue implements IValue {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StringValue(Object value) {
        this.value = (String) value;
    }

    @Override
    public String toString(int indent) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < indent; ++i) {
            res.append('\t');
        }
        res.append(this);
        return res.toString();
    }

    @Override
    public String toString() {
        return "\"" + value + "\"";
    }

    @Override
    public IValue execute(ExecutionContext context) {
        return this;
    }
}
