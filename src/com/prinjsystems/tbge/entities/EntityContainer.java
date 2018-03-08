/*
 * Copyright (C) 2018 PrinJ Systems
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
