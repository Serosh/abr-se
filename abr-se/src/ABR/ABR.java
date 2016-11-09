package ABR;

public class ABR {
	
	public class Node {
		
		private Node child_left;
		private Node child_right;
		private int value;
		
		Node(int valeur) {
			this.value = valeur;
			this.child_left = null;
			this.child_right = null;
		}
		
		Node(int valeur,Node left,Node right) {
			this.value = valeur;
			this.child_left = left;
			this.child_right = right;
		}
		
		public int getValue(){
			return(this.value);
		}
		
		public void inserer(int valeur,ABR abr) {
			if(this.value<valeur){
				if(this.child_right==null){
					Node noeud = new Node(valeur);
					this.child_right = noeud;
					abr.nb += 1;
				}
				else {
					this.child_right.inserer(valeur,abr);
				}
			}
			else if(this.value>valeur){
				if(this.child_left==null){
					Node noeud = new Node(valeur);
					this.child_left = noeud;
					abr.nb += 1;
				}
				else {
					this.child_left.inserer(valeur,abr);
				}
			}
			else {}
		}	
	}
	
	private Node root;
	private int nb;
	
	ABR() {
		this.root = null;
		this.nb = 0;
	}
	
	ABR(Node racine) {
		this.root = racine;
		this.nb = 1;
	}
	
	public void insert(int valeur) {
		if(this.isEmpty()) {
			Node racine = new Node(valeur);
			this.root = racine;
			this.nb += 1;
		}
		else {
			this.root.inserer(valeur, this);
		}
		
	}
	
	public boolean isEmpty() {
		return(this.root==null);
	}
	
	public int nbElements() {
		return(this.nb);
	}
}

