package syntax_tree;

public class Declaration implements IBody {
    private Identifier name;
    private IExpression value;
    private FunctionDef functionDef;

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

    public FunctionDef getFunctionDef() {
        return functionDef;
    }

    public void setFunctionDef(FunctionDef functionDef) {
        this.functionDef = functionDef;
    }

    public Declaration(Object name) {
        this.name = (Identifier) name;
        this.value = new IntegerValue("0");
    }

    public Declaration(Object name, Object value) {
        this.name = (Identifier) name;
        this.value = (IExpression) value;
    }

    public Declaration(Object name, Object functionDef, int a) {
        this.name = (Identifier) name;
        this.functionDef = (FunctionDef) functionDef;
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
        if (functionDef == null && value == null) {
            return "var " + name.toString();
        } else if (functionDef == null) {
            return "var " + name.toString() + " := " + value.toString();
        } else {
            return "var " + name.toString() + " := " + functionDef.toString();
        }
    }
}
