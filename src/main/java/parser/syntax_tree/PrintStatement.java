package parser.syntax_tree;

import interpreter.ExecutionContext;

public class PrintStatement implements IBody {
    private IExpression expression;

    public IExpression getExpression() {
        return expression;
    }

    public void setExpression(IExpression expression) {
        this.expression = expression;
    }

    public PrintStatement(Object expression) {
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
        return "print " + expression.toString();
    }

    @Override
    public IValue execute(ExecutionContext context) {
        System.out.println(expression.execute(context).toString());
        return null;
    }
}
