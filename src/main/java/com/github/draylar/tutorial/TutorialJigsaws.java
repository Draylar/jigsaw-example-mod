package com.github.draylar.tutorial;

import com.github.draylar.tutorial.features.example.ExampleFeature;
import com.github.draylar.tutorial.features.example.ExamplePiece;
import net.fabricmc.api.ModInitializer;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.StructureFeature;

public class TutorialJigsaws implements ModInitializer
{
	public static final StructureFeature<DefaultFeatureConfig> FEATURE = Registry.register(
			Registry.FEATURE,
			new Identifier("tutorial", "example_feature"),
			new ExampleFeature(DefaultFeatureConfig::deserialize)
	);

	public static final StructureFeature<DefaultFeatureConfig> STRUCTURE = Registry.register(
			Registry.STRUCTURE_FEATURE,
			new Identifier("tutorial", "example_structure_feature"),
			new ExampleFeature(DefaultFeatureConfig::deserialize)
	);

	public static final StructurePieceType EXAMPLE_PIECE = Registry.register(
			Registry.STRUCTURE_PIECE,
			new Identifier("tutorial", "example_piece"),
			ExamplePiece::new
	);

	static {
		Feature.STRUCTURES.put("tutorial_jigsaw", FEATURE);
	}

	@Override
	public void onInitialize()
	{
		Registry.BIOME.forEach(biome -> {
			biome.addFeature(GenerationStep.Feature.RAW_GENERATION, Biome.configureFeature(FEATURE, new DefaultFeatureConfig(), Decorator.NOPE, DecoratorConfig.DEFAULT));
			biome.addStructureFeature(FEATURE, new DefaultFeatureConfig());
		});
	}
}
