package parser.syntax_tree;

import java.util.ArrayList;

public class ArrayValues {

    private ArrayList<IExpression> values = new ArrayList<>();

    public ArrayList<IExpression> getValues() {
        return values;
    }

    public void setValues(ArrayList<IExpression> values) {
        this.values = values;
    }

    public void add(IExpression value) {
        values.add(0, value);
    }

    public ArrayValues(Object values, Object expression) {
        this.values = ((ArrayValues)values).values;
        add((IExpression) expression);
    }

    public ArrayValues() { }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.size(); ++ i) {
            if (i != 0) {
                res.append(", ");
            }
            res.append(values.get(i).toString());
        }
        return res.toString();
    }
}
