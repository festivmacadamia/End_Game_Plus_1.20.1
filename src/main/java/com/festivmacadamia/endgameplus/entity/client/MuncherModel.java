package com.festivmacadamia.endgameplus.entity.client;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.entity.custom.MuncherEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MuncherModel extends GeoModel<MuncherEntity> {
    @Override
    public ResourceLocation getModelResource(MuncherEntity animatable) {
        return new ResourceLocation(EndGamePlus.MOD_ID,"geo/muncher.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MuncherEntity animatable) {
        return new ResourceLocation(EndGamePlus.MOD_ID,"textures/entity/muncher.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MuncherEntity animatable) {
        return new ResourceLocation(EndGamePlus.MOD_ID,"animations/muncher.animation.json");
    }

    @Override
    public void setCustomAnimations(MuncherEntity animatable, long instanceId, AnimationState<MuncherEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
