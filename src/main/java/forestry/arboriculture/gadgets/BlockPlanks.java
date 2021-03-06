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
package forestry.arboriculture.gadgets;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import forestry.arboriculture.WoodType;

public class BlockPlanks extends BlockWood {

	public BlockPlanks(boolean fireproof) {
		super("planks", fireproof);
		setResistance(5.0F);
		setHarvestLevel("axe", 0);
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void getSubBlocks(Item item, CreativeTabs par2CreativeTabs, List list) {
		for (WoodType woodType : WoodType.VALUES) {
			list.add(woodType.getPlanks(isFireproof()));
		}
	}

	/* ICONS */
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		return WoodType.ACACIA.getPlankIcon();
	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		TileWood wood = getWoodTile(world, x, y, z);
		WoodType type = wood.getWoodType();
		return type.getPlankIcon();
	}

}
