/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */
package microspaceempire.gui;

import java.net.URL;

public class Resources {
    public static final URL getResourceFile(String name){
		// opens file with path relative to location of the Resources class
		URL url=Resources.class.getResource(name);
		return url; 
	}
}
