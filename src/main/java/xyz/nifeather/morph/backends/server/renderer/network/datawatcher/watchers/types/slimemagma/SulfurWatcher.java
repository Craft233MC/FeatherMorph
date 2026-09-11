package xyz.nifeather.morph.backends.server.renderer.network.datawatcher.watchers.types.slimemagma;

import net.minecraft.nbt.CompoundTag;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import xyz.nifeather.morph.backends.server.renderer.network.registries.CustomEntries;
import xyz.nifeather.morph.backends.server.renderer.network.registries.ValueIndex;
import xyz.nifeather.morph.misc.disguiseProperty.DisguiseProperties;
import xyz.nifeather.morph.misc.disguiseProperty.SingleProperty;
import xyz.nifeather.morph.misc.disguiseProperty.values.SulfurPropertyCollection;

public class SulfurWatcher extends AbstractSlimeWatcher
{
    public SulfurWatcher(Player bindingPlayer)
    {
        super(bindingPlayer, EntityType.SULFUR_CUBE);
    }

    @Override
    protected <X> void onPropertyWrite(SingleProperty<X> property, X value)
    {
        var properties = DisguiseProperties.INSTANCE.getCollectionOrThrow(SulfurPropertyCollection.class);

        if (property.equals(properties.SIZE))
        {
            var size = (int) value;
            this.writeEntry(CustomEntries.SLIME_SIZE_REAL, size);
            this.writePersistent(ValueIndex.SLIME_MAGMA.SIZE, size);
        }

        super.onPropertyWrite(property, value);
    }

    @Override
    public void writeToCompound(CompoundTag nbt)
    {
        super.writeToCompound(nbt);

        nbt.putInt("Size", readEntryOrDefault(CustomEntries.SLIME_SIZE_REAL, 1));
    }
}
