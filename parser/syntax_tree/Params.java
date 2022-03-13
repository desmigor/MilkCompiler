package syntax_tree;

import java.util.ArrayList;

public class Params {

    private ArrayList<Identifier> params = new ArrayList<>();

    public ArrayList<Identifier> getParams() {
        return params;
    }

    public void setParams(ArrayList<Identifier> params) {
        this.params = params;
    }

    public void add(Identifier name) {
        params.add(0, name);
    }

    public Params(Object params, Object name) {
        this.params = ((Params)params).params;
        add((Identifier) name);
    }

    public Params() {  }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('(');
        for (int i = 0; i < params.size(); ++i) {
            if (i != 0) {
                res.append(", ");
            }
            res.append(params.get(i).toString());
        }
        res.append(')');
        return res.toString();
    }
}
