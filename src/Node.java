import java.util.ArrayList;
import java.util.List;

public class Node<T> {

	 private T data = null;
	 
	 private List<Node<T>> children = new ArrayList<>();
	 
	 private Node<T> parent = null;
	 

	 public Node(T data) {
		 this.data = data;
	 }
	 
	 public Node<T> addChild(Node<T> child) {
		 child.setParent(this);
		 this.children.add(child);
		 return child;
	 }
	 
	 public void addChildren(List<Node<T>> children) {
		 for(int i = 0; i < children.size(); i++) {
			 children.get(i).setParent(this);
		 }
		 
		 this.children.addAll(children);
	 }
	 
	 public List<Node<T>> getChildren() {
		 return children;
	 }
	 
	 public T getData() {
		 return data;
	 }
	 
	 public void setData(T data) {
		this.data = data;
	 }
	 
	 private void setParent(Node<T> parent) {
		 this.parent = parent;
	 }
	 
	 public Node<T> getParent() {
		 return parent;
	 }
	 
	 public void printData(int level) {
		 	String s = "";
		 for(int i = 0; i < level; i++) {s = s + "-";}
		 	System.out.println(s + ">| " + this.getData());
		 for(int j = 0; j < this.getChildren().size(); j++) {
			 this.getChildren().get(j).printData(level+1);
		 }
	 }
	
	
	public void replace(T search, T replace) {
		if(this.getData().equals(search)) {
			this.setData(replace);
		}
		for(int i = 0; i < this.getChildren().size(); i++) {
			this.getChildren().get(i).replace(search, replace);
		}
	}
	
	public Node<T> copy(){
		Node<T> n = new Node<T>(this.getData());
		for(int i = 0; i < children.size(); i++) {
			n.addChild(children.get(i).copy());
		}
		return n;
	}
}