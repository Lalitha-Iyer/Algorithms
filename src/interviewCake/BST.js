
function isBST(root)
{

   return isBSTHelper(root,-Infinity, Infinity);
   
}

function isBSTHelper(root,lower, upper)
{
    var flag = true;
    if(root == null)
        return true;
      flag = root.val >lower;
      flag = flag && root.val < upper
    
    flag = flag && isBSTHelper(root.left, lower, root.val)
    flag = flag &&isBSTHelper(root.right, root.val, upper);
        
     
    return flag;
        
     
}

var left={val:5, left:{val:4,left:null}, right:{val:7,left:null,right:null}};
var right={val:45, left:null, right:null};
var root= { val:12, left: left, right:right};

console.log(isBST(root));
