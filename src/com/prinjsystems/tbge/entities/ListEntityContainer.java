/*
 * ------------------------------------------------------------
 * -- This code is of property and maintance of PrinJ Systems.
 * ------------------------------------------------------------
 * 
 * Changes are accepted if not changing the original form.
 */

package com.prinjsystems.tbge.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Uses a ArrayList to store entities.
 */
public class ListEntityContainer implements EntityContainer {
	private List<Entity> entities;
	
	/**
	 * Creates a new empty ListEntityContainer, ready to be used.
	 */
	public ListEntityContainer() {
		entities = new ArrayList<>();
	}
	
	@Override
	public void add(Entity e) {
		entities.add(e);
	}
	
	@Override
	public void add(int p, Entity e) {
		entities.add(p, e);
	}
	
	@Override
	public Entity get(int i) throws IndexOutOfBoundsException {
		return entities.get(i);
	}
	
	@Override
	public Entity remove(int i) throws IndexOutOfBoundsException {
		return entities.remove(i);
	}

	@Override
	public int size() {
		return entities.size();
	}
}
