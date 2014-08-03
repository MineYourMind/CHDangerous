
package com.brothercraft.chdangerous;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.core.extensions.AbstractExtension;
import com.laytonsmith.core.extensions.MSExtension;

/**
 *
 */
@MSExtension("CHDangerous")
public class CHDangerous extends AbstractExtension {

	public Version getVersion() {
		return new SimpleVersion(1, 0, 0);
	}

	@Override
	public void onStartup() {
	}
	
	

}
