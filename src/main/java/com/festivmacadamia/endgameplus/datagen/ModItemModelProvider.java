package com.festivmacadamia.endgameplus.datagen;

import java.util.LinkedHashMap;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.block.ModBlocks;
import com.festivmacadamia.endgameplus.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider{

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output,EndGamePlus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ENDERITE_INGOT);
        simpleItem(ModItems.ENDERITE_SCRAP);
        simpleItem(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE);

        simpleItem(ModItems.GOLDEN_STEAK);
        simpleItem(ModItems.STRAWBERRY_PIE);
        simpleItem(ModItems.POPPED_AMARANTH);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.STRAWBERRY_SEEDS);
        simpleItem(ModItems.AMARANTH);
        simpleItem(ModItems.AMARANTH_SEEDS);

        spawnEggItem(ModItems.MUNCHER_SPAWN_EGG);
        spawnEggItem(ModItems.CAPYBARA_SPAWN_EGG);
        
        simpleItem(ModItems.METAL_DETECTOR);

        handheldItem(ModItems.ENDERITE_SWORD);
        handheldItem(ModItems.ENDERITE_SHOVEL);
        handheldItem(ModItems.ENDERITE_PICKAXE);
        handheldItem(ModItems.ENDERITE_AXE);
        handheldItem(ModItems.ENDERITE_HOE);

        trimmedArmorItem(ModItems.ENDERITE_HELMET);
        trimmedArmorItem(ModItems.ENDERITE_CHESTPLATE);
        trimmedArmorItem(ModItems.ENDERITE_LEGGINGS);
        trimmedArmorItem(ModItems.ENDERITE_BOOTS);

        saplingItem(ModBlocks.LAVENDER_SAPLING);
        saplingItem(ModBlocks.PINK_ORCHID);
        saplingItem(ModBlocks.WILD_STRAWBERRY);
        saplingItem(ModBlocks.CATMINT);
        saplingItem(ModBlocks.AZURRI_BLUE_SATIN);

        evenSimplerBlockItem(ModBlocks.LAVENDER_STAIRS);
        evenSimplerBlockItem(ModBlocks.LAVENDER_SLAB);
        evenSimplerBlockItem(ModBlocks.LAVENDER_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.LAVENDER_FENCE_GATE);
        simpleBlockItem(ModBlocks.LAVENDER_DOOR);
        trapdoorItem(ModBlocks.LAVENDER_TRAPDOOR);
        buttonItem(ModBlocks.LAVENDER_BUTTON, ModBlocks.LAVENDER_PLANKS);
        fenceItem(ModBlocks.LAVENDER_FENCE, ModBlocks.LAVENDER_PLANKS);
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = EndGamePlus.MOD_ID;

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EndGamePlus.MOD_ID,"item/" + item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(EndGamePlus.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(EndGamePlus.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(EndGamePlus.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(EndGamePlus.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(EndGamePlus.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EndGamePlus.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder spawnEggItem(RegistryObject<ForgeSpawnEggItem> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/template_spawn_egg"));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EndGamePlus.MOD_ID,"block/" + block.getId().getPath()));
    }

}
