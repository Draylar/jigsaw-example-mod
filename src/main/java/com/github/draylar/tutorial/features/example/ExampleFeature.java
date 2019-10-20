package com.github.draylar.tutorial.features.example;

import com.mojang.datafixers.Dynamic;
import net.minecraft.world.gen.feature.AbstractTempleFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.function.Function;

public class ExampleFeature extends AbstractTempleFeature<DefaultFeatureConfig> {

    public ExampleFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> config) {
        super(config);
    }

    @Override
    protected int getSeedModifier() {
        return 0;
    }

    @Override
    public StructureStartFactory getStructureStartFactory() {
        return ExampleStructureStart::new;
    }

    // used for structure feature location
    @Override
    public String getName() {
        return "TutorialJigsaw";
    }

    // radius seems to be the max size of a piece inside a chunk
    // I assume it is used for random rotation and placement
    @Override
    public int getRadius() {
        return 2;
    }
}
