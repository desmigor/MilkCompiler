package parser.syntax_tree;

import java.util.ArrayList;

public class Args {

    private ArrayList<IExpression> args = new ArrayList<>();

    public ArrayList<IExpression> getArgs() {
        return args;
    }

    public void setArgs(ArrayList<IExpression> args) {
        this.args = args;
    }

    public void add(IExpression value) {
        args.add(0, value);
    }

    public Args(Object args, Object expression) {
        this.args = ((Args)args).args;
        add((IExpression) expression);
    }

    public Args() {  }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < args.size(); ++ i) {
            if (i != 0) {
                res.append(", ");
            }
            res.append(args.get(i).toString());
        }
        return res.toString();
    }
}
