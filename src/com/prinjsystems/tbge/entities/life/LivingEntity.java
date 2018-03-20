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
package com.prinjsystems.tbge.entities.life;

import com.prinjsystems.tbge.entities.Entity;
import com.prinjsystems.tbge.entities.EntityContainer;

/**
 * This is a special type of entity, that has a artificial intelligence.
 * It is meant for creatures that have life inside the game (like animals or
 * peoples).
 */
public class LivingEntity extends Entity {
	private final ArtificialIntelligence ai;
	
	/**
	 * Creates a new instance of LivingEntity.
	 * @param name Name of the entity.
	 * @param inventory Inventory of the entity.
	 * @param ai ArtificialIntelligence 
	 */
	public LivingEntity(String name, EntityContainer inventory, ArtificialIntelligence ai) {
		super(name, inventory);
		this.ai = ai;
	}
}
