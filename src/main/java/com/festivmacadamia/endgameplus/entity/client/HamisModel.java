package com.festivmacadamia.endgameplus.entity.client;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.entity.custom.HamisEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class HamisModel extends GeoModel<HamisEntity> {
    @Override
    public ResourceLocation getModelResource(HamisEntity animatable) {
        return new ResourceLocation(EndGamePlus.MOD_ID,"geo/hamis.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HamisEntity animatable) {
        return new ResourceLocation(EndGamePlus.MOD_ID,"textures/entity/hamis.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HamisEntity animatable) {
        return new ResourceLocation(EndGamePlus.MOD_ID,"animations/hamis.animation.json");
    }

    @Override
    public void setCustomAnimations(HamisEntity animatable, long instanceId, AnimationState<HamisEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
