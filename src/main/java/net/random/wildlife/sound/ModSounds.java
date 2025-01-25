package net.random.wildlife.sound;

import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.random.wildlife.Wildlife;
import net.minecraft.registry.Registry;

public class ModSounds {
    public static final SoundEvent SNAKE_AMBIENT = registerSoundEvent("snake_ambient");
    public static final SoundEvent SNAKE_HURT = registerSoundEvent("snake_hurt");


    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(Wildlife.MOD_ID,name);
        return Registry.register(Registries.SOUND_EVENT,id,SoundEvent.of(id));
    }


    public static void registerSounds(){
        Wildlife.LOGGER.info("Registering sounds for"+ Wildlife.MOD_ID);
    }
}
