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
package forestry.apiculture;

import net.minecraft.item.ItemStack;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBeeHousingInventory;
import forestry.core.interfaces.IAccessHandler;
import forestry.core.inventory.InvTools;
import forestry.core.inventory.InventoryAdapterRestricted;
import forestry.core.utils.Utils;

public class BeeHousingInventory extends InventoryAdapterRestricted implements IBeeHousingInventory {
	public static final int SLOT_QUEEN = 0;
	public static final int SLOT_DRONE = 1;
	public static final int SLOT_PRODUCT_1 = 2;
	public static final int SLOT_PRODUCT_COUNT = 7;

	public BeeHousingInventory(int size, String name, IAccessHandler accessHandler) {
		super(size, name, accessHandler);
	}

	@Override
	public boolean canSlotAccept(int slotIndex, ItemStack itemStack) {
		EnumBeeType beeType = BeeManager.beeRoot.getType(itemStack);

		if (slotIndex == SLOT_QUEEN) {
			return beeType == EnumBeeType.QUEEN || beeType == EnumBeeType.PRINCESS;
		} else if (slotIndex == SLOT_DRONE) {
			return beeType == EnumBeeType.DRONE;
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int slotIndex, ItemStack itemstack, int side) {
		if (!super.canExtractItem(slotIndex, itemstack, side)) {
			return false;
		}
		return Utils.isIndexInRange(slotIndex, SLOT_PRODUCT_1, SLOT_PRODUCT_COUNT);
	}

	@Override
	public final ItemStack getQueen() {
		return getStackInSlot(SLOT_QUEEN);
	}

	@Override
	public final ItemStack getDrone() {
		return getStackInSlot(SLOT_DRONE);
	}

	@Override
	public final void setQueen(ItemStack itemstack) {
		setInventorySlotContents(SLOT_QUEEN, itemstack);
	}

	@Override
	public final void setDrone(ItemStack itemstack) {
		setInventorySlotContents(SLOT_DRONE, itemstack);
	}

	@Override
	public final boolean addProduct(ItemStack product, boolean all) {
		return InvTools.tryAddStack(this, product, SLOT_PRODUCT_1, SLOT_PRODUCT_COUNT, all, true);
	}

}
