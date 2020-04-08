package com.github.draylar.tutorial.features.example;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.structure.pool.SinglePoolElement;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;

public class ExampleStructureStart extends StructureStart {

    private static final Identifier BASE_POOL = new Identifier("tutorial:base_pool");
    private static final Identifier COLOR_POOL = new Identifier("tutorial:color_pool");

    ExampleStructureStart(StructureFeature<?> feature, int x, int z, BlockBox box, int int_3, long seed) {
        super(feature, x, z, box, int_3, seed);
    }

    @Override
    public void initialize(ChunkGenerator<?> chunkGenerator, StructureManager structureManager, int x, int z, Biome biome) {
        // start pool, size, piece (only 1 piece needed)
        StructurePoolBasedGenerator.addPieces(BASE_POOL, 15, ExamplePiece::new, chunkGenerator, structureManager, new BlockPos(x * 16, 150, z * 16), children, random);
        setBoundingBoxFromChildren();
    }

    static {
        StructurePoolBasedGenerator.REGISTRY.add(
                new StructurePool(
                        BASE_POOL,
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(new SinglePoolElement("tutorial:black_square"), 1),
                                Pair.of(new SinglePoolElement("tutorial:white_square"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePoolBasedGenerator.REGISTRY.add(
                new StructurePool(
                        COLOR_POOL,
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(new SinglePoolElement("tutorial:lime_square"), 1),
                                Pair.of(new SinglePoolElement("tutorial:magenta_square"), 1),
                                Pair.of(new SinglePoolElement("tutorial:orange_square"), 1),
                                Pair.of(new SinglePoolElement("tutorial:light_blue_square"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );
    }
}
