package com.github.draylar.tutorial;

import com.github.draylar.tutorial.features.example.ExampleFeature;
import com.github.draylar.tutorial.features.example.ExamplePiece;
import com.github.draylar.tutorial.mixin.*;
import com.google.common.collect.*;
import com.mojang.datafixers.util.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.structure.pool.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.*;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.*;

import java.util.*;

public class TutorialJigsaws implements ModInitializer {
	public static final StructureFeature<StructurePoolFeatureConfig> FEATURE = StructureFeature.register(
			"tutorial:example_feature",
			new ExampleFeature(StructurePoolFeatureConfig.CODEC),
			GenerationStep.Feature.SURFACE_STRUCTURES
	);

	public static final StructurePieceType EXAMPLE_PIECE = StructurePieceType.register(
			ExamplePiece::new,
			"tutorial:example_piece"
	);

	public static final Identifier BASE_POOL = new Identifier("tutorial:base_pool");
	public static final Identifier COLOR_POOL = new Identifier("tutorial:color_pool");

	public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ? extends StructureFeature<StructurePoolFeatureConfig>> FEATURE_CONFIGURED
			= FEATURE.configure(new StructurePoolFeatureConfig(BASE_POOL, 7));

	static {
		StructuresConfigAccessor.setDefaultStructures(
				new ImmutableMap.Builder<StructureFeature<?>, StructureConfig>()
						.putAll(StructuresConfig.DEFAULT_STRUCTURES)
						.put(TutorialJigsaws.FEATURE, new StructureConfig(32, 8, 10387312))
						.build()
		);
	}

	@Override
	public void onInitialize() {
		Registry.BIOME.forEach(biome -> {
			biome.addStructureFeature(FEATURE_CONFIGURED);
		});
	}
}
