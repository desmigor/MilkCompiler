package parser.syntax_tree;

import interpreter.ExecutionContext;

public class BooleanValue implements IValue {
    private boolean value;

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public BooleanValue(Object value) {
        this.value = Boolean.parseBoolean((String) value);
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
        return String.valueOf(value);
    }

    @Override
    public IValue execute(ExecutionContext context) {
        return this;
    }
}
