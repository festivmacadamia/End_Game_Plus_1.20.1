package com.festivmacadamia.endgameplus.entity;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.entity.custom.MuncherEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EndGamePlus.MOD_ID);

    public static final RegistryObject<EntityType<MuncherEntity>> MUNCHER = ENTITY_TYPE.register("muncher",
            () -> EntityType.Builder.of(MuncherEntity::new, MobCategory.CREATURE)
                    .sized(1.0f,1.0f)
                    .build(new ResourceLocation(EndGamePlus.MOD_ID,"muncher").toString())
    );

    public static void register(IEventBus eventBus){
        ENTITY_TYPE.register(eventBus);
    }
}
