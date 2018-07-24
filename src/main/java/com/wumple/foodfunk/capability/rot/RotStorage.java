package com.wumple.foodfunk.capability.rot;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class RotStorage implements IStorage<IRot>
{
    @Override
    public NBTBase writeNBT(Capability<IRot> capability, IRot instance, EnumFacing side)
    {
        NBTTagCompound tags = new NBTTagCompound();

        // some other mod doing bad things?
        if (instance != null)
        {
            tags.setLong("rotStart", instance.getDate());
            tags.setLong("rotTime", instance.getTime());
            tags.setByte("i", instance.getForceId());
        }

        return tags;
    }

    @Override
    public void readNBT(Capability<IRot> capability, IRot instance, EnumFacing side, NBTBase nbt)
    {
        NBTTagCompound tags = (NBTTagCompound) nbt;

        // some other mod doing bad things?
        if ((tags != null) && (instance != null))
        {
            // handle backwards compatibility for now
            if (tags.hasKey("EM_ROT_DATE"))
            {
                instance.setDate(tags.getLong("EM_ROT_DATE"));
                instance.setTime(tags.getLong("EM_ROT_TIME"));
            }
            else if (tags.hasKey("rotStartTimestamp"))
            {
                instance.setDate(tags.getLong("rotStartTimestamp"));
                instance.setTime(tags.getLong("rotLengthTime"));
                instance.setForceId(tags.getByte("i"));
            }
            else
            {
                instance.setDate(tags.getLong("rotStart"));
                instance.setTime(tags.getLong("rotTime"));
                instance.setForceId(tags.getByte("i"));
            }
        }
    }
}
