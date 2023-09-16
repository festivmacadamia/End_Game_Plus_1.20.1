package com.festivmacadamia.endgameplus.entity.client;

import com.festivmacadamia.endgameplus.EndGamePlus;
import com.festivmacadamia.endgameplus.entity.custom.CapybaraEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CapybaraModel extends GeoModel<CapybaraEntity> {
    @Override
    public ResourceLocation getModelResource(CapybaraEntity animatable) {
        return new ResourceLocation(EndGamePlus.MOD_ID,"geo/capybara.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CapybaraEntity animatable) {
        return new ResourceLocation(EndGamePlus.MOD_ID,"textures/entity/capybara.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CapybaraEntity animatable) {
        return new ResourceLocation(EndGamePlus.MOD_ID,"animations/capybara.animation.json");
    }

    @Override
    public void setCustomAnimations(CapybaraEntity animatable, long instanceId, AnimationState<CapybaraEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
