package org.slf4j.impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties file parser of assets/slf4j-android.properties file
 * 
 * @author Claudio Degioanni
 * @since 1.2.0
 */
class PropertiesParser implements Parser {

	/* DEBUG */
	final static private boolean DEBUG = false;
	final static private String TAG = "PropertiesParser";

	/* Token definition */
	static final private String LEVEL_TOKEN = "LEVEL";
	static final private String MARKER_TOKEN = "MARKER";

	/* Log level definition */
	static final private String ERROR_LEVEL = "ERROR";
	static final private String WARN_LEVEL = "WARN";
	static final private String INFO_LEVEL = "INFO";
	static final private String DEBUG_LEVEL = "DEBUG";
	static final private String TRACE_LEVEL = "TRACE";
	static final private String NONE_LEVEL = "NONE";
	static final private String ALL_LEVEL = "ALL";

	/**
	 * Log configuration file
	 */
	final static String CONFIG_PROPERTIES_FILE = "slf4j-android.properties";

	/**
	 * The android application context
	 */
	private Context context = null;

	/**
	 * Create a {@link PropertiesParser} object
	 * 
	 * @param context
	 */
	PropertiesParser(Context context) {
		this.context = context;
	}

	@Override
	final public Descriptor parse() {

		if (DEBUG)
			Log.i(TAG, "call parse on file: " + CONFIG_PROPERTIES_FILE);

		InputStream inputStream = null;

		// The root object
		final Descriptor root = new Descriptor();

		if (context == null)
			return root;

		try {
			final AssetManager assetManager = context.getResources().getAssets();
			inputStream = assetManager.open(CONFIG_PROPERTIES_FILE);

			if (DEBUG)
				Log.d(TAG, "Configuration file was found");

			final Properties prop = new Properties();
			prop.load(inputStream);

			for (final Object key : prop.keySet()) {
				parseKey((String) key, (String) prop.get(key), root);
			}
		} catch (IOException e) {
			Log.w(TAG, "Configuration file not found");
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}

		if (DEBUG)
			root.log();

		return root;
	}

	/**
	 * Parse a properties file key
	 * 
	 * @param key
	 *            the key to parse
	 * @param value
	 *            the value to parse
	 * @param parent
	 *            the parent descriptor
	 * @return true on success, false on fails
	 */
	private boolean parseKey(final String key, final String value, final Descriptor parent) {

		if (DEBUG)
			Log.i(TAG, "parseKey(" + key + ", " + value + ")");

		final int index = key.indexOf('.');

		if (index == -1) {
			// It a final

			if (key.equals(LEVEL_TOKEN)) {
				// parse the level of logging required by this token

				final String[] split = value.split(",");
				for (String string : split) {

					string = string.trim();

					int level = Descriptor.NONE;

					if (string.equalsIgnoreCase(ERROR_LEVEL)) {
						level = Descriptor.ERROR;
					} else if (string.equalsIgnoreCase(WARN_LEVEL)) {
						level = Descriptor.WARN;
					} else if (string.equalsIgnoreCase(INFO_LEVEL)) {
						level = Descriptor.INFO;
					} else if (string.equalsIgnoreCase(DEBUG_LEVEL)) {
						level = Descriptor.DEBUG;
					} else if (string.equalsIgnoreCase(TRACE_LEVEL)) {
						level = Descriptor.TRACE;
					} else if (string.equalsIgnoreCase(NONE_LEVEL)) {
						level = Descriptor.NONE;
					} else if (string.equalsIgnoreCase(ALL_LEVEL)) {
						level = Descriptor.ALL;
					} else {
						Log.w(TAG, "found invalid log level value: " + value);
						continue;
					}
					parent.addLevel(level);
				}
				return true;
			} else if (key.equals(MARKER_TOKEN)) {
				// set the descriptor market
				parent.setMarker(value);
				return true;
			}

			Log.w(TAG, "found invalid log descriptor entry: " + key);
			return false;
		}

		// Get the sub string

		final String subString = key.substring(0, index);

		Descriptor currentNode = null;

		if (parent.getChilds() != null) {
			currentNode = parent.getChilds().get(subString);
		}

		if (currentNode == null) {
			currentNode = new Descriptor();
		}

		final boolean result = parseKey(key.substring(index + 1, key.length()), value, currentNode);

		if (result) {
			parent.appendChild(subString, currentNode);
			return true;
		}
		return false;
	}
}
