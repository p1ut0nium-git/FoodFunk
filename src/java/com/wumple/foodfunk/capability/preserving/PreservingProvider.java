package com.wumple.foodfunk.capability.preserving;

import javax.annotation.Nullable;

import com.wumple.foodfunk.Reference;

import choonster.capability.SimpleCapabilityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

// TODO filter out if item doesn't preserve anymore?

public class PreservingProvider extends SimpleCapabilityProvider<IPreserving>
{
    TileEntity owner = null;

    public PreservingProvider(Capability<IPreserving> capability, @Nullable EnumFacing facing, TileEntity ownerIn)
    {
        super(capability, facing, (capability != null) ? capability.getDefaultInstance() : null);
        owner = ownerIn;
    }

    public PreservingProvider(Capability<IPreserving> capability, @Nullable EnumFacing facing, IPreserving instance,
            TileEntity ownerIn)
    {
        super(capability, facing, instance);
        owner = ownerIn;
    }

    public final IPreserving getInstance()
    {
        IPreserving cap = super.getInstance();
        cap.setOwner(owner);
        return cap;
    }
}