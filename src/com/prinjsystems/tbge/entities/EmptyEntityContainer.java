/*
 * ------------------------------------------------------------
 * -- This code is of property and maintance of PrinJ Systems.
 * ------------------------------------------------------------
 * 
 * Changes are accepted if not changing the original form.
 */

package com.prinjsystems.tbge.entities;

/**
 * This class can be used when no inventory is wanted in some place of the game.
 */
public class EmptyEntityContainer implements EntityContainer {
	@Override
	public void add(Entity e) {
		return;
	}
	
	@Override
	public void add(int p, Entity e) {
		return;
	}
	
	@Override
	public Entity get(int i) {
		return null;
	}
	
	@Override
	public Entity remove(int i) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}
