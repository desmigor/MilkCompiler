package parser.syntax_tree;

import interpreter.ExecutionContext;

public class Identifier implements IExpression {

    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Identifier(Object name) {
        this.name = (String) name;
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
        return name;
    }

    @Override
    public IValue execute(ExecutionContext context) {
        return (IValue) context.getByName(name);
    }
}
