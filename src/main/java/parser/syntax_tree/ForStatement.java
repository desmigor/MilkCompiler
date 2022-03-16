package parser.syntax_tree;

import interpreter.ExecutionContext;

public class ForStatement implements IStatement {
    public Identifier identifier;
    public IExpression forExpression;
    public IBody body;

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public IExpression getForExpression() {
        return forExpression;
    }

    public void setForExpression(IExpression forExpression) {
        this.forExpression = forExpression;
    }

    public IBody getBody() {
        return body;
    }

    public void setBody(IBody body) {
        this.body = body;
    }

    public ForStatement(Object name, Object enumeration, Object body) {
        this.identifier = (Identifier) name;
        this.forExpression = (IExpression) enumeration;
        this.body = (IBody) body;
    }

    @Override
    public String toString(int indent) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < indent; ++i) {
            res.append('\t');
        }
        res.append("for (").append(identifier.toString()).append(" in ").append(forExpression.toString()).append(") loop\n");
        res.append(body.toString(indent + 1));
        res.append('\n');
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

    @Override
    public IValue execute(ExecutionContext context) {
        return null;
    }
}
