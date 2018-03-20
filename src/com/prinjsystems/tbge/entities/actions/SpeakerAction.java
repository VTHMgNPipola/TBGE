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
package com.prinjsystems.tbge.entities.actions;

import com.prinjsystems.tbge.entities.Entity;
import com.prinjsystems.tbge.text.FastTerminalPrinter;
import com.prinjsystems.tbge.text.TerminalPrinter;

/**
 * This action takes care just of speaking a pre-defined text when required.
 */
public class SpeakerAction implements EntityAction {
	private boolean speakParentName;
	private TerminalPrinter tp;
	private String text;
	private Entity e;
	
	/**
	 * Creates a default instance of SpeakerAction, which does not speaks
	 * parent entity name before text.
	 * @param text Text to be speaked when {@link #run() run} method called.
	 */
	public SpeakerAction(String text) {
		this.text = text;
		tp = new FastTerminalPrinter();
		speakParentName = false;
	}
	
	/**
	 * Creates a default instance of SpeakerAction, that can select if the
	 * parent entity name will appear with text.
	 * @param tp What will be used to print text on screen.
	 * @param text Text to be speaked when {@link #run() run} method called.
	 * @param speakParentName Defines if the parent entity name will appear with text.
	 */
	public SpeakerAction(TerminalPrinter tp, String text, boolean speakParentName) {
		this.text = text;
		this.speakParentName = speakParentName;
	}
	
	@Override
	public void setEntity(Entity e) {
		this.e = e;
	}
	
	@Override
	public void run() {
		String entityName = "";
		if(speakParentName) {
			entityName = "[" + e.getName() + "] ";
		}
		
		tp.println();
		tp.print(entityName + text);
		tp.println();
	}
}
