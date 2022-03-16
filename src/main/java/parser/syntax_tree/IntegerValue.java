package parser.syntax_tree;

import interpreter.ExecutionContext;

public class IntegerValue implements IValue {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public IntegerValue(Object value) {
        this.value = Integer.parseInt((String) value);
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
