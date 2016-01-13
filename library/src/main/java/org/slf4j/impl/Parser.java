package org.slf4j.impl;

interface Parser {

	/**
	 * Parse the configuration of logging system
	 *
	 * @return the root descriptor object
	 */
	Descriptor parse();
}
