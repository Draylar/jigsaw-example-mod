package com.github.draylar.tutorial.mixin;

import com.google.common.collect.*;
import net.minecraft.world.gen.chunk.*;
import net.minecraft.world.gen.feature.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin(StructuresConfig.class)
public interface StructuresConfigAccessor {
    @Accessor("DEFAULT_STRUCTURES")
    public static void setDefaultStructures(ImmutableMap<StructureFeature<?>, StructureConfig> defaultStructures) {
        throw new IllegalAccessError();
    }
}
