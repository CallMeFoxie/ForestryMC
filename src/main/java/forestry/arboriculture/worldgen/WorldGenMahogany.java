/*******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 ******************************************************************************/
package forestry.arboriculture.worldgen;

import net.minecraft.world.World;

import forestry.api.world.ITreeGenData;

public class WorldGenMahogany extends WorldGenTree {

	public WorldGenMahogany(ITreeGenData tree) {
		super(tree, 12, 6);
	}

	@Override
	public void generate(World world) {
		generateTreeTrunk(world, height, girth, 0.6f);
		generateSupportStems(world, height, girth, 0.4f, 0.4f);

		int leafSpawn = height + 1;

		generateAdjustedCylinder(world, leafSpawn--, 0, 1, leaf);

		generateAdjustedCylinder(world, leafSpawn--, 1.5f, 1, leaf);
		generateAdjustedCylinder(world, leafSpawn--, 2f, 1, leaf);

		generateAdjustedCylinder(world, leafSpawn--, 3f, 1, leaf);
		generateAdjustedCylinder(world, leafSpawn--, 3f, 1, leaf);
		generateAdjustedCylinder(world, leafSpawn--, 2f, 1, leaf);

	}

}
