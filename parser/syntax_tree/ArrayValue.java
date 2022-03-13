package syntax_tree;

public class ArrayValue implements IValue {
    private ArrayValues arrayValues;

    public ArrayValues getArrayValues() {
        return arrayValues;
    }

    public void setArrayValues(ArrayValues arrayValues) {
        this.arrayValues = arrayValues;
    }

    public ArrayValue(Object values) {
        arrayValues = (ArrayValues) values;
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
        return "[" + arrayValues.toString() + "]";
    }
}
