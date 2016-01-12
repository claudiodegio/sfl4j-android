package org.slf4j.impl;

import android.content.Context;
import android.util.Log;

/**
 * Configuration class for logging system on android
 * 
 * @author Claudio Degioanni
 * @since 1.2.0
 */
abstract class Configurator {
	/* DEBUG */
	final static private boolean DEBUG = false;
	final static private String TAG = "Configurator";

	/**
	 * Load the configuration descriptor based on declared parser
	 * 
	 * @param context
	 *            the application context
	 * @return
	 */
	static Descriptor loadConfiguration(final Context context) {
		return new PropertiesParser(context).parse();
	}

	/**
	 * Get the configuration of a class name or name (a simple string)
	 * 
	 * @param rootDescriptor
	 *            the root object where to start the search
	 * @param name
	 *            the name to get the configuration
	 * @return the logging description of class name or name
	 */
	static Descriptor getConfiguration(final Descriptor rootDescriptor, final String name) {

		if (DEBUG)
			Log.i(TAG, "get config for name: " + name);

		// start the descriptor search
		final Descriptor desc = new Descriptor();

		searchDesc(desc, name, rootDescriptor);

		if (DEBUG)
			Log.d(TAG, "Desc resultof search:" + desc.toString());

		return desc;
	}

	/**
	 * Private recursive version of
	 * {@link #getConfiguration(Descriptor, String)}
	 * 
	 * @param desc
	 *            the final search result descriptor
	 * @param key
	 *            the search key
	 * @param parent
	 *            the parent desc
	 */
	static private void searchDesc(final Descriptor desc, final String key, final Descriptor parent) {
		if (DEBUG)
			Log.d(TAG, "searchDesc for key: " + key + " parent: " + parent);

		if (parent.getMarker() != null) {
			desc.setMarker(parent.getMarker());
		}

		if (parent.getLevel() != Descriptor.UNDEFINED) {
			desc.setLevel(parent.getLevel());
		}

		if (key == null)
			return;

		final int index = key.indexOf('.');
		String currentKey = null;

		if (index == -1) {
			currentKey = key;
		} else {
			currentKey = key.substring(0, index);
		}

		final Descriptor child = (parent.getChilds() != null ? parent.getChilds().get(currentKey) : null);

		if (child == null) {
			return;
		}

		if (index == -1) {
			searchDesc(desc, null, child);
			return;
		}
		searchDesc(desc, key.substring(index + 1, key.length()), child);
	}
}
