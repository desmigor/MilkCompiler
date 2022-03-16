package parser.syntax_tree;

import interpreter.ExecutionContext;

public class Assignment implements IBody {
    private Identifier name;
    private IExpression value;

    public Identifier getName() {
        return name;
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    public IExpression getValue() {
        return value;
    }

    public void setValue(IExpression value) {
        this.value = value;
    }

    public Assignment(Object name, Object value) {
        this.name = (Identifier) name;
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
        return name.toString() + " := " + value.toString();
    }

    @Override
    public IValue execute(ExecutionContext context) {
        context.setName(name.getName(), value.execute(context));
        return null;
    }
}
