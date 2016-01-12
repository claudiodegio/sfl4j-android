package org.slf4j.impl;

interface Parser {

	/**
	 * Parse the configuration of logging system
	 * 
	 * @param properties
	 *            the properties to parse
	 * @return the root descriptor object
	 */
	Descriptor parse();
}
