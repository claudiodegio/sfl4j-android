package org.slf4j.impl;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Logger descriptor object, act as container tree
 *
 * @author Claudio Degioanni
 */
final class Descriptor {
	/* DEBUG */
	final static private boolean DEBUG_T = false;
	final static private String TAG = "Descriptor";

	/**
	 * The level of logging supported
	 */
	final static public int NONE = 0x00;
	final static public int ERROR = 0x02;
	final static public int WARN = 0x04;
	final static public int INFO = 0x08;
	final static public int DEBUG = 0x10;
	final static public int TRACE = 0x20;
	final static public int ALL = 0xFF;
	final static public int UNDEFINED = 0x40;

	/**
	 * Log level
	 */
	private int level = UNDEFINED;

	/**
	 * The string marker, used as additional indicator
	 */
	private String marker = null;

	/**
	 * The child list
	 */
	private Map<String, Descriptor> childs = null;

	/**
	 * Append a {@link Descriptor} as child of this node nodes on name key
	 *
	 * @param name
	 *            the key name of descriptor
	 * @param child
	 *            the child reference
	 */
	final void appendChild(final String name, final Descriptor child) {

		if (childs == null) {
			childs = new HashMap<String, Descriptor>();
		}

		if (DEBUG_T)
			Log.v(TAG, "append of name: " + name + " and desc " + child.toString());

		// check already defined desc
		final Descriptor desc = childs.get(name);

		if (desc == null) {
			childs.put(name, child);
		}
	}

	/**
	 * Add a new log level
	 *
	 * @param level
	 *            the level to add
	 */
	final void addLevel(final int level) {

		if (level == UNDEFINED || level == NONE)
			this.level = level;
		else
			this.level = (this.level | level);

		if (DEBUG_T)
			Log.v(TAG, "addLevel to " + Integer.toBinaryString(level));
	}

	/**
	 * Set a new log level
	 *
	 * @param level
	 *            the level to set
	 */
	final void setLevel(final int level) {

		this.level = level;

		if (DEBUG_T)
			Log.v(TAG, "setLevel to " + Integer.toBinaryString(level));
	}

	/**
	 * Get the descriptor child's
	 *
	 * @return the child's of this object
	 */
	final Map<String, Descriptor> getChilds() {
		return childs;
	}

	/**
	 * Set the descriptor marker
	 *
	 * @param marker
	 *            the marker to set
	 */
	final void setMarker(final String marker) {
		this.marker = marker;
	}

	/**
	 * Get marker of descriptor
	 *
	 * @return the marker
	 */
	final String getMarker() {
		return marker;
	}

	/**
	 * Get the complete log level
	 */
	final int getLevel() {
		return level;
	}

	/**
	 * Check if log level {@link #DEBUG} is enable
	 *
	 * @return true is enable, false otherwise
	 */
	final boolean isDebugEnabled() {
		return ((level & DEBUG) == DEBUG);
	}

	/**
	 * Check if log level {@link #INFO} is enable
	 *
	 * @return true is enable, false otherwise
	 */
	final boolean isInfoEnabled() {
		return ((level & INFO) == INFO);
	}

	/**
	 * Check if log level {@link #TRACE} is enable
	 *
	 * @return true is enable, false otherwise
	 */
	final boolean isTraceEnabled() {
		return ((level & TRACE) == TRACE);
	}

	/**
	 * Check if log level {@link #ERROR} is enable
	 *
	 * @return true is enable, false otherwise
	 */
	final boolean isErrorEnabled() {
		return ((level & ERROR) == ERROR);
	}

	/**
	 * Check if log level {@link #WARN} is enable
	 *
	 * @return true is enable, false otherwise
	 */
	final boolean isWarnEnabled() {
		return ((level & WARN) == WARN);
	}

	@Override
	public String toString() {

		final StringBuilder buff = new StringBuilder();

		buff.append('|');
		if (marker != null) {
			buff.append(marker);
			buff.append(":");
		}

		buff.append(Integer.toBinaryString(level));
		buff.append('|');
		return buff.toString();
	}

	/**
	 * Print the descriptor tree to the {@link Log}
	 */
	final void log() {
		log(this, 0);
	}

	/**
	 * Private recursive version of {@link #log()} function
	 *
	 * @param desc
	 *            the descriptor to navigate
	 * @param level
	 *            the tree level
	 */
	static private void log(final Descriptor desc, int level) {

		{
			final StringBuilder buff = new StringBuilder();

			for (int i = 0; i < level; ++i) {
				buff.append("\t");
			}
			Log.v(TAG, buff.toString() + desc.toString());
		}
		if (desc.childs != null) {
			for (final String key : desc.childs.keySet()) {
				final StringBuilder buff = new StringBuilder();

				for (int i = 0; i < level + 1; ++i) {
					buff.append("\t");
				}

				buff.append("|name:" + key + "|");
				Log.v(TAG, buff.toString());
				log(desc.childs.get(key), level + 1);
			}
		}
	}
}
