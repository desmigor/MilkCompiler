package parser.syntax_tree;

import interpreter.ExecutionContext;

public class PriorityExpression implements IExpression {

    private IExpression expression;

    public IExpression getExpression() {
        return expression;
    }

    public void setExpression(IExpression expression) {
        this.expression = expression;
    }

    public PriorityExpression(Object expression) {
        this.expression = (IExpression) expression;
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
        return "(" + expression.toString() + ")";
    }

    @Override
    public IValue execute(ExecutionContext context) {
        return expression.execute(context);
    }
}
