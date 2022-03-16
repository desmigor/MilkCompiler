package parser.syntax_tree;

import interpreter.ExecutionContext;

public class UnaryRelation implements IRelation {
    public IExpression expression;
    public String op;

    public IExpression getExpression() {
        return expression;
    }

    public void setExpression(IExpression expression) {
        this.expression = expression;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public UnaryRelation(Object expression, Object op) {
        this.expression = (IExpression) expression;
        this.op = (String) op;
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
        return "not " + expression.toString();
    }

    @Override
    public IValue execute(ExecutionContext context) {
        IValue executed = expression.execute(context);
        if (executed instanceof BooleanValue) {
            return new BooleanValue(String.valueOf(!(((BooleanValue) executed).getValue())));
        } else {
            throw new RuntimeException("Operation " + op + " cannot be applied to " + expression.getClass().getName());
        }
    }
}
