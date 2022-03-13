package syntax_tree;

public class FunctionCall implements IExpression {
    private Identifier funcName;
    private Args funcArgs;

    public Identifier getFuncName() {
        return funcName;
    }

    public void setFuncName(Identifier funcName) {
        this.funcName = funcName;
    }

    public Args getFuncArgs() {
        return funcArgs;
    }

    public void setFuncArgs(Args funcArgs) {
        this.funcArgs = funcArgs;
    }

    public FunctionCall(Object name, Object args) {
        this.funcName = (Identifier) name;
        this.funcArgs = (Args) args;
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
        return funcName.toString() + "(" + funcArgs.toString() + ")";
    }
}
