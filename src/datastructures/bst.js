function Node(val, left, right) {
    this.val = val;
    this.left = left;
    this.right = right;
}


function BST(root) {
    this.root = root;
    this.insert = insert;
    this.inOrder = inOrder;
    this.preOrder = preOrder;
    this.postOrder = postOrder;
}

function insert(data) {

    let n = new Node(data, null, null);
    if (this.root == null) {
        this.root = n;
    } else {
        let current = this.root,
            parent;
        while (current != null) {
            parent = current;
            if (current.val < data) {
                current = current.right
            } else {
                current = current.left;
            }
        }

        if (parent.val < data) {
            parent.right = n
        } else {
            parent.left = n
        }
    }
}

function inOrder(node) {

    if (node == null)
        return;
    inOrder(node.left);
    console.log(node.val + " ");
    inOrder(node.right);

}

function preOrder(node) {
    if (node == null)
        return
    console.log(node.val + " ")
    preOrder(node.left)
    preOrder(node.right)

}

function postOrder(node) {
    if (node == null)
        return
    postOrder(node.left)
    postOrder(node.right)
    console.log(node.val + " ")
}