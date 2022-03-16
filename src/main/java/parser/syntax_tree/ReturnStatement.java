package parser.syntax_tree;

import interpreter.ExecutionContext;

public class ReturnStatement implements IBody {
    private IExpression value;

    public IExpression getValue() {
        return value;
    }

    public void setValue(IExpression value) {
        this.value = value;
    }

    public ReturnStatement(Object value) {
        this.value = (IExpression) value;
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
        return "return " + value.toString();
    }

    @Override
    public IValue execute(ExecutionContext context) {
        return null;
    }
}
