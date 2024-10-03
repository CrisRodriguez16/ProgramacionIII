package co.edu.umanizales.kids_list.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NodeBST {
    private Kid kid;
    private NodeBST left, right;

    public NodeBST(Kid kid) {
        this.kid = kid;
        left = right = null;
    }

}
