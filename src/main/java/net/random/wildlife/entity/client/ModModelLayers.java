package net.random.wildlife.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.random.wildlife.Wildlife;

public class ModModelLayers {
    public static final EntityModelLayer SNAKE =
            new EntityModelLayer(new Identifier(Wildlife.MOD_ID, "snake"),"main");
    public static final EntityModelLayer BUTTERFLY =
            new EntityModelLayer(new Identifier(Wildlife.MOD_ID,"butterfly"), "main" );
    public static final EntityModelLayer BEAR =
            new EntityModelLayer(new Identifier(Wildlife.MOD_ID,"bear"), "main" );

}
