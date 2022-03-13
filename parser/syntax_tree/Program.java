package syntax_tree;

import java.util.ArrayList;

public class Program implements IBody {
    private ArrayList<IBody> statements = new ArrayList<>();

    public ArrayList<IBody> getStatements() {
        return statements;
    }

    public void setStatements(ArrayList<IBody> statements) {
        this.statements = statements;
    }

    public void add(IBody statement) {
        statements.add(0, statement);
    }

    public Program(Object statements, Object statement) {
        this.statements = ((Program)statements).statements;
        add((IBody) statement);
    }

    public Program(Object statements) {
        this.statements = ((Program)statements).statements;
    }

    public Program() {  }

    public String toString(int indent) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < statements.size(); ++i) {
            res.append(statements.get(i).toString(indent));
            if (i < statements.size() - 1) {
                res.append('\n');
            }
        }
        return res.toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
