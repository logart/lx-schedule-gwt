package org.logart.shared;

/**
 * @author Artem Loginov(ALohinov@luxoft.com)
 * @since 5/19/14 7:13 PM
 */
public enum PERIOD {
	ONCE,
	NEVER,
	EVER;

	public static PERIOD valueOf(int selected) {
		switch (selected){
			case 0:
				return ONCE;
			case 1:
				return NEVER;
			case 2:
				return EVER;
		}
		return ONCE;
	}
}
