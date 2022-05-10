package test;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod("mymod")
public class MyMod {
    public static final String MODID = "mymod";

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final RegistryObject<SoundEvent> MATOTES_SOUND = SOUNDS.register(
            "matotes_ow",
            () -> new SoundEvent(new ResourceLocation(MODID, "matotes_ow"))
    );

    public static final RegistryObject<Item> AMOGUS = ITEMS.register(
            "amogus",
            () -> new Item(new Item.Properties()
                    .tab(CreativeModeTab.TAB_MISC)
                    .rarity(Rarity.EPIC)
                    .stacksTo(1)));

    public static final RegistryObject<Block> MATOTES_BLOCK = BLOCKS.register(
            "matotes",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE))
    );

    public static final RegistryObject<BlockItem> MATOTES_BLOCK_ITEM = ITEMS.register(
            "matotes",
            () -> new BlockItem(MATOTES_BLOCK.get(), new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_MISC))
    );

    public MyMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(eventBus);
        SOUNDS.register(eventBus);
        BLOCKS.register(eventBus);
    }
}
