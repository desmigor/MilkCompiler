package syntax_tree;

public class IfStatement implements IStatement {
    private IExpression expression;
    private IBody successBody;
    private IBody failBody;

    public IExpression getExpression() {
        return expression;
    }

    public void setExpression(IExpression expression) {
        this.expression = expression;
    }

    public IBody getSuccessBody() {
        return successBody;
    }

    public void setSuccessBody(IBody successBody) {
        this.successBody = successBody;
    }

    public IBody getFailBody() {
        return failBody;
    }

    public void setFailBody(IBody failBody) {
        this.failBody = failBody;
    }

    public IfStatement(Object expression, Object successBody) {
        this.expression = (IExpression) expression;
        this.successBody = (IBody) successBody;
    }

    public IfStatement(Object expression, Object successBody, Object failBody) {
        this.expression = (IExpression) expression;
        this.successBody = (IBody) successBody;
        this.failBody = (IBody) failBody;
    }

    @Override
    public String toString(int indent) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < indent; ++i) {
            res.append('\t');
        }
        res.append("if (").append(expression.toString()).append(") then\n");
        res.append(successBody.toString(indent + 1));
        res.append('\n');
        if (failBody != null) {
            for (int i = 0; i < indent; ++i) {
                res.append('\t');
            }
            res.append("else\n");
            res.append(failBody.toString(indent + 1));
            res.append('\n');
        }
        for (int i = 0; i < indent; ++i) {
            res.append('\t');
        }
        res.append("end");
        return res.toString();
    }
}
