package parser.syntax_tree;

public class FunctionDef {
    private Params params;
    private IBody body;

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public IBody getBody() {
        return body;
    }

    public void setBody(IBody body) {
        this.body = body;
    }

    public FunctionDef(Object params, Object body) {
        this.params = (Params) params;
        this.body = (IBody) body;
    }

    public String toString(int indent) {
        return "funct" + params.toString() + " is\n" + body.toString(indent + 1) + "\nend";
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
