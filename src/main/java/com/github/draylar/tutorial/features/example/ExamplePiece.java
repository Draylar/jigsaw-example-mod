package com.github.draylar.tutorial.features.example;

import com.github.draylar.tutorial.TutorialJigsaws;
import com.github.draylar.tutorial.mixin.*;
import com.google.common.collect.*;
import com.mojang.datafixers.util.Pair;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.chunk.*;
import net.minecraft.world.gen.feature.*;

import java.util.*;

public class ExamplePiece extends PoolStructurePiece {

    public static void init() { }

    static {
        StructurePoolBasedGenerator.REGISTRY.add(
                new StructurePool(
                        TutorialJigsaws.BASE_POOL,
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(new LegacySinglePoolElement("tutorial:black_square"), 1),
                                Pair.of(new LegacySinglePoolElement("tutorial:white_square"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePoolBasedGenerator.REGISTRY.add(
                new StructurePool(
                        TutorialJigsaws.COLOR_POOL,
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(new LegacySinglePoolElement("tutorial:lime_square"), 1),
                                Pair.of(new LegacySinglePoolElement("tutorial:magenta_square"), 1),
                                Pair.of(new LegacySinglePoolElement("tutorial:orange_square"), 1),
                                Pair.of(new LegacySinglePoolElement("tutorial:light_blue_square"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );
    }

    ExamplePiece(StructureManager structureManager_1, StructurePoolElement structurePoolElement_1, BlockPos blockPos_1, int int_1, BlockRotation blockRotation_1, BlockBox mutableIntBoundingBox_1) {
        super(TutorialJigsaws.EXAMPLE_PIECE, structureManager_1, structurePoolElement_1, blockPos_1, int_1, blockRotation_1, mutableIntBoundingBox_1);
    }

    public ExamplePiece(StructureManager manager, CompoundTag tag) {
        super(manager, tag, TutorialJigsaws.EXAMPLE_PIECE);
    }
}
