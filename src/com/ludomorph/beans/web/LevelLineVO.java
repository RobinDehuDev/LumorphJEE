package com.ludomorph.beans.web;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.struts.action.ActionForm;

public class LevelLineVO extends ActionForm implements List<Integer>{

	private static final long serialVersionUID = 1L;
	private String Name;
	private List<Integer> line;
	public LevelLineVO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param line
	 */
	public LevelLineVO(List<Integer> line) {
		super();
		this.line = line;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the line
	 */
	public List<Integer> getLine() {
		return line;
	}
	/**
	 * @param line the line to set
	 */
	public void setLine(List<Integer> line) {
		this.line = line;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return line.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return line.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return line.contains(o);
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return line.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return line.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return line.toArray(a);
	}

	@Override
	public boolean add(Integer e) {
		// TODO Auto-generated method stub
		return line.add(e);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return line.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return line.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return line.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return line.addAll(index,c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return line.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return line.retainAll(c);
	}

	@Override
	public void clear() {
		line.clear();
		
	}

	@Override
	public Integer get(int index) {
		// TODO Auto-generated method stub
		return line.get(index);
	}
	
	public Integer getLine(int index) {
		while (index >= line.size()) {
            line.add(0);
        }

        return line.get(index);
	}

	@Override
	public Integer set(int index, Integer element) {
		// TODO Auto-generated method stub
		return line.set(index, element);
	}

	@Override
	public void add(int index, Integer element) {
		line.add(index, element);
		
	}

	@Override
	public Integer remove(int index) {
		// TODO Auto-generated method stub
		return line.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return line.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return line.lastIndexOf(o);
	}

	@Override
	public ListIterator<Integer> listIterator() {
		// TODO Auto-generated method stub
		return line.listIterator();
	}

	@Override
	public ListIterator<Integer> listIterator(int index) {
		// TODO Auto-generated method stub
		return line.listIterator(index);
	}

	@Override
	public List<Integer> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return line.subList(fromIndex, toIndex);
	}
	

}
