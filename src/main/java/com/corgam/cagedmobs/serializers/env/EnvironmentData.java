package com.corgam.cagedmobs.serializers.env;

import com.corgam.cagedmobs.CagedMobs;
import com.corgam.cagedmobs.serializers.RecipesHelper;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Set;

public class EnvironmentData implements IRecipe<IInventory> {

    public static final EnvironmentDataSerializer SERIALIZER = new EnvironmentDataSerializer();

    private final ResourceLocation id;
    private final Ingredient inputItem;
    private final BlockState renderState;
    private final float growModifier;
    private final Set<String> environments;

    EnvironmentData(ResourceLocation id, Ingredient item, BlockState renderState, float growModifier, Set<String> categories){
        this.id = id;
        this.inputItem = item;
        this.renderState = renderState;
        this.growModifier = growModifier;
        this.environments = categories;
        CagedMobs.LOGGER.info("Loaded EnvironmentData recipe for: " + this.environments.toString());
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return false;
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canFit(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return this.SERIALIZER;
    }

    @Override
    public IRecipeType<?> getType() {
        return RecipesHelper.ENV_RECIPE;
    }

    public Ingredient getInputItem() {
        return inputItem;
    }

    public BlockState getRenderState() {
        return renderState;
    }

    public float getGrowModifier() {
        return growModifier;
    }

    public Set<String> getEnvironments() {
        return environments;
    }
}
