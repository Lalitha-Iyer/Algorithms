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
    this.nextNode = nextNode;
    this.previousNode = previousNode;
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

//in order successor
function nextNode(node) {

    if (this.root == null)
        return null
    let successor = {}
    nextNodeInOrder(this.root, node, successor)
    return successor.val

}

//in order successor
function previousNode(val) {

    if (this.root == null)
        return null
    let pre = {}
    previousNodeInOrder(this.root, val, pre)
    prevFlag = false;
    return pre.val

}

flag = false

function nextNodeInOrder(root, val, successor) {
    if (root == null) return
    nextNodeInOrder(root.left, val, successor)
    if (flag) {
        successor.val = root;
        flag = false;
    }
    if (root.val === val) {
        flag = true
    }
    nextNodeInOrder(root.right, val, successor)


}

prevFlag = false;

function previousNodeInOrder(root, val, pre) {
    if (root == null) return
    nextNodeInOrder(root.left, val, pre)
    if (!prevFlag) {
        pre.val = root;
    }
    if (root.val === val) {
        prevFlag = true
    }
    nextNodeInOrder(root.right, val, pre)


}