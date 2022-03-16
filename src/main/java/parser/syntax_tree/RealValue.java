package parser.syntax_tree;

import interpreter.ExecutionContext;

public class RealValue implements IValue {
    private Float value;

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public RealValue(Object value) {
        this.value = Float.parseFloat((String) value);
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
