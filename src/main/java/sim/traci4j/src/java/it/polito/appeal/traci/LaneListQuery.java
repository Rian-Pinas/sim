/*   
    Copyright (C) 2013 ApPeAL Group, Politecnico di Torino

    This file is part of TraCI4J.

    TraCI4J is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    TraCI4J is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with TraCI4J.  If not, see <http://www.gnu.org/licenses/>.
*/

package sim.traci4j.src.java.it.polito.appeal.traci;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Query for obtaining an ordered list of {@link Lane}s.
 * 
 * @author Enrico Gueli &lt;enrico.gueli@polito.it&gt;
 *
 */
public class LaneListQuery extends ObjectCollectionQuery<Lane, List<Lane>> {
	LaneListQuery(DataInputStream dis, DataOutputStream dos, int commandID,
			String objectID, int varID, Repository<Lane> repository) {
		super(dis, dos, commandID, repository, objectID, varID);
	}
	@Override
	protected List<Lane> makeCollection() {
		return new ArrayList<Lane>();
	}
}