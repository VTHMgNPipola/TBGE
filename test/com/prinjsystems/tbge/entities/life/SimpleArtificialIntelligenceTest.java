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

import com.prinjsystems.tbge.entities.actions.EntityAction;
import com.prinjsystems.tbge.entities.actions.SpeakerAction;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Make tests of class SimpleArtificialIntelligence.
 */
public class SimpleArtificialIntelligenceTest {
	/**
	 * Test of getActions method, of class SimpleArtificialIntelligence.
	 */
	@Test
	public void testGetActions() {
		System.out.println("\nTesting getActions");
		SimpleArtificialIntelligence instance = new SimpleArtificialIntelligence();
		Map<Object, EntityAction> expResult = new HashMap<>();
		expResult.put("SomeValue", new SpeakerAction("nothing"));
		instance.setActions(expResult);
		Map<Object, EntityAction> result = instance.getActions();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of think method, of class SimpleArtificialIntelligence.
	 */
	@Test
	public void testThink() {
		System.out.println("\nTesting think");
		Object input = "think";
		Map<Object, EntityAction> actions = new HashMap<>();
		actions.put("die", new SpeakerAction("Naah, not this time."));
		actions.put("think", new SpeakerAction("Ohh, wait... that's true! I not know what I am talking about!"));
		actions.put("live", new SpeakerAction("Only if I want! Well, and I want to..."));
		SimpleArtificialIntelligence instance = new SimpleArtificialIntelligence();
		instance.setActions(actions);
		instance.think(input);
	}
}
