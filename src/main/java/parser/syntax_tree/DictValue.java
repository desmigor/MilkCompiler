package parser.syntax_tree;

import interpreter.ExecutionContext;

public class DictValue implements IValue {
    private DictValues value;

    public DictValues getValue() {
        return value;
    }

    public void setValue(DictValues value) {
        this.value = value;
    }

    public DictValue(Object values) {
        value = (DictValues) values;
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
        return "{" + value.toString() + "}";
    }

    @Override
    public IValue execute(ExecutionContext context) {
        return null;
    }
}
