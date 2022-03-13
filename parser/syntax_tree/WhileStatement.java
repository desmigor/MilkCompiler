package syntax_tree;

public class WhileStatement implements IStatement {
    private IExpression expression;
    private IBody body;

    public IExpression getExpression() {
        return expression;
    }

    public void setExpression(IExpression expression) {
        this.expression = expression;
    }

    public IBody getBody() {
        return body;
    }

    public void setBody(IBody body) {
        this.body = body;
    }

    public WhileStatement(Object expression, Object body) {
        this.expression = (IExpression) expression;
        this.body = (IBody) body;
    }

    @Override
    public String toString(int indent) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < indent; ++i) {
            res.append('\t');
        }
        res.append("while (").append(expression.toString()).append(") loop\n");
        res.append(expression.toString(indent + 1)).append('\n');
        for (int i = 0; i < indent; ++i) {
            res.append('\t');
        }
        res.append("end");
        return res.toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
