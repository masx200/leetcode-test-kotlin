import { TreeNode } from "../binary-tree-inorder-traversal/TreeNode.ts";

export default function levelOrderBottom(root: TreeNode | null): number[][] {
    if (!root) return [];
    const current: TreeNode[] = [root];
    const result: number[][] = [];

    level(current, (r) => result.push(r));
    return result.reverse();
}

// function levelOrder(root: TreeNode | null): number[][] {
// if(!root){return []}
//     const current:TreeNode[]=[root]
//     const result: number[][] =[]

// level(current,r=>result.push(r))
//     return result
// };
export function level(nodes: TreeNode[], output: (r: number[]) => void) {
    if (nodes.length === 0) return;

    output(nodes.map((n) => n.val));

    level(
        nodes
            .map((n) => [n.left, n.right].filter(Boolean) as TreeNode[])
            .flat(),
        output,
    );
}
