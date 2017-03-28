private TreeNode findNode(TreeNode parent, String item) { /* your code here */ }  

02    

03 private TreeNode insert(TreeNode parent, String item) { /* your code here */ }  

04    

05 private boolean searchTree(String item) { return findNode(this.root, item)!=null; }  

06    

07 public void insert(String item){  

08     if(isEmpty()){  

09         this.root = new TreeNode(item);   

10         System.out.println("inserted " + "'" + item + "'" + " into tree. Frequency: " + root.getFreq());  

11     } else {  

12         TreeNode node = findNode(this.root, item);  

13         if(node!=null) {  

14             node.upFreq();  

15             System.out.print( "'" + item + "'" + " already exists!");  

16         } else {  

17             node = insert(this.root, item);  

18             System.out.print("inserted " + "'" + item + "'" + " into tree!");  

19         }    

20         System.out.println(" Frequency: " + node.getFreq());  

21     }  

