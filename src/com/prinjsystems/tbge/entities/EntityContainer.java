/*
 * ------------------------------------------------------------
 * -- This code is of property and maintance of PrinJ Systems.
 * ------------------------------------------------------------
 * 
 * Changes are accepted if not changing the original form.
 */
package com.prinjsystems.tbge.entities;

/**
 * A list that stores entities an can provide them to the application.
 */
public interface EntityContainer {

	/**
	 * Adds a new Entity to the list, at the last empty index.
	 * @param e Entity to be added at the list end.
	 */
	public void add(Entity e);
	
	/**
	 * Adds a new Entity to the list in the selected index.
	 * @param p Position (index) of the added item.
	 * @param e Entity to be added to the list.
	 */
	public void add(int p, Entity e);
	
	/**
	 * Returns the Entity contained at the given position (IndexOutOfBoundsException if the index not exists).
	 * @param i Index to return the containing entity.
	 * @return Entity of the given index.
	 */
	public Entity get(int i) throws IndexOutOfBoundsException;
	
	/**
	 * Removes a entity from the list, and returns it to the user.
	 * @param i Index of the entity to remove and return.
	 * @return The removed entity.
	 */
	public Entity remove(int i) throws IndexOutOfBoundsException;
	
	/**
	 * Returns the size of the list.
	 * @return List size.
	 */
	public int size();
}
