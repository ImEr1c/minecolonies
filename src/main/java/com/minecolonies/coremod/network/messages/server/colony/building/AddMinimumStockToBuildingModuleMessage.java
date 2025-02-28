package com.minecolonies.coremod.network.messages.server.colony.building;

import com.minecolonies.api.colony.IColony;
import com.minecolonies.api.colony.buildings.IBuilding;
import com.minecolonies.api.colony.buildings.views.IBuildingView;
import com.minecolonies.coremod.colony.buildings.modules.BuildingModules;
import com.minecolonies.coremod.network.messages.server.AbstractBuildingServerMessage;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Set a new block to the minimum stock list.
 */
public class AddMinimumStockToBuildingModuleMessage extends AbstractBuildingServerMessage<IBuilding>
{
    /**
     * How many item need to be transfer from the player inventory to the building chest.
     */
    private ItemStack itemStack;

    /**
     * How many item need to be transfer from the player inventory to the building chest.
     */
    private int quantity;

    /**
     * Empty constructor used when registering the
     */
    public AddMinimumStockToBuildingModuleMessage()
    {
        super();
    }

    /**
     * Creates a Transfer Items request
     *
     * @param itemStack to be take from the player for the building
     * @param quantity  of item needed to be transfered
     * @param building  the building we're executing on.
     */
    public AddMinimumStockToBuildingModuleMessage(final IBuildingView building, final ItemStack itemStack, final int quantity)
    {
        super(building);
        this.itemStack = itemStack;
        this.quantity = quantity;
    }

    @Override
    public void fromBytesOverride(@NotNull final FriendlyByteBuf buf)
    {
        itemStack = buf.readItem();
        quantity = buf.readInt();
    }

    @Override
    public void toBytesOverride(@NotNull final FriendlyByteBuf buf)
    {
        buf.writeItem(itemStack);
        buf.writeInt(quantity);
    }

    @Override
    public void onExecute(final NetworkEvent.Context ctxIn, final boolean isLogicalServer, final IColony colony, final IBuilding building)
    {
        if (building.hasModule(BuildingModules.MIN_STOCK))
        {
            building.getModule(BuildingModules.MIN_STOCK).addMinimumStock(itemStack, quantity);
        }
    }
}
