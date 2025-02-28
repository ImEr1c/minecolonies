package com.minecolonies.api.colony.managers.interfaces;

import com.minecolonies.api.colony.ColonyProgressType;
import com.minecolonies.api.colony.buildings.IBuilding;
import com.minecolonies.api.colony.workorders.IWorkOrder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public interface IProgressManager
{
    /**
     * Notifies progress on building block placement.
     *
     * @param block the placed block.
     */
    void progressBuildingPlacement(Block block);

    /**
     * Notifies progress on citizen spawn.
     *
     * @param total    the total citizen count.
     * @param employed the employed count.
     */
    void progressCitizenSpawn(int total, int employed);

    /**
     * Notifies progress on workOrder creation.
     *
     * @param workOrder the placed workOrder.
     */
    void progressWorkOrderPlacement(IWorkOrder workOrder);

    /**
     * Notifies progress on building built.
     *
     * @param building     the built building.
     */
    void progressBuildBuilding(IBuilding building);

    /**
     * Notifies progress on employing citizen.
     *
     * @param employed the amount of employed citizen.
     */
    void progressEmploy(int employed);

    /**
     * Notifies progress on employment mode change.
     */
    void progressEmploymentModeChange();

    /**
     * Triggers a progress type to notify the player.
     *
     * @param type the progress type.
     */
    void trigger(ColonyProgressType type);

    /**
     * Toggle print progress to turn it on or off.
     */
    void togglePrintProgress();

    /**
     * Reads the progress manager from NBT.
     *
     * @param compound the compound to read it from.
     */
    void read(@NotNull CompoundTag compound);

    /**
     * Writes the progress manager to NBT.
     *
     * @param compound the compound to write it to.
     */
    void write(@NotNull CompoundTag compound);

    /**
     * Check if progress should be printed.
     *
     * @return true if so.
     */
    boolean isPrintingProgress();
}
