package parcial;

public interface Set<E> {
	public void insertar(E x);
	public void delete (E x);
	public boolean member(E x);
	public Set<E> intersection(Set<E> S);
	public Set<E> union(Set<E> S);
	public LinkedList<E> values();
	
}
