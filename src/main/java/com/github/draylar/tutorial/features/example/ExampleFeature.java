package com.github.draylar.tutorial.features.example;

import com.mojang.serialization.*;
import net.minecraft.structure.*;
import net.minecraft.structure.pool.*;
import net.minecraft.util.math.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.source.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.chunk.*;
import net.minecraft.world.gen.feature.*;

public class ExampleFeature extends StructureFeature<StructurePoolFeatureConfig> {

    public ExampleFeature(Codec<StructurePoolFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<StructurePoolFeatureConfig> getStructureStartFactory() {
        return Start::new;
    }

    @Override
    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long l, ChunkRandom chunkRandom, int i, int j, Biome biome, ChunkPos chunkPos, StructurePoolFeatureConfig featureConfig) {
        return chunkRandom.nextInt(150) == 0; // 1 in 150
    }

    public static class Start extends StructureStart<StructurePoolFeatureConfig> {

        Start(StructureFeature<StructurePoolFeatureConfig> feature, int x, int z, BlockBox box, int int_3, long seed) {
            super(feature, x, z, box, int_3, seed);
        }

        @Override
        public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int x, int z, Biome biome,
                         StructurePoolFeatureConfig config) {
            BlockPos pos = new BlockPos(x * 16, 80, z * 16);

            boolean randomYPos = false;
            boolean calculateMaxYFromPiecePositions = false;

            ExamplePiece.init();

            StructurePoolBasedGenerator.addPieces(config.startPool, config.size, ExamplePiece::new, chunkGenerator, structureManager,
                    pos, children, random, calculateMaxYFromPiecePositions, randomYPos);

            setBoundingBoxFromChildren();
        }
    }
}
