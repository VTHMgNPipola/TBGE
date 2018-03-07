/*
 * ------------------------------------------------------------
 * -- This code is of property and maintance of PrinJ Systems.
 * ------------------------------------------------------------
 * 
 * Changes are accepted if not changing the original form.
 */

package com.prinjsystems.tbge.entities;

/**
 * Uses a common array to store entites. Can be fixed size or extendable.
 */
public class ArrayEntityContainer implements EntityContainer {
	private Entity[] entities;
	private boolean fixedSize;
	
	public ArrayEntityContainer(int startSize, boolean fixedSize) {
		entities = new Entity[startSize];
		this.fixedSize = fixedSize;
	}
	
	public ArrayEntityContainer(int startSize) {
		entities = new Entity[startSize];
		this.fixedSize = false;
	}
	
	public void setFixedSize(boolean fixedSize) {
		this.fixedSize = fixedSize;
	}
	
	public boolean isFixedSize() {
		return fixedSize;
	}
	
	@Override
	public void add(Entity e) {
		if(fixedSize) {
			for(int i = 0; i < entities.length; i++) {
				if(entities[i] == null) {
					entities[i] = e;
					break;
				}
			}
		} else {
			for(int i = 0; i < entities.length; i++) {
				if(entities[i] == null) {
					if(entities.length <= i + 1) {
						Entity[] tmp = entities;
						entities = new Entity[entities.length + 5];
						for(int j = 0; j < tmp.length; j++) {
							entities[j] = tmp[j];
						}
					}
					entities[i] = e;
					break;
				}
			}
		}
	}
	
	@Override
	public void add(int p, Entity e) {
		if(entities.length <= p) {
			Entity[] tmp = entities;
			entities = new Entity[p + 5];
			for(int j = 0; j < tmp.length; j++) {
				entities[j] = tmp[j];
			}
		}
		
		entities[p] = e;
	}
	
	@Override
	public Entity get(int i) throws IndexOutOfBoundsException {
		return entities[i];
	}
	
	@Override
	public Entity remove(int i) throws IndexOutOfBoundsException {
		Entity tmp = entities[i];
		entities[i] = null;
		for(int j = i + 1; j < entities.length; j++) {
			entities[j - 1] = entities[j];
			entities[j] = null;
		}
		return tmp;
	}
	
	@Override
	public int size() {
		return entities.length;
	}
}
