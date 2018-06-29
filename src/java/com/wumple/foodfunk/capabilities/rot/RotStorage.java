package com.wumple.foodfunk.capabilities.rot;

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
		
		tags.setLong("EM_ROT_DATE", instance.getDate());
		tags.setLong("EM_ROT_TIME", instance.getTime());
		
		return tags; 
	} 

	@Override 
	public void readNBT(Capability<IRot> capability, IRot instance, EnumFacing side, NBTBase nbt) 
	{ 
		NBTTagCompound tags = (NBTTagCompound)nbt;
		
		instance.setDate( tags.getLong("EM_ROT_DATE") );
		instance.setTime( tags.getLong("EM_ROT_TIME") );
	} 
}
