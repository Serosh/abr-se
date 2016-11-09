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
		
		public boolean contient(int valeur) {
			if(this.value<valeur){
				if(this.child_right==null){
					return(false);
				}
				else {
					return(this.child_right.contient(valeur));
				}
			}
			else if(this.value>valeur){
				if(this.child_left==null){
					return(false);
				}
				else {
					return(this.child_left.contient(valeur));
				}
			}
			else {
				return(true);
			}
		}
		
		public void ajout(java.util.List<java.lang.Integer> l) { //NonTerminé
			if(this.child_left!=null) {
				if(this.child_left.child_left!=null) {
					this.child_left.ajout(l);
				}
				else {
					l.add(this.child_left.value);
					l.add(this.value);
					if (this.child_right!=null){
						this.child_right.ajout(l);
					}
					else {
						//NonTerminé
					}
				}
			}
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
	
	public boolean contains(int value){
		if(this.isEmpty()){
			return(false);
		}
		else {
			return(this.root.contient(value));
		}
	}
	
	public void toList(java.util.List<java.lang.Integer> l){
		if(this.isEmpty()) {}
		else {
			this.root.ajout(l);
		}
	}
}

