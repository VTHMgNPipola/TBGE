/*
 * ------------------------------------------------------------
 * -- This code is of property and maintance of PrinJ Systems.
 * ------------------------------------------------------------
 * 
 * Changes are accepted if not changing the original form.
 */

package com.prinjsystems.tbge.entities;

/**
 * Base class for all entities in the game (including items). They always
 * have a name and a {@link EntityContainer}.
 */
public abstract class Entity {
	private String name;
	private EntityContainer inventory;
	
	/**
	 * Creates a new Entity, with the required name and inventory parameters.
	 * @param name Name of the entity.
	 * @param inventory Inventory of the entity.
	 */
	public Entity(String name, EntityContainer inventory) {
		this.name = name;
		this.inventory = inventory;
	}
	
	public final String getName() {
		return name;
	}
	
	public final EntityContainer getInventory() {
		return inventory;
	}
}
