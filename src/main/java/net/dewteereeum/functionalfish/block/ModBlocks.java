package net.dewteereeum.functionalfish.block;

import net.dewteereeum.functionalfish.FunctionalFishMod;
import net.dewteereeum.functionalfish.block.custom.Fishbowl;
import net.dewteereeum.functionalfish.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(FunctionalFishMod.MOD_ID);

    public static final DeferredBlock<Block> IMPROVED_SUBSTRATE_BLOCK = registerBlock("improved_substrate_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> FISHBOWL = registerBlock("fishbowl",
            () -> new Fishbowl(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.GLASS)));




    private static <T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}